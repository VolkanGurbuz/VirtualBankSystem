package com.developer.guys.RestApi;

import com.developer.guys.Business.Abstract.ICustomerService;
import com.developer.guys.Business.Constants.Messages;
import com.developer.guys.Core.Utilities.Result.DataResult;
import com.developer.guys.Core.Utilities.Result.Result;
import com.developer.guys.Entity.Concrete.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private ICustomerService _customerService;

    @GetMapping("/customers")
    public ResponseEntity<?> GetAll(){
        DataResult<List<Customer>> result = _customerService.GetAll();

        if (result.Success) {
            return new ResponseEntity<>(result.Data, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/customers/find{id}")
    public ResponseEntity<?> GetById(String id){
        DataResult<Optional<Customer>> result = _customerService.GetById(id);

        if (result.Success) {
            return new ResponseEntity<>(result.Data, HttpStatus.OK);
        }
        return new ResponseEntity<>(result.Message, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/customers/add")
    public ResponseEntity<?> Add(@RequestBody Customer customer){
        Result result = _customerService.Add(customer);

        if (result.Success) {
            return new ResponseEntity<>(result.Message, HttpStatus.OK);
        }
        return new ResponseEntity<>(Messages.SomethingWrong, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/customers/delete")
    public ResponseEntity<?> Delete(@RequestBody Customer customer){
        Result result = _customerService.Delete(customer);

        if (result.Success) {
            return new ResponseEntity<>(result.Message, HttpStatus.OK);
        }
        return new ResponseEntity<>(Messages.SomethingWrong, HttpStatus.BAD_REQUEST);

    }

}
