package com.exadel.eventapp.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long millisec;
    private EventType type;
    private String message;
}
