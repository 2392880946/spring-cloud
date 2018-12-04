package net.good.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class MovieServiceHystric implements MovieService {
    @Override
    public String helloWorld(String name) {
        return "sorry " + name;
    }
}
