package pages;

import actions.Action;
import entities.ILogger;

public final class HomepageAuth extends Page {
    private static HomepageAuth instance = null;

    private HomepageAuth() {
    }

    /**This method returns the Singleton instance of this page.**/
    public static HomepageAuth getInstance() {
        if (instance == null) {
            instance = new HomepageAuth();
        }
        return instance;
    }

    @Override
    public void completeReachable() {
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
    }

    @Override
    public void auto() { }

    @Override
    public String toString() {
        return "HomepageAuth{}";
    }
}
