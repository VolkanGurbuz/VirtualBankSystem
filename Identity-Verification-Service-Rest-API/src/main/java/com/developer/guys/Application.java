package com.developer.guys;

import com.developer.guys.Core.Utilities.Util.Util;
import com.developer.guys.Entities.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.soap.SOAPBody;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    Util util = new Util();

    SOAPBody soapBody = util.sendMessage(new Person("21892064260", "SEZER", "YILDIRIM", "1993"));

    System.out.println("isValid: " + util.isValid(soapBody));
  }
}
