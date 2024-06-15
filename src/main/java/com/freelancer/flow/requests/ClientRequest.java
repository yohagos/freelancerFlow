package com.freelancer.flow.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientRequest {
    private Integer id;
    @NotEmpty(message = "Company Name is mandatory")
    @NotBlank(message = "Company Name cannot be blank")
    private String companyName;
    @NotEmpty(message = "Client Name is mandatory")
    @NotBlank(message = "Client Name cannot be blank")
    private String clientName;
    @Email(message = "Enter a valid email address")
    @NotEmpty(message = "Email is mandatory")
    @NotBlank(message = "Email cannot be blank")
    private String clientEmail;
    private String website;
    private String phone;
}
