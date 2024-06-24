package com.freelancer.flow.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RecruiterRequest {
    private Integer id;
    @NotNull(message = "Agency name cannot be null")
    @NotBlank(message = "Agency name cannot be blank")
    private String agency;
    @NotNull(message = "Recruiter name cannot be null")
    @NotBlank(message = "Recruiter name cannot be blank")
    private String name;
    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @NotNull(message = "Phone cannot be null")
    @NotBlank(message = "Phone cannot be blank")
    private String phone;
    private String website;
}
