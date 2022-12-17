package pages;

import actions.Action;
import entities.POOTVCore;
import entities.ILogger;

public final class Movies extends Page {
    private static Movies instance = null;

    private Movies() {
    }

    /**This method returns the Singleton instance of this page.**/
    public static Movies getInstance() {
        if (instance == null) {
            instance = new Movies();
        }
        return instance;
    }

    @Override
    public void completeReachable() {
        this.addReachable(HomepageAuth.getInstance());
        this.addReachable(SeeDetails.getInstance());
        this.addReachable(LogoutPage.getInstance());
        this.addReachable(this);
    }

    @Override
    public void makeAction(final Action action) {
        action.execute(this);
    }

    @Override
    public void toLogger(final ILogger logger) {
        logger.print(this);
    }

    @Override
    public void auto() {
        POOTVCore.getInstance().resetCurrentMovies();
    }

    @Override
    public String toString() {
        return "Movies{}";
    }
}
