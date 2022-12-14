package com.MicroClients.Clients.service.web;


import com.MicroClients.Clients.entity.Client;
import com.MicroClients.Clients.entity.Response;
import com.MicroClients.Clients.service.ClientService;
import com.MicroClients.Clients.service.web.mapper.ClientMapper;
import com.MicroClients.Clients.service.web.model.ClientModel;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import java.net.URI;
import java.time.Duration;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/client")
public class ClientController {

    @Value("${spring.application.name}")
    String name;

    @Value("${server.port}")
    String port;

    @Autowired
    private ClientService clientService;


    @Autowired
    private ClientMapper clientMapper;

    private static final String RESILIENCE4J_INSTANCE_NAME = "example";

    private static final String FALLBACK_METHOD = "fallback";


    @GetMapping("/findAll")
    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    @TimeLimiter(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Mono<ResponseEntity<Flux<ClientModel>>> getAll(){
        log.info("getAll executed");
        return Mono.just(ResponseEntity.ok()
                .body(clientService.findAll()
                        .map(client -> clientMapper.entityToModel(client))));
    }

    @GetMapping("/findById/{id}")
    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    @TimeLimiter(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Mono<ResponseEntity<ClientModel>> findById(@PathVariable String id){
        log.info("findById executed {}", id);
        Mono<Client> response = clientService.findById(id);
        return response
                .map(client -> clientMapper.entityToModel(client))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findByIdentityDni/{identityDni}")
    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    @TimeLimiter(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Mono<ResponseEntity<ClientModel>> findByIdentityDni(@PathVariable String identityDni){
        log.info("findByIdentityDni executed {}", identityDni);
        Mono<Client> response = clientService.findByIdentityDni(identityDni);
        return response
                .map(client -> clientMapper.entityToModel(client))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    @TimeLimiter(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Mono<ResponseEntity<ClientModel>> create(@Valid @RequestBody ClientModel request){
        log.info("create executed {}", request);
        return clientService.create(clientMapper.modelToEntity(request))
                .map(client -> clientMapper.entityToModel(client))
                .flatMap(c -> Mono.just(ResponseEntity.created(URI.create(String.format("http://%s:%s/%s/%s", name, port, "client", c.getId())))
                        .body(c)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    @TimeLimiter(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Mono<ResponseEntity<ClientModel>> updateById(@PathVariable String id, @Valid @RequestBody ClientModel request){
        log.info("updateById executed {}:{}", id, request);
        return clientService.update(id, clientMapper.modelToEntity(request))
                .map(client -> clientMapper.entityToModel(client))
                .flatMap(c -> Mono.just(ResponseEntity.created(URI.create(String.format("http://%s:%s/%s/%s", name, port, "client", c.getId())))
                        .body(c)))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    @TimeLimiter(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Mono<ResponseEntity<Void>> deleteById(@PathVariable String id){
        log.info("deleteById executed {}", id);
        return clientService.delete(id)
                .map( r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    private Response<Boolean> toOkResponse() {
        return toResponse(HttpStatus.OK, Boolean.TRUE);
    }

    private Response<Boolean> toResponse(HttpStatus httpStatus, Boolean result) {
        return Response.<Boolean>builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .data(result)
                .build();
    }





}
