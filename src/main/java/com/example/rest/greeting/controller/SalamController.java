package com.example.rest.greeting.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.rest.greeting.entity.Salam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController                             //make this class as a REST Controller using springboot framework
public class SalamController {
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Halo, %s!";

    @GetMapping("/salam")                   //link the URI /salam to this method
    public Salam salam(@RequestParam(value = "nama", defaultValue = "Dunia") String nama){
        return new Salam(
            counter.incrementAndGet(),      //this will auto increase the value of 'counter'
            String.format(template, nama)   //this will put the name inputed in the URI to the template text
        );
    }

    @GetMapping("/salam/{nama}")
    public Salam salamUntukmu(@PathVariable final String nama){
        return new Salam(
            counter.incrementAndGet(),      //this will auto increase the value of 'counter'
            String.format(template, nama)   //this will put the name inputed in the URI to the template text
        );
    }
}
