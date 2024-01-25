package com.freelancer.flow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClientEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String companyName;
    private String clientName;
    private String clientEmail;
    private String website;
    private String phone;


    @Override
    public String toString() {
        return String.format(
                "Client=[id=%d, companyName=%s, clientName=%s, clientEmail=%s, website=%s, phone=%s]",
                getId(), getCompanyName(), getClientName(), getClientEmail(), getWebsite(), getPhone()
        );
    }

}
