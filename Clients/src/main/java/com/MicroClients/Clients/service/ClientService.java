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

}
