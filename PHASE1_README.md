# POO-TV
**Stefan Darius - 324CD**

### Packages
* **pages/**
    * **Page** - an abstract class that shapes a generic page; it is used to implement the Visitor design pattern (for Logger and Action classes), so that pages are the visitable objects;
    * **HomepageAuth**, **HomepageUnauth**, **LoginPage**, **LogoutPage**, **Movies**, **RegisterPage**, **SeeDetails** and **Upgrades** - classes that extends **Page** and contains the implementations of methods from this abstract class; these classes
    are made in accordance with Singleton design pattern, so they can be instanced only one time, because there is only one page of each type;

* **actions/**
    * **Action** - an abstract class that shapes a generic action; it contains abstract methods **execute** for each type of page; each page implements a method called **makeAction** which calls this function, so **actions** are the visitors objects;
    * a class for every type of action that exists in POO-TV; these classes extends **Action**, and contains implementation of **execute** for every type of page;
    * **ActionFactory** - a Singleton class that is used to create **Actions**; this class has a method that creates object of type Action based on an object of class **Actioninput**; so, there is implemented the Factory pattern;

* **input/**
    * contains input clases that are used to map the JSON format input files;

* **entities/**
    * **User** - a class that shapes a user that do stuff on POO-TV; it retains the authentification infos, called **Credentials** which are stored in another class from this package, and informations about purchased, watched, liked and rated movies; this class offers implementation for methods used to buy tokens, to purchase movies, to upgrade account, etc.;
    * **Credentials**;
    * **Movie** - a class that shapes a movie existent on POO-TV; it contains informations about actors, genres, number of likes and ratings, average rating;
    * **ILogger** - an interface that is used to implement something like the Visitor pattern for printing the ouput; it defines methods that print something in case of succesfully done actions on pages **HomepageAuth**, **Movies** and **SeeDetails**;
    * **Logger** - a class that implements the interface above; it offers implementation for **print** methods for each of those pages; this class is also a Singleton class, because there must be only one Logger; this class also has a method to print in case of Error;
    * **POOTVCore** - a class that is the core of this application; it contains the registered users, the current user, the existing movies and the current movies to be displayed (on page Movie); this class is also a Singleton one;

* **strategies/**
    * **FilterStrategy** - interface that shapes a generic strategy to use in action Filter; a class that implements this interface must offer implementation for a method **filter**; it is used to implement Strategy design pattern;
    * **ActorsFilter**, **DurationSort**, **GenreFilter** and **RatingSort** - classes that implements this interface;

### General implementation
In main method, all pages are intitialized, POOTVCore and Logger are initialized. Next HomepageNeauth is set as current page and current user is null. Next, for every action, the current page calls method **makeAction**.