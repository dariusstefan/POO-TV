package Pages;

import Actions.Action;
import Entities.iLogger;

public class HomepageUnauth extends Page {
    private static HomepageUnauth instance = null;

    private HomepageUnauth() {
    }

    public static HomepageUnauth getInstance() {if (instance == null) {
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
    public void makeAction(Action action) {
        action.execute(this);
    }

    @Override
    public void toLogger(iLogger logger) {}

    @Override
    public void auto() {}

    @Override
    public String toString() {
        return "HomepageUnauth{}";
    }
}
