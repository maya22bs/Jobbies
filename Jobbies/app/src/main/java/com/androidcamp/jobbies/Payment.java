package com.androidcamp.jobbies;

import java.util.Currency;

/**
 * Created by Karolina Pawlikowska on 8/4/16.
 */
public class Payment {

    private int price;
    private Currency currency;
    private static final String[] availableCurrencies = {
            "USD",
            "EUR",
            "GBP",
            "PLN"
    };

    public Payment(int price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public Payment(String str) {
        this(Integer.parseInt(str.split(" ")[0]), Currency.getInstance(str.split(" ")[1]));
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public static String[] getAvailableCurrencies() {
        return availableCurrencies;
    }

    @Override
    public String toString() {
        return String.valueOf(price) + " " + currency.getCurrencyCode();
    }
}
