package com.rntgroup.event.service.mapper;

import com.rntgroup.event.service.dto.EventDto;
import com.rntgroup.event.service.request.EventRequestDto;
import com.rntgroup.event.service.response.EventResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventRequestMapper {

    EventDto toDto(EventRequestDto eventRequestDto);

    EventResponseDto toResponseDto(EventDto eventDto);

}
