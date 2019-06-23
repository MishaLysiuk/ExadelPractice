package com.exadel.eventapp.provider;

import com.exadel.eventapp.user.User;

public interface Provider {

    User getById(Integer id);

}
