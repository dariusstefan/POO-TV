package Pages;

import Actions.Action;
import Entities.iLogger;

public class RegisterPage extends Page {
    private static RegisterPage instance = null;

    private RegisterPage() {
    }

    public static RegisterPage getInstance() {
        if (instance == null) {
            instance = new RegisterPage();
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
        return "RegisterPage{}";
    }
}
