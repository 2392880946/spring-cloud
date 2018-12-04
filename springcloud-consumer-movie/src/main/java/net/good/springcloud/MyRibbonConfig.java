package net.good.springcloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcudeAnnotation
public class MyRibbonConfig {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}