
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
 * Static methods are to be tested in Exceptional Climbing method
 * 
 * @author Sharan
 *
 */
public class ExceptionalClimbing {
  /**
   * 
   * @param args
   */


  /**
   * verifying grade method
   * 
   * @param grade
   * @return false if grade.length is not equal to 2 or char index 0 isnt 'V"
   * @return also the numerical digit at index 1 should be less than 7
   */
  private static boolean verifyGrade(String grade) {
    if (grade.length() != 2 || grade.charAt(0) != 'V' || !Character.isDigit(grade.charAt(1))) {
      return false;
    }

    return Integer.parseInt(grade.substring(1)) <= 7 && Integer.parseInt(grade.substring(1)) >= 0;
  }

  /**
   * verifying over size array method
   * 
   * @param <T>
   * @param array
   * @param index
   * @return
   */
  private static <T> boolean verifyOversizedArray(T[] array, int index) {
    if (index < 0 || index > array.length - 1) {
      return false;
    }

    for (int i = index; i < array.length; i++) {
      if (array[i] != null) {
        return false;
      }
    }
    return true;
  }

  /**
   * getGradeString method
   * 
   * @param grade
   * @return Integer.parseInt
   */
  private static int getGradeFromString(String grade) {
    return Integer.parseInt(grade.substring(1));
  }

  /**
   * addClimb method
   * 
   * @param climbs
   * @param numClimbs
   * @param grade
   * @return numClimbs
   */
  private static int addClimb(String[] climbs, int numClimbs, String grade) {

    if (!verifyOversizedArray(climbs, numClimbs)) {
      return numClimbs;
    }

    if (!verifyGrade(grade) || numClimbs >= climbs.length) {
      return numClimbs;
    }

    climbs[numClimbs] = grade;
    return numClimbs + 1;
  }

  /**
   * sendClimb method
   * 
   * @param send
   * @param numSend
   * @param grade
   * @return addClimb (send, numSend, grade)
   * @throws DataFormatException
   */
  public static int sendClimb(String[] send, int numSend, String grade) throws DataFormatException {

    try {
      int x = addClimb(send, numSend, grade);
      return -1;
    } catch (IllegalArgumentException e) {
      System.out.println("Not a valid grade");
      return numSend;
    }


    /**
     * 
     * 
     * boolean full = true; for (int i = 0; i < send.length; i++) { if (send[i] == null) { full =
     * false;
     * 
     * break; } }
     * 
     * if (full) { throw new IllegalArgumentException("cannot add new value to full length 8
     * array"); } else if (send.length == numSend) { throw new IllegalArgumentException("cannot add
     * new value to full length 8 array"); } boolean empty = false; for (int i = 0; i < numSend;
     * i++) { if (send[i] == null) { empty = true;
     * 
     * break; }
     * 
     * }
     * 
     * if (numSend < 0 || empty == true) { throw new DataFormatException("invalid oversize array");
     * }
     * 
     * }
     * 
     * catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
     * 
     * 
     * 
     * catch (DataFormatException e1) { System.out.println(e1.getMessage()); } finally { return
     * addClimb(send, numSend, grade); }
     * 
     */
  }

  /**
   * failClimb method
   * 
   * @param fail
   * @param numFail
   * @param grade
   * @return addClimb(fail, numFail, grade);
   * @throws DataFormatException
   */
  public static int failClimb(String[] fail, int numFail, String grade) throws DataFormatException {
    try {
      int x = addClimb(fail, numFail, grade);
      return -1;
    } catch (IllegalArgumentException e) {
      System.out.println("Not a valid grade");
      return numFail;
    }

    /*
     *
     *
     * boolean full = true; for (int i = 0; i < fail.length; i++) { if (fail[i] == null) { full =
     * false;
     * 
     * break; } }
     * 
     * if (full) { throw new
     * IllegalArgumentException("cannot add new value to full length 8 array"); } else if
     * (fail.length == numFail) { throw new
     * IllegalArgumentException("cannot add new value to full length 8 array"); } boolean empty =
     * false; for (int i = 0; i < numFail; i++) { if (fail[i] == null) { empty = true;
     * 
     * break; }
     * 
     * } if (numFail < 0 || empty == true) { throw new
     * DataFormatException("invalid oversize array"); }
     * 
     * }
     * 
     * 
     * catch (IllegalArgumentException e2) { System.out.println(e2.getMessage()); } catch
     * (DataFormatException e3) { System.out.println(e3.getMessage());
     * 
     * } finally { return addClimb(fail, numFail, grade); }
     */


  }

  /**
   * getStats method
   * 
   * @param send
   * @param numSend
   * @param fail
   * @param numFail
   * @param historyLength
   * @return statsString
   */
  public static String getStats(String[] send, int numSend, String[] fail, int numFail,
      int historyLength) {
    String statsString;
    int sendIndex, failIndex;
    int sumSend = 0, sumFail = 0;
    int quantSend = 0, quantFail = 0;

    for (int i = 1; i <= historyLength; i++) {
      sendIndex = numSend - i;
      failIndex = numFail - i;

      if (sendIndex >= 0 && sendIndex < send.length && send[sendIndex] != null) {
        sumSend += getGradeFromString(send[sendIndex]);
        quantSend++;
      }

      if (failIndex >= 0 && failIndex < fail.length && fail[failIndex] != null) {
        sumFail += getGradeFromString(fail[failIndex]);
        quantFail++;
      }
    }

    statsString = "send: " + (quantSend == 0 ? "--" : sumSend * 1.0 / quantSend) + "\n";
    statsString += "fail: " + (quantFail == 0 ? "--" : sumFail * 1.0 / quantFail);

    boolean stats = false;
    try {

      if (historyLength <= 0) {
        throw new IllegalArgumentException("Not a valid history length");
      }

      for (int i = 0; i < send.length; i++) {
        if (send[i] == null) {
          stats = true;

        } else {
          stats = false;
          break;
        }

      }
      if (stats == false) {
        throw new RuntimeException("no climbs provided");
      }
      stats = false;
      for (int i = 0; i < send.length; i++) {
        if (fail[i] == null) {
          stats = true;

        } else {
          stats = false;
          break;
        }
      }



    } catch (IllegalArgumentException e4) {
      System.out.println(e4.getMessage());
    } catch (RuntimeException e5) {
      System.out.println(e5.getMessage());
    }



    return statsString;
  }

  /**
   * getHistogram method
   * 
   * @param send
   * @param numSend
   * @param fail
   * @param numFail
   * @return histogram length
   */
  public static String getHistogram(String[] send, int numSend, String[] fail, int numFail) {
    String histogram = "";
    String bufferString = "";
    int fails, sends;
    String gradeString;

    for (int grade = 0; grade < 7; grade++) {

      gradeString = "V" + (grade);
      fails = 0;
      sends = 0;

      for (int failIndex = 0; failIndex < numFail; failIndex++) {
        if (fail[failIndex].equals(gradeString)) {
          fails++;
        }
      }

      for (int sendIndex = 0; sendIndex < numSend; sendIndex++) {
        if (send[sendIndex].equals(gradeString)) {
          sends++;
        }
      }

      bufferString += gradeString + ": " + "- ".repeat(fails) + "+ ".repeat(sends) + "\n";
      if (fails + sends > 0) {
        histogram += bufferString;
        bufferString = "";
      }
    }

    boolean histogram1 = false;
    try {
      for (int i = 0; i < send.length; i++) {
        if (send[i] == null) {
          histogram1 = true;

        } else {
          histogram1 = false;
          break;
        }

      }
      if (histogram1 == false) {
        throw new RuntimeException("no climbs provided");
      }
      histogram1 = false;
      for (int i = 0; i < send.length; i++) {
        if (fail[i] == null) {
          histogram1 = true;

        } else {
          histogram1 = false;
          break;
        }
      }

    } catch (RuntimeException e6) {
      System.out.println(e6.getMessage());
    }


    return histogram.length() == 0 ? "Error: no data to display" : histogram;
  }


}
