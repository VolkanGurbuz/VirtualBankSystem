package com.developer.guys.Entity.Concrete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard{
    private String CardNumber;
    private String ExpirationDate;
    private String CVC;
    private String CreditCardType;
}
