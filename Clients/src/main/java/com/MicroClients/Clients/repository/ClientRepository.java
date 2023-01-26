package com.MicroClients.Clients.repository;

import com.MicroClients.Clients.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
//@RequiredArgsConstructor
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

    Mono<Client> findByIdentityDni(String identityDni);


}
