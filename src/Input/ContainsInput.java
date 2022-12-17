package Input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ContainsInput {
    private ArrayList<String> actors;
    private ArrayList<String> genre;

    public ContainsInput() {
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
