package actions;

import entities.Logger;
import entities.POOTVCore;
import entities.State;
import pages.HomepageUnauth;
import pages.HomepageAuth;
import pages.LoginPage;
import pages.RegisterPage;
import pages.Movies;
import pages.Upgrades;
import pages.SeeDetails;
import pages.Page;

public final class ChangePageAction extends Action {
    private Page nextPage;
    private final String movieTitle;

    public ChangePageAction(final Page page) {
        this.nextPage = page;
        this.movieTitle = null;
    }

    public ChangePageAction(final Page page, final String movieTitle) {
        this.nextPage = page;
        this.movieTitle = movieTitle;
    }

    public void setNextPage(final Page nextPage) {
        this.nextPage = nextPage;
    }

    private void changePage(final Page page) {
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

        if (POOTVCore.getInstance().getCurrentUser() != null) {
            POOTVCore.getInstance().getPagesHistory()
                    .add(new State(page, POOTVCore.getInstance().getCurrentMovie()));
        }

        POOTVCore.getInstance().setCurrentPage(this.nextPage);
        nextPage.toLogger(Logger.getInstance());
    }

    @Override
    public void execute(final HomepageUnauth homepageUnauth) {
        changePage(homepageUnauth);
    }

    @Override
    public void execute(final HomepageAuth homepageAuth) {
        changePage(homepageAuth);
    }

    @Override
    public void execute(final LoginPage loginPage) {
        changePage(loginPage);
    }

    @Override
    public void execute(final RegisterPage registerPage) {
        changePage(registerPage);
    }

    @Override
    public void execute(final Movies moviesPage) {
        changePage(moviesPage);
    }

    @Override
    public void execute(final Upgrades upgradesPage) {
        changePage(upgradesPage);
    }

    @Override
    public void execute(final SeeDetails seeDetailsPage) {
        changePage(seeDetailsPage);
    }
}
