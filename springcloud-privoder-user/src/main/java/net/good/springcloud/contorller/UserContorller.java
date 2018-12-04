package net.good.springcloud.contorller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UserContorller {

    @RequestMapping("/simple/{name}")
    public String helloWorld(@PathVariable String name) {
        return name + "HelloWorld";
    }

}
