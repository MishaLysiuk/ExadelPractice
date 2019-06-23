package com.exadel.eventapp.timer;

import lombok.AllArgsConstructor;

import java.util.Timer;

@AllArgsConstructor
public class CustomTimer extends Timer {
    private static Long TIME_BASE = 1000L;
    private static Long DELAY = 0L;
    private static Long PERIOD = 1 * TIME_BASE;

    private PublishTask publishTask;

    private ReceiveTask receiveTask;

    private void onInit()
    {
        this.schedule(publishTask, DELAY, PERIOD);
        this.schedule(receiveTask, DELAY, TIME_BASE);
    }
}
