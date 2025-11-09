package controller;

import Model.*;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import service.ServiceFactory;
import service.custom.CustomerService;
import service.custom.ItemService;
import utill.ServiceType;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    CustomerService customerService = ServiceFactory.getInstance().getServiceType(ServiceType.CUSTOMER);
    ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.ITEM);

    @FXML
    private JFXComboBox<String> cmbCustomerId;

    @FXML
    private JFXComboBox<String> cmbItemCode;

    @FXML
    private TableView<CartTM> tblOrder;

    @FXML
    private TableColumn<CartTM, String> colItemCode;

    @FXML
    private TableColumn<CartTM, String> colDescription;

    @FXML
    private TableColumn<CartTM, Integer> colQty;

    @FXML
    private TableColumn<CartTM, Double> colUnitPrice;

    @FXML
    private TableColumn<CartTM, Double> colTotal;


    @FXML
    private Label lblNetTotal;

    @FXML
    private JFXTextField txtCustomerAddress;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtCustomerSalary;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtUnitPrice;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        loadCustomerIds();
        loadItemIds();

        cmbCustomerId.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                setTextToValuesCustomer((String) newValue);
            }
        });
        cmbItemCode.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                setTextToValuesItem((String) newValue);
            }
        });
    }

    private void setTextToValuesCustomer(String customerId) {
        try {
            Customer customer = customerService.searchCustomerById(customerId);
            txtCustomerName.setText(customer.getName());
            txtCustomerAddress.setText(customer.getAddress());
            txtCustomerSalary.setText(customer.getSalary().toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setTextToValuesItem(String code) {
        try {
            Item item = itemService.searchItemById(code);
            txtDescription.setText(item.getDescription());
            txtQuantity.setText(item.getQtyOnHand().toString());
            txtUnitPrice.setText(item.getUnitPrice().toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<CartTM> cartTMS = new ArrayList<>();

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        Double unitPrice = Double.parseDouble(txtUnitPrice.getText());

        Integer qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());

        Double total = qtyOnHand * unitPrice;

        cartTMS.add(new CartTM(
                cmbItemCode.getValue().toString(),
                txtDescription.getText (),
                qtyOnHand,
                unitPrice,
                total
        ));

        tblOrder.setItems(FXCollections.observableArrayList(cartTMS));
        calNetTotal();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    private void loadCustomerIds() {
//        List<String> customerIds = customerService.getCustomerIds();
//        cmbCustomerId.setItems(FXCollections.observableArrayList(customerIds));

        try {
            cmbCustomerId.setItems(FXCollections.observableArrayList(customerService.getCustomerIds()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadItemIds() {
        try {
            cmbItemCode.setItems(FXCollections.observableArrayList(itemService.getAllItemIds()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void calNetTotal(){
        Double netTotal =0.0;
        for (CartTM tm : cartTMS){
            netTotal+= tm.getTotal();
        }

        lblNetTotal.setText(netTotal.toString());
    }
}
