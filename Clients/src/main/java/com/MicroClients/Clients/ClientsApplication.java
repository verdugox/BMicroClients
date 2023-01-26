package com.MicroClients.Clients;

import com.MicroClients.Clients.entity.Client;
import com.MicroClients.Clients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
@EnableEurekaClient
public class ClientsApplication {

public static void main(String[] args) {
SpringApplication.run(ClientsApplication.class, args);
}

    @Bean
    public ReactiveRedisTemplate<String, Client> reactiveJsonPostRedisTemplate(
            ReactiveRedisConnectionFactory connectionFactory) {

        RedisSerializationContext<String, Client> serializationContext = RedisSerializationContext
                .<String, Client>newSerializationContext(new StringRedisSerializer())
                .hashKey(new StringRedisSerializer())
                .hashValue(new Jackson2JsonRedisSerializer<>(Client.class))
                .build();


        return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
    }


}
