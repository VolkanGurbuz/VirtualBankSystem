package com.developer.guys.Core.Utilities.BankAccountTools;

import com.developer.guys.Core.Utilities.Constants.Messages;
import com.developer.guys.Core.Utilities.Result.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class BankAccountOperations {

    private static List<Currency> currencyList = Arrays.asList(
            new Currency("01", "EUR"),
            new Currency("02", "USD"),
            new Currency("03", "TRY"),
            new Currency("04", "GBP"),
            new Currency("05", "AUD"),
            new Currency("06", "CAD")
            );

    public static DataResult<String> generateBankAccount(String tc, String currency){
        try {
            String bankAccount = "";
            String lastFourNumber = tc.substring(tc.length() - 4);
            DataResult<Currency> getCurrency = getCurrencyCode(currency.toUpperCase());
            bankAccount += lastFourNumber;

            if (getCurrency.Success)
                bankAccount += getCurrency.Data.currencyCode;
            else
                return new ErrorDataResult<String>(null, getCurrency.Message);

            bankAccount += generateRandomNumber(99, 0);

            if (bankAccount.length() != 8){
                return new ErrorDataResult<String>(null, Messages.BankAccountLengthError + " Number: " + bankAccount);
            }

            return new SuccessDataResult<String>(bankAccount, Messages.CreateSuccessBankAccount);
        }
        catch (Exception e){
            return new ErrorDataResult<String>(null, Messages.Fail + " Details: " + e.getMessage());
        }
    }

    private static String generateRandomNumber(int max, int min){
        Random random = new Random(System.nanoTime());
        int number = random.nextInt((max - min) + 1) + min;
        if (number < 10)
            return "0" + number;
        else
            return String.valueOf(number);
    }

    private static DataResult<Currency> getCurrencyCode(String currency){
        Currency cur = currencyList.stream()
                .filter(x -> x.getCurrency().equals(currency)).findFirst().orElse(null);
        if (cur != null){
            return new SuccessDataResult<Currency>(cur, Messages.Success);
        }
        return new ErrorDataResult<Currency>(null, Messages.CurrencyNotFound);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Currency{
        String currencyCode;
        String currency;
    }
}
