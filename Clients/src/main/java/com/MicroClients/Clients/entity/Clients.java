package com.MicroClients.Clients.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@ToString
@EqualsAndHashCode(of = {"dni"})
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "clients")
public class Clients
{
    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    @Column(nullable = false, length = 8)
    private Integer dni;
    @NotEmpty
    @Column(nullable = false, length = 50)
    private String firstName;
    @NotEmpty
    @Column(nullable = false, length = 50)
    private String lastName;
    @NotEmpty
    @Column(nullable = false, length = 100)
    private String address;
    @NotNull
    @Indexed(unique = true)
    @Column(nullable = false, length = 9)
    private Integer phone;
    @NotEmpty
    @Indexed(unique = true)
    @Column(nullable = false, length = 100)
    private String email;
    @NotEmpty
    @Column(nullable = false, length = 50)
    private String typeClient;
    @NotNull
    @Indexed(unique = true)
    @Column(nullable = false, length = 11)
    private float ruc;
    @NotEmpty
    @Column(nullable = false, length = 100)
    private String companyName;
    @NotNull
    @Column(nullable = false, length = 50)
    private LocalDate dateRegister;

    //♥☻☺

}
