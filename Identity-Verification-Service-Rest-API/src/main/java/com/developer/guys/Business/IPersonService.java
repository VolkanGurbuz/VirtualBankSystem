package com.developer.guys.Business;

import com.developer.guys.Core.Utilities.Results.Result;
import com.developer.guys.Entities.Person;

public interface IPersonService {
    Result verifyPerson(Person person);
}
