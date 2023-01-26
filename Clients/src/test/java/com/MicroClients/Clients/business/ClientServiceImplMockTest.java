package com.MicroClients.Clients.business;

import com.MicroClients.Clients.service.ClientService;
<<<<<<< HEAD
import com.MicroClients.Clients.web.mapper.ClientMapper;
import org.junit.jupiter.api.BeforeEach;
=======
import com.MicroClients.Clients.util.TestUtil;
import org.junit.jupiter.api.Assertions;
>>>>>>> c250c417b530379d349fb85c465b686e1f70b4a3
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
<<<<<<< HEAD
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

=======
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

>>>>>>> c250c417b530379d349fb85c465b686e1f70b4a3
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplMockTest {

    @MockBean
    ClientMapper clientMapper;

    @InjectMocks
    ClientService clientService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Prueba TestMono1")
    @Test
    public void testMono1(){
        Mono<String> mono = Mono.empty();
    }

    @DisplayName("Prueba TestMono2")
    @Test
    public void testMono2(){
        Mono<String> mono = Mono.just("Spring");
        mono.subscribe(System.out::println);
    }
    @DisplayName("Prueba TestMono3")
    @Test
    public void testMono3(){
        Mono<Integer> mono = Mono.just(10);
        mono.subscribe(System.out::println);
    }
    @DisplayName("Prueba TestMono4")
    @Test
    public void testMono4(){
        Mono<String> mono = Mono.error(new RuntimeException(("Exception ocurred")));

    }
    @DisplayName("Prueba TestMono5")
    @Test
    public void testMono5(){
        Mono<String> mono=Mono.just("Spring");
        StepVerifier.create(mono.log())
                .expectNext("Spring")
                .verifyComplete();
    }

    @DisplayName("Prueba TestMono6")
    @Test
    public void testMono6(){
        Mono<String> mono = Mono.error(new RuntimeException("Exception ocurred"));
        StepVerifier.create(mono.log())
                .expectError(RuntimeException.class)
                .verify();
        //Another approach
        StepVerifier.create(Mono.error(new RuntimeException("Exception")).log())
                .expectError(RuntimeException.class)
                .verify();
    }

//    @DisplayName("Prueba ListClientForId")
//    @Test
//    public void findById() throws Exception {
//
//        //given
//
////        Client client = TestUtil.readFile("client-search-id-null","mocks", Client.class);
////        Client.builder().dateRegister(LocalDate.now());
//
//        Client client =
//                Client.builder().id("6387b7bb67dd4a1d78553555")
//                        .identityDni("34526985")
//                        .firstName("Pepe")
//                        .lastName("Rodriguez")
//                        .address("Urb. La Tombola")
//                        .phone(987456346)
//                        .email("pepetombo@outlook.com")
//                        .typeClient("PERSONAL")
//                        .ruc(2059658240)
//                        .companyName("AcunaCompany")
//                        .dateRegister(LocalDate.now()).build();
//
//        //when
//        when(clientRepository.findById("6387b7bb67dd4a1d78553555")).thenReturn(Mono.just(client));
//
//        //then
//        StepVerifier.create(clientService.findById("6387b7bb67dd4a1d78553555")).expectNext(client).verifyComplete();
//
//
//
//        //when(clientRepository.findById(anyString()))
//        //        .thenReturn(Mono.just(client));
//
//        //Client test = (Client) clientService.findById("6387b7bb67dd4a1d78553555").subscribe();
//
//        //test.assertNoErrors();
//        //test.assertValue(p -> p.getFirstName() == null);
//        //test.assertValue(x -> x.getPrice() == 200.00);
//        //test.assertValues(client);
//
//    }

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
