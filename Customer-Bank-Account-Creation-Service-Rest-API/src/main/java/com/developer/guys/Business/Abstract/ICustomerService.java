package com.developer.guys.Business.Abstract;

import com.developer.guys.Core.Utilities.Result.DataResult;
import com.developer.guys.Core.Utilities.Result.Result;
import com.developer.guys.Entity.Concrete.Customer;
import com.developer.guys.Entity.Dtos.UserLoginDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Result Update(UserLoginDto userLoginDto);
    DataResult<Customer> GetByTcNo(String tc);
    DataResult<Optional<Customer>> GetById(String id);
    DataResult<List<Customer>> GetByName(String name);
    Result Add(Customer customer);
}
