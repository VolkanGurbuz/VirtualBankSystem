package com.developer.guys;

import com.developer.guys.Core.Utilities.Util.Util;
import com.developer.guys.Entities.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Util.sendMessage(new Person(
                "21892064260","SEZER","YILDIRIM","1993"
        ));
    }
}
