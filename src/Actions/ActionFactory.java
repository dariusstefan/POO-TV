package Actions;

import Entities.Credentials;
import Entities.Movie;
import Input.ActionInput;
import Pages.*;
import Strategies.*;

import java.util.ArrayList;

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
                case "register" -> new ChangePageAction(RegisterPage.getInstance());
                case "login" ->  new ChangePageAction(LoginPage.getInstance());
                case "logout" -> new ChangePageAction(LogoutPage.getInstance());
                case "movies" -> new ChangePageAction(Movies.getInstance());
                case "upgrades" -> new ChangePageAction(Upgrades.getInstance());
                case "see details" -> new ChangePageAction(SeeDetails.getInstance(), actionInput.getMovie());
                default -> null;
            };
        } else {
            return switch (actionInput.getFeature()) {
                case "login" -> new LoginAction(new Credentials(actionInput.getCredentials()));
                case "register" -> new RegisterAction(new Credentials(actionInput.getCredentials()));
                case "search" -> new SearchAction(actionInput.getStartsWith());
                case "filter" -> new FilterAction(this.getStrategies(actionInput));
                case "buy tokens" -> new BuyTokensAction(Integer.parseInt(actionInput.getCount()));
                case "buy premium account" -> new BuyPremiumAccountAction();
                case "purchase" -> new PurchaseAction();
                case "watch" -> new WatchAction();
                case "like" -> new LikeAction();
                case "rate" -> new RateAction(actionInput.getRate());
                default -> null;
            };
        }
    }

    private ArrayList<FilterStrategy> getStrategies(ActionInput actionInput) {
        ArrayList<FilterStrategy> strategies = new ArrayList<>();

        if (actionInput.getFilters().getSort() != null) {
            strategies.add(new RatingSort(actionInput.getFilters().getSort().getRating()));
            strategies.add(new DurationSort(actionInput.getFilters().getSort().getDuration()));
        }

        if (actionInput.getFilters().getContains() != null) {
            strategies.add(new ActorsFilter(actionInput.getFilters().getContains().getActors()));
            strategies.add(new GenreFilter(actionInput.getFilters().getContains().getGenre()));
        }

        return strategies;
    }
}
