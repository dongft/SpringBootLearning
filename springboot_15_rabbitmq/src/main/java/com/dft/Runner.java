package com.dft;

import com.dft.message.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;

    public Runner(RabbitTemplate rabbitTemplate,
                  Receiver receiver,
                  ConfigurableApplicationContext context) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("sending msg...");
        rabbitTemplate.convertAndSend(SpringbootRabbitmqApplication.queueName, "Hello from " +
                "RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MICROSECONDS);
        context.close();
    }
}
