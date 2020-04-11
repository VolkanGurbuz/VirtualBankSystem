package com.developer.guys.Business;

import com.developer.guys.Core.Utilities.Results.Result;
import com.developer.guys.Core.Utilities.Results.SuccessResult;
import com.developer.guys.Entities.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonManager implements IPersonService{

    @Override
    public Result verifyPerson(Person person) {
        //Test Data Example
        SuccessResult successResult = new SuccessResult();
        successResult.Message = "Kişi Başarıyla Tanımlandı.";
        return successResult;
    }
}
