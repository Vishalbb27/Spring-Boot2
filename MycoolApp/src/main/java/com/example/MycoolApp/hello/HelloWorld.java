package com.example.MycoolApp.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public Hello HelloWorldApplication(){
        Hello hello = new Hello();
        hello.setHello("Hello World");
        return hello;
    }

    @GetMapping("/fortune/{data}")
    public Hello FortuneController(@PathVariable("data") String data){
        Hello hello = new Hello();
        hello.setHello(data+"Fortune");
        return hello;
    }
}
