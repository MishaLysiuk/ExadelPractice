package com.exadel.eventapp.config;

import com.exadel.eventapp.eventstorage.EventStorage;
import com.exadel.eventapp.generator.*;
import com.exadel.eventapp.provider.impl.UserProvider;
import com.exadel.eventapp.publisher.Publisher;
import com.exadel.eventapp.publisher.impl.PublisherImpl;
import com.exadel.eventapp.subscriber.*;
import com.exadel.eventapp.timer.CustomTimer;
import com.exadel.eventapp.timer.PublishTask;
import com.exadel.eventapp.timer.ReceiveTask;
import com.exadel.eventapp.user.UserGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@Configuration
public class Context {

    //Timer
    @Bean(initMethod = "onInit")
    public CustomTimer customTimer(){
        return new CustomTimer(publishTask(), receiveTask());
    }

    @Bean
    public ReceiveTask receiveTask(){
        return new ReceiveTask(eventStorage());
    }

    @Bean
    public PublishTask publishTask(){
        return new PublishTask(publisher());
    }

    //Subscriber's list
    @Bean
    public EventStorage eventStorage(){
        List<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(customSubscriber());
        subscribers.add(errorSubscriber());
        subscribers.add(infoSubscriber());
        subscribers.add(systemSubscriber());
        subscribers.add(userSubscriber());
        return new EventStorage(subscribers);
    }

    //Publisher
    @Bean
    public Publisher publisher(){
        List<MainGenerator> generators = new ArrayList<>();
        generators.add(customGenerator());
        generators.add(errorGenerator());
        generators.add(infoGenerator());
        generators.add(systemGenerator());
        generators.add(userGeneratorEvent());
        return new PublisherImpl(eventStorage(),generators);
    }

    // Generators
    @Bean
    public CustomEventGenerator customGenerator(){
        return new CustomEventGenerator();
    }

    @Bean
    public ErrorEventGenerator errorGenerator(){
        return new ErrorEventGenerator();
    }

    @Bean
    public InfoEventGenerator infoGenerator(){
        return new InfoEventGenerator();
    }

    @Bean
    public SystemEventGenerator systemGenerator(){
        return new SystemEventGenerator();
    }

    @Bean //userProvider
    public UserEventGenerator userGeneratorEvent(){
        return new UserEventGenerator(userProvider());
    }

    @Bean
    public UserGenerator userGenerator(){
        return new UserGenerator();
    }

//Subscribers

    @Bean
    public CustomSubscriber customSubscriber(){
        return new CustomSubscriber();
    }

    @Bean
    public ErrorSubscriber errorSubscriber(){
        return new ErrorSubscriber();
    }

    @Bean
    public InfoSubscriber infoSubscriber(){
        return new InfoSubscriber();
    }

    @Bean
    public SystemSubscriber systemSubscriber(){
        return new SystemSubscriber();
    }

    @Bean
    public UserSubscriber userSubscriber(){
        return new UserSubscriber(userProvider());
    }

//Providers

    @Bean(initMethod = "onInit")
    public UserProvider userProvider(){
        return new UserProvider(userGenerator());
    }

}
