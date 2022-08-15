package com.rntgroup.event.service.response;

import com.rntgroup.event.service.enums.EventTypeDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventResponseDto extends RepresentationModel<EventResponseDto> {

    Long id;
    String title;
    Integer place;
    String speaker;
    EventTypeDto eventType;
    LocalDateTime dateTime;

}
