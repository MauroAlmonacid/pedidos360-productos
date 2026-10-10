# --- Etapa 1: Build (Construcción) ---
# Trae Maven con el JDK 21 para compilar todo el código
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Descarga las dependencias del proyecto aprovechando la caché de Docker
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia la carpeta con tus controladores y modelos Java y empaqueta el JAR
COPY src ./src
RUN mvn clean package -DskipTests

# --- Etapa 2: Runtime (Ejecución limpia) ---
# Usamos solo el entorno de ejecución (JRE) para que la imagen pese muy poco
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Seguridad: Creamos un usuario de sistema para no correr como root
RUN addgroup -S spring && adduser -S spring -G spring

# Rescatamos únicamente el archivo .jar generado en la Etapa 1
COPY --from=build /app/target/*.jar app.jar

# Cambiamos al usuario seguro
USER spring:spring

# Puerto oficial del microservicio de productos
EXPOSE 8080

# Inicia Spring Boot con optimización de memoria para no saturar tu EC2
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]