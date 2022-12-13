package Entities;

import Input.GeneralInput;
import Input.MovieInput;
import Input.UserInput;

import java.util.ArrayList;

public class POOTVCore {
    private ArrayList<User> regUsers;
    private User currentUser;
    private ArrayList<Movie> movies;

    public POOTVCore(GeneralInput input) {
        this.regUsers = new ArrayList<>();
        this.currentUser = null;
        this.movies = new ArrayList<>();

        for (UserInput userInput : input.getUsers())
            this.regUsers.add(new User(userInput));

        for (MovieInput movieInput : input.getMovies())
            this.movies.add(new Movie(movieInput));
    }

    public ArrayList<User> getRegUsers() {
        return regUsers;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void regUser(User user) {
        this.regUsers.add(user);
    }

    @Override
    public String toString() {
        return "POOTVCore{" +
                "\nregUsers=" + regUsers +
                "\ncurrentUser=" + currentUser +
                "\nmovies=" + movies +
                "\n}";
    }
}
