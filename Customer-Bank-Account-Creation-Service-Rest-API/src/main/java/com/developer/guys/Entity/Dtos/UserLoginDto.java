package com.developer.guys.Entity.Dtos;

import com.developer.guys.Core.Entities.IDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto implements IDto {
    private String tcno;
    private String password;
    private String currency;
}
