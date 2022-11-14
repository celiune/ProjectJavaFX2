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

public class AccessoriesController implements Initializable {

    @FXML
    private Button btnProduct;

    @FXML
    private Button btnPurchase;

    @FXML
    private Button btnSell;

    @FXML
    private Label label_list_accessories;

    @FXML
    private Label lblAccessories;

    @FXML
    private Label lblDiscount;

    @FXML
    private Label lblName;

    @FXML
    private Label lblNbItems;

    @FXML
    private Label lblPrice;

    @FXML
    private ListView<Accessories> listViewAccessories;

    @FXML
    private TextField txtFieldDiscount;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TextField txtFieldNbItems;

    @FXML
    private TextField txtFieldPrice;

    DBManager manager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manager = new DBManager();

        List<Accessories> newAccessories = new ArrayList<>();
        newAccessories.add(new Accessories("Necklace",15,10));
        newAccessories.add(new Accessories("Bracelet",15,12));
        ObservableList<Accessories> accessories = FXCollections.observableArrayList(newAccessories);
        listViewAccessories.setItems(accessories);

        listViewAccessories.getSelectionModel().selectedItemProperty().addListener(e->
                displayAccessoriesDetails(listViewAccessories.getSelectionModel().getSelectedItem()));

    }

    private void displayAccessoriesDetails(Accessories selectedItem) {
        try {
            if(selectedItem!=null){
                txtFieldName.setText(selectedItem.getName());
                txtFieldPrice.setText(String.valueOf(selectedItem.getPrice()));
                txtFieldNbItems.setText(String.valueOf(selectedItem.getNbItems()));
                }
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
