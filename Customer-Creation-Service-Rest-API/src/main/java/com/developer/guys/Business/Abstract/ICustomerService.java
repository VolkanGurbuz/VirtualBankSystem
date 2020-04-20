package com.developer.guys.Business.Abstract;

import com.developer.guys.Core.Utilities.Result.DataResult;
import com.developer.guys.Core.Utilities.Result.Result;
import com.developer.guys.Entity.Concrete.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    DataResult<List<Customer>> GetAll();
    DataResult<Optional<Customer>> GetById(String id);
    Result Add(Customer customer);
    Result Delete(Customer customer);
}
