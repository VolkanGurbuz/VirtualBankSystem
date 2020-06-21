package com.developer.guys.Business.Concrete;

import com.developer.guys.Business.Abstract.ICustomerService;
import com.developer.guys.Business.Constants.Messages;
import com.developer.guys.Core.Utilities.PasswordTools.PasswordUtils;
import com.developer.guys.Core.Utilities.Result.*;
import com.developer.guys.DataAccess.Abstract.ICustomerDal;
import com.developer.guys.Entity.Concrete.Customer;
import com.developer.guys.Entity.Dtos.BankAccountDto;
import com.developer.guys.Entity.Dtos.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import static com.developer.guys.Core.Utilities.BankAccountTools.BankAccountOperations.generateBankAccount;

@Service
public class CustomerManager implements ICustomerService {

    @Autowired
    private ICustomerDal _customerDal;

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
    public DataResult<List<Customer>> GetByName(String name) {
        List<Customer> tempResult = _customerDal.findByName(name);
        if (tempResult != null){
            return new SuccessDataResult<List<Customer>>(tempResult, Messages.CustomerFound);
        }
        else
            return new ErrorDataResult<List<Customer>>(null, Messages.CustomerNotFound);
    }

    @Override
    public Result Update(UserLoginDto userLoginDto) {
        try {
            DataResult<Customer> customer = GetByTcNo(userLoginDto.getTcno());
            BankAccountDto bankAccountDto = new BankAccountDto();
            String accountNumber = generateBankAccount(userLoginDto.getTcno(), userLoginDto.getCurrency()).Data;
            bankAccountDto.setAccountNumber(accountNumber);
            bankAccountDto.setAccountCurrency(userLoginDto.getCurrency());
            bankAccountDto.setBranchCode("001");
            bankAccountDto.setIBANNumber("TR1000000000000000" + accountNumber);
            bankAccountDto.setTypeOfAccount("Personel");

            List bankAccountList = customer.Data.getBankAccounts();
            bankAccountList.add(bankAccountDto);

            customer.Data.setBankAccounts(bankAccountList);

            _customerDal.save(customer.Data);

            return new SuccessResult("Başarıyla Eklendi");
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());
        }
    }

    @Override
    public DataResult<Customer> GetByTcNo(String tcno) {
        Customer tempResult = _customerDal.findByTcno(tcno);
        if (tempResult != null){
            return new SuccessDataResult<Customer>(tempResult, Messages.CustomerFound);
        }
        else
            return new ErrorDataResult<Customer>(null, Messages.CustomerNotFound);
    }

    @Override
    public Result Add(Customer customer) {
        _customerDal.save(customer);
        return new SuccessResult(Messages.CustomerDeleted);
    }
}
