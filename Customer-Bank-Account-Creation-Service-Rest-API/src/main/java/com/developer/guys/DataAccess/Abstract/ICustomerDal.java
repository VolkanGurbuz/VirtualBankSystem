package com.developer.guys.DataAccess.Abstract;

import com.developer.guys.Entity.Concrete.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerDal extends MongoRepository<Customer, String> {
    @Query("{'tcno' : ?0}")
    Customer findByTcno(String tcno);
    @Query("{'name' : {$regex : ?0, $options: 'i'}}")
    List<Customer> findByName(String name);
}
