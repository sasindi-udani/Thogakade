package controller;

import Model.Customer;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Data;
import service.ServiceFactory;
import service.custom.CustomerService;
import service.custom.impl.CustomerServiceImpl;
import utill.CrudUtill;
import utill.ServiceType;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@Data

public class CustomerFormController {

//    public TextField txtSalary;
//    public TableColumn colSalary;
//    public TableColumn colAddress;
//    public TextField txtAddress;


//    @FXML
//    private TableColumn<?, ?> colID;
//
//    @FXML
//    private TableColumn<?, ?> colName;

//
//    @FXML
//    private TableView<?> tblCustomer;
//
//
//    @FXML
//    private TextField txtId;
//
//    @FXML
//    private TextField txtName;

    @FXML
    private AnchorPane back;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSalary;

    CustomerService service = ServiceFactory.getInstance().getServiceType(ServiceType.CUSTOMER);


    public void tblLoard() {
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

        Customer customer = new Customer(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText()));
        try{
            if (service.addCustomer(customer)) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Added!").show();
                tblLoard();
            }
        }catch(SQLException ex) {
            throw new RuntimeException(ex);
        }

//        Connection connection = DbConnection.getInstance().getConnection();
//        Customer customer = new Customer(
//                txtId.getText(),
//                txtName.getText(),
//                txtAddress.getText(),
//                Double.parseDouble(txtSalary.getText()));
//        try{
//            PreparedStatement psTm = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?)");
//            psTm.setString(1,customer.getId());
//            psTm.setString(2,customer.getName());
//            psTm.setString(3,customer.getAddress());
//            psTm.setDouble(4,customer.getSalary());
//
//            if(psTm.executeUpdate()>0){
//                new Alert(Alert.AlertType.INFORMATION,"Customer added").show();
//            }
//            tblLoard();
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

    @FXML
    void onActionLoardCust(ActionEvent event) throws SQLException {

        tblLoard();

    }

//    public void onActionLoardItemForm(ActionEvent actionEvent) throws IOException {
//        Stage stage = new Stage();
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("View/viewCustomer.fxml"))));
//        stage.show();
//    }

    public void onActionSearchCustomer(ActionEvent event) throws SQLException {
        Customer customer = service.searchCustomerById(txtId.getText());
        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtSalary.setText(Double.toString(customer.getSalary()));
    }

    public void onActionDeleteCustomer(ActionEvent event) throws SQLException {
        if(service.deleteCustomer(txtId.getText())){
            new Alert(Alert.AlertType.INFORMATION, "Customer Deleted!").show();
            tblLoard();
        }
    }

    public void onActionUpdateCustomer(ActionEvent event) {
        Customer customer = new Customer(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText()));
        try{
            if (service.updateCustomer(customer)) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Updated!").show();
                tblLoard();
            }else{
                new Alert(Alert.AlertType.INFORMATION, "Cannot find customer.Retry with the correct ID!").show();
            }
        }catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}

