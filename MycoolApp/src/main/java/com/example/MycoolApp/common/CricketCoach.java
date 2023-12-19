package com.example.MycoolApp.common;

import com.example.MycoolApp.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("CricketCoach")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff"+ getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("DoMyCleanUpStuff"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "hi";
    }


}
