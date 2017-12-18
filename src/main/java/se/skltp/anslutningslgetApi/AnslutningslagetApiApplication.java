package se.skltp.anslutningslgetApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "se.skltp.anslutningslgetApi.*" })
public class AnslutningslagetApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AnslutningslagetApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AnslutningslagetApiApplication.class, args);
    }
}
