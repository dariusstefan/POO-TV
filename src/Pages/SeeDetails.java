package Pages;

import Actions.Action;
import Entities.iLogger;

public class SeeDetails extends Page {
    private static SeeDetails instance = null;

    private SeeDetails() {
    }

    public static SeeDetails getInstance() {
        if (instance == null) {
            instance = new SeeDetails();
        }
        return instance;
    }

    @Override
    public void completeReachable() {
        this.addReachable(HomepageAuth.getInstance());
        this.addReachable(Movies.getInstance());
        this.addReachable(Upgrades.getInstance());
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
        return "SeeDetails{}";
    }
}
