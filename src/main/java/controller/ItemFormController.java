package controller;

import Model.Item;
import dbConnection.DbConnection;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemFormController {

    public TextField txtCode;
    public TextField txtUnitPrice;
    public TableColumn colCode;
    public TableColumn colUnitPrice;


    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableView<Item> tblItemForm;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

//    @FXML
//    void btnAddItemOnAction(ActionEvent event) {
//        DbConnection.getInstance().getItemList().add(new Item(
//                txtCode.getText(),
//                txtDescription.getText(),
//                Double.parseDouble(txtPrice.getText()),
//                txtQty.getText()));
//    }

    @FXML
    void btnLoardTableOnAction(ActionEvent event) throws IOException, SQLException {
//        Stage stage = new Stage();
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("View/viewItem.fxml"))));
//        stage.show();

        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        Connection connection = DbConnection.getInstance().getConnection();
        ArrayList<Item> itemArrayList = new ArrayList<>();
        try{
            PreparedStatement prt = connection.prepareStatement("SELECT * FROM item");
            ResultSet resultSet = prt.executeQuery();
            while (resultSet.next()) {
                Item item = new Item(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4));
                itemArrayList.add(item);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        tblItemForm.setItems(FXCollections.observableArrayList(itemArrayList));
    }

    public void btnAddItemOnAction(ActionEvent event) throws IOException, SQLException {
//        Stage stage = new Stage();
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("View/viewItem.fxml"))));
//        stage.show();

        Connection connection = DbConnection.getInstance().getConnection();
        Item item = new Item(
                txtCode.getText(),
                txtUnitPrice.getText(),
                Double.parseDouble(colCode.getText()),
                colUnitPrice.getText());

        try{
            PreparedStatement psTm = connection.prepareStatement("INSERT INTO item VALUES(?,?,?,?)");
            psTm.setString(1,item.getCode());
            psTm.setString(2,item.getDescription());
            psTm.setDouble(3,item.getUnitPrice());
            psTm.setString(4,item.getQtyOnHand());

            if(psTm.executeUpdate()>0){
                new Alert(Alert.AlertType.INFORMATION,"Item added").show();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
