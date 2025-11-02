package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class Dashboard {
    public AnchorPane root;
    public Button btnItemData;

    @FXML
    public void btnCustomerManageOnAction(ActionEvent event) throws IOException {
        URL resourse = this.getClass().getResource("/View/viewCustomer.fxml");
        assert resourse != null;
        Parent load = FXMLLoader.load(resourse);
        this.root.getChildren().clear();
        this.root.getChildren().add(load);
    }
//    public void setBtnItemDataOnAction(ActionEvent event) throws IOException{
//        URL resourse = this.getClass().getResource("/View/viewItem.fxml");
//        assert resourse != null;
//        Parent load = FXMLLoader.load(resourse);
//        this.root.getChildren().clear();
//        this.root.getChildren().add(load);
//    }

    public void btnItemDataOnAction(ActionEvent event) throws IOException {
        URL resourse = this.getClass().getResource("/View/viewItem.fxml");
        assert resourse != null;
        Parent load = FXMLLoader.load(resourse);
        this.root.getChildren().clear();
        this.root.getChildren().add(load);
    }
}
