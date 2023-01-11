# POO-TV
**Stefan Darius - 324CD**

In this README file, I only noted what I added and modified to implement the functionalities required in the 2nd stage of the project.

### Added classes

* in package **actions/**
  * **SubscribeAction** - a class that implements interface *Action*; it is made to implement the subscribe feature;
  * **BackAction** - a class that implements the option to go back to the previous page;
  * **AddMovieAction** and **DeleteMovieAction** - classes that implement the database features: add and remove movies;

* in package **entities/**
  * **Notification** - a class that shapes a notification that will appear for a user;
  * **State** - a class that shapes the state of this application at some time: the page and the current movie; it is used to implement the *Back* feature;
  * **RecommendationManager** - a utility class that is used to make the recommendations for premium users;

### Modifications

* in package **input/**
  * I modified **ActionInput** class to deal with the new fields from JSON files that are used for the new features;

* in package **entities/**
  * **User** - I added some fields to implement the new features: an arraylist for *notifications*, an arraylist for *subscriptions* and a hashmap for *liked genres*;
  * **Movie** - I modified the *ratings* field to a hashmap, so that user can modify his rating for a movie;
  * **ILogger** - I modified this interface so that it doesn't contain a required method for page **HomepageAuth**, because there will be no output when *Back* is made to this page;
  * **Logger** - I added two methods: *printLogin*, to be used when a *login* or *register* action is made, and *printRecommendation* to implement the recommendation feature;
  * **POOTVCore** - I added an arraylist of *States* to implement a pages history for the *Back* feature;

The general implementation is explained in file *PHASE1_README.md*.
