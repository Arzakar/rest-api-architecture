package com.rntgroup.api;

import com.rntgroup.model.EventDto;

import java.util.List;

public interface EventServiceApi {

    EventDto createEvent(EventDto eventDto);

    EventDto updateEvent(Long id, EventDto eventDto);

    EventDto getEventById(Long id);

    EventDto deleteEvent(Long id);

    List<EventDto> getAllEvents();

    List<EventDto> getAllEventsByTitle(String title);

}
