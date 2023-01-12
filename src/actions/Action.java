package actions;

import pages.HomepageUnauth;
import pages.HomepageAuth;
import pages.LoginPage;
import pages.RegisterPage;
import pages.Movies;
import pages.Upgrades;
import pages.SeeDetails;

public interface Action {
    /**This method should implement an action's behaviour for Homepage Unauthenticated.**/
    void execute(HomepageUnauth homepageUnauth);

    /**This method should implement an action's behaviour for Homepage Authenticated.**/
    void execute(HomepageAuth homepageAuth);

    /**This method should implement an action's behaviour for Login Page.**/
    void execute(LoginPage loginPage);

    /**This method should implement an action's behaviour for Register Page.**/
    void execute(RegisterPage registerPage);

    /**This method should implement an action's behaviour for Movies Page.**/
    void execute(Movies moviesPage);

    /**This method should implement an action's behaviour for Upgrades Page.**/
    void execute(Upgrades upgradesPage);

    /**This method should implement an action's behaviour for See Details Page.**/
    void execute(SeeDetails seeDetailsPage);
}
