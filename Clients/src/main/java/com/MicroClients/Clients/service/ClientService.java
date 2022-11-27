package com.MicroClients.Clients.service;

import com.MicroClients.Clients.entity.Client;
import com.MicroClients.Clients.repository.ClientRepository;
import com.MicroClients.Clients.web.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;


    public Flux<Client> findAll(){
        log.debug("findAll executed");
        return clientRepository.findAll();
    }

    public Mono<Client> findById(String clientId){
        log.debug("findById executed {}" , clientId);
        return clientRepository.findById(clientId);
    }

    public Mono<Client> create(Client client){
        log.debug("create executed {}",client);
        return clientRepository.save(client);
    }

    public Mono<Client> update(String clientId, Client client){
        log.debug("update executed {}:{}", clientId, client);
        return clientRepository.findById(clientId)
                .flatMap(dbClient -> {
                    clientMapper.update(dbClient, client);
                    return clientRepository.save(dbClient);
                });
    }

    public Mono<Client>delete(String clientId){
        log.debug("delete executed {}",clientId);
        return clientRepository.findById(clientId)
                .flatMap(existingClient -> clientRepository.delete(existingClient)
                        .then(Mono.just(existingClient)));
    }

}
