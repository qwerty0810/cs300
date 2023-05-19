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
import java.util.Random;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class TankObject implements TankListener {
  protected static FishTank tank; // PApplet object which represents
  // the display window
  protected PImage image; // image of this tank object
  private float x; // x-position of this tank in the display window
  private float y; // y-position of this tank in the display window
  private boolean isDragging; // indicates whether this tank object
  // is being dragged or not
  private static int oldMouseX; // old x-position of the mouse
  private static int oldmouseY; // old y-position of the mouse
  private static int mouseX;
  private static int mouseY;

  // draws this tank object to the display window
  public void draw() {
    tank.draw();

  }

  // called each time the mouse is Pressed
  public void mousePressed() {
    isDragging = true;
  }

  // called each time the mouse is Released
  public void mouseReleased() {
    isDragging = false;
  }

  // checks whether the mouse is over this Tank GUI
  // return true if the mouse is over this tank GUI object, false otherwise
  public boolean isMouseOver() {
    if (this.mouseX >= x && this.mouseY >= y) {
      return true;
    } else {
      return false;
    }
  }

  public TankObject(float x, float y, String imageFileName) {
    this.x = x;
    this.y = y;
    image = tank.loadImage(imageFileName);

  }

  // Sets the PApplet graphic display window for all TankObjects
  public static void setProcessing(FishTank tank) {
    Fish.tank = tank;
  }

  // Moves this tank object with dx and dy
  // dx move to the x-position of this tank object
  // dy move to the y-position of this tank object
  public void move(int dx, int dy) {
    x += dx;
    y += dy;

  }

  // Returns the x-position of this tank object
  public float getX() {
    return x;

  }

  // Returns the y-position of this tank object
  public float getY() {
    return y;
  }

  // Sets the x-position of this object
  public void setX(float x) {
    this.x = x;
  }

  // Sets the y-position of this object
  public void setY(float y) {
    this.y = y;
  }

  // Returns the image of this tank object
  public PImage getImage() {
    return image;
  }

  // Getter of the isDragging field.
  // returns true if this object is being dragged, false otherwise
  public boolean isDragging() {
    if (isDragging) {
      return true;
    } else {
      return false;
    }
  }

  // Starts dragging this tank object
  public void startDragging() {
    this.isDragging = true;
  }

  // Stops dragging this tank object
  public void stopDragging() {
    this.isDragging = false;
  }


}
