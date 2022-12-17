package Pages;

import Actions.Action;
import Entities.POOTVCore;
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
        this.addReachable(this);
    }

    @Override
    public void makeAction(Action action) {
        action.execute(this);
    }

    @Override
    public void toLogger(iLogger logger) {
        logger.print(this);
    }

    @Override
    public void auto() {
        POOTVCore.getInstance().resetCurrentMovies();
    }

    @Override
    public String toString() {
        return "Movies{}";
    }
}
