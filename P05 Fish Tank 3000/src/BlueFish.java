//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 Fish Tank 3000
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

import java.io.File;

public class BlueFish extends Fish {

  private float x; // swimming speed of this fish
  private float width;

  BlueFish() {

    super(2, "images" + File.separator + "blue.png");
  }

  // Overrides Fish.swim() method
  @Override
  public void swim() {
    // move the fish towards its destination
    // if destination is reached (meaning this fish is over its destination,
    // switch source and destination


    if (super.getX() <= 0) {
      super.setX(tank.width);
    } else {
      super.setX((super.getX() - super.speed()) % tank.width);
    }
  }
}
