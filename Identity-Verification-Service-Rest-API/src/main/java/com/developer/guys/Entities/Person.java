package com.developer.guys.Entities;

import com.developer.guys.Core.Utilities.Entities.IEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class Person implements IEntity {
  private String TC;
  private String Name;
  private String Surname;
  private String BirthYear;
}
