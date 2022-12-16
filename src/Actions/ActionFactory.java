package Actions;

import Entities.Credentials;
import Entities.Movie;
import Input.ActionInput;
import Pages.*;

public class ActionFactory {
    private static ActionFactory instance = null;

    private ActionFactory() {}

    public static ActionFactory getInstance() {
        if (instance == null) {
            instance = new ActionFactory();
        }
        return instance;
    }

    public Action createAction(ActionInput actionInput) {
        if (actionInput.getType().equals("change page")) {
            return switch (actionInput.getPage()) {
                case "register" -> new ChangePageAction(RegisterPage.getInstance(), false);
                case "login" ->  new ChangePageAction(LoginPage.getInstance(), false);
                case "logout" -> new ChangePageAction(LogoutPage.getInstance(), true);
                case "movies" -> new ChangePageAction(Movies.getInstance(), false);
                case "upgrades" -> new ChangePageAction(Upgrades.getInstance(), false);
                case "see details" -> new ChangePageAction(SeeDetails.getInstance(), actionInput.getMovie(), false);
                default -> null;
            };
        } else {
            return switch (actionInput.getFeature()) {
                case "login" -> new LoginAction(new Credentials(actionInput.getCredentials()));
                case "register" -> new RegisterAction(new Credentials(actionInput.getCredentials()));
//                case "search" -> new SearchAction(actionInput.getStartsWith());
                default -> null;
            };
        }
    }
}
