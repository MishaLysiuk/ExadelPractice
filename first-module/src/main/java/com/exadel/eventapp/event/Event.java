package com.exadel.eventapp.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Event {
    private Long millisec;
    private EventType type;
    private String message;
}
