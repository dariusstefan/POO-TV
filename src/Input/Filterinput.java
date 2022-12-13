package Input;

import java.util.ArrayList;

public class Filterinput {
    private ArrayList<String> actors;
    private ArrayList<String> genre;

    public Filterinput() {
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Filterinput{" +
                "actors=" + actors +
                ", genre=" + genre +
                '}';
    }
}
