package com.rntgroup.event.service.request;

import com.rntgroup.event.service.enums.EventTypeDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventRequestDto {

    @Schema(description = "Название мероприятия",
            example = "Выставка картин эпохи Возрождения")
    String title;

    @Schema(description = "Место",
            example = "5")
    Integer place;

    @Schema(description = "Выступающий на мероприятии (спикер)",
            example = "Антон Р.")
    String speaker;

    @Schema(description = "Тип мероприятия (значение выбирается из списка EventTypeDto)",
            example = "PRESENTATION")
    EventTypeDto eventType;

    @Schema(description = "Дата и время начала мероприятия",
            example = "2022-09-25 19:00:00.000")
    LocalDateTime dateTime;

}
