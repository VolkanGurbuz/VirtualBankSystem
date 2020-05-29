package com.developer.guys.RestApi;

import com.developer.guys.Business.Abstract.ICustomerService;
import com.developer.guys.Business.Constants.Messages;
import com.developer.guys.Core.Utilities.Result.DataResult;
import com.developer.guys.Core.Utilities.Result.Result;
import com.developer.guys.Entity.Concrete.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class CustomerController {

  @Autowired private ICustomerService _customerService;

  @GetMapping("/customers")
  public ResponseEntity<?> GetAll() {
    DataResult<List<Customer>> result = _customerService.GetAll();

    if (result.Success) {
      return new ResponseEntity<>(result.Data, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/customers/{id}")
  public ResponseEntity<?> GetById(@PathVariable String id) {
    DataResult<Optional<Customer>> result = _customerService.GetById(id);

    if (result.Success) {
      return new ResponseEntity<>(result.Data, HttpStatus.OK);
    }
    return new ResponseEntity<>(result.Message, HttpStatus.BAD_REQUEST);
  }

  @PostMapping("/customers/add")
  public ResponseEntity<?> Add(@RequestBody Customer customer, ResponseEntity responseEntity) {
    Result result = _customerService.Add(customer);

    if (result.Success) {
      return new ResponseEntity<>(result.Message, HttpStatus.OK);
    }
    return new ResponseEntity<>(Messages.SomethingWrong, HttpStatus.BAD_REQUEST);
  }

  @PostMapping("/customers/register")
  public String greetingSubmit(@ModelAttribute Customer customer, Model model) {
    Result result = _customerService.Add(customer);
    String resultMessage = result.getMessage();

    model.addAttribute("resultmessage", resultMessage);

    return "bank/welcome";
  }

  @GetMapping("/customers/register")
  public String Add(@ModelAttribute Customer customer, Model model) {
    // Result result = _customerService.Add(customer);
    model.addAttribute("customer", customer);

    return "bank/register";
  }

  @DeleteMapping("/customers/delete")
  public ResponseEntity<?> Delete(@RequestBody Customer customer) {
    Result result = _customerService.Delete(customer);

    if (result.Success) {
      return new ResponseEntity<>(result.Message, HttpStatus.OK);
    }
    return new ResponseEntity<>(Messages.SomethingWrong, HttpStatus.BAD_REQUEST);
  }
}
