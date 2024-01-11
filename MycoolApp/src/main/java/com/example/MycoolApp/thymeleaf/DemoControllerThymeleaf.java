package com.example.MycoolApp.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/thymeleaf")
public class DemoControllerThymeleaf {
    @GetMapping("/hello")
    public String sayHello(Model theModle){
        theModle.addAttribute("theDate",new java.util.Date());
        return "helloworld";
    }

}
