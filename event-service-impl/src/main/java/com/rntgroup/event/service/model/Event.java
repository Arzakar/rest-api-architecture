package com.rntgroup.event.service.model;

import com.rntgroup.event.service.enums.EventType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "place", nullable = false)
    Integer place;

    @Column(name = "speaker", nullable = false)
    String speaker;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    EventType eventType;

    @Column(name = "date_time")
    LocalDateTime dateTime;

}
