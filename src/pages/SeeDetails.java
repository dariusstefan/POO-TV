package pages;

import actions.Action;
import entities.ILogger;

public final class SeeDetails extends Page {
    private static SeeDetails instance = null;

    private SeeDetails() {
    }

    /**This method returns the Singleton instance of this page.**/
    public static SeeDetails getInstance() {
        if (instance == null) {
            instance = new SeeDetails();
        }
        return instance;
    }

    @Override
    public void completeReachable() {
        this.addReachable(HomepageAuth.getInstance());
        this.addReachable(Movies.getInstance());
        this.addReachable(Upgrades.getInstance());
        this.addReachable(LogoutPage.getInstance());
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
    public void auto() { }

    @Override
    public String toString() {
        return "SeeDetails{}";
    }
}
