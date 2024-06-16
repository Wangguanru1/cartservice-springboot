package edu.whu.cartstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;


@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class CartstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartstoreApplication.class, args);
    }

}
