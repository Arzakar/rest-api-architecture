package com.rntgroup.event.service.mapper;

import com.rntgroup.event.service.dto.EventDto;
import com.rntgroup.event.service.model.Event;

import org.mapstruct.Mapper;

@Mapper
public interface EventMapper {
    EventDto toDto(Event event);
    Event toModel(EventDto eventDto);
}
