package com.developer.guys;

import com.developer.guys.Business.Concrete.CustomerManager;
import com.developer.guys.Core.Utilities.Result.Result;
import com.developer.guys.Entity.Dtos.UserLoginDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
