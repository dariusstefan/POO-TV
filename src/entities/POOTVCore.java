package entities;

import actions.Action;
import actions.ActionFactory;
import input.ActionInput;
import input.GeneralInput;
import input.MovieInput;
import input.UserInput;
import pages.Page;

import java.util.ArrayList;

public final class POOTVCore {
    private static POOTVCore instance;
    private ArrayList<User> regUsers;
    private User currentUser;
    private ArrayList<Movie> movies;
    private Page currentPage;
    private ArrayList<Action> actions;
    private ArrayList<Movie> currentMovies;

    private Movie currentMovie;

    private POOTVCore() {
    }

    /**This method returns the Singleton instance of this class.**/
    public static POOTVCore getInstance() {
        if (instance == null) {
            instance = new POOTVCore();
        }
        return instance;
    }

    /**This method initializes the POOTVCore.**/
    public void initPOOTVCore(final GeneralInput input) {
        regUsers = new ArrayList<>();
        currentUser = null;
        movies = new ArrayList<>();
        actions = new ArrayList<>();

        for (UserInput userInput : input.getUsers()) {
            regUsers.add(new User(userInput));
        }

        for (MovieInput movieInput : input.getMovies()) {
            movies.add(new Movie(movieInput));
        }

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

    public void setCurrentUser(final User user) {
        currentUser = user;
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }

    /**This method sets the current movie for operations on See Details page.**/
    public void setCurrentMovie(final String movieTitle) {
        for (Movie movie : currentMovies) {
            if (movie.getName().equals(movieTitle)) {
                this.currentMovie = movie;
                return;
            }
        }
    }

    /**This method adds a user to the list of registered users.**/
    public void regUser(final User user) {
        regUsers.add(user);
    }

    /**This method sets the current page and run its auto method.**/
    public void setCurrentPage(final Page page) {
        currentPage = page;
        page.auto();
    }

    public ArrayList<Movie> getCurrentMovies() {
        return currentMovies;
    }

    /**This method resets the current movies list for operations on Movies Page.**/
    public void resetCurrentMovies() {
        this.currentMovies = new ArrayList<>(this.movies);
        this.currentMovies.removeIf(movie -> (movie.getCountriesBanned()
                .contains(this.currentUser.getCredentials().getCountry())));
    }

    /**This method deep-copies the current movies arraylist.
     * It is used to display this arraylist with putPOJO JSON method.**/
    public ArrayList<Movie> pojoCopyCurrentMovies() {
        ArrayList<Movie> copy = new ArrayList<>();
        for (Movie movie : currentMovies) {
            copy.add(movie.pojoCopy());
        }
        return copy;
    }
}
