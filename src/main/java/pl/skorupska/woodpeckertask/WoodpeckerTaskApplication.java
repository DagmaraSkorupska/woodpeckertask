package pl.skorupska.woodpeckertask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;

@SpringBootApplication
public class WoodpeckerTaskApplication {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(WoodpeckerTaskApplication.class, args);
    }
}