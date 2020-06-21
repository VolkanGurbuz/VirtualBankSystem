package com.developer.guys.Business.Concrete;

import com.developer.guys.Business.Abstract.ICustomerService;
import com.developer.guys.Core.Utilities.Result.*;
import com.developer.guys.DataAccess.Abstract.ICustomerDal;
import com.developer.guys.Entity.Concrete.Customer;
import com.developer.guys.Entity.Dtos.BankAccountDto;
import com.developer.guys.Entity.Dtos.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.developer.guys.Core.Utilities.BankAccountTools.BankAccountOperations.generateBankAccount;

@Service
public class CustomerManager implements ICustomerService {

  @Autowired private ICustomerDal _customerDal;

  @Override
  public Result Update(UserLoginDto userLoginDto) {
    try {
      DataResult<Customer> customer = GetByTcNo(userLoginDto.getTcno());
      System.out.println(customer.Data);
      BankAccountDto bankAccountDto = new BankAccountDto();
      String accountNumber =
          generateBankAccount(userLoginDto.getTcno(), userLoginDto.getCurrency()).Data;
      System.out.println(accountNumber);
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
  public DataResult<Customer> GetByTcNo(String tc) {
    try {
      Customer customer = _customerDal.findByTcno(tc);
      System.out.println(customer);
      return new SuccessDataResult<>(customer);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ErrorDataResult<>(null, e.getMessage());
    }
  }
}
