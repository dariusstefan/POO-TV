package pages;

import actions.Action;
import entities.ILogger;

public final class RegisterPage extends Page {
    private static RegisterPage instance = null;

    private RegisterPage() {
    }

    /**This method returns the Singleton instance of this page.**/
    public static RegisterPage getInstance() {
        if (instance == null) {
            instance = new RegisterPage();
        }
        return instance;
    }

    @Override
    public void completeReachable() { }

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
        return "RegisterPage{}";
    }
}
