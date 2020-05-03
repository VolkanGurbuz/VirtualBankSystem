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

    @BsonId
    private String Id;
    private String Name;
    private String Surname;
    private String Email;
    private String Password;

    @Nullable
    private List<CreditCard> creditCards;

    @Nullable
    private List<BankAccount> bankAccounts;
}

class BankAccount{
    private String AccountNumber;
    private String BranchCode;
    private String BranchName;
    private String IBANNumber;
    private String AccountCurrency;
    private String TypeOfAccount;
}

class CreditCard{
    private String CardNumber;
    private String ExpirationDate;
    private String CVC;
    private String CreditCardType;
}

