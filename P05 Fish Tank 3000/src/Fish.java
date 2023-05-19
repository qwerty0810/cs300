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
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Class Header comes here
 *
 */
public class Fish extends TankObject {

  private int speed; // swimming speed of this fish

  private boolean isSwimming; // indicates whether this fish is swimming or not

  private float x; // swimming speed of this fish

  private float y; // indicates whether this fish is swimming or not

  private static int oldmouseX;

  private static int oldMouseY;

  private static int mouseX;

  private static int MouseY;
  private boolean isDragging;
  protected float width;

  /**
   * Creates a new fish object positioned at the center of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Fish(int speed, String fishImageFileName) {
    super(3, 6, fishImageFileName);
    this.speed = speed;

    if (speed <= 0) {
      throw new IllegalArgumentException("Warning: speed cannot be negative");
    }
  }

  /**
   * Creates a new fish object positioned at a specific position of the display window
   * 
   * @param processing        PApplet object that represents the display window
   * @param x                 x-coordinate of the image of this fish in the display window
   * @param y                 y-coordinate of the image of this fish in the display window
   * @param speed             the swimming speed of this fish
   * @param fishImageFileName file name of the image of this fish
   */
  public Fish() {
    super(5, 7, "images" + File.separator + "orange.png");
    this.speed = 5;
  }

  /**
   * Draws this fish to the display window.
   */
  public void draw() {

    // if the fish is swimming, call its swim() method
    if (isSwimming) {
      swim();
    } else {
      // draw the fish at its current position
      super.draw();

    }
  }

  /**
   * Moves this fish with dx and dy
   * 
   * @param dx move to the x-position of this fish
   * @param dy move to the y-position of this fish
   */
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }

  /**
   * Returns the image of this fish
   * 
   * @return the image of type PImage of the fish object
   */
  public PImage getImage() {
    return image;
  }

  /**
   * Returns the x-position of this fish in the display window
   * 
   * @return the X coordinate of the fish position
   */
  public float getPositionX() {
    return x;
  }

  /**
   * Returns the y-position of this fish in the display window
   * 
   * @return the Y coordinate of the fish position
   */
  public float getPositionY() {
    return y;
  }

  /**
   * Checks whether this fish is being dragged
   * 
   * @return true if the fish is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
  }

  /**
   * Starts dragging this fish
   * 
   */
  public void startDragging() {
    oldmouseX = this.mouseX;
    oldMouseY = this.MouseY;
    this.isDragging = true;
  }

  /**
   * Stops dragging this fish
   * 
   */
  public void stopDragging() {
    this.isDragging = false;
  }

  /**
   * Starts swimming this fish
   * 
   */
  public void startSwimming() {
    // this.stopDragging();
    this.isSwimming = true;
    swim();
  }

  /**
   * Stops swimming this fish
   * 
   */
  public void stopSwimming() {
    this.isSwimming = false;
  }

  /**
   * Checks if the mouse is over this fish
   * 
   * @return true if the mouse is over this fish object (i.e. over the image of this fish), false
   *         otherwise
   */
  public boolean isMouseOver() {
    int fishWidth = image.width;
    int fishHeight = image.height;

    // checks if the mouse is over this fish
    return this.mouseX >= x - fishWidth / 2 && this.mouseX <= x + fishWidth / 2
        && this.MouseY >= y - fishHeight / 2 && this.MouseY <= y + fishHeight / 2;
  }

  public int speed() {
    return speed;
  }

  /**
   * Moves horizontally the fish one speed step from left to right. Note that x-position of the fish
   * is bounded by the width of the display window. If the x-position of this fish reaches the width
   * of the display window, it is going to be set to zero. You may think of using the modulo
   * operator.
   */
  public void swim() {
    x = (x + speed) % this.width;

    x = (x - speed);
    if (x < 0) {
      x = this.width;
    }
  }

  public int getSpeed() {
    return speed;
  }

}
