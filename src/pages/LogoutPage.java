package pages;

import actions.Action;
import entities.POOTVCore;
import entities.ILogger;

public final class LogoutPage extends Page {
    private static LogoutPage instance = null;

    private LogoutPage() {
    }

    /**This method returns the Singleton instance of this page.**/
    public static LogoutPage getInstance() {
        if (instance == null) {
            instance = new LogoutPage();
        }
        return instance;
    }

    @Override
    public void completeReachable() { }

    @Override
    public void makeAction(final Action action) { }

    @Override
    public void toLogger(final ILogger logger) { }

    @Override
    public void auto() {
        POOTVCore.getInstance().setCurrentUser(null);
        POOTVCore.getInstance().setCurrentPage(HomepageUnauth.getInstance());
        POOTVCore.getInstance().resetPagesHistory();
    }

    @Override
    public String toString() {
        return "LogoutPage{}";
    }
}
