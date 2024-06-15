package com.freelancer.flow.responses;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {

    private Integer id;
    private String companyName;
    private String clientName;
    private String clientEmail;
    private String website;
    private String phone;
}
