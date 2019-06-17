package com.exadel.eventapp.provider.impl;

import com.exadel.eventapp.provider.Provider;
import com.exadel.eventapp.user.User;
import com.exadel.eventapp.user.UserGenerator;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class UserProvider implements Provider {

    private final UserGenerator userGenerator;

    private Map<Integer, User> userMap;

    @Override
    public User getById(Integer id) {
        return userMap.get(id);
    }

    private void onInit() {
        userMap = generateUserMap();
    }

    private Map<Integer, User> generateUserMap() {
        Map<Integer, User> map = new HashMap<>();
        IntStream.range(1, 11).forEach(i -> map.put(i, userGenerator.generate()));
        return map;
    }

    public Integer mapSize(){
        return userMap.size();
    }
}
