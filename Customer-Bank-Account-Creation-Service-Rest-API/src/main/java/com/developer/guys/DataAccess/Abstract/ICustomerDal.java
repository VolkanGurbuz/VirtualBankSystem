package com.developer.guys.DataAccess.Abstract;

import com.developer.guys.Entity.Concrete.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ICustomerDal extends MongoRepository<Customer, String> {

    @Query("{'tcno':?0}")
    Customer findByTcno(String tc);
}
