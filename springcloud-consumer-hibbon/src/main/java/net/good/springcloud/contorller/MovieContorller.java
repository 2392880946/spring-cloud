package net.good.springcloud.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieContorller {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return restTemplate.getForObject("http://springcloud-privoder-user/simple/" + name, String.class);
    }

    @GetMapping("/test")
    public void test() {
        ServiceInstance instance = this.loadBalancerClient.choose("SPRINGCLOUD-PRIVODER-USER");
        System.out.println("111: " + instance.getServiceId() + ": " + instance.getHost() + ": " + instance.getPort());
    }

}