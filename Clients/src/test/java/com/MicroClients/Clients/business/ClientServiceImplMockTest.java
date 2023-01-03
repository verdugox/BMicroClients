package com.MicroClients.Clients.business;

import com.MicroClients.Clients.entity.Client;
import com.MicroClients.Clients.repository.ClientRepository;
import com.MicroClients.Clients.service.ClientService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ClientServiceImplMockTest {

    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    ClientService clientService;

    Client client;

    Client clientSave;

}
