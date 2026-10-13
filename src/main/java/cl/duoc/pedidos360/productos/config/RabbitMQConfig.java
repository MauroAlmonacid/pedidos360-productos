package cl.duoc.pedidos360.productos.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Declara los recursos AMQP (cola, exchange y binding) y el conversor JSON
 * que usa Spring AMQP tanto para enviar como para recibir mensajes.
 */
@Configuration
public class RabbitMQConfig {

    @Value("${app.rabbitmq.queue}")
    private String queueName;

    @Value("${app.rabbitmq.exchange}")
    private String exchangeName;

    @Value("${app.rabbitmq.routingkey}")
    private String routingKey;

    // Cola durable: sobrevive a un reinicio del broker.
    @Bean
    public Queue productQueue() {
        return new Queue(queueName, true);
    }

    // Exchange de tipo topic, durable.
    @Bean
    public TopicExchange pedidosExchange() {
        return new TopicExchange(exchangeName, true, false);
    }

    // Une la cola al exchange usando la routing key configurada.
    @Bean
    public Binding productBinding(Queue productQueue, TopicExchange pedidosExchange) {
        return BindingBuilder.bind(productQueue).to(pedidosExchange).with(routingKey);
    }

    // Spring Boot detecta este único MessageConverter y lo aplica al listener.
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
