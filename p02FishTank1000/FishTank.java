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
import java.util.Random;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class FishTank {

  private static PApplet processing; // PApplet object that represents the graphic
  // interface of the JunglePark application
  private static PImage backgroundImage; // PImage object that represents the
  // background image
  private static Fish[] fishes; // perfect size array storing the different fish present
  // in the fish tank. These fish can be of different species.
  private static Random randGen; // Generator of random numbers

  /**
   * Checks if the mouse is over a specific Fish whose reference is provided as input parameter
   *
   * @param Fish reference to a specific fish
   * @return true if the mouse is over the specific Fish object (i.e. over the image of the Fish),
   *         false otherwise
   */
  public static boolean isMouseOver(Fish Fish) {
    PImage fishImage = fish.getImage();

    float fishWidth = fishImage.width;
    float fishHeight = fishImage.height;
    float fishAtX = fish.getPositionX();
    float fistAtY = fish.getPositionY();

    float mouseX = (float) processing.mouseX;
    float mouseY = (float) processing.mouseY;



  }



  /**
   * Defines the initial environment properties of this application
   * 
   * @param processingObj a reference to the graphic display window of this application
   */
  public static void setup(PApplet processingObj) {
    System.out.println("Set Up....");

    processing = processingObj;

    // load the image of the background
    backgroundImage = processing.loadImage("images/background.png");

   Random ranGen = new Random();

    fishes = Fish[8];

    fishes[0] = new Fish(processing);
    fishes[0] = new Fish(processing, processing.width / 2, processing.height / 2);



  }

  public static Fish randGenFish() {
    float x = (float) randGen.nextInt(processing.width);// generates a random x-position of type
    // float within the width of the display window
    float y = (float) randGen.nextInt(processing.height); // generates a random y-position of type
    // float within the height of the display window

    return Fish(processing.width, processing.height, x, y);
  }


  /**
   * Draws and updates the application display window. This callback method called in an infinite
   * loop.
   */
  public static void draw() {


    // Draw the background image at the center of the screen
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    // width [resp. height]: System variable of the processing library that stores
    // the width [resp. height] of the display window.

    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] == null) {
        continue;


      }
      fishes[i].draw();
    }
  }

  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed() {
    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] == null) {
        continue;
      } else if (isMouseOver(fishes[i])) {
        fishes[i].setDragging(true);
      }
    }
  }

  /**
   * Callback method called each time the mouse is released
   */
  public static void mouseReleased() {
    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] == null) {
        continue;
      }
      fishes[i].setDragging(false);
    }
  }

  /**
   * Callback method called each time the user presses a key
   */
  public static void keyPressed() {
    if (processing.key == 'F' || processing.key == 'f') {
      for (int i = 0; i < fishes.length; i++) {
        if (fishes[i] != null) {
          continue;
        }
        fishes[i] = randGenFish();
        break;
      }
    }

    else if (processing.key == 'R' || processing.key == 'r') {
      for (int i = 0; i < fishes.length; i++) {
        if (!isMouseOver(fishes[i]) || fishes[i] == null) {
          continue;
        }

        fishes[i] = null;
        break;
      }
    }


  }

  public static void main(String[] args) {
    Utility.startApplication(); // starts the application

  }


}
