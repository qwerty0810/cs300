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

public class BlackFish extends Fish {

  private TankObject source;
  private TankObject destination;

  public BlackFish(TankObject source, TankObject destination) {
    super(2, "images" + File.separator + "black.png");
    this.source = source;
    this.destination = destination;
  }

  // makes one speed move towards destination
  // see hints below
  public void moveTowardsDestination() {
    double newX, newY, dx, dy, oldX, oldY;
    int d;

    oldX = this.getX();
    oldY = this.getY();

    dx = destination.getX() - oldX;
    dy = destination.getY() - oldY;
    d = (int) Math.sqrt(dx * dx + dy * dy);

    newX = oldX + (this.getSpeed() * (destination.getX() - oldX) / d);
    newY = oldY + (this.getSpeed() * (destination.getY() - oldX) / d);
  }

  // returns true if this black fish is over another tank object, and false otherwise
  // see hints below
  public boolean isOver(TankObject other) {
    if (other.getX() == this.getX() && other.getY() == this.getY()) {
      return true;
    } else {
      return false;
    }

  }

  // Overrides Fish.swim() method
  @Override
  public void swim() {
    // move the fish towards its destination
    // if destination is reached (meaning this fish is over its destination,
    // switch source and destination

    if (this.getX() == destination.getX() && this.getY() == destination.getY()) {
      TankObject tank = source;
      source = destination;
      destination = tank;
    }
  }

}
