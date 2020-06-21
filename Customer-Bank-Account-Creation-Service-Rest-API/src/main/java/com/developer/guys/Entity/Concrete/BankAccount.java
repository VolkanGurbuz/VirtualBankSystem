package com.developer.guys.Entity.Concrete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class BankAccount {
    private String accountNumber;
    private String branchCode;
    private String branchName;
    private String IBANNumber;
    private String accountCurrency;
    private String typeOfAccount;
}
