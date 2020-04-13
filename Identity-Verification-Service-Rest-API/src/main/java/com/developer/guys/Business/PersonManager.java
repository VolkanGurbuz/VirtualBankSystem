package com.developer.guys.Business;

import com.developer.guys.Core.Utilities.Messages.StaticMessages;
import com.developer.guys.Core.Utilities.Results.ErrorResult;
import com.developer.guys.Core.Utilities.Results.Result;
import com.developer.guys.Core.Utilities.Results.SuccessResult;
import com.developer.guys.Core.Utilities.Util.Util;
import com.developer.guys.Entities.Person;
import org.springframework.stereotype.Service;

import javax.xml.soap.SOAPBody;

@Service
public class PersonManager implements IPersonService{

    @Override
    public Result verifyPerson(Person person) {
        try {
            Util util = new Util();
            SOAPBody soapBody = util.sendMessage(person);
            boolean result = util.isValid(soapBody);
            if (result){
                return new SuccessResult(StaticMessages.SuccessVerification);
            }
            else
                return new ErrorResult(StaticMessages.NonSuccessVerification);

        }
        catch (Exception e){
            return new ErrorResult(StaticMessages.ErrorVerification + " - Error Details: " + e.getMessage());
        }
        //return null;
    }
}
