package Actions;

import Entities.Logger;
import Entities.Movie;
import Entities.POOTVCore;
import Pages.*;

import java.util.ArrayList;

public class ChangePageAction extends Action {
    private Page nextPage;
    private String movieTitle;
    private boolean isLogout;

    public ChangePageAction(Page page, boolean isLogout) {
        this.nextPage = page;
        this.movieTitle = null;
        this.isLogout = isLogout;
    }

    public ChangePageAction(Page page, String movieTitle, boolean isLogout) {
        this.nextPage = page;
        this.movieTitle = movieTitle;
        this.isLogout = isLogout;
    }

    public void setNextPage(Page nextPage) {
        this.nextPage = nextPage;
    }

    private void changePage(Page page) {
        if (!page.checkReachable(this.nextPage)) {
            Logger.getInstance().printError();
            return;
        }
        if (this.isLogout) {
            POOTVCore.getInstance().setCurrentUser(null);
            POOTVCore.getInstance().setCurrentPage(HomepageUnauth.getInstance());
            return;
        }
        POOTVCore.getInstance().setCurrentPage(this.nextPage);
        nextPage.toLogger(null, Logger.getInstance());
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
