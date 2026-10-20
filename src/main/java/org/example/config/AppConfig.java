package org.example.config;

import java.util.List;

// Singleton configuration class
public class AppConfig {
    private static AppConfig instance;

    private final String applicationName;
    private final String currency;
    private final double taxRate;
    private final List<String> supportedCurrencies;
    private AppConfig(){
        this.applicationName = "Bootcamp Payment App";
        this.currency = "EUR";
        this.taxRate = 0.21;
        this.supportedCurrencies = List.of("EUR", "USD");
    }

    public static AppConfig getInstance(){
        if (instance == null){
            instance = new AppConfig();
        }
        return instance;
    }
    public boolean isCurrencySupported(String currency) {
        return supportedCurrencies.contains(currency.toUpperCase());
    }

    public String getApplicationName() {
        return applicationName;
    }
    public String getCurrency() {
        return currency;
    }
    public double getTaxRate() {
        return taxRate;
    }
}
