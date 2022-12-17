package entities;

import pages.HomepageAuth;
import pages.Movies;
import pages.SeeDetails;

public interface ILogger {
    /**This method should implement print action for Homepage Authenticated.**/
    void print(HomepageAuth homepageAuth);

    /**This method should implement print action for Movies Page.**/
    void print(Movies moviesPage);

    /**This method should implement print action for See Details Page.**/
    void print(SeeDetails seeDetailsPage);
}
