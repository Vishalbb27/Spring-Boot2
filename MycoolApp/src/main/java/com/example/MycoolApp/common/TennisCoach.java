package com.example.MycoolApp.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("TennisCoach")
public class TennisCoach  implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "how";
    }
}
