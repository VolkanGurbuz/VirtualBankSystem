package com.developer.guys.Entity.Dtos;

import com.developer.guys.Core.Entities.IDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BankAccountDto implements IDto {
    private String AccountNumber;
    private String BranchCode;
    private String BranchName;
    private String IBANNumber;
    private String AccountCurrency;
    private String TypeOfAccount;
}
