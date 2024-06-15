package com.freelancer.flow.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EventEnum {

    ADD("Add"),
    EDIT("Edit"),
    DELETE("Delete");

    @Getter
    private final String event;
}
