package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.context.annotation.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

}
