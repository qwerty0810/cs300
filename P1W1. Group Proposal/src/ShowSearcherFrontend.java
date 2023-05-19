////////// File Header///////
// Name:Gurusharan
/// email: kunusoth@wisc.edu
///// Team: DU
///// color: Red
///////////////////////////

import java.util.List;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ShowSearcherFrontend implements IShowSearcherFrontend {

  Scanner scnr;
  ShowSearcherBackend backend;

  /**
   * constructor, initializes backend object, uses scanner using the System.in
   * 
   * @param e
   */
  public ShowSearcherFrontend(ShowSearcherBackend e) {
    this.backend = e;
    scnr = new Scanner(System.in);
  }

  /**
   * constructor, initializes showsearcerbackend object, initializes scanner with string
   * 
   * @param s
   * @param e
   */
  public ShowSearcherFrontend(String string, ShowSearcherBackend e) {
    this.backend = e;
    this.scnr = new Scanner(string);
    System.out.println(string);

  }

  public void tester() {
    System.out.println(scnr.next());
  }

  @Override
  public void runCommandLoop() {
    // TODO Auto-generated method stub
    System.out.println("Welcome to the Show Searcher App!");
    System.out.println("=================================");
    // avoids error
    String command = "Enter command to change.";
    // runs the command loop. runs until the user quits using the below commands
    while (!command.equals("Q") || !command.equals("4")) {
      displayCommandMenu();
      // userInput is read
      try {
        command = scnr.next();
        System.out.println(command);
      } catch (InputMismatchException e) {
        System.out.println(e + "Restarting.....");
      }
      // converts userinput to uppercase
      command = command.toUpperCase();
      // pressing any other command will force the loop to restart
      if (command.equals("1") || command.equals("T")) {
        titleSearch();
      } else if (command.equals("2") || command.equals("Y")) {
        yearSearch();
      } else if (command.equals("F") || command.equals("3")) {
        filter();
      } else if (command.equals("Q") || command.equals("4")) {
        return;
      } else {
        System.out.println("Invalid command! Try again: ");
      }


    }



  }

  private void filter() {
    String input = "";


    while (!input.equals("Q")) {

      String n;// netflix toggle
      String h;// hulu toggle
      String p;// prime toggle
      String d;// disney toggle
      if (backend.getProviderFilter("Netflix")) {
        n = "x";
      } else {
        n = "_";
      }
      if (backend.getProviderFilter("Hulu")) {
        h = "x";
      } else {
        h = "_";
      }
      if (backend.getProviderFilter("Prime Video")) {
        p = "x";
      } else {
        p = "_";
      }
      if (backend.getProviderFilter("Disney +")) {
        d = "x";
      } else {
        d = "_";
      }

      // this prints info to ser
      System.out.println("Providers that shows are being searched for:");
      System.out.println("_" + n + "_ 1)   [N]etflix");
      System.out.println("_" + h + "_ 2)   [H]ulu");
      System.out.println("_" + p + "_ 3)   [P]rime Video");
      System.out.println("_" + d + "_ 4)   [D]isney +");
      System.out.println("[Q]uit toggling provider filters");
      System.out.println("Choose the provider that you'd like to toggle the filter for:");
      // restarts command loop
      try {
        input = scnr.next();
      } catch (InputMismatchException e) {
        System.out.println(e + "Restarting.....");
        runCommandLoop();
      }
      // input to uppercase
      input = input.toUpperCase();

      if (input.equals("1") || input.equals("N")) {
        backend.toggleProviderFilter("Netflix");
      } else if (input.equals("2") || input.equals("H")) {
        backend.toggleProviderFilter("Hulu");

      } else if (input.equals("3") || input.equals("P")) {
        backend.toggleProviderFilter("Prime Video");

      } else if (input.equals("4") || input.equals("D")) {
        backend.toggleProviderFilter("Disney +");
      } else if (input.equals("Q")) {

      } else {
        System.out.println("Try again: ");
      }

    }
  }

  /**
   * This method displays the command window as to save time
   */
  @Override
  public void displayCommandMenu() {
    // TODO Auto-generated method stub

    System.out.println("Command Menu:");
    System.out.println("	1) Search by [T]itle Word");
    System.out.println("	2) Search by [Y]ear First Produced");
    System.out.println("	3) [F]ilter by Streaming Provider");
    System.out.println("	4) [Q]uit");
    System.out.println("Choose a command from the menu above: ");


  }


  @Override
  /**
   * prints a list of required shows from IShow
   */
  public void displayShows(List<IShow> shows) {
    // TODO reformat how the shows are printed
    for (int i = 0; i < shows.size(); i++) {
      ///////
      String provider;
      if (shows.get(i).isAvailableOn("Netflix")) {
        provider = "Netflix";
      } else if (shows.get(i).isAvailableOn("Hulu")) {
        provider = "Hulu";
      } else if (shows.get(i).isAvailableOn("Prime Video")) {
        provider = "Prime Video";
      } else if (shows.get(i).isAvailableOn("Disney +")) {
        provider = "Disney+";
      } else {
        provider = "Provider not found!";
      }

      // shows are printed
      System.out.println((i + 1) + ". " + shows.get(i).getTitle());
      System.out.println(
          "	" + shows.get(i).getRating() + "/100 (" + shows.get(i).getYear() + ") on: " + provider);
    }

  }

  @Override
  /**
   * user has to search for a word theyd like to search for. List of shows containing that word is
   * returned
   * 
   */
  public void titleSearch() {
    // TODO Auto-generated method stub
    System.out.println("Choose a word that you would like to search for: ");
    String word = "";
    try {
      word = scnr.next();
    } catch (InputMismatchException e) {
      System.out.println(e + "Returning....");
    }

    // list of shows with searched word
    List<IShow> showsByTitle = backend.searchByTitleWord(word);

    // null is returned by backend if theres no show
    if (showsByTitle == null) {
      System.out.println("No shows found with word: " + word);
      System.out.println("Returning to the command menu");
    } else {
      // displays shows by title
      displayShows(showsByTitle);
      return;
    }


  }

  @Override
  /**
   * user has to pick a year theyd like to search for. List of shows containing that word is
   * returned
   * 
   */
  public void yearSearch() {
    // TODO Auto-generated method stub

    System.out.println("Choose a year that you would like to search for: ");
    int year = -1;
    try {
      year = scnr.nextInt();
    } catch (InputMismatchException e) {
      System.out.println(e + "Returnoing....");
    }
    // list of shows with searched year
    List<IShow> showsByYear = backend.searchByYear(year);

    // null is returned by backend if theres no show
    if (showsByYear == null) {
      System.out.println("No shows found from: " + year);
      System.out.println("Returning....");
    } else {
      // prints the shows according to year
      displayShows(showsByYear);
    }
  }

}
