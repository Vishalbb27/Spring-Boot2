package com.example.MycoolApp.rest;

import com.example.MycoolApp.common.Coach;
import com.example.MycoolApp.common.CricketCoach;
import com.example.MycoolApp.common.TennisCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Coach myCoach;

    @Autowired
    public Controller(@Qualifier("tennisCoach") Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/rest/cricketCoach")
    public String coach(){
        System.out.println("hi");
        return myCoach.getDailyWorkout();
    }


}
