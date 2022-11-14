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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClothesController implements Initializable {

    @FXML
    private Button btnProduct;

    @FXML
    private Button btnPurchase;

    @FXML
    private Button btnSell;

    @FXML
    private Label label_list_clothes;

    @FXML
    private Label lblClothes;

    @FXML
    private Label lblDiscount;

    @FXML
    private Label lblName;

    @FXML
    private Label lblNbItems;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblSize;

    @FXML
    private ListView<Clothes> listViewclothes;

    @FXML
    private TextField txtFieldDiscount;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TextField txtFieldNbItems;

    @FXML
    private TextField txtFieldSize;

    @FXML
    private TextField txtFrieldPrice;

    DBManager manager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manager = new DBManager();

        List<Clothes> newClothes = new ArrayList<>();
        newClothes.add(new Clothes("T-Shirt",15,15,35));
        newClothes.add(new Clothes("Jeans",30,20,35));
        ObservableList<Clothes> clothes = FXCollections.observableArrayList(newClothes);
        listViewclothes.setItems(clothes);

        listViewclothes.getSelectionModel().selectedItemProperty().addListener(e->
                displayClothesDetails(listViewclothes.getSelectionModel().getSelectedItem()));

    }

    private void displayClothesDetails(Clothes selectedItem) {
        try {
            if(selectedItem!=null){
                txtFieldName.setText(selectedItem.getName());
                txtFrieldPrice.setText(String.valueOf(selectedItem.getPrice()));
                txtFieldNbItems.setText(String.valueOf(selectedItem.getNbItems()));
                txtFieldSize.setText(String.valueOf(selectedItem.getSize()));}
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void onClickProduct(ActionEvent event) throws IOException {
        Parent product_page = FXMLLoader.load(getClass().getResource("product.fxml"));
        Scene product_scene = new Scene(product_page, 600, 400);
        Stage product_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        product_stage.setScene(product_scene);
        product_stage.show();
    }


}
