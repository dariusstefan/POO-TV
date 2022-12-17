package entities;

import input.CredentialsInput;

public final class Credentials {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    public Credentials(final CredentialsInput credsInput) {
        this.name = credsInput.getName();
        this.password = credsInput.getPassword();
        this.accountType = credsInput.getAccountType();
        this.country = credsInput.getCountry();
        this.balance = credsInput.getBalance();
    }

    public Credentials(final Credentials creds) {
        this.name = creds.getName();
        this.password = creds.getPassword();
        this.accountType = creds.getAccountType();
        this.country = creds.getCountry();
        this.balance = creds.getBalance();
    }

    /**This method returns a deep-copied object of this class for the JSON putPOJO method.**/
    public Credentials pojoCopy() {
        return new Credentials(this);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getCountry() {
        return country;
    }

    public String getBalance() {
        return balance;
    }

    /**This method decreases the balance of an account.**/
    public void decBalance(final int amount) {
        int balanceInt = Integer.parseInt(this.balance);
        balanceInt -= amount;
        this.balance = Integer.toString(balanceInt);
    }

    /**This method sets account to premium.**/
    public void upgradeAccount() {
        this.accountType = "premium";
    }
}
