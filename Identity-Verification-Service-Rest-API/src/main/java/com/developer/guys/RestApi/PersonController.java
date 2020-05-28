package com.developer.guys.RestApi;

import com.developer.guys.Business.*;
import com.developer.guys.Core.Utilities.Results.Result;
import com.developer.guys.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

  private IPersonService personService;

  @Autowired
  public PersonController(IPersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/verify")
  public String verifyPerson(@ModelAttribute Person person, Model model) {
    model.addAttribute("person", person);
    return "verify";
  }

  @PostMapping("/verify")
  public String greetingSubmit(@ModelAttribute Person person, Model model) {
    // Getting Result From PersonService
    Result result = personService.verifyPerson(person);
    String resultMessage = result.getMessage();

    model.addAttribute("resultmessage", resultMessage);

    return "result";
  }
}
