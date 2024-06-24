package com.freelancer.flow.entities;


import com.freelancer.flow.common.BaseEntity;
import com.freelancer.flow.enums.CategoryEnum;
import com.freelancer.flow.enums.EventEnum;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EventEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    @Enumerated(EnumType.STRING)
    private EventEnum event;

    private Integer categoryId;
    @Nullable
    private String phone;
    @Nullable
    private String website;
    @Nullable
    private String companyName;
    @Nullable
    private String name;
    @Nullable
    private String email;
    @Nullable
    private LocalDateTime startDate;
    @Nullable
    private LocalDateTime endDate;
    @Nullable
    private String projectName;
    @Nullable
    private String recruiterName;
    @Nullable
    private Double remoteRate;
    @Nullable
    private Double onSiteRate;
    @Nullable
    private LocalDateTime workDate;
    @Nullable
    private Double hoursWorked;
    @Nullable
    private Boolean isRemote;
    @Nullable
    @Column(columnDefinition = "TEXT", length = 1024)
    private String notice;

    @Override
    public String toString() {
        return String.format("Event=[category=%s, event=%s, categoryId=%s]", getCategory().getCategory(), getEvent().getEvent(), getCategoryId());
    }
}
