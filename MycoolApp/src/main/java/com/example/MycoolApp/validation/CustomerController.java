package com.example.MycoolApp.validation;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    //add an initbinder ... to convert trim input strings
    //remove leading and trailing whitespace
    //resolve issue for our validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);

    }

    @GetMapping("/customer/post")
    public String showCustomer(Model theModel){
        theModel.addAttribute("customer",new Customer());
        return "customer-form";
    }

    @PostMapping("/customer")
    public String processCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult){
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }
        else {
            return "customer-confiramtion";
        }
    }
}
