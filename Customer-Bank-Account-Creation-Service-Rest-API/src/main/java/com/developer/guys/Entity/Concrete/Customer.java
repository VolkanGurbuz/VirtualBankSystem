package com.developer.guys.Entity.Concrete;

import com.developer.guys.Core.Entities.IEntity;
import com.mongodb.lang.Nullable;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

  @DBRef
  @Nullable private List<CreditCard> creditCards;

  @DBRef
  @Nullable private List<BankAccount> bankAccounts;
}
