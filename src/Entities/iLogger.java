package Entities;

import Pages.*;

public interface iLogger {
    void print(HomepageAuth homepageAuth);

    void print(HomepageUnauth homepageUnauth);

    void print(LoginPage loginPage);

    void print(RegisterPage registerPage);

    void print(Movies moviesPage);

    void print(SeeDetails seeDetailsPage);

    void print(Upgrades upgradesPage);
}
