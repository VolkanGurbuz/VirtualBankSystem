package com.developer.guys.Entity.Dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDto {
    private String accountNumber;
    private String branchCode;
    private String branchName;
    private String IBANNumber;
    private String accountCurrency;
    private String typeOfAccount;
}
