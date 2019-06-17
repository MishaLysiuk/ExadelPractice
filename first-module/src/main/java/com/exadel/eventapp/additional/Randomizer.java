package com.exadel.eventapp.additional;

import java.util.Random;

public class Randomizer {
    public static Integer generateRandomNumber(Integer size){
            Random random = new Random();
            return random.nextInt(size);
    }
}
