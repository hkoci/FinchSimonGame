/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simongamefx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Henri
 */
public class StatsGUI extends Application {
    
    @Override
    public void start(Stage statsStage) {
        //Auto-generated code from FXML
        //Netbeans FXML 2 JAVA Converter created the positioning and sizing as an abstract class
        //This has then been edited from the abstract class to this so that it can be run on start
        //It contains the sizing and positioning of the graphical elements which will be inserted onto the stage
        AnchorPane anchorPane = new AnchorPane();
        ToolBar toolBar = new ToolBar();
        Label label = new Label();
        TabPane tabPane = new TabPane();
        Tab tab = new Tab();
        AnchorPane anchorPane0 = new AnchorPane();
        CategoryAxis categoryAxis = new CategoryAxis();
        NumberAxis numberAxis = new NumberAxis();
        LineChart lineChart = new LineChart(categoryAxis, numberAxis);
        TableView tableView = new TableView();
        TableColumn tableColumn = new TableColumn();
        TableColumn tableColumn0 = new TableColumn();
        TableColumn tableColumn1 = new TableColumn();
        Tab tab0 = new Tab();
        AnchorPane anchorPane1 = new AnchorPane();
        TableView tableView0 = new TableView();
        TableColumn tableColumn2 = new TableColumn();
        TableColumn tableColumn3 = new TableColumn();
        TableColumn tableColumn4 = new TableColumn();
        TableColumn tableColumn5 = new TableColumn();
        CategoryAxis categoryAxis0 = new CategoryAxis();
        NumberAxis numberAxis0 = new NumberAxis();
        LineChart lineChart0 = new LineChart(categoryAxis0, numberAxis0);
        TextField textField = new TextField();
        Button button = new Button();
        Button button0 = new Button();
        Tab tab1 = new Tab();
        AnchorPane anchorPane2 = new AnchorPane();
        CategoryAxis categoryAxis1 = new CategoryAxis();
        NumberAxis numberAxis1 = new NumberAxis();
        BarChart barChart = new BarChart(categoryAxis1, numberAxis1);
        Tab tab2 = new Tab();
        AnchorPane anchorPane3 = new AnchorPane();
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        VBox vboxWindow = new VBox();

        vboxWindow.setPrefHeight(400.0);
        vboxWindow.setPrefWidth(712.0);

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setMaxWidth(-1.0);
        anchorPane.setPrefHeight(-1.0);
        anchorPane.setPrefWidth(-1.0);

        toolBar.setLayoutY(381.0);
        toolBar.setPrefHeight(27.0);
        toolBar.setPrefWidth(712.0);

        label.setText("Your username is: testUser");

        tabPane.setPrefHeight(408.0);
        tabPane.setPrefWidth(712.0);
        tabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        tab.setText("Singleplayer Stats");

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(180.0);
        anchorPane0.setPrefWidth(200.0);

        categoryAxis.setLabel("Attempt Number");
        categoryAxis.setSide(javafx.geometry.Side.BOTTOM);

        numberAxis.setLabel("Score");
        numberAxis.setSide(javafx.geometry.Side.LEFT);
        lineChart.setLayoutX(21.0);
        lineChart.setLayoutY(27.0);
        lineChart.setPrefHeight(317.0);
        lineChart.setPrefWidth(394.0);
        lineChart.setTitle("Your Score");

        tableView.setLayoutX(426.0);
        tableView.setLayoutY(27.0);
        tableView.setPrefHeight(323.0);
        tableView.setPrefWidth(268.0);

        tableColumn.setEditable(false);
        tableColumn.setPrefWidth(75.0);
        tableColumn.setText("Attempt");

        tableColumn0.setEditable(false);
        tableColumn0.setPrefWidth(129.0);
        tableColumn0.setText("Date");

        tableColumn1.setEditable(false);
        tableColumn1.setPrefWidth(63.0);
        tableColumn1.setText("Score");
        tab.setContent(anchorPane0);

        tab0.setText("Multiplayer Stats");

        anchorPane1.setMinHeight(0.0);
        anchorPane1.setMinWidth(0.0);
        anchorPane1.setPrefHeight(180.0);
        anchorPane1.setPrefWidth(200.0);

        tableView0.setLayoutX(379.0);
        tableView0.setLayoutY(14.0);
        tableView0.setPrefHeight(362.0);
        tableView0.setPrefWidth(329.0);

        tableColumn2.setPrefWidth(62.0);
        tableColumn2.setText("Session");

        tableColumn3.setPrefWidth(88.0);
        tableColumn3.setText("Date");

        tableColumn4.setPrefWidth(108.0);
        tableColumn4.setText("Name");

        tableColumn5.setPrefWidth(76.0);
        tableColumn5.setText("Score");

        categoryAxis0.setLabel("Multiplayer Session Number");
        categoryAxis0.setSide(javafx.geometry.Side.BOTTOM);

        numberAxis0.setLabel("Score");
        numberAxis0.setSide(javafx.geometry.Side.LEFT);
        lineChart0.setLayoutX(9.0);
        lineChart0.setLayoutY(51.0);
        lineChart0.setPrefHeight(306.0);
        lineChart0.setPrefWidth(365.0);
        lineChart0.setTitle("Your Score");

        textField.setLayoutX(35.0);
        textField.setLayoutY(14.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(149.0);
        textField.setPromptText("Check a username's stats");

        button.setLayoutX(200.0);
        button.setLayoutY(14.0);
        button.setMnemonicParsing(false);
        button.setText("Check");

        button0.setLayoutX(256.0);
        button0.setLayoutY(14.0);
        button0.setMnemonicParsing(false);
        button0.setText("Reset to default");
        tab0.setContent(anchorPane1);

        tab1.setText("Game Stats");

        anchorPane2.setMinHeight(0.0);
        anchorPane2.setMinWidth(0.0);
        anchorPane2.setPrefHeight(180.0);
        anchorPane2.setPrefWidth(200.0);

        categoryAxis1.setLabel("Date");
        categoryAxis1.setSide(javafx.geometry.Side.BOTTOM);

        numberAxis1.setLabel("Times played");
        numberAxis1.setSide(javafx.geometry.Side.LEFT);
        numberAxis1.setTickLength(5.0);
        numberAxis1.setUpperBound(25.0);
        barChart.setLayoutX(18.0);
        barChart.setLayoutY(14.0);
        barChart.setPrefHeight(348.0);
        barChart.setPrefWidth(672.0);
        barChart.setTitle("Number of times Simon has been played via multiplayer");
        tab1.setContent(anchorPane2);

        tab2.setText("Login Details");

        anchorPane3.setMinHeight(0.0);
        anchorPane3.setMinWidth(0.0);
        anchorPane3.setPrefHeight(180.0);
        anchorPane3.setPrefWidth(200.0);

        button1.setLayoutX(14.0);
        button1.setLayoutY(14.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(34.0);
        button1.setPrefWidth(175.0);
        button1.setText("Change login details");

        button2.setLayoutX(14.0);
        button2.setLayoutY(59.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(34.0);
        button2.setPrefWidth(174.0);
        button2.setText("Reset your multiplayer stats");

        button3.setLayoutX(14.0);
        button3.setLayoutY(108.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(34.0);
        button3.setPrefWidth(173.0);
        button3.setText("Reset your singleplayer stats");
        tab2.setContent(anchorPane3);

        toolBar.getItems().add(label);
        anchorPane.getChildren().add(toolBar);
        anchorPane0.getChildren().add(lineChart);
        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(tableColumn0);
        tableView.getColumns().add(tableColumn1);
        anchorPane0.getChildren().add(tableView);
        tabPane.getTabs().add(tab);
        tableView0.getColumns().add(tableColumn2);
        tableView0.getColumns().add(tableColumn3);
        tableView0.getColumns().add(tableColumn4);
        tableView0.getColumns().add(tableColumn5);
        anchorPane1.getChildren().add(tableView0);
        anchorPane1.getChildren().add(lineChart0);
        anchorPane1.getChildren().add(textField);
        anchorPane1.getChildren().add(button);
        anchorPane1.getChildren().add(button0);
        tabPane.getTabs().add(tab0);
        anchorPane2.getChildren().add(barChart);
        tabPane.getTabs().add(tab1);
        anchorPane3.getChildren().add(button1);
        anchorPane3.getChildren().add(button2);
        anchorPane3.getChildren().add(button3);
        tabPane.getTabs().add(tab2);
        anchorPane.getChildren().add(tabPane);
        vboxWindow.getChildren().add(anchorPane);
        
        Scene scene = new Scene(vboxWindow); 
        
        statsStage.setTitle("Simon Statistics");
        statsStage.setScene(scene);
        statsStage.setResizable(false);
        statsStage.getIcons().add(new Image(getClass().getResource("stageicon.png").toExternalForm()));
        statsStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
