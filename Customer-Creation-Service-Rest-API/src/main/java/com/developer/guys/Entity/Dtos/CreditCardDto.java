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
public class CreditCardDto implements IDto {
    private String CardNumber;
    private String ExpirationDate;
    private String CVC;
    private String CreditCardType;
}
