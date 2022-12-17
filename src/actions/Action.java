package actions;

import pages.HomepageUnauth;
import pages.HomepageAuth;
import pages.LoginPage;
import pages.RegisterPage;
import pages.Movies;
import pages.Upgrades;
import pages.SeeDetails;

public abstract class Action {
    /**This method should implement an action's behaviour for Homepage Unauthenticated.**/
    public abstract void execute(HomepageUnauth homepageUnauth);

    /**This method should implement an action's behaviour for Homepage Authenticated.**/
    public abstract void execute(HomepageAuth homepageAuth);

    /**This method should implement an action's behaviour for Login Page.**/
    public abstract void execute(LoginPage loginPage);

    /**This method should implement an action's behaviour for Register Page.**/
    public abstract void execute(RegisterPage registerPage);

    /**This method should implement an action's behaviour for Movies Page.**/
    public abstract void execute(Movies moviesPage);

    /**This method should implement an action's behaviour for Upgrades Page.**/
    public abstract void execute(Upgrades upgradesPage);

    /**This method should implement an action's behaviour for See Details Page.**/
    public abstract void execute(SeeDetails seeDetailsPage);
}
