package Pages;

import Actions.Action;
import Entities.iLogger;

public class LogoutPage extends Page {
    private static LogoutPage instance = null;

    private LogoutPage() {
    }

    public static LogoutPage getInstance() {
        if (instance == null) {
            instance = new LogoutPage();
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
    }

    @Override
    public String toString() {
        return "LogoutPage{}";
    }
}
