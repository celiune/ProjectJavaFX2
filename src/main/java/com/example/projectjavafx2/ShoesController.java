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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShoesController implements Initializable {

    @FXML
    private Button btnProduct;

    @FXML
    private Button btnPurchase;

    @FXML
    private Button btnSell;

    @FXML
    private Label label_list_shoes;

    @FXML
    private Label lblDiscount;

    @FXML
    private Label lblName;

    @FXML
    private Label lblNbItems;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblShoeSize;

    @FXML
    private Label lblShoes;

    @FXML
    private ListView<Shoes> listViewShoes;

    @FXML
    private TextField txtFieldDiscount;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TextField txtFieldNbItems;

    @FXML
    private TextField txtFieldPrice;

    @FXML
    private TextField txtFieldShoeSize;

    DBManager manager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manager = new DBManager();

        List<Shoes> newShoes = new ArrayList<>();
        newShoes.add(new Shoes("AirForce",15,10,36));
        newShoes.add(new Shoes("Yeezie",15,12,37));
        ObservableList<Shoes> shoes = FXCollections.observableArrayList(newShoes);
        listViewShoes.setItems(shoes);

        listViewShoes.getSelectionModel().selectedItemProperty().addListener(e->
                displayShoesDetails(listViewShoes.getSelectionModel().getSelectedItem()));
    }

    private void displayShoesDetails(Shoes selectedItem) {
        try {
            if(selectedItem!=null){
                txtFieldName.setText(selectedItem.getName());
                txtFieldPrice.setText(String.valueOf(selectedItem.getPrice()));
                txtFieldNbItems.setText(String.valueOf(selectedItem.getNbItems()));
                txtFieldShoeSize.setText(String.valueOf(selectedItem.getShoeSize()));}
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
