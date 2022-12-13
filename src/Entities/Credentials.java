package Entities;

import Input.CredentialsInput;

public class Credentials {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    public Credentials(CredentialsInput credsInput) {
        this.name = credsInput.getName();
        this.password = credsInput.getPassword();
        this.accountType = credsInput.getAccountType();
        this.country = credsInput.getCountry();
        this.balance = credsInput.getBalance();
    }

    public Credentials(Credentials creds) {
        this.name = creds.getName();
        this.password = creds.getPassword();
        this.accountType = creds.getAccountType();
        this.country = creds.getCountry();
        this.balance = creds.getBalance();
    }

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

    public void decBalance(int amount) {
        int balanceInt = Integer.parseInt(this.balance);
        balanceInt -= amount;
        this.balance = Integer.toString(balanceInt);
    }

    public void upgradeAccount() {
        this.accountType = "premium";
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "\nname='" + name + '\'' +
                "\npassword='" + password + '\'' +
                "\naccountType='" + accountType + '\'' +
                "\ncountry='" + country + '\'' +
                "\nbalance='" + balance + '\'' +
                "\n}";
    }
}
