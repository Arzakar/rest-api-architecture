package com.rntgroup.event.service.controller;

import com.rntgroup.event.service.exception.EventExceptionResponse;
import com.rntgroup.event.service.request.EventRequestDto;
import com.rntgroup.event.service.response.EventResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "event-resource", description = "API взаимодействия с Event")
@RequestMapping("/api/v1/events")
public interface EventResource {

    @Operation(summary = "Получить все мероприятия")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Мероприятия успешно получены",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = EventResponseDto.class)))),
            @ApiResponse(responseCode = "204", description = "В базе данных нет ни одного мероприятия",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервиса",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class)))
    })
    @GetMapping
    ResponseEntity<List<EventResponseDto>> getEvents();

    @Operation(summary = "Создать и сохранить мероприятие")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Мероприятия успешно создано",
                    content = @Content(schema = @Schema(implementation = EventResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Ошибки при заполнении полей в теле сообщения",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервиса",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class)))
    })
    @PostMapping
    ResponseEntity<EventResponseDto> createEvent(@RequestBody EventRequestDto eventRequestDto);

    @Operation(summary = "Получить все мероприятия с конкретным именем")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Мероприятия успешно получены",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = EventResponseDto.class)))),
            @ApiResponse(responseCode = "204", description = "Ни одна запись не соответствует этому фильтру",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервиса",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class)))
    })
    @GetMapping("/find")
    ResponseEntity<List<EventResponseDto>> getEventsByTitle(@RequestParam(name = "title") String title);

    @Operation(summary = "Обновить информацию о мероприятии")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Информация успешно обновлена",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "400", description = "Ошибки при заполнении полей в теле сообщения или в запросе",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "Мероприятие с данным id не найдено, обновить невозможно",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервиса",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class)))
    })
    @PatchMapping(path = "/{id}")
    ResponseEntity<EventResponseDto> updateEvent(@PathVariable("id") Long id,
                                                 @RequestBody EventRequestDto eventRequestDto);

    @Operation(summary = "Получить мероприятие с конкретным id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Мероприятие успешно получено",
                    content = @Content(schema = @Schema(implementation = EventResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Ошибки при заполнении id в запросе",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "Мероприятие с данным id не найдено",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервиса",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class)))
    })
    @GetMapping(path = "/{id}")
    ResponseEntity<EventResponseDto> getEventById(@PathVariable("id") Long id);

    @Operation(summary = "Удалить мероприятие с конкретным id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Мероприятие успешно удалено",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "400", description = "Ошибки при заполнении id в запросе",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "Мероприятие с данным id не найдено",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервиса",
                    content = @Content(schema = @Schema(implementation = EventExceptionResponse.class)))
    })
    @DeleteMapping(path = "/{id}")
    ResponseEntity<EventResponseDto> deleteEventById(@PathVariable("id") Long id);

}
