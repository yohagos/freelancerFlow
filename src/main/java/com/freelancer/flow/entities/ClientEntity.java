package com.freelancer.flow.entities;

import com.freelancer.flow.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClientEntity extends BaseEntity {
    private String companyName;
    private String clientName;
    private String clientEmail;
    private String website;
    private String phone;

    @Override
    public String toString() {
        return String.format("Client=[companyName=%s, clientName=%s, clientEmail=%s]", getCompanyName(), getClientName(), getClientEmail());
    }
}
