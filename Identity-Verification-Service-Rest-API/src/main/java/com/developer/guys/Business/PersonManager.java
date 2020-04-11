package com.developer.guys.Business;

import com.developer.guys.Core.Utilities.Results.ErrorResult;
import com.developer.guys.Core.Utilities.Results.Result;
import com.developer.guys.Core.Utilities.Results.SuccessResult;
import com.developer.guys.Core.Utilities.Util.Util;
import com.developer.guys.Entities.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonManager implements IPersonService{

    @Override
    public Result verifyPerson(Person person) {
        //Test Data Example
//        try {
//            Util.sendMessage(person);
//            if ()
//        }
//        catch (Exception e){
//            return new ErrorResult(e.getMessage());
//        }
        return null;
    }
}
