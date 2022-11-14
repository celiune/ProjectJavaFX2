package com.example.projectjavafx2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductController implements Initializable{

    @FXML
    private Button btnAccessories;

    @FXML
    private Button btnClothes;

    @FXML
    private Button btnShoes;

    @FXML
    private ImageView imageViewAccessories;

    @FXML
    private ImageView imageViewClothes;

    @FXML
    private ImageView imageViewShoes;

    @FXML
    private ListView<Accessories> listViewAccessories;

    @FXML
    private ListView<Clothes> listViewClothes;

    @FXML
    private ListView<Shoes> listViewShoes;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image imageClothes = null;
        try {
            imageClothes = new Image(new FileInputStream("C:\\Users\\celin\\OneDrive - De Vinci\\S7\\Object Oriented Development\\ProjectJavaFX2\\src\\main\\Images\\Clothes.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        imageViewClothes.setImage(new ImageView(imageClothes).getImage());

        Image imageShoes = null;
        try {
            imageShoes = new Image(new FileInputStream("C:\\Users\\celin\\OneDrive - De Vinci\\S7\\Object Oriented Development\\ProjectJavaFX2\\src\\main\\Images\\Shoes.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        imageViewShoes.setImage(new ImageView(imageShoes).getImage());

        Image imageAccessories = null;
        try {
            imageAccessories = new Image(new FileInputStream("C:\\Users\\celin\\OneDrive - De Vinci\\S7\\Object Oriented Development\\ProjectJavaFX2\\src\\main\\Images\\Accessories.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        imageViewAccessories.setImage(new ImageView(imageAccessories).getImage());

        List<Accessories> newAccessories = new ArrayList<>();
        newAccessories.add(new Accessories("Necklace",15,10));
        newAccessories.add(new Accessories("Bracelet",15,12));
        ObservableList<Accessories> accessories = FXCollections.observableArrayList(newAccessories);
        listViewAccessories.setItems(accessories);

        List<Clothes> newClothes = new ArrayList<>();
        newClothes.add(new Clothes("T-Shirt",15,15,35));
        newClothes.add(new Clothes("Jeans",30,20,35));
        ObservableList<Clothes> clothes = FXCollections.observableArrayList(newClothes);
        listViewClothes.setItems(clothes);

        List<Shoes> newShoes = new ArrayList<>();
        newShoes.add(new Shoes("AirForce",15,10,36));
        newShoes.add(new Shoes("Yeezie",15,12,37));
        ObservableList<Shoes> shoes = FXCollections.observableArrayList(newShoes);
        listViewShoes.setItems(shoes);
    }

    public void onClickClothes(ActionEvent event) throws IOException {
        Parent clothes_page = FXMLLoader.load(getClass().getResource("clothes.fxml"));
        Scene clothes_scene = new Scene(clothes_page, 600, 400);
        Stage clothes_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        clothes_stage.setScene(clothes_scene);
        clothes_stage.show();
    }

    public void onClickShoes(ActionEvent event) throws IOException {
        Parent clothes_page = FXMLLoader.load(getClass().getResource("shoes.fxml"));
        Scene clothes_scene = new Scene(clothes_page, 600, 400);
        Stage clothes_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        clothes_stage.setScene(clothes_scene);
        clothes_stage.show();

    }

    public void onClickAccessories(ActionEvent event) throws IOException {
        Parent clothes_page = FXMLLoader.load(getClass().getResource("accessories.fxml"));
        Scene clothes_scene = new Scene(clothes_page, 600, 400);
        Stage clothes_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        clothes_stage.setScene(clothes_scene);
        clothes_stage.show();

    }
}