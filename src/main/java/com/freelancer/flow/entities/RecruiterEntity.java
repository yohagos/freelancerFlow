package com.freelancer.flow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RecruiterEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String agency;
    private String name;
    private String email;
    private String phone;
    private String website;


    @Override
    public String toString() {
        return String.format(
                "Recruiter=[id=%d, agency=%s, name=%s, email=%s, phone=%s, website=%s]",
                getId(), getAgency(), getName(), getEmail(), getPhone(), getWebsite()
        );
    }
}
