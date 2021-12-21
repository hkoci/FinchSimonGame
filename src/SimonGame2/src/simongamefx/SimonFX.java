/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simongamefx;

//Data Structures Required Modules
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//JavaFX Required Modules
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//Ethan's multiplayer imports
import java.net.*;
import java.io.*;
import org.apache.commons.validator.routines.InetAddressValidator; //to validate IP address
/**
 *
 * @author Henri
 */
public class SimonFX extends Application {
    
    //Global variables
    private static boolean multiplayer; //To show if multiplayer state is on
    private static int connectedFinches = 5; //Shows the number of finches connected
    private static boolean isHost; //To show if the multiplayer game is the host
    private static String serverIP; //Server IP to connect to
    private static String preferredMPname; //Multiplayer name to display in table of game class
    
    
    //Start method is the first Stage JavaFX will try to open on SimonFX class launch.
    @Override
    public void start(Stage primaryStage) {
        //Auto-generated code from FXML
        //Netbeans FXML 2 JAVA Converter created the positioning and sizing as an abstract class
        //This has then been edited from the abstract class to this so that it can be run on start
        //It contains the sizing and positioning of the graphical elements which will be inserted onto the stage
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu();
        MenuItem menuItem = new MenuItem();
        AnchorPane anchorPane = new AnchorPane();
        ImageView simonGameMenuImage = new ImageView();
        Button singleplayerBtn = new Button();
        Button multiplayerBtn = new Button();
        Button settingsBtn = new Button();
        Button statsBtn = new Button();
        Label finchToggleInfo = new Label();
        VBox vboxWindow = new VBox();

        vboxWindow.setPrefHeight(441.0);
        vboxWindow.setPrefWidth(640.0);

        VBox.setVgrow(menuBar, javafx.scene.layout.Priority.NEVER);

        menu.setMnemonicParsing(false);
        menu.setText("Help");

        menuItem.setMnemonicParsing(false);
        menuItem.setText("About Simon Game for Finch");
        //JavaFX is event driven, so when this is clicked, we will display the alert with the team names
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                //Display new alert with the team names and program version
                Alert teamInfoAlert = new Alert(AlertType.INFORMATION);
                teamInfoAlert.setTitle("About Simon Game");
                teamInfoAlert.setHeaderText("Simon Game v2.0");
                teamInfoAlert.setContentText("Created by Green Group 46." + '\n' + 
                        "Group Leader: Yousaf Kouhdamani - 1919170" + '\n' + '\n' +
                        "Programming Team:" + '\n' + "Henri Koci - 1808346" + '\n' + "Ethan Ludlam - 1915222" + '\n' + '\n' +
                        "Implementation Planning Team:" + '\n' +  "Arjon Kucaj  - 1906217" + '\n' + "Khalil Magbok - 1921932" + '\n' + '\n' +
                        "Documentation/Risk Management Team:" + '\n' + "Yousaf Kouhdamani - 1919170" + '\n' + "Usama Akbar - 1918711" + '\n' + "Terence Liu - 1908563"
                );

                //show the alert
                teamInfoAlert.show();
            }
        });

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setMaxWidth(-1.0);

        simonGameMenuImage.setFitHeight(273.0);
        simonGameMenuImage.setFitWidth(553.0);
        simonGameMenuImage.setLayoutX(46.0);
        simonGameMenuImage.setLayoutY(-12.0);
        simonGameMenuImage.setPickOnBounds(true);
        simonGameMenuImage.setPreserveRatio(true);
        simonGameMenuImage.setImage(new Image(getClass().getResource("simonlogo.png").toExternalForm()));

        singleplayerBtn.setLayoutX(267.0);
        singleplayerBtn.setLayoutY(267.0);
        singleplayerBtn.setMnemonicParsing(false);
        singleplayerBtn.setText("Play Singleplayer");
        singleplayerBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                //Singleplayer mode, disable multiplayer by making variable false
                multiplayer = false;
                
                //ask how many finches are connected.
                List<Integer> finchNumDialogOpts = new ArrayList<>();
                //Add the numbers 0 to 5 to this arraylist for the number of finches connected
                finchNumDialogOpts.add(0);
                finchNumDialogOpts.add(1);
                finchNumDialogOpts.add(2);
                finchNumDialogOpts.add(3);
                finchNumDialogOpts.add(4);
                finchNumDialogOpts.add(5);
                
                //Create a new choice dialog with the default value 5, using the arraylist with options provided.
                ChoiceDialog<Integer> deviceCountDialog = new ChoiceDialog<>(5, finchNumDialogOpts);
                
                //Set title and content of dialog to ask the user how many finches are connected
                deviceCountDialog.setTitle("Finch Device Count");
                deviceCountDialog.setHeaderText("How many finches will be connected?");
                deviceCountDialog.setContentText("Choose the number of finch robots which are connected to the PC now:");

                //Set the dialog to show and wait, store this in the dialogResult - to enable the retrieval of the choice the user has input
                Optional<Integer> dialogResult = deviceCountDialog.showAndWait();
                //if user has choose the number of finches...
                if (dialogResult.isPresent()){
                    //Then print out the number of finches connected
                    System.out.println("User has stated that: " + dialogResult.get() + " finch robots are connected.");
                    
                    //Set the variable connectedFinches with the number of finches connected
                    connectedFinches = dialogResult.get();
                    
                    //If less than 5 finches are connected, warn them about using the virtual finches
                    if(connectedFinches < 5){
                        //Display new warning alert
                        Alert alert = new Alert(AlertType.WARNING);
                        //Set content to explain to user that the virtual finches will work for the ones not present.
                        alert.setTitle("Warning!");
                        alert.setHeaderText("Less than 5 required finches are connected");
                        alert.setContentText("Only " + connectedFinches + " finch robots will have their leds working, for the others you will be using the virtual finch!");
                        //Show this alert
                        alert.showAndWait();
                    }
                    
                    //Open the class with the relevant Finch objects instantiated.
                    if(connectedFinches == 0){
                        // New window (Stage)
                        Stage newWindow = new Stage();
                        GamePlayVFinchGUI gamePlayClass = new GamePlayVFinchGUI();
                        gamePlayClass.start(newWindow);

                        //show the gameplay class
                        newWindow.show();
                        //close this menu stage
                        primaryStage.close();
                    }else if(connectedFinches == 1){
                        // New window (Stage)
                        Stage newWindow = new Stage();
                        GamePlayPhysicalFinch1 gamePlayClass = new GamePlayPhysicalFinch1();
                        gamePlayClass.start(newWindow);

                        //show the gameplay class
                        newWindow.show();
                        //close this menu stage
                        primaryStage.close();
                    }else if(connectedFinches == 2){
                        // New window (Stage)
                        Stage newWindow = new Stage();
                        GamePlayPhysicalFinch2 gamePlayClass = new GamePlayPhysicalFinch2();
                        gamePlayClass.start(newWindow);

                        //show the gameplay class
                        newWindow.show();
                        //close this menu stage
                        primaryStage.close();
                    }else if(connectedFinches == 3){
                        // New window (Stage)
                        Stage newWindow = new Stage();
                        GamePlayPhysicalFinch3 gamePlayClass = new GamePlayPhysicalFinch3();
                        gamePlayClass.start(newWindow);

                        //show the gameplay class
                        newWindow.show();
                        //close this menu stage
                        primaryStage.close();
                    }else if(connectedFinches == 4){
                        // New window (Stage)
                        Stage newWindow = new Stage();
                        GamePlayPhysicalFinch4 gamePlayClass = new GamePlayPhysicalFinch4();
                        gamePlayClass.start(newWindow);

                        //show the gameplay class
                        newWindow.show();
                        //close this menu stage
                        primaryStage.close();
                    }else if(connectedFinches == 5){
                        // New window (Stage)
                        Stage newWindow = new Stage();
                        GamePlayPhysicalFinch5 gamePlayClass = new GamePlayPhysicalFinch5();
                        gamePlayClass.start(newWindow);

                        //show the gameplay class
                        newWindow.show();
                        //close this menu stage
                        primaryStage.close();
                    }

                }else{
                    //do nothing - user has cancelled dialog.
                }

                
            }
        });

        multiplayerBtn.setLayoutX(267.0);
        multiplayerBtn.setLayoutY(299.0);
        multiplayerBtn.setMnemonicParsing(false);
        multiplayerBtn.setPrefHeight(25.0);
        multiplayerBtn.setPrefWidth(106.0);
        multiplayerBtn.setText("Play Multiplayer");
        multiplayerBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                multiplayer = true;
                
                //Create a new choice dialog with the default value of host, using either host/client options available
                ChoiceDialog<String> serverOptsDialog = new ChoiceDialog<>("Host Server", "Host Server", "Connect to Client on LAN");
                serverOptsDialog.setTitle("Simon Game - Multiplayer Options");
                serverOptsDialog.setHeaderText("Server Configuration");
                serverOptsDialog.setContentText("Choose your mode:");

                //Set the dialog to show and wait, store this in the dialogResult - to enable the retrieval of the choice the user has input
                Optional<String> serverDialogResults = serverOptsDialog.showAndWait();
                if (serverDialogResults.isPresent()){
                    System.out.println("User is to: " + serverDialogResults.get());
                    
                    //Flag for ip address being valid format
                    boolean isValid = false;
                    
                    //Check if the user is hosting or not
                    if(serverDialogResults.get() == "Connect to Client on LAN"){
                        //Disable host flag
                        isHost = false;
                        
                        //ask them for the IP address of the server
                        TextInputDialog ipDialog = new TextInputDialog("");
                        ipDialog.setTitle("Simon Game - IP Address");
                        ipDialog.setHeaderText("Internal IP Address");
                        ipDialog.setContentText("Type the IP you wish to connect to:");

                        //Set the dialog to show and wait, store this in the dialogResult - to enable the retrieval of the choice the user has input
                        Optional<String> ipResultDialog = ipDialog.showAndWait();
                        
                        //If a result is enetered for the IP address text field, we should check if it is a valid IP format
                        if(ipResultDialog.isPresent()){
                            //store the result of the IP address in serverIP variable
                            serverIP = ipResultDialog.get();
                            
                            //Instantiate new InetAddressValidator class to validate if IP address is in correct format.
                            InetAddressValidator ipAddressValid = new InetAddressValidator();
                            
                            //Validate the entered ip address
                            if(ipAddressValid.isValid(serverIP)){
                                isValid = true; //true if valid
                            }else{
                                //else, incorrect format, show error dialog
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Simon Game - Invalid IP Address");
                                alert.setHeaderText("Invalid IP Address");
                                alert.setContentText("There was an error with your IP address.");

                                alert.showAndWait();
                            }
                        }
                    }
                    else if(serverDialogResults.get() == "Host Server"){
                        isHost = true; //is host so set this flag
                        isValid = true; //no need to validate IP format, as no IP is entered.
                    }
                    
                    //If the connected IP format is correct or host has been chosen
                    if(isValid){
                        //ask them for a username
                        TextInputDialog nameDialog = new TextInputDialog("");
                        nameDialog.setTitle("Simon Game - Multiplayer Name");
                        nameDialog.setHeaderText("Multiplayer username");
                        nameDialog.setContentText("Choose your multiplayer name:");

                        //Set the dialog to show and wait, store this in the dialogResult - to enable the retrieval of the choice the user has input
                        Optional<String> nameResultDialog = nameDialog.showAndWait();
                        if (nameResultDialog.isPresent()){
                            System.out.println("Your name: " + nameResultDialog.get());
                            //ask how many finches are connected.
                            List<Integer> finchNumDialogOpts = new ArrayList<>();
                            //Add the numbers 0 to 5 to this arraylist for the number of finches connected
                            finchNumDialogOpts.add(0);
                            finchNumDialogOpts.add(1);
                            finchNumDialogOpts.add(2);
                            finchNumDialogOpts.add(3);
                            finchNumDialogOpts.add(4);
                            finchNumDialogOpts.add(5);

                            //Create a new choice dialog with the default value 5, using the arraylist with options provided.
                            ChoiceDialog<Integer> deviceCountDialog = new ChoiceDialog<>(5, finchNumDialogOpts);

                            //Set title and content of dialog to ask the user how many finches are connected
                            deviceCountDialog.setTitle("Finch Device Count");
                            deviceCountDialog.setHeaderText("How many finches will be connected?");
                            deviceCountDialog.setContentText("Choose the number of finch robots which are connected to the PC now:");

                            //Set the dialog to show and wait, store this in the dialogResult - to enable the retrieval of the choice the user has input
                            Optional<Integer> dialogResult = deviceCountDialog.showAndWait();
                            //if user has choose the number of finches...
                            if (dialogResult.isPresent()){
                                //Then print out the number of finches connected
                                System.out.println("User has stated that: " + dialogResult.get() + " finch robots are connected.");

                                //Set the variable connectedFinches with the number of finches connected
                                connectedFinches = dialogResult.get();

                                //If less than 5 finches are connected, warn them about using the virtual finches
                                if(connectedFinches < 5){
                                    //Display new warning alert
                                    Alert alert = new Alert(AlertType.WARNING);
                                    //Set content to explain to user that the virtual finches will work for the ones not present.
                                    alert.setTitle("Warning!");
                                    alert.setHeaderText("Less than 5 required finches are connected");
                                    alert.setContentText("Only " + connectedFinches + " finch robots will have their leds working, for the others you will be using the virtual finch!");
                                    //Show this alert
                                    alert.showAndWait();
                                }

                                //Open the class with the relevant Finch objects instantiated.
                                if(connectedFinches == 0){
                                    // New window (Stage)
                                    Stage newWindow = new Stage();
                                    GamePlayVFinchGUI gamePlayClass = new GamePlayVFinchGUI();
                                    gamePlayClass.start(newWindow);

                                    //show the gameplay class
                                    newWindow.show();
                                    //close this menu stage
                                    primaryStage.close();
                                }else if(connectedFinches == 1){
                                    // New window (Stage)
                                    Stage newWindow = new Stage();
                                    GamePlayPhysicalFinch1 gamePlayClass = new GamePlayPhysicalFinch1();
                                    gamePlayClass.start(newWindow);

                                    //show the gameplay class
                                    newWindow.show();
                                    //close this menu stage
                                    primaryStage.close();
                                }else if(connectedFinches == 2){
                                    // New window (Stage)
                                    Stage newWindow = new Stage();
                                    GamePlayPhysicalFinch2 gamePlayClass = new GamePlayPhysicalFinch2();
                                    gamePlayClass.start(newWindow);

                                    //show the gameplay class
                                    newWindow.show();
                                    //close this menu stage
                                    primaryStage.close();
                                }else if(connectedFinches == 3){
                                    // New window (Stage)
                                    Stage newWindow = new Stage();
                                    GamePlayPhysicalFinch3 gamePlayClass = new GamePlayPhysicalFinch3();
                                    gamePlayClass.start(newWindow);

                                    //show the gameplay class
                                    newWindow.show();
                                    //close this menu stage
                                    primaryStage.close();
                                }else if(connectedFinches == 4){
                                    // New window (Stage)
                                    Stage newWindow = new Stage();
                                    GamePlayPhysicalFinch4 gamePlayClass = new GamePlayPhysicalFinch4();
                                    gamePlayClass.start(newWindow);

                                    //show the gameplay class
                                    newWindow.show();
                                    //close this menu stage
                                    primaryStage.close();
                                }else if(connectedFinches == 5){
                                    // New window (Stage)
                                    Stage newWindow = new Stage();
                                    GamePlayPhysicalFinch5 gamePlayClass = new GamePlayPhysicalFinch5();
                                    gamePlayClass.start(newWindow);

                                    //show the gameplay class
                                    newWindow.show();
                                    //close this menu stage
                                    primaryStage.close();
                                }

                            }else{
                                //do nothing - user has cancelled dialog.
                            }
                        }
                    }

                }
                
            }
        });

        settingsBtn.setLayoutX(267.0);
        settingsBtn.setLayoutY(330.0);
        settingsBtn.setMnemonicParsing(false);
        settingsBtn.setPrefHeight(25.0);
        settingsBtn.setPrefWidth(106.0);
        settingsBtn.setText("Game Settings");
        settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                // New window (Stage)
                Stage newWindow = new Stage();
                
                //Instantiate the settings gui class
                SettingsGUI SettingsGUIClass = new SettingsGUI();
                
                //Run the start method which will initialise all graphical elements with the newly called stage
                SettingsGUIClass.start(newWindow);
 
                //Display this stage window on screen
                newWindow.show(); 
            }
        });

        statsBtn.setLayoutX(267.0);
        statsBtn.setLayoutY(360.0);
        statsBtn.setMnemonicParsing(false);
        statsBtn.setPrefHeight(25.0);
        statsBtn.setPrefWidth(106.0);
        statsBtn.setText("Statistics");
        statsBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                // New window (Stage)
                Stage newWindow = new Stage();
                
                //Instantiate the settings gui class
                StatsGUI StatsGUIClass = new StatsGUI();
                
                //Run the start method which will initialise all graphical elements with the newly called stage
                StatsGUIClass.start(newWindow);
                
                //Display this stage window on screen
                newWindow.show();
            }
        });

        finchToggleInfo.setLayoutX(88.0);
        finchToggleInfo.setLayoutY(390.0);
        finchToggleInfo.setText("To quit the game, turn the Finch without a light for its beak to be facing up");
        finchToggleInfo.setFont(new Font("System Italic", 15.0));

        menu.getItems().add(menuItem);
        menuBar.getMenus().add(menu);
        vboxWindow.getChildren().add(menuBar);
        anchorPane.getChildren().add(simonGameMenuImage);
        anchorPane.getChildren().add(singleplayerBtn);
        anchorPane.getChildren().add(multiplayerBtn);
        anchorPane.getChildren().add(settingsBtn);
        anchorPane.getChildren().add(statsBtn);
        anchorPane.getChildren().add(finchToggleInfo);
        vboxWindow.getChildren().add(anchorPane);
        
        // New window (Stage) set to the vBox which is where all graphical elements are drawn on
        Scene scene = new Scene(vboxWindow); 
        
        //Set title,scene,resizability and icon
        primaryStage.setTitle("Simon Game 2.0");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResource("stageicon.png").toExternalForm()));
        
        //Show the menu
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static boolean getMultiplayer() {
        return multiplayer;
    }
    
    public static int getConnectedFinches() {
        return connectedFinches;
    }
    
    public static boolean getHost() {
        return isHost;
    }
    
    public static String getMPName() {
        return preferredMPname;
    }
    
}