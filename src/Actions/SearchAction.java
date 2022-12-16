package Actions;

import Entities.Logger;
import Entities.POOTVCore;
import Pages.*;

public class SearchAction extends Action {
    private String startsWith;

    public SearchAction(String startsWith) {
        this.startsWith = startsWith;
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
        POOTVCore.getInstance().getCurrentMovies()
                .removeIf(movie -> (!movie.getName().startsWith(this.startsWith)));
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
