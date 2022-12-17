package pages;

import actions.Action;
import entities.ILogger;

public final class Upgrades extends Page {
    private static Upgrades instance = null;

    private Upgrades() {
    }

    /**This method returns the Singleton instance of this page.**/
    public static Upgrades getInstance() {
        if (instance == null) {
            instance = new Upgrades();
        }
        return instance;
    }

    @Override
    public void completeReachable() {
        this.addReachable(HomepageAuth.getInstance());
        this.addReachable(Movies.getInstance());
        this.addReachable(LogoutPage.getInstance());
    }

    @Override
    public void makeAction(final Action action) {
        action.execute(this);
    }

    @Override
    public void toLogger(final ILogger logger) { }

    @Override
    public void auto() { }

    @Override
    public String toString() {
        return "Upgrades{}";
    }
}
