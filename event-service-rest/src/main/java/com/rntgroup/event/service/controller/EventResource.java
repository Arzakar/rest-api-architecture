package com.rntgroup.event.service.controller;

import com.rntgroup.event.service.request.EventRequestDto;
import com.rntgroup.event.service.response.EventResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/v1/events")
public interface EventResource {

    @GetMapping
    ResponseEntity<List<EventResponseDto>> getEvents();

    @PostMapping
    ResponseEntity<EventResponseDto> createEvent(@RequestBody EventRequestDto eventRequestDto);

    @GetMapping("/find")
    ResponseEntity<List<EventResponseDto>> getEventsByTitle(@RequestParam(name = "title") String title);

    @PatchMapping(path = "/{id}")
    ResponseEntity<EventResponseDto> updateEvent(@PathVariable("id") Long id,
                                                 @RequestBody EventRequestDto eventRequestDto);

    @GetMapping(path = "/{id}")
    ResponseEntity<EventResponseDto> getEventById(@PathVariable("id") Long id);

    @DeleteMapping(path = "/{id}")
    ResponseEntity<EventResponseDto> deleteEventById(@PathVariable("id") Long id);

}
