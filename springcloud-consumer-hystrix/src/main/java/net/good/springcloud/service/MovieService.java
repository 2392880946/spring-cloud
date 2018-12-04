package net.good.springcloud.service;

import com.netflix.ribbon.proxy.annotation.Hystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "springcloud-privoder-user", fallback = MovieServiceHystric.class)

public interface MovieService {

    @RequestMapping(value = "/simple/{name}")
    public String helloWorld(@PathVariable("name") String name);

}