package com.freelancer.flow.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CategoryEnum {
    CLIENT("Client"),
    CONTRACT("Contract"),
    PROJECT("Project"),
    RECRUITER("Recruiter"),
    WORK_LOG("Work Log");

    @Getter
    private final String category;
}
