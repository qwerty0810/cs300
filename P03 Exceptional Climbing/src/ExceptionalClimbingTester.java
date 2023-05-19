
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P02 Fish Tank 1000
// Course: CS 300 Fall 2021
//
// Author: Sharan
// Email: kunusoth@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.zip.DataFormatException;

/**
 * static methods to be tested
 * 
 * @author Sharan
 *
 */
public class ExceptionalClimbingTester {
  public static boolean testSendClimb() {

    String[] testArray0 = new String[10];
    String[] testArray1 = new String[] {"V0", "V1", "V0", "V2", null, null, null};
    String[] testArray2 = new String[] {"V0", "V1", "V0", "V2", "V4", "V2", "V3"};
    String[] testArray3 = new String[] {"V0", "V1", "V0", "V2", null, null, null};

    try {
      if (1 != ExceptionalClimbing.sendClimb(testArray0, 0, "V1") || !testArray0[0].equals("V1")) {
        return false;
      }
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      if (5 != ExceptionalClimbing.sendClimb(testArray1, 4, "V5") || !testArray1[4].equals("V5")) {
        return false;
      }
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      if (7 != ExceptionalClimbing.sendClimb(testArray2, 7, "V1") || !testArray2[6].equals("V3")) {
        return false;
      }
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      if (4 != ExceptionalClimbing.sendClimb(testArray3, 4, "V9") || !testArray3[3].equals("V2")
          || testArray3[4] != null) {
        return false;
      }
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
  }

  /**
   * testing the failClimb
   * 
   * @return true if the given conditions are false
   * @throws DataFormatException
   */
  public static boolean testFailClimb() {
    String[] testArray0 = new String[10];
    String[] testArray1 = new String[] {"V0", "V1", "V0", "V2", null, null, null};
    String[] testArray2 = new String[] {"V0", "V1", "V0", "V2", "V4", "V2", "V3"};
    String[] testArray3 = new String[] {"V0", "V1", "V0", "V2", null, null, null};

    try {
      if (1 != ExceptionalClimbing.failClimb(testArray0, 0, "V1") || !testArray0[0].equals("V1")) {
        return false;
      }
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      if (5 != ExceptionalClimbing.failClimb(testArray1, 4, "V5") || !testArray1[4].equals("V5")) {
        return false;
      }
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      if (7 != ExceptionalClimbing.failClimb(testArray2, 7, "V1") || !testArray2[6].equals("V3")) {
        return false;
      }
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      if (4 != ExceptionalClimbing.failClimb(testArray3, 4, "V9") || !testArray3[3].equals("V2")
          || testArray3[4] != null) {
        return false;
      }
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
  }

  /**
   * tests getStats
   * 
   * @return true if the given conditions are false
   * 
   */
  public static boolean testGetStats() {

    String[] send = {"V0", "V1", "V0", "V0", null};
    String[] fail = {"V2", "V1", null, null, null};
    int numSend = 4, numFail = 2;

    String stats, expectedResult;

    stats = ExceptionalClimbing.getStats(send, numSend, fail, numFail, 2);
    expectedResult = "send: 0.0\nfail: 1.5";

    if (!stats.equals(expectedResult)) {
      System.out.println("3.1 fails");
      return false;
    }

    stats = ExceptionalClimbing.getStats(send, numSend, fail, numFail, 3);
    expectedResult = "send: 0.3333333333333333\nfail: 1.5";

    if (!stats.equals(expectedResult)) {
      System.out.println("3.2 fails");
      return false;
    }

    stats = ExceptionalClimbing.getStats(send, numSend, fail, 0, 3);
    expectedResult = "send: 0.3333333333333333\nfail: --";

    if (!stats.equals(expectedResult)) {
      System.out.println("3.3 fails");
      return false;
    }

    stats = ExceptionalClimbing.getStats(send, numSend, fail, numFail, 0);
    expectedResult = "send: --\nfail: --";

    if (!stats.equals(expectedResult)) {
      System.out.println("3.4 fails");
      return false;
    }

    return true;
  }

  /**
   * tests getHistogram
   * 
   * @return true if the given conditions are false
   */
  public static boolean testGetHistogram() {

    String histogram, expectedResult;

    histogram =
        ExceptionalClimbing.getHistogram(new String[] {"V0", "V1", "V0", "V2", null, null, null}, 4,
            new String[] {"V0", "V1", "V0", "V2", "V4", "V2", "V3"}, 7);

    expectedResult = "V0: - - + + \nV1: - + \nV2: - - + \nV3: - \nV4: - \n";

    if (!histogram.equals(expectedResult)) {
      System.out.println("4.1 fails");

      return false;
    }

    histogram =
        ExceptionalClimbing.getHistogram(new String[] {"V3", "V1", "V2", "V2", null, null, null}, 4,
            new String[] {"V3", "V1", "V2", "V2", "V5", "V2", "V3"}, 7);

    expectedResult = "V0: \nV1: - + \nV2: - - - + + \nV3: - - + \nV4: \nV5: - \n";

    if (!histogram.equals(expectedResult)) {
      System.out.println("4.2 fails");
      return false;
    }

    histogram =
        ExceptionalClimbing.getHistogram(new String[] {"V3", "V1", "V2", "V2", null, null, null}, 0,
            new String[] {"V3", "V1", "V2", "V2", "V5", "V2", "V3"}, 0);

    expectedResult = "Error: no data to display";

    if (!histogram.equals(expectedResult)) {
      System.out.println("4.3 fails");
      return false;
    }

    return true;

  }

  /**
   * runs all the above tests
   * 
   * @return sendTest && failTest && statsTest && histoTest
   */
  public static boolean runAllTests() {

    boolean sendTest = false;
    boolean failTest = false;

    boolean statsTest = testGetStats();
    boolean histoTest = testGetHistogram();

    return sendTest && failTest && statsTest && histoTest;
  }

  /**
   * prints all the results of the above tests which were run
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }


}