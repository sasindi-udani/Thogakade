package controller;

import Model.Customer;
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
import service.ServiceFactory;
import service.custom.CustomerService;
import service.custom.ItemService;
import utill.CrudUtill;
import utill.ServiceType;

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

    ItemService service = ServiceFactory.getInstance().getServiceType(ServiceType.ITEM);

     private void tableLoard(){
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));

        ArrayList<Item> itemArrayList = new ArrayList<>();
        try{
            ResultSet resultSet = CrudUtill.execute("SELECT * FROM item");
            while (resultSet.next()) {
                Item item = new Item(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4));
                itemArrayList.add(item);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        tblItemForm.setItems(FXCollections.observableArrayList(itemArrayList));
    }
    @FXML
    void btnLoardTableOnAction(ActionEvent event) {
        tableLoard();

    }

    public void btnAddItemOnAction(ActionEvent event){

        Item item = new Item(
                txtCode.getText(),
                txtDescription.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                txtQty.getText());
        try{
            if (service.addItem(item)) {
                new Alert(Alert.AlertType.INFORMATION, "Item Added!").show();
                tableLoard();
            }
        }catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void btnDeleteItemOnAction(ActionEvent event) throws SQLException {
        if(service.deleteItem(txtCode.getText())){
            new Alert(Alert.AlertType.INFORMATION, "Item Deleted!").show();
            tableLoard();
        }
    }

    public void btnUpdateItemOnAction(ActionEvent event) {
        Item item = new Item(
                txtCode.getText(),
                txtDescription.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                txtQty.getText());
        try{
            if (service.updateItem(item)) {
                new Alert(Alert.AlertType.INFORMATION, "Item Updated!").show();
                tableLoard();
            }else{
                new Alert(Alert.AlertType.INFORMATION, "Cannot find item.Retry with the correct item code!").show();
            }
        }catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
