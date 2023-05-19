////////// File Header///////
// Name:Gurusharan
/// email: kunusoth@wisc.edu
///// Team: DU
///// color: Red
///////////////////////////
public class FrontendDeveloperTests {
  // tests search by title
  public static boolean test1() {
    // tests searching by a title, the placeholder class returns shows containing the title

    TextUITester tester = new TextUITester("t title q");

    ShowSearcherFrontend object = new ShowSearcherFrontend(new ShowSearcherBackend());
    object.runCommandLoop();
    String output = tester.checkOutput();
    if (output.startsWith("Welcome to the Show Searcher App!") && output.contains("1. Title")) {
      System.out.println("Test PASSED.");
    } else {
      System.out.println("Test FAILED");
      return false;
    }

    if (!output.contains("(0)")) {
      return false;
    }



    return true;
  }

  // tests search by year
  public static boolean test2() {
    // tests searching by a year, the placeholder class returns shows according to the year

    TextUITester tester = new TextUITester("y 0 q");

    ShowSearcherFrontend object = new ShowSearcherFrontend(new ShowSearcherBackend());
    object.runCommandLoop();
    String output = tester.checkOutput();
    if (output.startsWith("Welcome to the Show Searcher App!") && output.contains("1. Title")) {
      System.out.println("Test PASSED.");
    } else {
      System.out.println("Test FAILED");
      return false;
    }

    if (!output.contains("(0)")) {
      return false;
    }



    return true;

  }

  // tests toggling fo a filter
  public static boolean test3() {

    TextUITester tester = new TextUITester("f n q q");

    ShowSearcherFrontend object = new ShowSearcherFrontend(new ShowSearcherBackend());
    object.runCommandLoop();
    String output = tester.checkOutput();
    if (output.startsWith("Welcome to the Show Searcher App!") && output.contains("====")) {
      System.out.println("Test PASSED.");
    } else {
      System.out.println("Test FAILED");
      return false;
    }

    if (!output.contains("_x_")) {
      System.out.println("False 3");
      return false;
    }



    return true;


  }

  // tests the quit command
  public static boolean test4() {
    

    TextUITester tester = new TextUITester("q");

    ShowSearcherFrontend object = new ShowSearcherFrontend(new ShowSearcherBackend());
    object.runCommandLoop();
    String output = tester.checkOutput();
    if (output.startsWith("Welcome to the Show Searcher App!") && output.contains("====")) {
      System.out.println("Test PASSED  .");
    } else {
      System.out.println("Test FAILED");
      return false;
    }



    if (output.contains("(0)")) {
      return false;
    }
    if (output.contains("Title")) {
      return false;
    }
    if (output.contains("[N]etflix")) {
      return false;
    }


    return true;



  }

  /**
   * This method tests to see whether the appearance of what filter is bering toggled correctly
   * changes once a filter is chosen. Side Note: This method will not be able to return true until a
   * working version of toggle is created
   * 
   * @return
   */
  // tests whether display of filter is being toggled corrrectly after it is chosen
  public static boolean test5() {

    TextUITester tester = new TextUITester("f n q q");

    ShowSearcherFrontend obj = new ShowSearcherFrontend(new ShowSearcherBackend());
    obj.runCommandLoop();
    String output = tester.checkOutput();
    if (output.startsWith("Welcome to the Show Searcher App!") && output.contains("=========")) {
      System.out.println("Test PASSED.");
    } else {
      System.out.println("Test FAILED");
      return false;

     }


    if (!output.contains("___")) {
      System.out.println("___");
      return false;
    }
    if (!output.contains("_x_")) {
      System.out.println("_x_");
      return false;
    }

    if (output.contains("(0)")) {
      return false;
    }
    if (output.contains("Title")) {
      return false;
    }
    if (!output.contains("[N]etflix")) {
      return false;
    }


    return true;



  }


  public static void main(String[] args) {
    System.out.println("HERE!");
    System.out.println("1: " + test1());
    System.out.println("2: " + test2());
    System.out.println("3: " + test3());
    System.out.println("4: " + test4());
    System.out.println("5: " + test5());

  }

}
