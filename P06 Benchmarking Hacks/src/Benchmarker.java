
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Benchmarking Hacks
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
/**
 * File Header comes here
 */
import java.util.Random;

/*
 * has a list of methods
 */
public class Benchmarker {
  public static void main(String[] args) {

  }

  /*
   * this method records time in long before and after calling passwordHacker's bruteForce method
   */
  public static long timeBruteForce(PasswordHacker ph) {
    long x = System.currentTimeMillis();
    ph.bruteForce();
    long y = System.currentTimeMillis();
    return y - x;
  }

  /*
   * this method records time in long before and after calling passwordHacker's timeHack method
   */
  public static long timeHack(PasswordHacker ph) {
    long x = System.currentTimeMillis();
    ph.hack();
    long y = System.currentTimeMillis();
    return y - x;
  }

  /*
   * two approaches are raced against eachother.Results of this race are returned
   */
  public static String race(int passwordLength, int numRuns) {

    long bruteForceTimeTotal = 0;
    long bruteForceTimeAvg = 0;
    long timeHackTimeTotal = 0;
    long timeHackTimeAvg = 0;
    for (int i = 0; i < numRuns; i++) {
      PasswordHacker ph = new PasswordHacker(passwordLength);
      bruteForceTimeTotal = bruteForceTimeTotal + timeBruteForce(ph);

    }
    bruteForceTimeAvg = bruteForceTimeTotal / (long) numRuns;
    for (int i = 0; i < numRuns; i++) {
      PasswordHacker ph = new PasswordHacker(passwordLength);
      timeHackTimeTotal = timeHackTimeTotal + timeBruteForce(ph);
    }
    timeHackTimeAvg = timeHackTimeTotal / (long) numRuns;
    return "Brute force " + passwordLength + ": " + bruteForceTimeAvg + "\nHack " + passwordLength
        + ": " + timeHackTimeAvg;
  }


}
