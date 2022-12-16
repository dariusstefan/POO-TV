package Actions;

import Entities.Logger;
import Pages.*;
import Strategies.FilterStrategy;

import java.util.ArrayList;

public class FilterAction extends Action {
    private final ArrayList<FilterStrategy> strategies;

    public FilterAction(ArrayList<FilterStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public void execute(HomepageUnauth homepageUnauth) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(HomepageAuth homepageAuth) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(LoginPage loginPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(RegisterPage registerPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(Movies moviesPage) {
        for (FilterStrategy strategy : strategies) {
            strategy.filter();
        }
        moviesPage.toLogger(Logger.getInstance());
    }

    @Override
    public void execute(Upgrades upgradesPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(SeeDetails seeDetailsPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(LogoutPage logoutPage) {

    }
}
