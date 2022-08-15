package com.rntgroup.event.service.api;

import com.rntgroup.event.service.dto.EventDto;

import java.util.List;

public interface EventServiceApi {

    EventDto createEvent(EventDto eventDto);

    EventDto updateEvent(Long id, EventDto eventDto);

    EventDto getEventById(Long id);

    void deleteEvent(Long id);

    List<EventDto> getAllEvents();

    List<EventDto> getAllEventsByTitle(String title);

}
