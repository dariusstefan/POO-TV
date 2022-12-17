package pages;

import actions.Action;
import entities.ILogger;

public final class LoginPage extends Page {
    private static LoginPage instance = null;

    private LoginPage() {
    }

    /**This method returns the Singleton instance of this page.**/
    public static LoginPage getInstance() {
        if (instance == null) {
            instance = new LoginPage();
        }
        return instance;
    }

    @Override
    public void completeReachable() {
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
        return "LoginPage{}";
    }
}
