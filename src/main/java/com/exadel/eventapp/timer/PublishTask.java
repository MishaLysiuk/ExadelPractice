package com.exadel.eventapp.timer;

import com.exadel.eventapp.publisher.Publisher;
import lombok.AllArgsConstructor;

import java.util.TimerTask;

@AllArgsConstructor
public class PublishTask extends TimerTask {

    private Publisher publisher;

    @Override
    public void run() {
        publisher.publish();
    }
}
