package Pages;

import Actions.Action;
import Entities.POOTVCore;
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
    public void toLogger(iLogger logger) {
    }

    @Override
    public void auto() {
        POOTVCore.getInstance().setCurrentUser(null);
        POOTVCore.getInstance().setCurrentPage(HomepageUnauth.getInstance());
    }

    @Override
    public String toString() {
        return "LogoutPage{}";
    }
}
