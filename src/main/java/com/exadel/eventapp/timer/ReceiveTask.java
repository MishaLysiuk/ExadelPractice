package com.exadel.eventapp.timer;

import com.exadel.eventapp.eventstorage.EventStorage;
import lombok.AllArgsConstructor;

import java.util.TimerTask;

@AllArgsConstructor
public class ReceiveTask extends TimerTask {
    private EventStorage eventStorage;

    @Override
    public void run() {
        eventStorage.receive();
    }
}
