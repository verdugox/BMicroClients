package com.MicroClients.Clients.business;

import com.MicroClients.Clients.entity.Client;
import com.MicroClients.Clients.repository.ClientRepository;
import com.MicroClients.Clients.service.ClientService;
import com.MicroClients.Clients.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplMockTest {

    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    ClientService clientService;

    Client client;

    Client clientSave;

    @DisplayName("Retorna un cliente sin nombre")
    @Test
    public void whenClientIsOk() throws Exception {
        Client client = TestUtil.readFile("client-search-id-null","mocks", Client.class);

        Mockito.when(clientRepository.findByIdentityDni(any()));

        Mockito.verify(clientRepository,Mockito.times(1)).findByIdentityDni(any());
    }


    @Test
    public void anemicTest() throws IOException {
        Client client = TestUtil.readFile("client-search-id-null","mocks", Client.class);

        String DNITest = client.getIdentityDni();

        Assertions.assertEquals(46285513, DNITest);
    }

}
