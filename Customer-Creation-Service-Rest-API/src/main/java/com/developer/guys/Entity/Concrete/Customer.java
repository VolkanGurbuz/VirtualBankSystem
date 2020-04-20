package com.developer.guys.Entity.Concrete;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Getter
@Setter
@Document
public class Customer {
    @Id
    private String id;
    private String adi;
    private String soyadi;
    private HashMap ozellikleri;
}
