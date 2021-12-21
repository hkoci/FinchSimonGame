/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simongamefx;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Henri
 */
public class VirtualFinchGUI extends Application {
    
    //Variables which change based on the virtual finch properties
    //E.g. tapped variable turns to true on tap
    //Visibility applies on class launch this is acting as an constructor for now
    public boolean finch1Tapped = false;
    public boolean finch1Visible = false;
    public boolean finch2Tapped = false;
    public boolean finch2Visible = false;
    public boolean finch3Tapped = false;
    public boolean finch3Visible = false;
    public boolean finch4Tapped = false;
    public boolean finch4Visible = false;
    public boolean finchToggleTapped = false;
    
    //This class is deprecated - it is only used for previewing the finch colours and not the actual game now
    //The virtual finch is now incorporated within the gameplay gui!
    
    @Override
    public void start(Stage vFinchStage) {
        //Auto-generated code from FXML
        //Netbeans FXML 2 JAVA Converter created the positioning and sizing as an abstract class
        //This has then been edited from the abstract class to this so that it can be run on start
        //The virtual finches do have event triggers for setting their tapped flags - which has been added.
        AnchorPane anchorPane = new AnchorPane();
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
        VBox vboxWindow = new VBox();


        vboxWindow.setPrefHeight(161.0);
        vboxWindow.setPrefWidth(573.0);

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setMaxWidth(-1.0);

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
        //data binding to visibility variable (not working currently)
        SimpleBooleanProperty finch1VisibilityAsBoolProp = new SimpleBooleanProperty(finch1Visible);
        vFinch1Circle.visibleProperty().bind(finch1VisibilityAsBoolProp);
        
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
        //data binding to visibility variable (not working currently)
        SimpleBooleanProperty finch2VisibilityAsBoolProp = new SimpleBooleanProperty(finch2Visible);
        vFinch2Circle.visibleProperty().bind(finch2VisibilityAsBoolProp);

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
        //data binding to visibility variable (not working currently)
        SimpleBooleanProperty finch3VisibilityAsBoolProp = new SimpleBooleanProperty(finch3Visible);
        vFinch3Circle.visibleProperty().bind(finch3VisibilityAsBoolProp);

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
        //data binding to visibility variable (not working currently)
        SimpleBooleanProperty finch4VisibilityAsBoolProp = new SimpleBooleanProperty(finch4Visible);
        vFinch4Circle.visibleProperty().bind(finch4VisibilityAsBoolProp);

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

        finch1Group.getChildren().add(vFinch1Img);
        finch1Group.getChildren().add(vFinch1Circle);
        finch1Group.getChildren().add(vFinch1Label);
        finch1Group.setOnMouseClicked(e -> { finch1Tapped = true;} ); //set tapped variable to true on click
        
        vFinchHorizontalContainer.getChildren().add(finch1Group);
        
        finch2Group.getChildren().add(vFinch2Img);
        finch2Group.getChildren().add(vFinch2Circle);
        finch2Group.getChildren().add(vFinch2Label);
        finch2Group.setOnMouseClicked(e -> { finch2Tapped = true;} );//set tapped variable to true on click
        
        vFinchHorizontalContainer.getChildren().add(finch2Group);
        
        finch3Group.getChildren().add(vFinch3Img);
        finch3Group.getChildren().add(vFinch3Circle);
        finch3Group.getChildren().add(vFinch3Label);
        finch3Group.setOnMouseClicked(e -> { finch3Tapped = true;} );//set tapped variable to true on click
        
        vFinchHorizontalContainer.getChildren().add(finch3Group);
        
        finch4Group.getChildren().add(vFinch4Img);
        finch4Group.getChildren().add(vFinch4Circle);
        finch4Group.getChildren().add(vFinch4Label);
        finch4Group.setOnMouseClicked(e -> { finch4Tapped = true;} );//set tapped variable to true on click
        
        vFinchHorizontalContainer.getChildren().add(finch4Group);
        
        finchToggleGroup.getChildren().add(vFinchToggleImg);
        finchToggleGroup.getChildren().add(vFinchToggleCircle);
        finchToggleGroup.getChildren().add(vFinchToggleLabel);
        finch4Group.setOnMouseClicked(e -> { finchToggleTapped = true;} );//set tapped variable to true on click
        
        vFinchHorizontalContainer.getChildren().add(finchToggleGroup);
        
        anchorPane.getChildren().add(vFinchHorizontalContainer);
        anchorPane.getChildren().add(vFinchTitle);
        vboxWindow.getChildren().add(anchorPane);
        
        Scene scene = new Scene(vboxWindow); 
        
        vFinchStage.setTitle("Virtual Finch");
        vFinchStage.setScene(scene);
        vFinchStage.setResizable(false);
        vFinchStage.getIcons().add(new Image(getClass().getResource("stageicon.png").toExternalForm()));
        vFinchStage.show();
        
        //Get device screen boundaries and set the Y positioning to just below the center
        Rectangle2D deviceScreenBoundary = Screen.getPrimary().getVisualBounds();
        vFinchStage.setY(((deviceScreenBoundary.getHeight() - vFinchStage.getHeight()) / 4) + 300);
        
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            launch(args);
        }
    
}
