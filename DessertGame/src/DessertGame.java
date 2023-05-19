import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Random;

public class DessertGame extends Application {
    
    private int score = 0;

    @Override
    public void start(final Stage stage) {
        // Step 1 & 2
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 3
        Label scoreLabel = new Label("Score: 0");
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 4
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        // TODO: Step 5-8
        
        exitButton.requestFocus();
        
        Button [] buttonArray = new Button[8];
        
        // dessert button
        Button dessertButton = new Button("Dessert");
        pane.getChildren().add(dessertButton);
        buttonArray[0] = dessertButton;
        
        // first desert button
        Button desert1 = new Button("Desert");
        pane.getChildren().add(desert1);
        buttonArray[1] = desert1;
        
        // second desert button
        Button desert2 = new Button("Desert");
        pane.getChildren().add(desert2);
        buttonArray[2] = desert2;
        
        // third desert button
        Button desert3 = new Button("Desert");
        pane.getChildren().add(desert3);
        buttonArray[3] = desert3;
        
        // fourth desert button
        Button desert4 = new Button("Desert");
        pane.getChildren().add(desert4);
        buttonArray[4] = desert4;
        
        // fifth desert button
        Button desert5 = new Button("Desert");
        pane.getChildren().add(desert5);
        buttonArray[5] = desert5;
        
        // sixth desert button
        Button desert6 = new Button("Desert");
        pane.getChildren().add(desert6);
        buttonArray[6] = desert6;
        
        // seventh desert button
        Button desert7 = new Button("Desert");
        pane.getChildren().add(desert7);
        buttonArray[7] = desert7;
       
        // randomizes
        Random random = new Random();
        randomizeButtonPositions(random, buttonArray);
        
        // all of the event handlers
        
        dessertButton.setOnAction(event -> {
            exitButton.requestFocus();
            randomizeButtonPositions(random, buttonArray);
            score++;
            scoreLabel.setText("Score: " + score);
        });
        
        desert1.setOnAction(event -> {
            exitButton.requestFocus();
            randomizeButtonPositions(random, buttonArray);
            score--;
            scoreLabel.setText("Score: " + score);
        });
        
        desert2.setOnAction(event -> {
            exitButton.requestFocus();
            randomizeButtonPositions(random, buttonArray);
            score--;
            scoreLabel.setText("Score: " + score);
        });
        
        desert3.setOnAction(event -> {
            exitButton.requestFocus();
            randomizeButtonPositions(random, buttonArray);
            score--;
            scoreLabel.setText("Score: " + score);
        });
        
        desert4.setOnAction(event -> {
            exitButton.requestFocus();
            randomizeButtonPositions(random, buttonArray);
            score--;
            scoreLabel.setText("Score: " + score);
        });
        
        desert5.setOnAction(event -> {
            exitButton.requestFocus();
            randomizeButtonPositions(random, buttonArray);
            score--;
            scoreLabel.setText("Score: " + score);
        });
        
        desert6.setOnAction(event -> {
            exitButton.requestFocus();
            randomizeButtonPositions(random, buttonArray);
            score--;
            scoreLabel.setText("Score: " + score);
        });
        
        desert7.setOnAction(event -> {
            exitButton.requestFocus();
            randomizeButtonPositions(random, buttonArray);
            score--;
            scoreLabel.setText("Score: " + score);
        });
        
        stage.setScene(scene);
        stage.show();
    }
    
    private void randomizeButtonPositions(Random random, Button [] buttonArray) 
    {
        for(int i = 0;i < buttonArray.length;i++) 
        {
            buttonArray[i].setLayoutX(random.nextInt(601));
            buttonArray[i].setLayoutY(random.nextInt(401));
        }
    }

    public static void main(String[] args) {
        Application.launch();
    }
}