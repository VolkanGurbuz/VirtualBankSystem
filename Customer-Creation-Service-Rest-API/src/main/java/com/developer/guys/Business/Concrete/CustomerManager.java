package com.developer.guys.Business.Concrete;

import com.developer.guys.Business.Abstract.ICustomerService;
import com.developer.guys.Business.Constants.Messages;
import com.developer.guys.Core.Utilities.Result.*;
import com.developer.guys.DataAccess.Abstract.ICustomerDal;
import com.developer.guys.Entity.Concrete.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerManager implements ICustomerService {

    @Autowired
    private ICustomerDal _customerDal;

    @Override
    public DataResult<List<Customer>> GetAll() {
        List<Customer> customerList = _customerDal.findAll();
        if (customerList != null){
            return new SuccessDataResult<List<Customer>>(customerList, Messages.CustomerFound);
        }
        else
            return new ErrorDataResult<List<Customer>>(null, Messages.CustomerNotFound);
    }

    @Override
    public DataResult<Optional<Customer>> GetById(String id) {
        Optional<Customer> tempResult = _customerDal.findById(id);
        if (tempResult != null){
            return new SuccessDataResult<Optional<Customer>>(tempResult, Messages.CustomerFound);
        }
        else
            return new ErrorDataResult<Optional<Customer>>(null, Messages.CustomerNotFound);
    }

    @Override
    public Result Add(Customer customer) {
        _customerDal.save(customer);
        return new SuccessResult(Messages.CustomerAdded);
    }

    @Override
    public Result Delete(Customer customer) {
        _customerDal.delete(customer);
        return new SuccessResult(Messages.CustomerDeleted);
    }
}
