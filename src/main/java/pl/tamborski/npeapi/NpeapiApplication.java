package pl.tamborski.npeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


//@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class NpeapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NpeapiApplication.class, args);
    }

}
