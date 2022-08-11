package com.rntgroup.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventDto {

    Long id;
    String title;
    Integer place;
    String speaker;
    EventType eventType;
    LocalDateTime dateTime;

    enum EventType {
        PRESENTATION,
        LECTURE,
        FREE_DISCUSSION
    }
}
