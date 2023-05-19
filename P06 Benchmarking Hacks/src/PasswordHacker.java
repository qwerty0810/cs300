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


public class PasswordHacker {
  private LockBox toPick;
  private int passwordLength;

  /*
   * constructor stores the provided password length for future reference and creates a new LockBox
   * with a password of the same length.
   */
  public PasswordHacker(int passwordLength) {
    this.passwordLength = passwordLength;
    toPick = new LockBox(passwordLength);
  }

  /*
   * method which first resets the lockBox and the asks for password and then uses that password to
   * open that lockBox
   */
  /** Complexity: O( 1 ) */
  public void hack() {
    toPick.reset();

    String password = toPick.hackMe();
    toPick.authenticate(password);

  }

  /*
   * method which resets the lockBox and uses the generateGuess method to generate guesses
   * methodically until the LockBox opens.
   */
  /** Complexity: O( 10^n ) */
  public void bruteForce() {
    toPick.reset();
    int count = 0;
    while (!toPick.isOpen()) {
      String guess = generateGuess(count);
      toPick.authenticate(guess);
      count++;
    }
  }

  /*
   * method which returns returGuess
   */
  public String generateGuess(int count) {
    String returnGuess = count + "";
    if (returnGuess.length() > passwordLength) {
      returnGuess = returnGuess.substring(returnGuess.length() - passwordLength);
    } else {
      for (int i = returnGuess.length(); i < passwordLength; i++) {
        returnGuess = "0" + returnGuess;
      }
    }
    return returnGuess;

  }
}
