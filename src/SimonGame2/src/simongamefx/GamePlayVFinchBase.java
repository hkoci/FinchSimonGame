package simongamefx;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

public abstract class GamePlayVFinchBase extends VBox {

    protected final AnchorPane anchorPane;
    protected final Rectangle rectangle;
    protected final Reflection reflection;
    protected final Label label;
    protected final Label label0;
    protected final Glow glow;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final TableView tableView;
    protected final TableColumn tableColumn;
    protected final TableColumn tableColumn0;
    protected final TableColumn tableColumn1;
    protected final VBox vBox;
    protected final AnchorPane anchorPane0;
    protected final HBox hBox;
    protected final Group group;
    protected final ImageView imageView;
    protected final Circle circle;
    protected final Label label6;
    protected final Group group0;
    protected final ImageView imageView0;
    protected final Circle circle0;
    protected final Label label7;
    protected final Group group1;
    protected final ImageView imageView1;
    protected final Circle circle1;
    protected final Label label8;
    protected final Group group2;
    protected final ImageView imageView2;
    protected final Circle circle2;
    protected final Label label9;
    protected final Group group3;
    protected final ImageView imageView3;
    protected final Circle circle3;
    protected final Label label10;
    protected final Label label11;
    protected final Label label12;

    public GamePlayVFinchBase() {

        anchorPane = new AnchorPane();
        rectangle = new Rectangle();
        reflection = new Reflection();
        label = new Label();
        label0 = new Label();
        glow = new Glow();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        tableView = new TableView();
        tableColumn = new TableColumn();
        tableColumn0 = new TableColumn();
        tableColumn1 = new TableColumn();
        vBox = new VBox();
        anchorPane0 = new AnchorPane();
        hBox = new HBox();
        group = new Group();
        imageView = new ImageView();
        circle = new Circle();
        label6 = new Label();
        group0 = new Group();
        imageView0 = new ImageView();
        circle0 = new Circle();
        label7 = new Label();
        group1 = new Group();
        imageView1 = new ImageView();
        circle1 = new Circle();
        label8 = new Label();
        group2 = new Group();
        imageView2 = new ImageView();
        circle2 = new Circle();
        label9 = new Label();
        group3 = new Group();
        imageView3 = new ImageView();
        circle3 = new Circle();
        label10 = new Label();
        label11 = new Label();
        label12 = new Label();

        setPrefHeight(428.0);
        setPrefWidth(729.0);

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setMaxWidth(-1.0);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(700.0);

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#1f93ff"));
        rectangle.setHeight(150.0);
        rectangle.setLayoutX(258.0);
        rectangle.setLayoutY(14.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(150.0);

        reflection.setFraction(0.32);
        reflection.setTopOpacity(0.44);
        rectangle.setEffect(reflection);

        label.setLayoutX(325.0);
        label.setLayoutY(158.0);
        label.setText("5");
        label.setFont(new Font("System Bold", 29.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(151.0);
        label0.setLayoutY(38.0);
        label0.setPrefHeight(77.0);
        label0.setPrefWidth(339.0);
        label0.setText("Get Ready");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setWrapText(true);
        label0.setFont(new Font(53.0));
        label0.setCursor(Cursor.DEFAULT);

        glow.setLevel(0.53);
        label0.setEffect(glow);

        label1.setLayoutX(14.0);
        label1.setLayoutY(169.0);
        label1.setText("Your score: ");
        label1.setFont(new Font(15.0));

        label2.setLayoutX(92.0);
        label2.setLayoutY(166.0);
        label2.setText("0");
        label2.setFont(new Font(18.0));

        label3.setLayoutX(14.0);
        label3.setLayoutY(14.0);
        label3.setText("Lives:");
        label3.setFont(new Font(15.0));

        label4.setLayoutX(53.0);
        label4.setLayoutY(11.0);
        label4.setText("3");
        label4.setFont(new Font(18.0));

        label5.setLayoutX(491.0);
        label5.setLayoutY(14.0);
        label5.setText("Multiplayer Scores");
        label5.setFont(new Font("System Bold", 15.0));

        tableView.setLayoutX(490.0);
        tableView.setLayoutY(38.0);
        tableView.setPrefHeight(139.0);
        tableView.setPrefWidth(229.0);

        tableColumn.setEditable(false);
        tableColumn.setPrefWidth(123.0);
        tableColumn.setText("Player");

        tableColumn0.setEditable(false);
        tableColumn0.setPrefWidth(69.0);
        tableColumn0.setSortType(javafx.scene.control.TableColumn.SortType.DESCENDING);
        tableColumn0.setText("Score");

        tableColumn1.setEditable(false);
        tableColumn1.setPrefWidth(36.0);
        tableColumn1.setText("Lives");

        vBox.setLayoutX(64.0);
        vBox.setLayoutY(222.0);
        vBox.setPrefHeight(161.0);
        vBox.setPrefWidth(573.0);

        VBox.setVgrow(anchorPane0, javafx.scene.layout.Priority.ALWAYS);
        anchorPane0.setMaxHeight(-1.0);
        anchorPane0.setMaxWidth(-1.0);

        hBox.setLayoutX(9.0);
        hBox.setLayoutY(36.0);
        hBox.setPrefHeight(116.0);
        hBox.setPrefWidth(564.0);

        imageView.setFitHeight(111.0);
        imageView.setFitWidth(111.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../../../../../Desktop/virtualFinchImg-GreyBG.jpg").toExternalForm()));

        circle.setFill(javafx.scene.paint.Color.valueOf("#ff1f1f"));
        circle.setLayoutX(53.0);
        circle.setLayoutY(82.0);
        circle.setRadius(19.0);
        circle.setStroke(javafx.scene.paint.Color.BLACK);
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle.setStrokeWidth(2.0);

        label6.setLayoutX(24.0);
        label6.setLayoutY(-15.0);
        label6.setText("Finch 1");
        label6.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label6.setFont(new Font(20.0));

        imageView0.setFitHeight(111.0);
        imageView0.setFitWidth(111.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../../../../../Desktop/virtualFinchImg-GreyBG.jpg").toExternalForm()));

        circle0.setFill(javafx.scene.paint.Color.valueOf("#1fff49"));
        circle0.setLayoutX(53.0);
        circle0.setLayoutY(82.0);
        circle0.setRadius(19.0);
        circle0.setStroke(javafx.scene.paint.Color.BLACK);
        circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle0.setStrokeWidth(2.0);

        label7.setLayoutX(24.0);
        label7.setLayoutY(-15.0);
        label7.setText("Finch 2");
        label7.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label7.setFont(new Font(20.0));

        imageView1.setFitHeight(111.0);
        imageView1.setFitWidth(111.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("../../../../../Desktop/virtualFinchImg-GreyBG.jpg").toExternalForm()));

        circle1.setFill(javafx.scene.paint.Color.DODGERBLUE);
        circle1.setLayoutX(53.0);
        circle1.setLayoutY(82.0);
        circle1.setRadius(19.0);
        circle1.setStroke(javafx.scene.paint.Color.BLACK);
        circle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle1.setStrokeWidth(2.0);

        label8.setLayoutX(24.0);
        label8.setLayoutY(-15.0);
        label8.setText("Finch 3");
        label8.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label8.setFont(new Font(20.0));

        imageView2.setFitHeight(111.0);
        imageView2.setFitWidth(111.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("../../../../../Desktop/virtualFinchImg-GreyBG.jpg").toExternalForm()));

        circle2.setFill(javafx.scene.paint.Color.valueOf("#fff41f"));
        circle2.setLayoutX(53.0);
        circle2.setLayoutY(82.0);
        circle2.setRadius(19.0);
        circle2.setStroke(javafx.scene.paint.Color.BLACK);
        circle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle2.setStrokeWidth(2.0);

        label9.setLayoutX(24.0);
        label9.setLayoutY(-15.0);
        label9.setText("Finch 4");
        label9.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label9.setFont(new Font(20.0));

        imageView3.setFitHeight(111.0);
        imageView3.setFitWidth(111.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("../../../../../Desktop/virtualFinchImg-GreyBG.jpg").toExternalForm()));

        circle3.setLayoutX(53.0);
        circle3.setLayoutY(82.0);
        circle3.setRadius(19.0);
        circle3.setStroke(javafx.scene.paint.Color.BLACK);
        circle3.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle3.setStrokeWidth(2.0);

        label10.setLayoutX(1.0);
        label10.setLayoutY(-15.0);
        label10.setText("FinchToggle");
        label10.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label10.setFont(new Font(20.0));
        hBox.setCursor(Cursor.HAND);

        label11.setLayoutX(9.0);
        label11.setLayoutY(6.0);
        label11.setText("Virtual Finches");
        label11.setFont(new Font("System Bold", 20.0));

        label12.setLayoutX(2.0);
        label12.setLayoutY(158.0);
        label12.setText("If there is no pyshical finch connected, the virtual finch will work, you can tap it to perform the same functionality.");
        label12.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(label3);
        anchorPane.getChildren().add(label4);
        anchorPane.getChildren().add(label5);
        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(tableColumn0);
        tableView.getColumns().add(tableColumn1);
        anchorPane.getChildren().add(tableView);
        group.getChildren().add(imageView);
        group.getChildren().add(circle);
        group.getChildren().add(label6);
        hBox.getChildren().add(group);
        group0.getChildren().add(imageView0);
        group0.getChildren().add(circle0);
        group0.getChildren().add(label7);
        hBox.getChildren().add(group0);
        group1.getChildren().add(imageView1);
        group1.getChildren().add(circle1);
        group1.getChildren().add(label8);
        hBox.getChildren().add(group1);
        group2.getChildren().add(imageView2);
        group2.getChildren().add(circle2);
        group2.getChildren().add(label9);
        hBox.getChildren().add(group2);
        group3.getChildren().add(imageView3);
        group3.getChildren().add(circle3);
        group3.getChildren().add(label10);
        hBox.getChildren().add(group3);
        anchorPane0.getChildren().add(hBox);
        anchorPane0.getChildren().add(label11);
        anchorPane0.getChildren().add(label12);
        vBox.getChildren().add(anchorPane0);
        anchorPane.getChildren().add(vBox);
        getChildren().add(anchorPane);

    }
}
