package entities;

import pages.Movies;
import pages.SeeDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

public final class Logger implements ILogger {
    private static Logger instance = null;
    private ArrayNode outputNode;
    private ObjectMapper objectMapper;
    private static ArrayList<Movie> errorList;

    private Logger() { }

    /**This method returns the Singleton instance for this class.**/
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**This method initializes the Logger.**/
    public void initLogger(final ArrayNode output, final ObjectMapper mapper) {
        this.outputNode = output;
        this.objectMapper = mapper;
        errorList = new ArrayList<>();
    }

    /**This method creates an JSON output node.**/
    public void print(final String error, final ArrayList<Movie> currentMoviesList,
                      final User currentUser) {
        ObjectNode newNode = this.objectMapper.createObjectNode();
        newNode.put("error", error);
        newNode.putPOJO("currentMoviesList", currentMoviesList);
        newNode.putPOJO("currentUser", currentUser);
        this.outputNode.add(newNode);
    }

    /**This method implements the error printing.**/
    public void printError() {
        ObjectNode newNode = objectMapper.createObjectNode();
        newNode.put("error", "Error");
        newNode.putPOJO("currentMoviesList", errorList);
        newNode.putPOJO("currentUser", null);
        outputNode.add(newNode);
    }

    /**This method implements the printing for Movies Page.**/
    public void print(final Movies moviesPage) {
        this.print(null, POOTVCore.getInstance().pojoCopyCurrentMovies(),
                POOTVCore.getInstance().getCurrentUser().pojoCopy());
    }

    /**This method implements the printing for See Details Page.**/
    public void print(final SeeDetails seeDetailsPage) {
        ArrayList<Movie> printable = new ArrayList<>();
        printable.add(POOTVCore.getInstance().getCurrentMovie().pojoCopy());
        this.print(null, printable, POOTVCore.getInstance().getCurrentUser().pojoCopy());
    }

    public void printLogin() {
        this.print(null, new ArrayList<>(), POOTVCore.getInstance().getCurrentUser().pojoCopy());
    }

    public void printRecommendation() {
        this.print(null, null, POOTVCore.getInstance().getCurrentUser().pojoCopy());
    }
}
