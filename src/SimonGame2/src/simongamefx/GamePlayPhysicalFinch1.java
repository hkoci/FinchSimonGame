/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simongamefx;

//Game Dependencies
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import simongame2.GameStatistics;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

//JavaFX Dependencies
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


/**
 *
 * @author Greengroup 46
 */
public class GamePlayPhysicalFinch1 extends Application {
    
    //Global variables within scope of class GameEngine
    private static boolean gameFinchToggle = true; //Boolean flag for checking if game is running or not.

    //Initialise the ArrayList for the Colour pattern to be stored as Character data-type
    private static ArrayList<Integer> ColourSequenceRandomised = new ArrayList<Integer>();

    //Instantiate the GameStatistics class through the gameStatClass object
    private static GameStatistics gameStatClass = new GameStatistics();
    
    //Get the multiplayer and timeout settings without creating new instance by using their static variables
    private static boolean multiplayer = SimonFX.getMultiplayer();
    private static double timeout = SettingsGUI.getTimeout();
    
    //Get the JavaFX Colours from the settings menu as required AWT for finch library
    private static Color finch1Colour = SettingsGUI.getFinch1ColourAsAWT();
    private static Color finch2Colour = SettingsGUI.getFinch2ColourAsAWT();
    private static Color finch3Colour = SettingsGUI.getFinch3ColourAsAWT();
    private static Color finch4Colour = SettingsGUI.getFinch4ColourAsAWT();
    
    //Virtual Finch flags
    private boolean finch1Tapped = false;
    private boolean finch1Visible = true;
    private boolean finch2Tapped = false;
    private boolean finch2Visible = true;
    private boolean finch3Tapped = false;
    private boolean finch3Visible = true;
    private boolean finch4Tapped = false;
    private boolean finch4Visible = true;
    private boolean finchToggleVisible = false;
    private boolean finchToggleTapped = false;
    
    //Current character to check from user pattern and generated pattern
    private int indexChar = 0;

    //A boolean state which changes when game is over.
    private boolean hasDisplayedOnce = false;
    
    //A boolean state which changes when the game is checking the pattern
    private static boolean gamePatternChecking = false;
    
    //A boolean state which changes if the game was lost due to the timeout
    private static boolean gameTimeOut = false;
    
    //Instantiate finch objects
    private Finch finchObject1 = new Finch();
    
    @Override
    public void start(Stage gameStage) {
        //Auto-generated code from FXML
        //Netbeans FXML 2 JAVA Converter created the positioning and sizing as an abstract class
        //This has then been edited from the abstract class to this so that it can be run on start
        //The virtual finches do have event triggers for setting their tapped flags - which has been added.
        AnchorPane anchorPane = new AnchorPane();
        Rectangle currentColourRect = new Rectangle();
        Reflection reflection = new Reflection();
        Label timeoutLabel = new Label();
        Label gameStatusLabel = new Label();
        Glow glow = new Glow();
        Label scorePlaceholderLabel = new Label();
        Label scoreActualLabel = new Label();
        Label livesPlaceholderLabel = new Label();
        Label livesActualLabel = new Label();
        Label mpTableTitle = new Label();
        TableView mpTableView = new TableView();
        TableColumn playerColumn = new TableColumn();
        TableColumn scoreColumn = new TableColumn();
        TableColumn livesColumn = new TableColumn();
        VBox virtualFinchVBox = new VBox();
        AnchorPane anchorPane0 = new AnchorPane();
        HBox vFinchHorizontalContainer = new HBox();
        Group finch1Group = new Group();
        ImageView vFinch1Img = new ImageView();
        Circle vFinch1Circle = new Circle();
        Label vFinch1Label = new Label();
        Group finch2Group = new Group();
        ImageView vFinch2Img = new ImageView();
        Circle vFinch2Circle = new Circle();
        Label vFinch2Label = new Label();
        Group finch3Group = new Group();
        ImageView vFinch3Img = new ImageView();
        Circle vFinch3Circle = new Circle();
        Label vFinch3Label = new Label();
        Group finch4Group = new Group();
        ImageView vFinch4Img = new ImageView();
        Circle vFinch4Circle = new Circle();
        Label vFinch4Label = new Label();
        Group finchToggleGroup = new Group();
        ImageView vFinchToggleImg = new ImageView();
        Circle vFinchToggleCircle = new Circle();
        Label vFinchToggleLabel = new Label();
        Label vFinchTitle = new Label();
        Label virtualHelpLabel = new Label();
        VBox vboxWindow = new VBox();

        vboxWindow.setPrefHeight(428.0);
        vboxWindow.setPrefWidth(729.0);

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setMaxWidth(-1.0);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(700.0);

        currentColourRect.setArcHeight(5.0);
        currentColourRect.setArcWidth(5.0);
        currentColourRect.setFill(javafx.scene.paint.Color.WHITE);
        currentColourRect.setHeight(150.0);
        currentColourRect.setLayoutX(258.0);
        currentColourRect.setLayoutY(14.0);
        currentColourRect.setStroke(javafx.scene.paint.Color.BLACK);
        currentColourRect.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        currentColourRect.setWidth(150.0);

        reflection.setFraction(0.32);
        reflection.setTopOpacity(0.44);
        currentColourRect.setEffect(reflection);

        timeoutLabel.setLayoutX(325.0);
        timeoutLabel.setLayoutY(158.0);
        timeoutLabel.setText("5");
        timeoutLabel.setFont(new Font("System Bold", 29.0));
        timeoutLabel.setVisible(false);

        gameStatusLabel.setAlignment(javafx.geometry.Pos.CENTER);
        gameStatusLabel.setLayoutX(151.0);
        gameStatusLabel.setLayoutY(38.0);
        gameStatusLabel.setPrefHeight(77.0);
        gameStatusLabel.setPrefWidth(339.0);
        gameStatusLabel.setText("Get Ready");
        gameStatusLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameStatusLabel.setWrapText(true);
        gameStatusLabel.setFont(new Font(53.0));
        gameStatusLabel.setCursor(Cursor.DEFAULT);

        glow.setLevel(0.53);
        gameStatusLabel.setEffect(glow);

        scorePlaceholderLabel.setLayoutX(14.0);
        scorePlaceholderLabel.setLayoutY(169.0);
        scorePlaceholderLabel.setText("Your score: ");
        scorePlaceholderLabel.setFont(new Font(15.0));

        scoreActualLabel.setLayoutX(92.0);
        scoreActualLabel.setLayoutY(166.0);
        scoreActualLabel.setText("0");
        scoreActualLabel.setFont(new Font(18.0));

        livesPlaceholderLabel.setLayoutX(14.0);
        livesPlaceholderLabel.setLayoutY(14.0);
        livesPlaceholderLabel.setText("Lives:");
        livesPlaceholderLabel.setFont(new Font(15.0));

        livesActualLabel.setLayoutX(53.0);
        livesActualLabel.setLayoutY(11.0);
        livesActualLabel.setText("3");
        livesActualLabel.setFont(new Font(18.0));

        mpTableTitle.setLayoutX(491.0);
        mpTableTitle.setLayoutY(14.0);
        mpTableTitle.setText("Multiplayer Scores");
        mpTableTitle.setFont(new Font("System Bold", 15.0));

        mpTableView.setLayoutX(490.0);
        mpTableView.setLayoutY(38.0);
        mpTableView.setPrefHeight(139.0);
        mpTableView.setPrefWidth(229.0);

        playerColumn.setEditable(false);
        playerColumn.setPrefWidth(123.0);
        playerColumn.setText("Player");

        scoreColumn.setEditable(false);
        scoreColumn.setPrefWidth(69.0);
        scoreColumn.setSortType(javafx.scene.control.TableColumn.SortType.DESCENDING);
        scoreColumn.setText("Score");

        livesColumn.setEditable(false);
        livesColumn.setPrefWidth(36.0);
        livesColumn.setText("Lives");

        virtualFinchVBox.setLayoutX(64.0);
        virtualFinchVBox.setLayoutY(222.0);
        virtualFinchVBox.setPrefHeight(161.0);
        virtualFinchVBox.setPrefWidth(573.0);
        virtualFinchVBox.setVisible(false); //disable virtual finch on game startup

        VBox.setVgrow(anchorPane0, javafx.scene.layout.Priority.ALWAYS);
        anchorPane0.setMaxHeight(-1.0);
        anchorPane0.setMaxWidth(-1.0);

        vFinchHorizontalContainer.setLayoutX(9.0);
        vFinchHorizontalContainer.setLayoutY(36.0);
        vFinchHorizontalContainer.setPrefHeight(116.0);
        vFinchHorizontalContainer.setPrefWidth(564.0);

        vFinch1Img.setFitHeight(111.0);
        vFinch1Img.setFitWidth(111.0);
        vFinch1Img.setPickOnBounds(true);
        vFinch1Img.setPreserveRatio(true);
        vFinch1Img.setImage(new Image(getClass().getResource("virtualFinchImg-GreyBG.jpg").toExternalForm()));

        vFinch1Circle.setFill(SettingsGUI.getFinch1Colour());
        vFinch1Circle.setLayoutX(53.0);
        vFinch1Circle.setLayoutY(82.0);
        vFinch1Circle.setRadius(19.0);
        vFinch1Circle.setStroke(javafx.scene.paint.Color.BLACK);
        vFinch1Circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        vFinch1Circle.setStrokeWidth(2.0);
        vFinch1Circle.setVisible(finch1Visible);

        vFinch1Label.setLayoutX(24.0);
        vFinch1Label.setLayoutY(-15.0);
        vFinch1Label.setText("Finch 1");
        vFinch1Label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        vFinch1Label.setFont(new Font(20.0));

        vFinch2Img.setFitHeight(111.0);
        vFinch2Img.setFitWidth(111.0);
        vFinch2Img.setPickOnBounds(true);
        vFinch2Img.setPreserveRatio(true);
        vFinch2Img.setImage(new Image(getClass().getResource("virtualFinchImg-GreyBG.jpg").toExternalForm()));

        vFinch2Circle.setFill(SettingsGUI.getFinch2Colour());
        vFinch2Circle.setLayoutX(53.0);
        vFinch2Circle.setLayoutY(82.0);
        vFinch2Circle.setRadius(19.0);
        vFinch2Circle.setStroke(javafx.scene.paint.Color.BLACK);
        vFinch2Circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        vFinch2Circle.setStrokeWidth(2.0);
        vFinch2Circle.setVisible(finch2Visible);

        vFinch2Label.setLayoutX(24.0);
        vFinch2Label.setLayoutY(-15.0);
        vFinch2Label.setText("Finch 2");
        vFinch2Label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        vFinch2Label.setFont(new Font(20.0));

        vFinch3Img.setFitHeight(111.0);
        vFinch3Img.setFitWidth(111.0);
        vFinch3Img.setPickOnBounds(true);
        vFinch3Img.setPreserveRatio(true);
        vFinch3Img.setImage(new Image(getClass().getResource("virtualFinchImg-GreyBG.jpg").toExternalForm()));

        vFinch3Circle.setFill(SettingsGUI.getFinch3Colour());
        vFinch3Circle.setLayoutX(53.0);
        vFinch3Circle.setLayoutY(82.0);
        vFinch3Circle.setRadius(19.0);
        vFinch3Circle.setStroke(javafx.scene.paint.Color.BLACK);
        vFinch3Circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        vFinch3Circle.setStrokeWidth(2.0);
        vFinch3Circle.setVisible(finch3Visible);

        vFinch3Label.setLayoutX(24.0);
        vFinch3Label.setLayoutY(-15.0);
        vFinch3Label.setText("Finch 3");
        vFinch3Label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        vFinch3Label.setFont(new Font(20.0));

        vFinch4Img.setFitHeight(111.0);
        vFinch4Img.setFitWidth(111.0);
        vFinch4Img.setPickOnBounds(true);
        vFinch4Img.setPreserveRatio(true);
        vFinch4Img.setImage(new Image(getClass().getResource("virtualFinchImg-GreyBG.jpg").toExternalForm()));

        vFinch4Circle.setFill(SettingsGUI.getFinch4Colour());
        vFinch4Circle.setLayoutX(53.0);
        vFinch4Circle.setLayoutY(82.0);
        vFinch4Circle.setRadius(19.0);
        vFinch4Circle.setStroke(javafx.scene.paint.Color.BLACK);
        vFinch4Circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        vFinch4Circle.setStrokeWidth(2.0);
        vFinch4Circle.setVisible(finch4Visible);

        vFinch4Label.setLayoutX(24.0);
        vFinch4Label.setLayoutY(-15.0);
        vFinch4Label.setText("Finch 4");
        vFinch4Label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        vFinch4Label.setFont(new Font(20.0));

        vFinchToggleImg.setFitHeight(111.0);
        vFinchToggleImg.setFitWidth(111.0);
        vFinchToggleImg.setPickOnBounds(true);
        vFinchToggleImg.setPreserveRatio(true);
        vFinchToggleImg.setImage(new Image(getClass().getResource("virtualFinchImg-GreyBG.jpg").toExternalForm()));

        vFinchToggleCircle.setLayoutX(53.0);
        vFinchToggleCircle.setLayoutY(82.0);
        vFinchToggleCircle.setRadius(19.0);
        vFinchToggleCircle.setStroke(javafx.scene.paint.Color.BLACK);
        vFinchToggleCircle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        vFinchToggleCircle.setStrokeWidth(2.0);

        vFinchToggleLabel.setLayoutX(1.0);
        vFinchToggleLabel.setLayoutY(-15.0);
        vFinchToggleLabel.setText("FinchToggle");
        vFinchToggleLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        vFinchToggleLabel.setFont(new Font(20.0));
        vFinchHorizontalContainer.setCursor(Cursor.HAND);

        vFinchTitle.setLayoutX(9.0);
        vFinchTitle.setLayoutY(6.0);
        vFinchTitle.setText("Virtual Finches");
        vFinchTitle.setFont(new Font("System Bold", 20.0));

        virtualHelpLabel.setLayoutX(2.0);
        virtualHelpLabel.setLayoutY(158.0);
        virtualHelpLabel.setText("If there is no pyshical finch connected, the virtual finch will work, you can tap it to perform the same functionality.");
        virtualHelpLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        anchorPane.getChildren().add(currentColourRect);
        anchorPane.getChildren().add(timeoutLabel);
        anchorPane.getChildren().add(gameStatusLabel);
        anchorPane.getChildren().add(scorePlaceholderLabel);
        anchorPane.getChildren().add(scoreActualLabel);
        anchorPane.getChildren().add(livesPlaceholderLabel);
        anchorPane.getChildren().add(livesActualLabel);
        //show multiplayer table if in multiplayer game
        if (SimonFX.getMultiplayer() == true) {
            //get current user states, through the values of score and lives through constructor
            playerColumn.setCellValueFactory(new PropertyValueFactory("name"));
            scoreColumn.setCellValueFactory(new PropertyValueFactory("score"));
            livesColumn.setCellValueFactory(new PropertyValueFactory("lives"));
            anchorPane.getChildren().add(mpTableTitle);
            mpTableView.getColumns().add(playerColumn);
            mpTableView.getColumns().add(scoreColumn);
            mpTableView.getColumns().add(livesColumn);
            anchorPane.getChildren().add(mpTableView);
            //add yourself as first user
            mpTableView.getItems().add(gameStatClass);
        }
        
        finch1Group.getChildren().add(vFinch1Img);
        finch1Group.getChildren().add(vFinch1Circle);
        finch1Group.getChildren().add(vFinch1Label);
        finch1Group.setOnMouseClicked(e -> { 
            //Set finch tapped variable to true and display circle
            finch1Tapped = true;
            vFinch1Circle.setVisible(true);
            
            //Pause for 1.5 seconds
            PauseTransition vFinch1CircleLEDdelay = new PauseTransition(Duration.seconds(1));
            vFinch1CircleLEDdelay.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    //set finch tapped variable to false and reset visibility
                    finch1Tapped = false; 
                    vFinch1Circle.setVisible(false);
                }
            });

            vFinch1CircleLEDdelay.play();
        } );
        vFinchHorizontalContainer.getChildren().add(finch1Group);
        
        finch2Group.getChildren().add(vFinch2Img);
        finch2Group.getChildren().add(vFinch2Circle);
        finch2Group.getChildren().add(vFinch2Label);
        finch2Group.setOnMouseClicked(e -> { 
            //Set finch tapped variable to true and display circle
            finch2Tapped = true;
            vFinch2Circle.setVisible(true);
            
            //Pause for 1.5 seconds
            PauseTransition vFinch2CircleLEDdelay = new PauseTransition(Duration.seconds(1));
            vFinch2CircleLEDdelay.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    //set finch tapped variable to false and reset visibility
                    finch2Tapped = false;
                    vFinch2Circle.setVisible(false);
                }
            });

            vFinch2CircleLEDdelay.play();
        } );
        vFinchHorizontalContainer.getChildren().add(finch2Group);
        
        finch3Group.getChildren().add(vFinch3Img);
        finch3Group.getChildren().add(vFinch3Circle);
        finch3Group.getChildren().add(vFinch3Label);
        finch3Group.setOnMouseClicked(e -> { 
            //Set finch tapped variable to true and display circle
            finch3Tapped = true;
            vFinch3Circle.setVisible(true);
            
            //Pause for 1.5 seconds
            PauseTransition vFinch3CircleLEDdelay = new PauseTransition(Duration.seconds(1));
            vFinch3CircleLEDdelay.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    //set finch tapped variable to false and reset visibility
                    finch3Tapped = false;
                    vFinch3Circle.setVisible(false);
                }
            });

            vFinch3CircleLEDdelay.play();
        } );
        vFinchHorizontalContainer.getChildren().add(finch3Group);
        
        finch4Group.getChildren().add(vFinch4Img);
        finch4Group.getChildren().add(vFinch4Circle);
        finch4Group.getChildren().add(vFinch4Label);
        finch4Group.setOnMouseClicked(e -> { 
            //Set finch tapped variable to true and display circle
            finch4Tapped = true;
            vFinch4Circle.setVisible(true);
            
            //Pause for 1.5 seconds
            PauseTransition vFinch4CircleLEDdelay = new PauseTransition(Duration.seconds(1));
            vFinch4CircleLEDdelay.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    //set finch tapped variable to false and reset visibility
                    finch4Tapped = false;
                    vFinch4Circle.setVisible(false);
                }
            });

            vFinch4CircleLEDdelay.play();
        } );
        vFinchHorizontalContainer.getChildren().add(finch4Group);
        
        finchToggleGroup.getChildren().add(vFinchToggleImg);
        finchToggleGroup.getChildren().add(vFinchToggleCircle);
        finchToggleGroup.getChildren().add(vFinchToggleLabel);
        finchToggleGroup.setOnMouseClicked(e -> { 
            //Set finch tapped variable to true and display circle
            finchToggleTapped = true;
            vFinchToggleCircle.setVisible(true);
            
            //Pause for 1.5 seconds
            PauseTransition vFinchToggleCircleLEDdelay = new PauseTransition(Duration.seconds(1));
            vFinchToggleCircleLEDdelay.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    //set finch tapped variable to false and reset visibility
                    finchToggleTapped = false;
                    vFinchToggleCircle.setVisible(false);
                    if(gameFinchToggle) gameFinchToggle = false; //reset game running state to false
                }
            });

            vFinchToggleCircleLEDdelay.play();
        } );
        vFinchHorizontalContainer.getChildren().add(finchToggleGroup);
        
        anchorPane0.getChildren().add(vFinchHorizontalContainer);
        anchorPane0.getChildren().add(vFinchTitle);
        anchorPane0.getChildren().add(virtualHelpLabel);
        virtualFinchVBox.getChildren().add(anchorPane0);
        anchorPane.getChildren().add(virtualFinchVBox);
        vboxWindow.getChildren().add(anchorPane);

        //Create a new JavaFX Scene using the vBoxWindow which the GUI nodes is drawn on.
        Scene scene = new Scene(vboxWindow);
        
        gameStage.setTitle("Simon Gameplay"); //Set title of game to gameplay
        gameStage.setScene(scene); //Sets the stage to the scene, the scene contains the vBox which is drawn on
        gameStage.setResizable(false); //Apply no resizability
        gameStage.getIcons().add(new Image(getClass().getResource("stageicon.png").toExternalForm())); //Add stageicon for program icon
        gameStage.initStyle(StageStyle.UNDECORATED); //Use no Window dialog (so user cannot stop game by pressing the X)
        gameStage.show(); //Show the stage to the user
        
        //Start game sound on finch
        gameStartSound();
        
        //This is when the game actually is drawn, the code below runs whilst the game is drawn
        //Due to JavaFX being event driven programming, I made use of PauseTransitions and Timelines to act as while loops
        //It is not possible to use while true loops whilst the program is running - so indefinite timeline loops are used.
        
        PauseTransition gameStatusDelay = new PauseTransition(Duration.seconds(1));
        gameStatusDelay.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                //Hide game status and virtual finch beak leds
                gameStatusLabel.setVisible(false);
                currentColourRect.setVisible(true);
                vFinch1Circle.setVisible(false);
                vFinch2Circle.setVisible(false);
                vFinch3Circle.setVisible(false);
                vFinch4Circle.setVisible(false);
                vFinchToggleCircle.setVisible(false);
                virtualFinchVBox.setVisible(true);
                
                //Game is running, clear any previous output
                //Print the \f character which is the ASCII form feed
                System.out.println('\f');

                //Reset any player score keeping variables
                gameStatClass.setScore(0);
                gameStatClass.setLives(3);
                gameStatClass.setRound(0);
                
                //TODO Loop in JAVAFX without while as will breaks gui!
                //Solved, used Timeline lasting indefinitely
                Timeline gameLoopTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    
                    @Override
                    public void handle(ActionEvent event) {
                        //If the game state is true
                        if(gameFinchToggle){
                            
                            //System.out.println(gamePatternChecking);
                            if(!gamePatternChecking){
                                //Increase round by 1
                                gameStatClass.setRound(gameStatClass.getRound() + 1);
                                
                                //Hide status labels from the pattern checks
                                currentColourRect.setVisible(true);
                                gameStatusLabel.setVisible(false);
                                timeoutLabel.setVisible(false);

                                //Get scores/lives from this round and update the labelTexts appropriately.
                                scoreActualLabel.setText(Integer.toString(gameStatClass.getScore()) + " round(" + Integer.toString(gameStatClass.getRound()) + ")");
                                livesActualLabel.setText(Integer.toString(gameStatClass.getLives()));

                                //Add new random applicable character to the ColourSequenceRandomised arraylist
                                patternMethod();

                                //The paint for white rectangle in center when there is no colour sequence to blink
                                //It has been poorly converted here due to AWT Color being incompatible with FX Color
                                //The format in the constructor is (red,green,blue,opacity)
                                javafx.scene.paint.Color whiteFXColour = new javafx.scene.paint.Color (1,1,1,0);

                                /*Debug Output
                                System.out.println("Size of random array" + ColourSequenceRandomised.size());
                                System.out.println("round:" + gameStatClass.getRound());*/

                                //This pauseTransition will run after 1 second, it stops the visibility of the virtual finch (after its called)
                                //If a physical finch is connected, the setLed to Black (no colour) would happen here.
                                PauseTransition pauseColourChange = new PauseTransition(Duration.seconds(1));
                                pauseColourChange.setOnFinished((ActionEvent event1) -> {
                                    //set rectangle in middle to white colour to 'blink'
                                    currentColourRect.setFill(whiteFXColour);
                                    //also reset virtual finch light to off for all finches
                                    vFinch1Circle.setVisible(false);
                                    vFinch2Circle.setVisible(false);
                                    vFinch3Circle.setVisible(false);
                                    vFinch4Circle.setVisible(false);
                                    
                                    //reset finch colours
                                    finchObject1.setLED(Color.BLACK);
                                });

                                switch (ColourSequenceRandomised.get(gameStatClass.getRound() - 1)) {
                                    //finch1 case
                                    case 1:
                                        //Set center rectangle to the finch1 colour
                                        currentColourRect.setVisible(true);
                                        currentColourRect.setFill(SettingsGUI.getFinch1Colour());
                                        vFinch1Circle.setVisible(true); //Display coloured circle on virtual Finch1 beak
                                        
                                        //set finch colour
                                        finchObject1.setLED(finch1Colour);
                                        
                                        pauseColourChange.playFromStart(); //Calls the pause to be run (reset the lights)
                                        break;
                                    //finch2 case
                                    case 2:
                                        //Set center rectangle to the finch1 colour
                                        currentColourRect.setVisible(true);
                                        currentColourRect.setFill(SettingsGUI.getFinch2Colour());
                                        vFinch2Circle.setVisible(true); //Display coloured circle on virtual Finch2 beak
                                        
                                        pauseColourChange.playFromStart(); //Calls the pause to be run (reset the lights)
                                        break;
                                    //finch3 case
                                    case 3:
                                        //Set center rectangle to the finch1 colour
                                        currentColourRect.setVisible(true);
                                        currentColourRect.setFill(SettingsGUI.getFinch3Colour());
                                        vFinch3Circle.setVisible(true); //Display coloured circle on virtual Finch3 beak
                                        
                                        pauseColourChange.playFromStart();
                                        break;
                                    //finch4 case
                                    case 4:
                                        //Set center rectangle to the finch1 colour
                                        currentColourRect.setVisible(true);
                                        currentColourRect.setFill(SettingsGUI.getFinch4Colour());
                                        vFinch4Circle.setVisible(true); //Display coloured circle on virtual Finch4 beak
                                        
                                        pauseColourChange.playFromStart(); //Calls the pause to be run (reset the lights)
                                        break;
                                    default:
                                        break;
                                }
                                
                                //Check if the size of the generated array is the same as the round
                                //If so it's time to pattern check!
                                if(ColourSequenceRandomised.size() == gameStatClass.getRound()){
                                    gamePatternChecking = true;
                                    indexChar = 0;
                                }

                                //TODO: CHECK PATTERN (DONE)
                                //Loop until correct.
                            }else{
                                //User turn to enter pattern
                                //It's user turn to now enter pattern
                                
                                //Hide center rectangle which displays sequence
                                currentColourRect.setVisible(false);
                                
                                //Show the label telling user its their turn
                                gameStatusLabel.setVisible(true);
                                gameStatusLabel.setText("Your Turn");
                                
                                //get the start time (needed to check for timeout)
                                long startTime = System.currentTimeMillis(); // the current time in ms of when pattern check started
                                Timeline patternChkTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

                                    @Override
                                    public void handle(ActionEvent event) {
                                        /*
                                        Check that it has not been more than the timeout amount of seconds.
                                        A simple check is subtracting the current execution time with the previous execution time
                                        and then comparing if the difference is below the timeout (in ms)
                                        
                                        There is a bug fix here, we multiply the timeout by the round as the current execution time does not reflect
                                        on round changes.
                                        
                                        This is due to the gameloop being under the timeline indefinitely loop this being the time of when the loop
                                        started, nevertheless, it is a viable solution and works (as round 1 does count from 5-0)
                                        */
                                        if(System.currentTimeMillis() - startTime < (timeout * 1000 * gameStatClass.getRound())){
                                            //refresh mp stats
                                            mpTableView.getItems().remove(gameStatClass);
                                            mpTableView.getItems().add(gameStatClass);
                                            //If the current character being checked is the same size as the sequence, it is correct.
                                            //Therefore, there is no need to do any more checking, so set to false so game can generate next colour
                                            if(indexChar == (ColourSequenceRandomised.size())){
                                                gamePatternChecking = false;
                                                gameStatClass.setScore(gameStatClass.getRound());
                                            }else{
                                                //Check all virtual finch taps (the vFinch group triggers the variable to true on mouse click event).
                                                if (finch1Tapped == true || finchObject1.isTapped()) {
                                                    finch1Tapped = false; //reset variable to false.
                                                    //Check if the colour pattern current character is equal to Finch1
                                                    if (ColourSequenceRandomised.get(indexChar) == 1) {
                                                        //As true, we can now check for the next colour in the sequence
                                                        indexChar++;
                                                        finchObject1.setLED(finch1Colour,100);
                                                    } else {
                                                        //This finch was not tapped correctly, so we will reduce a live
                                                        //If they have had no lives then the game ends for them unfortunately
                                                        if (gameStatClass.getLives() > 0) {
                                                            gameStatClass.setLives(gameStatClass.getLives() - 1); //reduce a live
                                                            livesActualLabel.setText(Integer.toString(gameStatClass.getLives())); //set text to show lives left
                                                            System.out.println("Incorrect choice!"); //debug output from Simon v1 (terminal version of game)
                                                            System.out.println("You now have " + gameStatClass.getLives() + " lives remaining.");//debug output from Simon v1 (terminal version of game)
                                                            indexChar = 0; //reset character check to 0, so the user has to re-enter sequence from the start
                                                            // play incorrect sound and show red led on available finches
                                                            gameIncorrectPatternSound();
                                                            finchObject1.setLED(Color.RED,1000);
                                                        } else {
                                                            //There is no more lives, so their game has ended,
                                                            //Debug output from Simon v1 terminal game
                                                            System.out.println("You have run out of lives!");
                                                            System.out.println("Your score was " + gameStatClass.getScore());
                                                            gameFinchToggle = false; //set game running state to false.
                                                        }
                                                    }
                                                } else if (finch2Tapped == true) {
                                                    finch2Tapped = false; //reset variable to false
                                                    //Check if the colour pattern current character is equal to Finch2
                                                    if (ColourSequenceRandomised.get(indexChar) == 2) {
                                                        indexChar++;
                                                    } else {
                                                        //This finch was not tapped correctly, so we will reduce a live
                                                        //If they have had no lives then the game ends for them unfortunately
                                                        if (gameStatClass.getLives() > 0) {
                                                            gameStatClass.setLives(gameStatClass.getLives() - 1);
                                                            livesActualLabel.setText(Integer.toString(gameStatClass.getLives()));
                                                            System.out.println("Incorrect choice!"); //debug output from Simon v1 (terminal version of game)
                                                            System.out.println("You now have " + gameStatClass.getLives() + " lives remaining.");//debug output from Simon v1 (terminal version of game)
                                                            indexChar = 0; //reset character check to 0, so the user has to re-enter sequence from the start
                                                            // play incorrect sound and show red led on available finches
                                                            gameIncorrectPatternSound();
                                                            finchObject1.setLED(Color.RED,1000);
                                                        } else {
                                                            //There is no more lives, so their game has ended,
                                                            //Debug output from Simon v1 terminal game
                                                            System.out.println("You have run out of lives!");
                                                            System.out.println("Your score was " + gameStatClass.getScore());
                                                            gameFinchToggle = false; //set game running state to false.
                                                        }
                                                    }
                                                } else if (finch3Tapped == true) {
                                                    finch3Tapped = false; //reset variable to false
                                                    //Check if the colour pattern current character is equal to Finch3
                                                    if (ColourSequenceRandomised.get(indexChar) == 3) {
                                                        indexChar++;
                                                    } else {
                                                        if (gameStatClass.getLives() > 0) {
                                                        //This finch was not tapped correctly, so we will reduce a live
                                                        //If they have had no lives then the game ends for them unfortunately
                                                            gameStatClass.setLives(gameStatClass.getLives() - 1);
                                                            livesActualLabel.setText(Integer.toString(gameStatClass.getLives()));
                                                            System.out.println("Incorrect choice!"); //debug output from Simon v1 (terminal version of game)
                                                            System.out.println("You now have " + gameStatClass.getLives() + " lives remaining.");//debug output from Simon v1 (terminal version of game)
                                                            indexChar = 0; //reset character check to 0, so the user has to re-enter sequence from the start
                                                            // play incorrect sound and show red led on available finches
                                                            gameIncorrectPatternSound();
                                                            finchObject1.setLED(Color.RED,1000);
                                                        } else {
                                                            //There is no more lives, so their game has ended,
                                                            //Debug output from Simon v1 terminal game
                                                            System.out.println("You have run out of lives!");
                                                            System.out.println("Your score was " + gameStatClass.getScore());
                                                            gameFinchToggle = false; //set game running state to false.
                                                        }
                                                    }
                                                } else if (finch4Tapped == true) {
                                                    finch4Tapped = false; //reset variable to false
                                                    //Check if the colour pattern current character is equal to Finch4
                                                    if (ColourSequenceRandomised.get(indexChar) == 4) {
                                                        indexChar++;
                                                    } else {
                                                        //This finch was not tapped correctly, so we will reduce a live
                                                        //If they have had no lives then the game ends for them unfortunately
                                                        if (gameStatClass.getLives() > 0) {
                                                            gameStatClass.setLives(gameStatClass.getLives() - 1);
                                                            livesActualLabel.setText(Integer.toString(gameStatClass.getLives()));
                                                            System.out.println("Incorrect choice!"); //debug output from Simon v1 (terminal version of game)
                                                            System.out.println("You now have " + gameStatClass.getLives() + " lives remaining.");//debug output from Simon v1 (terminal version of game)
                                                            indexChar = 0; //reset character check to 0, so the user has to re-enter sequence from the start
                                                            // play incorrect sound and show red led on available finches
                                                            gameIncorrectPatternSound();
                                                            finchObject1.setLED(Color.RED,1000);
                                                        } else {
                                                            //There is no more lives, so their game has ended,
                                                            //Debug output from Simon v1 terminal game
                                                            System.out.println("You have run out of lives!");
                                                            System.out.println("Your score was " + gameStatClass.getScore());
                                                            gameFinchToggle = false; //set game running state to false.
                                                        }
                                                    }
                                                } else {
                                                    //nothing yet tapped, loop again.
                                                }
                                            }
                                        }else{
                                            //The game has reached the timeout - so it will end!
                                            gameTimeOut = true;
                                            gameFinchToggle = false;
                                        }
                                        
                                    }
                                }));
                                patternChkTimeline.setCycleCount(Timeline.INDEFINITE); //loop indefinitely (like a while(true) but for javafx)
                                patternChkTimeline.play(); //play the timeline

                            }

                        }
                        else{
                            //When the game state is false (gameFinchToggle)
                            //The stage of the GUI closes and the dialog (onGameExit method) is run
                            gameStage.close();
                            
                            onGameExit();
                        }
                    }
                }));
                
                gameLoopTimeline.setCycleCount(Timeline.INDEFINITE); //loop indefinitely (like a while(true) but for javafx)
                gameLoopTimeline.play(); //play the timeline
            }
        });
        
        gameStatusDelay.play(); //play the pause
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    //Methods for generating colour seq. pattern
    private static void patternMethod(){
        //Random character generator
        //We will try to set a random seed on every execution through the use of System.currentTimeMillis()
        //The java.util.Random module will try to generate an random integer in our case
        //This integer will choose from one of the character elements in the String containing the colours we have

        Random rand = new Random(System.currentTimeMillis()); //Instantiate the Random object with a random seed
        /* coloursToChooseFrom
             1 = finch1 2 = finch2 3 = finch3 4 = finch4
         */

        //Add to the ArrayList ColourSequenceRandomised, a character from coloursToChooseFrom
        //Using a random number from 1 to 5 of the element index position
        //The rand.nextInt(Num) will generate a random integer from 0 to Num
        //As we need to start from 1, this will now be from 1 to Num + 1
        //In our case, there is only 4 finch colours, so from 1 to 4 is needed, rand.nextInt(3) + 1 would work.
        ColourSequenceRandomised.add((rand.nextInt(3) + 1));
        
        //debug output, comment out on final production code.
        //System.out.println("I generated" + ColourSequenceRandomised.get(ColourSequenceRandomised.size() - 1));
        
        //I would perform the blinking of finches here previously in Simon v1.0 but this is now removed
        //JavaFX Scenes cannot be accessed from this method!
        //So the virtual finches would not blink here, so this is now down back in the stage method...
    }
    
    private void onGameExit(){
        //only display once (as timeline will definitely call this!)
        if(!hasDisplayedOnce){
            hasDisplayedOnce = true;
            gameOverSound();
          
            //Set a new alert dialog with error type
            Alert alert = new Alert(AlertType.ERROR);
            //Title: Game Over!
            alert.setTitle("Game Over!");
            //Header text set to reasoning.
            if(gameTimeOut) alert.setHeaderText("Oh no! You ran out of time!");
            if(!gameTimeOut) alert.setHeaderText("Oh no! You ran out of lives!");
            //Initalise gameovertext
            String gameOverText = "";
            //Set the text to their scores and if they did beat their high score - this highscore is set to the new score.
            if(gameStatClass.getScore() > gameStatClass.getHighscore()){
                gameOverText = "Well Done! You had beat your previous high score of " + gameStatClass.getHighscore() + " with " + gameStatClass.getScore() + " points :)";
                gameStatClass.setHighscore(gameStatClass.getScore());
            }else{
                gameOverText = "Bad luck! You did not beat your previous high score of " + gameStatClass.getHighscore() + ". " + '\n' + "You had gained " + gameStatClass.getScore() + " points. Why not try again?";
            }
            //Show the gameovertext content as the dialog text
            alert.setContentText(gameOverText);
            //display the dialog
            alert.show();
        }
    }
    
    //Sound methods
    public void gameOverSound(){
        //Go from buzz freq. 5000Hz to 1000Hz by decreasing 25Hz
        for(int i=5000;i>=1000;i-=25){
            finchObject1.buzz(i,10); //buzz at set interval freq. for 10ms
        }
    }
    
    public void gameStartSound(){
        //Go from low buzz freq. 1000Hz to 5000Hz by increasing 25Hz
        for(int i=1000;i<=5000;i+=25){
            finchObject1.buzz(i,10); //buzz at set interval freq. for 10ms
        }
    }
    
    public void gameIncorrectPatternSound(){
        //Go from buzz freq. 3000Hz to 1000Hz by decreasing 50Hz
        for(int i=3000;i>=1000;i-=50){
            finchObject1.buzz(i,10); //buzz at set interval freq. for 10ms
        }
    }

}