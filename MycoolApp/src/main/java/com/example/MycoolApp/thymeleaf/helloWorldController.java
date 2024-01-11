package com.example.MycoolApp.thymeleaf;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class helloWorldController {

    @Value("${countries}")
    private List<String> countries;

    List<String> students = new ArrayList<>();
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld";
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("studentname") String theName, Model model){
        //Read the request parameter from the HTML form
        //convert the data to all caps
        theName = theName.toUpperCase();
        //create the message
        String result = theName;
        students.add(result);
        //add message to the model
        model.addAttribute("students",students);
        model.addAttribute("message",result);
        return "helloworld";
    }
}
