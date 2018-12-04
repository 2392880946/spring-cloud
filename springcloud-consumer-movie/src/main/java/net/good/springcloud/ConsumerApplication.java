package net.good.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "SPRINGCLOUD-PRIVODER-USER", configuration = MyRibbonConfig.class)
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = { ExcudeAnnotation.class }) })
public class ConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {

        SpringApplication.run(ConsumerApplication.class, args);
    }
}
