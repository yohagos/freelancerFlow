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
public class RecruiterEntity extends BaseEntity {
    private String agency;
    private String name;
    private String email;
    private String phone;
    private String website;

    @Override
    public String toString() {
        return String.format("Recruiter=[agency=%s, name=%s, email=%s]", getAgency(), getName(), getEmail());
    }
}
