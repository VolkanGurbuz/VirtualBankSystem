package com.developer.guys.Entity.Concrete;

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
public class Customer {

    @BsonId
    private String Id;
    private String Name;
    private String Surname;
    private String Email;
    private String Password;
    private List<CreditCard> creditCards;
    private List<BankAccount> bankAccounts;
}

