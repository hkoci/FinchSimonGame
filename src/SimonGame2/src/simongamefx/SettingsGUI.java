/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simongamefx;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import simongame2.GameStatistics;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

/**
 *
 * @author Henri
 */
public class SettingsGUI extends Application {
    
    private static double timeout = 10;
    private static Color finch1Colour = Color.RED;
    private static Color finch2Colour = Color.BLUE;
    private static Color finch3Colour = Color.GREEN;
    private static Color finch4Colour = Color.YELLOW;
    
    @Override
    public void start(Stage settingsStage) {
        //Auto-generated code from FXML
        //Netbeans FXML 2 JAVA Converter created the positioning and sizing as an abstract class
        //This has then been edited from the abstract class to this so that it can be run on start
        //It contains the sizing and positioning of the graphical elements which will be inserted onto the stage
        AnchorPane anchorPane = new AnchorPane();
        Label finchColoursTitleLabel = new Label();
        Label finch1ColourLabel = new Label();
        ColorPicker finch1ColorPicker = new ColorPicker();
        Label finch2ColourLabel = new Label();
        ColorPicker finch2ColorPicker = new ColorPicker();
        Label finch3ColourLabel = new Label();
        ColorPicker finch3ColorPicker = new ColorPicker();
        Label finch4ColourLabel = new Label();
        ColorPicker finch4ColorPicker = new ColorPicker();
        Label gameDifficultyTitleLabel = new Label();
        Slider gameTimeoutSlider = new Slider();
        Label gameTimeoutLabel = new Label();
        Button exitBtn = new Button();
        Button previewBtn = new Button();
        Label timeoutEasyLabel = new Label();
        Label timeoutHarderLabel = new Label();
        VBox vboxWindow = new VBox();
        
        GameStatistics gameStatClass = new GameStatistics();
        
        vboxWindow.setPrefHeight(184.0);
        vboxWindow.setPrefWidth(640.0);

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setMaxWidth(-1.0);

        finchColoursTitleLabel.setLayoutX(55.0);
        finchColoursTitleLabel.setLayoutY(12.0);
        finchColoursTitleLabel.setText("Finch beak colours");
        finchColoursTitleLabel.setFont(new Font("System Bold", 18.0));

        finch1ColourLabel.setLayoutX(37.0);
        finch1ColourLabel.setLayoutY(48.0);
        finch1ColourLabel.setText("Finch 1");
        finch1ColourLabel.setFont(new Font(18.0));

        finch1ColorPicker.setLayoutX(108.0);
        finch1ColorPicker.setLayoutY(49.0);
        finch1ColorPicker.setValue(finch1Colour);
        finch1ColorPicker.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //When the user picks a colour from the colorpicker, store this in global variable finch1Colour
                finch1Colour = finch1ColorPicker.getValue();
            }
        });

        finch2ColourLabel.setLayoutX(37.0);
        finch2ColourLabel.setLayoutY(82.0);
        finch2ColourLabel.setText("Finch 2");
        finch2ColourLabel.setFont(new Font(18.0));

        finch2ColorPicker.setLayoutX(108.0);
        finch2ColorPicker.setLayoutY(83.0);
        finch2ColorPicker.setValue(finch2Colour);
        finch2ColorPicker.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //When the user picks a colour from the colorpicker, store this in global variable finch2Colour
                finch2Colour = finch2ColorPicker.getValue();
            }
        });

        finch3ColourLabel.setLayoutX(37.0);
        finch3ColourLabel.setLayoutY(115.0);
        finch3ColourLabel.setText("Finch 3");
        finch3ColourLabel.setFont(new Font(18.0));

        finch3ColorPicker.setLayoutX(108.0);
        finch3ColorPicker.setLayoutY(116.0);
        finch3ColorPicker.setValue(finch3Colour);
        finch3ColorPicker.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //When the user picks a colour from the colorpicker, store this in global variable finch3Colour
                finch3Colour = finch3ColorPicker.getValue();
            }
        });

        finch4ColourLabel.setLayoutX(37.0);
        finch4ColourLabel.setLayoutY(153.0);
        finch4ColourLabel.setText("Finch 4");
        finch4ColourLabel.setFont(new Font(18.0));

        finch4ColorPicker.setLayoutX(108.0);
        finch4ColorPicker.setLayoutY(154.0);
        finch4ColorPicker.setValue(finch4Colour);
        finch4ColorPicker.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //When the user picks a colour from the colorpicker, store this in global variable finch4Colour
                finch4Colour = finch4ColorPicker.getValue();
            }
        });

        gameDifficultyTitleLabel.setLayoutX(265.0);
        gameDifficultyTitleLabel.setLayoutY(12.0);
        gameDifficultyTitleLabel.setText("Game Difficulty");
        gameDifficultyTitleLabel.setFont(new Font("System Bold", 18.0));

        gameTimeoutSlider.setBlockIncrement(1.0);
        gameTimeoutSlider.setLayoutX(301.0);
        gameTimeoutSlider.setLayoutY(45.0);
        gameTimeoutSlider.setMajorTickUnit(1.0);
        gameTimeoutSlider.setMax(10.0);
        gameTimeoutSlider.setMin(1.0);
        gameTimeoutSlider.setMinorTickCount(1);
        gameTimeoutSlider.setShowTickLabels(true);
        gameTimeoutSlider.setShowTickMarks(true);
        gameTimeoutSlider.setSnapToTicks(true); //rounds number after drag
        gameTimeoutSlider.setValue(timeout); //sets the value of the slider to the number of timeout var  
        gameTimeoutSlider.valueProperty().addListener(new ChangeListener<Number>() {

            //Change listener property on slider value change
           @Override
           public void changed(ObservableValue<? extends Number> observable,
                 Number oldValue, Number newValue) {

               //Display label with the changed number of timeout
              gameTimeoutLabel.setText("Timeout (in seconds): " + newValue + " seconds");
              timeout = (double) newValue; //Convert from Number to Double using type casting and store in global var timeout
           }

        });

        gameTimeoutLabel.setLayoutX(301.0);
        gameTimeoutLabel.setLayoutY(87.0);
        gameTimeoutLabel.setText("Timeout (in seconds): " + gameTimeoutSlider.getValue() + " seconds"); //Display label with the default number of timeout

        exitBtn.setLayoutX(478.0);
        exitBtn.setLayoutY(122.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setPrefHeight(38.0);
        exitBtn.setPrefWidth(140.0);
        exitBtn.setText("Exit Settings");
        exitBtn.setFont(new Font(15.0));
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                settingsStage.close(); //when exit settings is clicked, we close this stage                
            }
        });
        
        previewBtn.setLayoutX(308.0);
        previewBtn.setLayoutY(122.0);
        previewBtn.setMnemonicParsing(false);
        previewBtn.setPrefHeight(38.0);
        previewBtn.setPrefWidth(140.0);
        previewBtn.setText("Preview colours");
        previewBtn.setFont(new Font(15.0));
        previewBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                
                //ask to test which finchColour or on virtual finches
                //these options are presented to user
                List<String> colourOptions = new ArrayList<>();
                colourOptions.add("Finch1 Colour on a finch");
                colourOptions.add("Finch2 Colour on a finch");
                colourOptions.add("Finch3 Colour on a finch");
                colourOptions.add("Finch4 Colour on a finch");
                colourOptions.add("All Finch Colours on 5 finches");
                colourOptions.add("Try on virtual Finch");

                //create a new choice dialog with the default option of "Finch1 Colour on a finch" 
                //and present the list of options from the arraylist colourOptions
                ChoiceDialog<String> finchColourDialog = new ChoiceDialog<>(colourOptions.get(0), colourOptions);
                //dialog content to explain what user can choose
                finchColourDialog.setTitle("Preview Colours");
                finchColourDialog.setHeaderText("How will you want to preview?");
                finchColourDialog.setContentText("Choose if you want to preview on a real finch or on the virtual one.");
                
                //store dialog call in variable so we can get result..
                Optional<String> colourDialogResult = finchColourDialog.showAndWait();
                //if option chosen from any of the following then:
                if (colourDialogResult.isPresent()){
                    System.out.println("User wants to see: " + colourDialogResult.get() + ".");
                    // disable colour picker and preview button during preview
                    finch1ColorPicker.setDisable(true);
                    finch2ColorPicker.setDisable(true);
                    finch3ColorPicker.setDisable(true);
                    finch4ColorPicker.setDisable(true);
                    previewBtn.setDisable(true);
                    //Option: Finch1 Colour on a finch
                    if(colourDialogResult.get().equals(colourOptions.get(0))){
                            //instantiate new finch object and display colour as java awt from javafx
                            Finch myFinch = new Finch();
                            myFinch.setLED(getFinch1ColourAsAWT());
                            
                            //Stop light after 3 seconds
                            PauseTransition previewFinchDelay = new PauseTransition(Duration.seconds(3));
                            previewFinchDelay.setOnFinished(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent event) {
                                    myFinch.quit(); //close finch object
                                    //enable activity for buttons and colour picker
                                    finch1ColorPicker.setDisable(false);
                                    finch2ColorPicker.setDisable(false);
                                    finch3ColorPicker.setDisable(false);
                                    finch4ColorPicker.setDisable(false);
                                    previewBtn.setDisable(false);
                                }
                            });
                            previewFinchDelay.play();
                    }
                    //Option: Finch2 Colour on a finch
                    else if(colourDialogResult.get().equals(colourOptions.get(1))){
                            //instantiate new finch object and display colour as java awt from javafx
                            Finch myFinch = new Finch();
                            myFinch.setLED(getFinch2ColourAsAWT());
                            
                            //Stop light after 3 seconds
                            PauseTransition previewFinchDelay = new PauseTransition(Duration.seconds(3));
                            previewFinchDelay.setOnFinished(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent event) {
                                    myFinch.quit(); //close finch object
                                    //enable activity for buttons and colour picker
                                    finch1ColorPicker.setDisable(false);
                                    finch2ColorPicker.setDisable(false);
                                    finch3ColorPicker.setDisable(false);
                                    finch4ColorPicker.setDisable(false);
                                    previewBtn.setDisable(false);
                                }
                            });
                            previewFinchDelay.play();
                    }
                    //Option: Finch3 Colour on a finch
                    else if(colourDialogResult.get().equals(colourOptions.get(2))){
                            //instantiate new finch object and display colour as java awt from javafx
                            Finch myFinch = new Finch();
                            myFinch.setLED(getFinch3ColourAsAWT());
                            
                            //Stop light after 3 seconds
                            PauseTransition previewFinchDelay = new PauseTransition(Duration.seconds(3));
                            previewFinchDelay.setOnFinished(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent event) {
                                    myFinch.quit(); //close finch object
                                    //enable activity for buttons and colour picker
                                    finch1ColorPicker.setDisable(false);
                                    finch2ColorPicker.setDisable(false);
                                    finch3ColorPicker.setDisable(false);
                                    finch4ColorPicker.setDisable(false);
                                    previewBtn.setDisable(false);
                                }
                            });
                            previewFinchDelay.play();
                    }
                    //Option: Finch4 Colour on a finch
                    else if(colourDialogResult.get().equals(colourOptions.get(3))){
                            //instantiate new finch object and display colour as java awt from javafx
                            Finch myFinch = new Finch();
                            myFinch.setLED(getFinch4ColourAsAWT());
                            
                            //Stop light after 3 seconds
                            PauseTransition previewFinchDelay = new PauseTransition(Duration.seconds(3));
                            previewFinchDelay.setOnFinished(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent event) {
                                    myFinch.quit(); //close finch object
                                    //enable activity for buttons and colour picker
                                    finch1ColorPicker.setDisable(false);
                                    finch2ColorPicker.setDisable(false);
                                    finch3ColorPicker.setDisable(false);
                                    finch4ColorPicker.setDisable(false);
                                    previewBtn.setDisable(false);
                                }
                            });
                            previewFinchDelay.play();
                    }
                    //Option: All finch colours on all finches
                    else if(colourDialogResult.get().equals(colourOptions.get(4))){
                            //instantiate new finch objects and display colours as java awt from javafx
                            Finch myFinch1 = new Finch();
                            Finch myFinch2 = new Finch();
                            Finch myFinch3 = new Finch();
                            Finch myFinch4 = new Finch();
                            
                            myFinch1.setLED(getFinch1ColourAsAWT());
                            myFinch2.setLED(getFinch1ColourAsAWT());
                            myFinch3.setLED(getFinch1ColourAsAWT());
                            myFinch4.setLED(getFinch1ColourAsAWT());
                            
                            //Stop light after 3 seconds
                            PauseTransition previewFinchDelay = new PauseTransition(Duration.seconds(3));
                            previewFinchDelay.setOnFinished(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent event) {
                                    //close finch objects
                                    myFinch1.quit();
                                    myFinch2.quit();
                                    myFinch3.quit();
                                    myFinch4.quit();
                                    //enable activity for buttons and colour picker
                                    finch1ColorPicker.setDisable(false);
                                    finch2ColorPicker.setDisable(false);
                                    finch3ColorPicker.setDisable(false);
                                    finch4ColorPicker.setDisable(false);
                                    previewBtn.setDisable(false);
                                }
                            });
                            previewFinchDelay.play();  

                    }
                    //Option: all finch colours on virtual finches
                    else if(colourDialogResult.get().equals(colourOptions.get(5))){
                            // open virtual finch main menu (Stage)
                            Stage newWindow = new Stage();
                            VirtualFinchGUI virtualFinchGuiClass = new VirtualFinchGUI();
                            //Set virtual finches to visible if hidden from previous use
                            virtualFinchGuiClass.finch1Visible = true;
                            virtualFinchGuiClass.finch2Visible = true;
                            virtualFinchGuiClass.finch3Visible = true;
                            virtualFinchGuiClass.finch4Visible = true;
                            //start the stage with the virtual finch scene
                            virtualFinchGuiClass.start(newWindow);
                            //display the gui
                            newWindow.show();
                            
                            //Hide window after 4 seconds
                            PauseTransition previewFinchDelay = new PauseTransition(Duration.seconds(4));
                            previewFinchDelay.setOnFinished(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent event) {
                                    //close virtual finch stage
                                    newWindow.close();
                                    //enable activity for buttons and colour picker
                                    finch1ColorPicker.setDisable(false);
                                    finch2ColorPicker.setDisable(false);
                                    finch3ColorPicker.setDisable(false);
                                    finch4ColorPicker.setDisable(false);
                                    previewBtn.setDisable(false);
                                }
                            });
                            previewFinchDelay.play();
                    }
                    else{
                        //do nothing - nothing selected.
                        
                        //reset button states incase this case ever does happen.
                        finch1ColorPicker.setDisable(false);
                        finch2ColorPicker.setDisable(false);
                        finch3ColorPicker.setDisable(false);
                        finch4ColorPicker.setDisable(false);
                        previewBtn.setDisable(false);
                    }
                    
                }else{
                    //do nothing - user has cancelled dialog.
                }
                
            }
        });

        timeoutEasyLabel.setLayoutX(447.0);
        timeoutEasyLabel.setLayoutY(43.0);
        timeoutEasyLabel.setText("Easier");

        timeoutHarderLabel.setLayoutX(265.0);
        timeoutHarderLabel.setLayoutY(43.0);
        timeoutHarderLabel.setText("Harder");

        anchorPane.getChildren().add(finchColoursTitleLabel);
        anchorPane.getChildren().add(finch1ColourLabel);
        anchorPane.getChildren().add(finch1ColorPicker);
        anchorPane.getChildren().add(finch2ColourLabel);
        anchorPane.getChildren().add(finch2ColorPicker);
        anchorPane.getChildren().add(finch3ColourLabel);
        anchorPane.getChildren().add(finch3ColorPicker);
        anchorPane.getChildren().add(finch4ColourLabel);
        anchorPane.getChildren().add(finch4ColorPicker);
        anchorPane.getChildren().add(gameDifficultyTitleLabel);
        anchorPane.getChildren().add(gameTimeoutSlider);
        anchorPane.getChildren().add(gameTimeoutLabel);
        anchorPane.getChildren().add(exitBtn);
        anchorPane.getChildren().add(previewBtn);
        anchorPane.getChildren().add(timeoutEasyLabel);
        anchorPane.getChildren().add(timeoutHarderLabel);
        vboxWindow.getChildren().add(anchorPane);
        
        
        Scene scene = new Scene(vboxWindow); 
        
        settingsStage.setTitle("Game Settings");
        settingsStage.setScene(scene);
        settingsStage.setResizable(false);
        settingsStage.getIcons().add(new Image(getClass().getResource("stagesettingsicon.png").toExternalForm()));
        settingsStage.show();
    }
    
    //Getters and JavaFX colour to AWT color
    public static Color getFinch1Colour() {
        return finch1Colour;
    }
    
    //Converts javafx color to awt using the awt class with the rgb and opacity options from fx color
    public static java.awt.Color getFinch1ColourAsAWT() {
        java.awt.Color finchColour = new java.awt.Color((float) SettingsGUI.finch1Colour.getRed(),
                                                        (float) SettingsGUI.finch1Colour.getGreen(),
                                                        (float) SettingsGUI.finch1Colour.getBlue(),
                                                        (float) SettingsGUI.finch1Colour.getOpacity());
        return finchColour;
    }
    
    public static Color getFinch2Colour() {
        return finch2Colour;
    }
    
    //Converts javafx color to awt using the awt class with the rgb and opacity options from fx color
    public static java.awt.Color getFinch2ColourAsAWT() {
        java.awt.Color finchColour = new java.awt.Color((float) SettingsGUI.finch2Colour.getRed(),
                                                        (float) SettingsGUI.finch2Colour.getGreen(),
                                                        (float) SettingsGUI.finch2Colour.getBlue(),
                                                        (float) SettingsGUI.finch2Colour.getOpacity());
        return finchColour;
    }
    
    public static Color getFinch3Colour() {
        return finch3Colour;
    }

    //Converts javafx color to awt using the awt class with the rgb and opacity options from fx color
    public static java.awt.Color getFinch3ColourAsAWT() {
        java.awt.Color finchColour = new java.awt.Color((float) SettingsGUI.finch3Colour.getRed(),
                                                        (float) SettingsGUI.finch3Colour.getGreen(),
                                                        (float) SettingsGUI.finch3Colour.getBlue(),
                                                        (float) SettingsGUI.finch3Colour.getOpacity());
        return finchColour;
    }
    
    public static Color getFinch4Colour() {
        return finch4Colour;
    }

    //Converts javafx color to awt using the awt class with the rgb and opacity options from fx color
    public static java.awt.Color getFinch4ColourAsAWT() {
        java.awt.Color finchColour = new java.awt.Color((float) SettingsGUI.finch4Colour.getRed(),
                                                        (float) SettingsGUI.finch4Colour.getGreen(),
                                                        (float) SettingsGUI.finch4Colour.getBlue(),
                                                        (float) SettingsGUI.finch4Colour.getOpacity());
        return finchColour;
    }
    
    public static double getTimeout() {
        return timeout;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
