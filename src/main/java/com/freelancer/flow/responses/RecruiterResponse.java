package com.freelancer.flow.responses;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruiterResponse {
    private Integer id;
    private String agency;
    private String name;
    private String email;
    private String phone;
    private String website;
}
