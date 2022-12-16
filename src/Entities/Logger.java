package Entities;

import Pages.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

public class Logger implements iLogger {
    private static Logger instance = null;
    private ArrayNode output;
    private ObjectMapper mapper;
    public static ArrayList<Movie> errorList;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void initLogger(ArrayNode output, ObjectMapper mapper) {
        this.output = output;
        this.mapper = mapper;
        errorList = new ArrayList<>();
    }

    public void print(String error, ArrayList<Movie> currentMoviesList, User currentUser) {
        ObjectNode newNode = mapper.createObjectNode();
        newNode.put("error", error);
        newNode.putPOJO("currentMoviesList", currentMoviesList);
        newNode.putPOJO("currentUser", currentUser);
        output.add(newNode);
    }

    public void printError() {
        ObjectNode newNode = mapper.createObjectNode();
        newNode.put("error", "Error");
        newNode.putPOJO("currentMoviesList", errorList);
        newNode.putPOJO("currentUser", null);
        output.add(newNode);
    }

    public void print(HomepageAuth homepageAuth) {
        this.print(null, new ArrayList<>(), POOTVCore.getInstance().getCurrentUser().pojoCopy());
    }

    public void print(HomepageUnauth homepageUnauth){
//        this.print(null, new ArrayList<>(), null);
    }

    public void print(LoginPage loginPage) {

    }

    public void print(RegisterPage registerPage) {

    }

    public void print(Movies moviesPage) {
        this.print(null, POOTVCore.getInstance().pojoCopyCurrentMovies(),
                POOTVCore.getInstance().getCurrentUser().pojoCopy());
    }

    public void print(SeeDetails seeDetailsPage) {
        ArrayList<Movie> printable = new ArrayList<>();
        printable.add(POOTVCore.getInstance().getCurrentMovie().pojoCopy());
        this.print(null, printable, POOTVCore.getInstance().getCurrentUser().pojoCopy());
    }

    public void print(Upgrades upgradesPage) {

    }
}
