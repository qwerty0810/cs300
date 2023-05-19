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

public class LockBox {
  protected static Random randGen;
  private String password;
  private boolean isOpen;
  private int passwordLength;

  /*
   * constructor which initializes the static random number generator
   */
  public LockBox(int passwordLength) {

    randGen = new Random();
    if (passwordLength <= 0) {
      throw new IllegalArgumentException("Invalid password length");
    }
    for (int i = 0; i < passwordLength; i++) {
      password = password + randGen.nextInt();
    }

    int password = randGen.nextInt(passwordLength);
    this.password = Integer.toString(password);
    this.password = "";
    for (int i = 0; i < passwordLength; i++) {
      this.password = (password % 10) + this.password;
      password = password / 10;
    }

  }

  /*
   * method which Checks the provided guess against the stored password and Sets the instance field
   * isOpen to true if the guess is correct.
   */
  public void authenticate(String guess) {
    if (guess.equals(password)) {
      isOpen = true;
    }
  }

  /*
   * method which Returns the stored password
   */
  public String hackMe() {
    return password;

  }

  /*
   * An accessor for the isOpen field, to check whether your authentication was successful
   */
  public boolean isOpen() {
    return isOpen;
  }

  /*
   * method which Resets the isOpen instance field to false
   */
  public void reset() {
    isOpen = false;
  }
}
