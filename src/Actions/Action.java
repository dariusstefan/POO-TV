package Actions;

import Pages.*;

public abstract class Action {
    public abstract void execute(HomepageUnauth homepageUnauth);
    public abstract void execute(HomepageAuth homepageAuth);
    public abstract void execute(LoginPage loginPage);
    public abstract void execute(RegisterPage registerPage);
    public abstract void execute(Movies moviesPage);
    public abstract void execute(Upgrades upgradesPage);
    public abstract void execute(SeeDetails seeDetailsPage);
}
