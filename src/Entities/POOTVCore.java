package Entities;

import Actions.Action;
import Actions.ActionFactory;
import Input.ActionInput;
import Input.GeneralInput;
import Input.MovieInput;
import Input.UserInput;
import Pages.Page;

import java.util.ArrayList;

public class POOTVCore {
    private static POOTVCore instance;
    private ArrayList<User> regUsers;
    private User currentUser;
    private ArrayList<Movie> movies;
    private Page currentPage;
    private ArrayList<Action> actions;
    private ArrayList<Movie> currentMovies;

    private POOTVCore() {
    }

    public static POOTVCore getInstance() {
        if (instance == null) {
            instance = new POOTVCore();
        }
        return instance;
    }

    public void initPOOTVCore(GeneralInput input) {
        regUsers = new ArrayList<>();
        currentUser = null;
        movies = new ArrayList<>();
        actions = new ArrayList<>();

        for (UserInput userInput : input.getUsers())
            regUsers.add(new User(userInput));

        for (MovieInput movieInput : input.getMovies())
            movies.add(new Movie(movieInput));

        for (ActionInput actionInput : input.getActions()) {
            actions.add(ActionFactory.getInstance().createAction(actionInput));
        }
    }

    public ArrayList<User> getRegUsers() {
        return regUsers;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public void regUser(User user) {
        regUsers.add(user);
    }

    public void setCurrentPage(Page page) {
        currentPage = page;
    }

    public void resetCurrentMovies() {
        this.currentMovies = new ArrayList<>(this.movies);
    }
}
