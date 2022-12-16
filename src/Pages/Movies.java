package Pages;

import Actions.Action;
import Entities.iLogger;

public class Movies extends Page {
    private static Movies instance = null;

    private Movies() {
    }

    public static Movies getInstance() {
        if (instance == null) {
            instance = new Movies();
        }
        return instance;
    }

    @Override
    public void completeReachable() {
        this.addReachable(HomepageAuth.getInstance());
        this.addReachable(SeeDetails.getInstance());
        this.addReachable(LogoutPage.getInstance());
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
        return "Movies{}";
    }
}
