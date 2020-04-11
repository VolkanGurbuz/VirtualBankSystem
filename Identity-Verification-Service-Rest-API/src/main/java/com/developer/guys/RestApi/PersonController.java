package com.developer.guys.RestApi;

import com.developer.guys.Business.*;
import com.developer.guys.Core.Utilities.Results.Result;
import com.developer.guys.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {

    private IPersonService personService;

    @Autowired
    public PersonController(IPersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/verify")
    public ResponseEntity<?> get(Person person){

        Result result = personService.verifyPerson(person);

        if (result.Success) {
            return new ResponseEntity<>(result.Message, HttpStatus.OK);
        }
        return new ResponseEntity<>(result.Message, HttpStatus.BAD_REQUEST);
    }


}
