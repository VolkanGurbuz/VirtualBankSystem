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
public class CreditCard {
    private String CardNumber;
    private String ExpirationDate;
    private String CVC;
    private String CreditCardType;
}
