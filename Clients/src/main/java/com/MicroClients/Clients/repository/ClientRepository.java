package com.MicroClients.Clients.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.MicroClients.Clients.entity.Client;

import reactor.core.publisher.Mono;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
        Mono<Client> findByIdentityNumber(String identityNumber);
}
