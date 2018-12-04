package net.good.springcloud.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import net.good.springcloud.service.MovieService;

@RestController
public class MovieContorller {
    @Autowired
    private MovieService movieService;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return movieService.helloWorld(name);
    }

}