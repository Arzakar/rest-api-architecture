package com.rntgroup.event.service.dto;

import com.rntgroup.event.service.enums.EventTypeDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventDto {

    Long id;
    String title;
    Integer place;
    String speaker;
    EventTypeDto eventType;
    LocalDateTime dateTime;

}
