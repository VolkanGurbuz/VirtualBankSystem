package com.developer.guys.DataAccess;

import com.developer.guys.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerDal extends MongoRepository<Customer, String> {
    
}
