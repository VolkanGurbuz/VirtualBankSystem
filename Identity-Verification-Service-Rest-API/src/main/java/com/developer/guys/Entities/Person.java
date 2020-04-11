package com.developer.guys.Entities;

import com.developer.guys.Core.Utilities.Entities.IEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person implements IEntity {
    private long TC;
    private String Name;
    private String Surname;
    private int BirthYear;
}
