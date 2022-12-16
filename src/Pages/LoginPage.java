package Pages;

import Actions.Action;
import Entities.iLogger;

public class LoginPage extends Page {
    private static LoginPage instance = null;

    private LoginPage() {
    }

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
    public void makeAction(Action action) {
        action.execute(this);
    }

    @Override
    public void toLogger(String error, iLogger logger) {
        logger.print(error, this);
    }

    @Override
    public String toString() {
        return "LoginPage{}";
    }
}
