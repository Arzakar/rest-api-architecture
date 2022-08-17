package com.rntgroup.event.service.controller;

import com.rntgroup.event.service.api.EventServiceApi;

import com.rntgroup.event.service.dto.EventDto;
import com.rntgroup.event.service.mapper.EventRequestMapper;
import com.rntgroup.event.service.request.EventRequestDto;
import com.rntgroup.event.service.response.EventResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class EventController implements EventResource {

    private final EventServiceApi eventServiceApi;
    private final EventRequestMapper eventRequestMapper;

    public ResponseEntity<List<EventResponseDto>> getEvents() {
        List<EventResponseDto> responseBody = eventServiceApi.getAllEvents().stream()
                .map(eventRequestMapper::toResponseDto)
                .collect(Collectors.toList());

        HttpStatus responseStatus;

        if (responseBody.isEmpty()) {
            responseStatus = HttpStatus.NO_CONTENT;
        } else {
            responseStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(responseBody, responseStatus);
    }

    public ResponseEntity<EventResponseDto> createEvent(@RequestBody EventRequestDto eventRequestDto) {
        EventDto savedEvent = eventServiceApi.createEvent(eventRequestMapper.toDto(eventRequestDto));
        EventResponseDto responseBody = eventRequestMapper.toResponseDto(savedEvent);

        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

    public ResponseEntity<List<EventResponseDto>> getEventsByTitle(@RequestParam(name = "title") String title) {
        List<EventResponseDto> responseBody = eventServiceApi.getAllEventsByTitle(title).stream()
                .map(eventRequestMapper::toResponseDto)
                .collect(Collectors.toList());

        HttpStatus responseStatus;

        if (responseBody.isEmpty()) {
            responseStatus = HttpStatus.NO_CONTENT;
        } else {
            responseStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(responseBody, responseStatus);
    }

    public ResponseEntity<EventResponseDto> updateEvent(@PathVariable("id") Long id,
                                                        @RequestBody EventRequestDto eventRequestDto) {
        eventServiceApi.updateEvent(id, eventRequestMapper.toDto(eventRequestDto));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<EventResponseDto> getEventById(@PathVariable("id") Long id) {
        EventDto eventDto = eventServiceApi.getEventById(id);
        EventResponseDto responseBody = eventRequestMapper.toResponseDto(eventDto);

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    public ResponseEntity<EventResponseDto> deleteEventById(@PathVariable("id") Long id) {
        eventServiceApi.deleteEvent(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
