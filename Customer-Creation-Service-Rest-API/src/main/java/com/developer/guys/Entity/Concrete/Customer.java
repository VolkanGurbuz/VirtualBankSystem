package com.developer.guys.Entity.Concrete;

import com.developer.guys.Core.Entities.IEntity;
import com.mongodb.lang.Nullable;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Customer")
public class Customer implements IEntity {

  @BsonId private String id;
  private String tcno;
  private String birthdate;
  private String name;
  private String surName;
  private String email;
  private String password;
  private String address;

  @Nullable private List<CreditCard> creditCards;

  @Nullable private List<BankAccount> bankAccounts;
}

class BankAccount {
  private String accountNumber;
  private String branchCode;
  private String branchName;
  private String IBANNumber;
  private String accountCurrency;
  private String typeOfAccount;
}

class CreditCard {
  private String CardNumber;
  private String ExpirationDate;
  private String CVC;
  private String CreditCardType;
}
