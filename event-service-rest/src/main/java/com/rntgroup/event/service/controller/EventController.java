package com.rntgroup.event.service.controller;

import com.rntgroup.event.service.api.EventServiceApi;

import com.rntgroup.event.service.dto.EventDto;
import com.rntgroup.event.service.mapper.EventRequestMapper;
import com.rntgroup.event.service.request.EventRequestDto;
import com.rntgroup.event.service.response.EventResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventServiceApi eventServiceApi;
    private final EventRequestMapper eventRequestMapper;

    @GetMapping
    public ResponseEntity<List<EventResponseDto>> getEvents() {
        List<EventResponseDto> responseBody = eventServiceApi.getAllEvents().stream()
                .map(eventRequestMapper::toResponseDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody EventRequestDto eventRequestDto) {
        EventDto savedEvent = eventServiceApi.createEvent(eventRequestMapper.toDto(eventRequestDto));
        EventResponseDto responseBody = eventRequestMapper.toResponseDto(savedEvent);

        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<EventResponseDto> updateEvent(@PathVariable("id") Long id,
                                                        @RequestBody EventRequestDto eventRequestDto) {
        EventDto updatedEvent = eventServiceApi.updateEvent(id, eventRequestMapper.toDto(eventRequestDto));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable("id") Long id) {
        EventDto eventDto = eventServiceApi.getEventById(id);
        EventResponseDto responseBody = eventRequestMapper.toResponseDto(eventDto);

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<EventResponseDto> deleteEventById(@PathVariable("id") Long id) {
        eventServiceApi.deleteEvent(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
