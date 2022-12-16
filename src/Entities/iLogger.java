package Entities;

import Pages.*;

public interface iLogger {
    void print(String error, HomepageAuth homepageAuth);

    void print(String error, HomepageUnauth homepageUnauth);

    void print(String error, LoginPage loginPage);

    void print(String error, RegisterPage registerPage);

    void print(String error, Movies moviesPage);

    void print(String error, SeeDetails seeDetailsPage);

    void print(String error, Upgrades upgradesPage);
}
