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

    public void print(String error, HomepageAuth homepageAuth) {
        this.print(error, new ArrayList<>(), POOTVCore.getInstance().getCurrentUser().pojoCopy());
    }

    public void print(String error, HomepageUnauth homepageUnauth){
        if (error != null)
            this.print(error, new ArrayList<>(), null);
    }

    public void print(String error, LoginPage loginPage) {

    }

    public void print(String error, RegisterPage registerPage) {

    }

    public void print(String error, Movies moviesPage) {

    }

    public void print(String error, SeeDetails seeDetailsPage) {

    }

    public void print(String error, Upgrades upgradesPage) {

    }
}
