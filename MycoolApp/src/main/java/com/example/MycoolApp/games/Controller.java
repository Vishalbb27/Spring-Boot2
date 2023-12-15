//package com.example.MycoolApp.games;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class Controller {
//
//    private CricketCoach cricketCoach;
//
//    @Autowired
//    public Controller(CricketCoach cricketCoach){
//        cricketCoach = cricketCoach;
//    }
//
//    @GetMapping("/crickeCoach")
//    public String coach(){
//        System.out.println("hi");
//        return cricketCoach.getDailyWorkout();
//    }
//}
