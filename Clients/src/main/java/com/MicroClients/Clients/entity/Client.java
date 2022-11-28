package com.MicroClients.Clients.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@ToString
@EqualsAndHashCode(of = {"identityDni"})
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "clients")
public class Client
{
    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    @Column(nullable = false, length = 8)
    private String identityDni;

    /*@NotNull
    @Indexed(unique = true)
    @Column(nullable = false, length = 8)
    private Integer dni;*/
    @NotEmpty
    @Size(min = 0, max = 50)
    @Column(nullable = false, length = 50)
    private String firstName;
    @NotEmpty
    @Size(min = 0, max = 50)
    @Column(nullable = false, length = 50)
    private String lastName;
    @NotEmpty
    @Size(min = 0, max = 100)
    @Column(nullable = false, length = 100)
    private String address;
    @NotNull
    @Indexed(unique = true)
    @Column(nullable = false, length = 9)
    private Integer phone;
    @NotEmpty
    @Indexed(unique = true)
    @Size(min = 0, max = 100)
    @Column(nullable = false, length = 100)
    private String email;
    @NotEmpty
    @Size(min = 0, max = 50)
    @Column(nullable = false, length = 50)
    private String typeClient;
    @NotNull
    @Indexed(unique = true)
    @Column(nullable = false, length = 11)
    private float ruc;
    @NotEmpty
    @Size(min = 0, max = 100)
    @Column(nullable = false, length = 100)
    private String companyName;
    @NotNull
    @Column(nullable = false, length = 50)
    private LocalDate dateRegister;

    //♥☻☺

}
