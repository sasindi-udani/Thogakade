package controller;

import Model.Customer;
import dbConnection.DbConnection;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lombok.Data;
import utill.CrudUtill;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@Data

public class CustomerController {

    public TextField txtSalary;
    public TableColumn colSalary;
    public TableColumn colAddress;
    public TextField txtAddress;
//    @FXML
//    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<Customer> tblCustomer;

//    @FXML
//    private TextField txtAuthor;


    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;


    public void tblLoard() throws SQLException {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

//        Connection connection = DbConnection.getInstance().getConnection();
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        try{
//            PreparedStatement prt = connection.prepareStatement("SELECT * FROM customer");
//            ResultSet resultSet = prt.executeQuery();
            ResultSet resultSet = CrudUtill.execute("SELECT * FROM customer");
            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4));
                customerArrayList.add(customer);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
//        tblCustomer.setItems(DbConnection.getInstance().getCustomerList());
        tblCustomer.setItems(FXCollections.observableArrayList(customerArrayList));

    }

    @FXML
    void onActionAddCust(ActionEvent event) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        Customer customer = new Customer(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText()));

        try{
            PreparedStatement psTm = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?)");
            psTm.setString(1,customer.getId());
            psTm.setString(2,customer.getName());
            psTm.setString(3,customer.getAddress());
            psTm.setDouble(4,customer.getSalary());

            if(psTm.executeUpdate()>0){
                new Alert(Alert.AlertType.INFORMATION,"Book added").show();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        tblLoard();

//        DbConnection.getInstance().getCustomerList().add( new Customer(
//                Integer.parseInt(txtId.getText()),
//                txtName.getText(),
//                txtAuthor.getText()));
//
//                tblLoard();

    }

    @FXML
    void onActionLoardCust(ActionEvent event) throws SQLException {

        tblLoard();

    }

    public void onActionLoardItemForm(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("View/viewCustomer.fxml"))));
        stage.show();
    }
}

