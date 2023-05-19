
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
import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Class Header comes here
 * 
 * @author Mouna
 *
 */

public class FishTank extends PApplet {



  private TankObject flower;
  private TankObject shell;
  private TankObject log;
  private TankObject ship;


  private PImage backgroundImage; // PImage object which represents the background image
  protected ArrayList<TankListener> objects; // list storing interactive objects
  protected Random randGen; // Generator of random numbers

  /**
   * Defines initial environment properties such as screen size and to load background images and
   * fonts as the program starts. It also initializes all data fields.
   * 
   * @param processingObj a PApplet object that represents the display window of Fish Tank 1000
   *                      application
   */
  @Override
  public void settings() {
    size(800, 600);
  }

  // Defines initial environment properties such as screen size and
  // loads the background image and fonts as the program starts.
  // It also initializes all data fields.
  // The above IS NOT a javadoc style method header!
  @Override
  public void setup() {

    backgroundImage = (this.loadImage("background"));
    // Set and display the title of the display window
    this.getSurface().setTitle("Fish Tank 3000");
    // Set the location from which images are drawn to CENTER
    this.imageMode(PApplet.CENTER);
    // Set the location from which rectangles are drawn.
    this.rectMode(PApplet.CORNERS);
    // rectMode(CORNERS) interprets the first two parameters of rect() method
    // as the location of one corner, and the third and fourth parameters as
    // the location of the opposite corner.
    // rect() method draws a rectangle to the display window

    this.focused = true; // Confirms that our Processing program is focused,
    // meaning that it is active and will accept mouse or keyboard input.

    // sets the text alignment to center
    this.textAlign(PApplet.CENTER, PApplet.CENTER);


    // TODO load the background image and store the loaded image to backgroundImage
    // Note that you can call the loadImage() method directly (this.loadImage())

    // TODO create an empty array list of objects
    objects = new ArrayList<TankListener>();
    this.loadImage("background.png");

    // TODO set randGen to the reference of a new Random objects
    randGen = this.randGen;

    flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
    log = new TankObject(580, 470, "images" + File.separator + "log.png");
    ship = new TankObject(65, 520, "images" + File.separator + "ship.png");
    shell = new TankObject(280, 535, "images" + File.separator + "shell.png");

    objects.add(flower);
    objects.add(log);
    objects.add(ship);
    objects.add(shell);

    BlackFish OB1 = new BlackFish(log, flower);
    BlackFish OB2 = new BlackFish(shell, flower);
    objects.add(OB1);
    objects.add(OB2);


    Button.setProcessing(this);
    TankObject.setProcessing(this);
  }

  // Continuously draws and updates the application display window
  @Override
  public void draw() {
    // TODO clear the display window by drawing the background image
    this.image(backgroundImage, this.width / 2, this.height / 2);

    // TODO traverse the objects list and draw each of the objects to this display
    // window
    for (int i = 0; i < objects.size(); i++) {

      objects.get(i).draw();
    }

  }

  // Callback method called each time the user presses the mouse
  @Override

  public void mousePressed() {

    for (int i = 0; i < objects.size(); i++) {
      if (((Fish) objects.get(i)).isDragging()) {
        objects.get(i).mousePressed();
      }
    }
  }

  // Callback method called each time the mouse is released
  @Override
  public void mouseReleased() {
    for (int i = 0; i < objects.size(); i++) {

      objects.get(i).mouseReleased();
    }
  }

  // adds an instance of TankListener passed as input to the objects arraylist
  public void addObject(TankListener object) {
    objects.add(object);
  }

  // Removes instances of the class Fish from this tank
  public void clear() {
    for (int i = 0; i < objects.size(); i++) {
      if (objects.get(i) instanceof Fish) {
        objects.remove(i);
        i--;
      }
    }
  }

  // Callback method called each time the user presses a key
  @Override
  public void keyPressed() {

    switch (Character.toUpperCase(this.key)) {
      case 'O': // add a new fish if the maximum numbers of fish allowed to be
                // present in the tank is not reached
        Fish F1 = new Fish(3, "images" + File.separator + "orange.png");
        objects.add(F1);
    }
    switch (Character.toUpperCase(this.key)) {
      case 'Y':

        Fish F2 = new Fish(2, "images" + File.separator + "yellow.png");
        objects.add(F2);
    }
    switch (Character.toUpperCase(this.key)) {
      case 'R':

        for (int i = 0; i < objects.size(); i++) {
          if (objects.get(i) instanceof Fish) {
            objects.remove(i);
          }
        }
    }
    switch (Character.toUpperCase(this.key)) {
      case 'S':

        for (int i = 0; i < objects.size(); i++) {

          ((Fish) (objects.get(i))).startSwimming();

        }
    }
    switch (Character.toUpperCase(this.key)) {
      case 'X':

        for (int i = 0; i < objects.size(); i++) {
          if (objects.get(i) instanceof Fish) {
            ((Fish) (objects.get(i))).stopSwimming();
          }
        }
    }
    switch (Character.toUpperCase(this.key)) {
      case 'C':

        clear();
    }
    switch (Character.toUpperCase(this.key)) {
      case 'B':

        Fish F3 = new Fish(2, "images" + File.separator + "blue.png");
    }

  }

  /**
   * This main method starts the application
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    PApplet.main("FishTank"); // do not add any other statement to the main method
    // The PApplet.main() method takes a String input parameter which represents
    // the name of your PApplet class.

  }

}
