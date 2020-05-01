package com.developer.guys.Entity.Concrete;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount{
    private String AccountNumber;
    private String BranchCode;
    private String BranchName;
    private String IBANNumber;
    private String AccountCurrency;
    private String TypeOfAccount;
}
