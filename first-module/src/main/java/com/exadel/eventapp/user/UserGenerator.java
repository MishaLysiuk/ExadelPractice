package com.exadel.eventapp.user;

import com.exadel.eventapp.additional.Generator;

public class UserGenerator implements Generator<User> {
    @Override
    public User generate() {
        return User.builder()
                .firstName("Misha")
                .lastName("Lysiuk")
                .build();
    }
}
