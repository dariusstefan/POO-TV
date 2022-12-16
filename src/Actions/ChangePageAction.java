package Actions;

import Entities.Logger;
import Entities.Movie;
import Entities.POOTVCore;
import Pages.*;

import java.util.ArrayList;

public class ChangePageAction extends Action {
    private Page nextPage;
    private String movieTitle;

    public ChangePageAction(Page page) {
        this.nextPage = page;
        this.movieTitle = null;
    }

    public ChangePageAction(Page page, String movieTitle) {
        this.nextPage = page;
        this.movieTitle = movieTitle;
    }

    public void setNextPage(Page nextPage) {
        this.nextPage = nextPage;
    }

    private void changePage(Page page) {
        if (!page.checkReachable(this.nextPage)) {
            Logger.getInstance().printError();
            return;
        }

        if (this.movieTitle != null) {
            if (POOTVCore.getInstance().getCurrentMovies()
                    .stream().allMatch(movie -> (!movie.getName().equals(movieTitle)))) {
                Logger.getInstance().printError();
                return;
            } else {
                POOTVCore.getInstance().setCurrentMovie(movieTitle);
            }
        }

        POOTVCore.getInstance().setCurrentPage(this.nextPage);
        nextPage.toLogger(Logger.getInstance());
    }

    @Override
    public void execute(HomepageUnauth homepageUnauth) {
        changePage(homepageUnauth);
    }

    @Override
    public void execute(HomepageAuth homepageAuth) {
        changePage(homepageAuth);
    }

    @Override
    public void execute(LoginPage loginPage) {
        changePage(loginPage);
    }

    @Override
    public void execute(RegisterPage registerPage) {
        changePage(registerPage);
    }

    @Override
    public void execute(Movies moviesPage) {
        changePage(moviesPage);
    }

    @Override
    public void execute(Upgrades upgradesPage) {
        changePage(upgradesPage);
    }

    @Override
    public void execute(SeeDetails seeDetailsPage) {
        changePage(seeDetailsPage);
    }

    @Override
    public void execute(LogoutPage logoutPage) {
    }
}
