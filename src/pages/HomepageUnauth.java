package pages;

import actions.Action;
import entities.ILogger;

public final class HomepageUnauth extends Page {
    private static HomepageUnauth instance = null;

    private HomepageUnauth() {
    }

    /**This method returns the Singleton instance of this page.**/
    public static HomepageUnauth getInstance() {
        if (instance == null) {
            instance = new HomepageUnauth();
        }
        return instance;
    }

    @Override
    public void completeReachable() {
        this.addReachable(LoginPage.getInstance());
        this.addReachable(RegisterPage.getInstance());
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
        return "HomepageUnauth{}";
    }
}
