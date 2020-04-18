package com.developer.guys.RestApi;

import com.developer.guys.DataAccess.ICustomerDal;
import com.developer.guys.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerDal _customerDal;

    @PostMapping
    public ResponseEntity<Customer> Register(@RequestBody Customer customer){
        return ResponseEntity.ok(_customerDal.save(customer));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> GetList(){
        return ResponseEntity.ok(_customerDal.findAll());
    }



}
