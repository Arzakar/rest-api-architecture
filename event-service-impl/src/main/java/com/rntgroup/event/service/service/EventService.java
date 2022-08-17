package com.rntgroup.event.service.service;

import com.rntgroup.event.service.api.EventServiceApi;
import com.rntgroup.event.service.dto.EventDto;
import com.rntgroup.event.service.exception.NotFoundEventException;
import com.rntgroup.event.service.repository.EventRepository;
import com.rntgroup.event.service.mapper.EventMapper;
import com.rntgroup.event.service.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService implements EventServiceApi {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = eventMapper.toModel(eventDto);
        return eventMapper.toDto(eventRepository.save(event));
    }

    @Override
    public EventDto updateEvent(Long id, EventDto eventDto) {
        if (!eventRepository.existsById(id)) {
            throw new NotFoundEventException("id", id.toString());
        }

        Event updatedEvent = eventMapper.toModel(eventDto.setId(id));
        return eventMapper.toDto(eventRepository.save(updatedEvent));
    }

    @Override
    public EventDto getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundEventException("id", id.toString()));
        return eventMapper.toDto(event);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.findById(id).orElseThrow(() -> new NotFoundEventException("id", id.toString()));
        eventRepository.deleteById(id);
    }

    @Override
    public List<EventDto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getAllEventsByTitle(String title) {
        return eventRepository.findByTitle(title).stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }
}
