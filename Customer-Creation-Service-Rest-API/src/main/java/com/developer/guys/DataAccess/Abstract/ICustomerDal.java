package com.developer.guys.DataAccess.Abstract;

import com.developer.guys.Entity.Concrete.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerDal extends MongoRepository<Customer, String> {
}
