package nl.hu.bep.FishySystem;

import nl.hu.bep.FishySystem.model.Testdata;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"nl.hu.bep.FishySystem.controller"})
public class DemoApplication {
    public static void main(String[] args) {
        Testdata.maaktestdata();
        SpringApplication.run(DemoApplication.class, args);
    }

}
