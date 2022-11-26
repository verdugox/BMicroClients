package com.MicroClients.Clients.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {

    @JsonIgnore
    private String id;

    @NotBlank(message="Identity Number cannot be null or empty")
    private String identityNumber;

    @NotBlank(message="Name cannot be null or empty")
    private String firstName;

    @NotBlank(message="LastName cannot be null or empty")
    private String lastName;

    @NotBlank(message="BusinessName cannot be null or empty")
    private String address;

    @NotBlank(message="BusinessName cannot be null or empty")
    private String phone;

    @NotBlank(message="Email cannot be null or empty")
    private String email;

    @NotBlank(message="PhoneNumber cannot be null or empty")
    private String typeClient;

    @NotBlank(message="PhoneNumber cannot be null or empty")
    private String ruc;

    @NotBlank(message="PhoneNumber cannot be null or empty")
    private String companyName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateRegister;


}
