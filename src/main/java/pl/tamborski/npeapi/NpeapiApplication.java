package pl.tamborski.npeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class NpeapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NpeapiApplication.class, args);
    }

}
