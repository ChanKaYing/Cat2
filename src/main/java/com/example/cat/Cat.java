package com.example.cat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.*;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Cat extends Application {

    @Override
    public void start(Stage primaryStage) {
        /// Create labels with the desired text

        Label upperLeftLabel = new Label("Cat Friend!");

        Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 30);
        // Set the font on the Label
        upperLeftLabel.setFont(font);

        Label middleLabel = new Label("");

        // Create image views for the small pictures
        ImageView upperRightImage1 = new ImageView(new Image(Cat.class.getResource("fbIcon.png").toString()));

        upperRightImage1.setFitWidth(50); // Set the desired width of the image
        upperRightImage1.setPreserveRatio(true); // Preserve the aspect ratio of the image

        ImageView upperRightImage2 = new ImageView(new Image(Cat.class.getResource("igIcon.png").toString()));
        upperRightImage2.setFitWidth(50); // Set the desired width of the image
        upperRightImage2.setPreserveRatio(true); // Preserve the aspect ratio of the image

        ImageView upperRightImage3 = new ImageView(new Image(Cat.class.getResource("ttIcon.png").toString()));
        upperRightImage3.setFitWidth(50); // Set the desired width of the image
        upperRightImage3.setPreserveRatio(true); // Preserve the aspect ratio of the image

        ImageView upperRightImage4 = new ImageView(new Image(Cat.class.getResource("catcatgif.gif").toString()));

        HBox hb= new HBox();
        hb.getChildren().add(upperRightImage4);
        hb.setAlignment(Pos.CENTER_LEFT);

        GridPane upperRightGrid = new GridPane();
        upperRightGrid.setHgap(10);
        upperRightGrid.add(upperRightImage1, 1, 0);
        upperRightGrid.add(upperRightImage2, 2, 0);
        upperRightGrid.add(upperRightImage3, 3, 0);
        upperRightGrid.add(hb,0,1);
        upperRightGrid.setAlignment(Pos.TOP_RIGHT);

        Label centerLabel1 = new Label("Unleash the");
        Label centerLabel2 = new Label("Feline Fun!");
        Font font1 = Font.font("Courier New", FontWeight.BOLD, 40);
        // Set the font on the Label
        centerLabel1.setFont(font1);
        centerLabel2.setFont(font1);
        Label centerText1 = new Label("Play Cat Friends and Discover ");
        Label centerText2 = new Label("a World of Whiskered Adventures!");
        Font font2 = Font.font("Courier New",FontWeight.BOLD,15);
        // Set the font on the Label
        centerText1.setFont(font2);
        centerText2.setFont(font2);
        Label centerSpace3 = new Label(" ");

        Button centerButton = new Button("       Play !       ");
        centerButton.setStyle("-fx-padding: 8 15 15 15;" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;" +
                "    -fx-background-radius: 8;" +
                "    -fx-background-color: " +
                "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%)," +
                "        #9d4024," +
                "        #d86e3a," +
                "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );" +
                "    -fx-font-weight: bold;" +
                "    -fx-font-size: 1.1em;");

        // Create a VBox for the upper left section with the label
        FlowPane flowPane = new FlowPane(centerLabel1,centerLabel2,
                centerText1,centerText2,centerSpace3,centerButton);
        flowPane.setAlignment(Pos.CENTER_LEFT);

        VBox vb= new VBox();
        vb.getChildren().add(centerButton);
        vb.setAlignment(Pos.CENTER_LEFT);

        // Create a GridPane for the middle section with the menu bar and label
        GridPane middleGrid = new GridPane();
        middleGrid.setHgap(10);
        middleGrid.add(createMenuBar(), 0, 0);
        middleGrid.add(middleLabel, 0, 0);
        middleGrid.setAlignment(Pos.TOP_CENTER);


        // Create a GridPane for the upper left section with the label
        GridPane upperLeftGrid = new GridPane();

        upperLeftGrid.add(upperLeftLabel, 0, 0);
        upperLeftGrid.setAlignment(Pos.TOP_LEFT);
        upperLeftGrid.add(flowPane,2,2);
        upperLeftGrid.add(vb,2,3);

        // Create a BorderPane and set the top, center, and right sections
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setLeft(upperLeftGrid);
        root.setCenter(middleGrid);
        root.setRight(upperRightGrid);

        // Set a background image for the root container
        Image backgroundImage = new Image(Cat.class.getResource("cat.jpg").toString());

        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        root.setBackground(new Background(background));



        // Create a scene with the BorderPane as the root node
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Welcome to Cat Friends!");
        // Set the scene to the stage and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public MenuBar createMenuBar() {
        // Create a menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.setStyle("-fx-background-color: transparent;"+"-fx-color:#ffffff");

        // Create menus and menu items
        Menu fileMenu = new Menu("Menu");
        Menu openItem = new Menu("Docs");
        Menu saveItem = new Menu("Whitepaper");

        // Add menu items to the file menu
        menuBar.getMenus().addAll(fileMenu,openItem, saveItem);

        return menuBar;
    }

    public static void main(String[] args) {
        launch(args);
    }
}