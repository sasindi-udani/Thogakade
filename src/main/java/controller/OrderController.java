//package controller;
//
//import com.jfoenix.controls.JFXComboBox;
//import com.jfoenix.controls.JFXTextField;
//import javafx.animation.Animation;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.collections.FXCollections;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.util.Duration;
//import model.CartTM;
//import model.Customer;
//import model.Item;
//import service.ServiceFactory;
//import service.SuperService;
//import service.custom.CustomerService;
//import service.custom.ItemService;
//import util.ServiceType;
//import utill.ServiceType;
//
//import java.net.URL;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public class OrderController implements Initializable {
//
//    @FXML
//    private JFXComboBox cmbCustomerId;
//
//    @FXML
//    private JFXComboBox cmbItemCode;
//
//    @FXML
//    private TableColumn colDescription;
//
//    @FXML
//    private TableColumn colItemCode;
//
//    @FXML
//    private TableColumn colQty;
//
//    @FXML
//    private TableColumn colTotal;
//
//    @FXML
//    private TableColumn colUnitPrice;
//
//    @FXML
//    private Label lblDate;
//
//    @FXML
//    private Label lblNetTotal;
//
//    @FXML
//    private Label lblTime;
//
//    @FXML
//    private TableView tblCart;
//
//    @FXML
//    private JFXTextField txtCustomerAddress;
//
//    @FXML
//    private JFXTextField txtCustomerName;
//
//    @FXML
//    private JFXTextField txtCustomerSalary;
//
//    @FXML
//    private JFXTextField txtDescription;
//
//    @FXML
//    private JFXTextField txtQtyOnHand;
//
//    @FXML
//    private JFXTextField txtStock;
//
//    @FXML
//    private JFXTextField txtUnitPrice;
//
//
//    CustomerService customerService = ServiceFactory.getInstance().getServiceType(ServiceType.CUSTOMER);
//    ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.ITEM);
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
//        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
//        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
//        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
//        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
//
//
//        loadDateAndTime();
//        loadCustomerIds();
//        loadItemIds();
//
//        cmbCustomerId.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
//            System.out.println(oldValue);
//            System.out.println(newValue);
//            if (newValue != null) {
//                setTextToValuesCustomer((String) newValue);
//            }
//        });
//        cmbItemCode.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
//            if (newValue != null) {
//                setTextToValuesItem((String) newValue);
//            }
//        });
//    }
//
//    private void setTextToValuesCustomer(String customerId) {
//        try {
//            Customer customer = customerService.searchCustomerById(customerId);
//            txtCustomerName.setText(customer.getName());
//            txtCustomerAddress.setText(customer.getAddress());
//            txtCustomerSalary.setText(customer.getSalary().toString());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void setTextToValuesItem(String code) {
//        try {
//            Item item = itemService.searchById(code);
//            txtDescription.setText(item.getDescription());
//            txtStock.setText(item.getQty().toString());
//            txtUnitPrice.setText(item.getUnitPrice().toString());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    ArrayList<CartTM> cartTMS = new ArrayList<>();
//
//    @FXML
//    void btnAddToCartOnAction(ActionEvent event) {
//
//        Double unitPrice = Double.parseDouble(txtUnitPrice.getText());
//
//        Integer qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
//
//        Double total = qtyOnHand * unitPrice;
//
//        cartTMS.add(new CartTM(
//                cmbItemCode.getValue().toString(),
//                txtDescription.getText (),
//                qtyOnHand,
//                unitPrice,
//                total
//        ));
//
//        tblCart.setItems(FXCollections.observableArrayList(cartTMS));
//        calNetTotal();
//
//    }
//
//    @FXML
//    void btnClearOnAction(ActionEvent event) {
//
//    }
//
//    @FXML
//    void btnPlaceOrderOnAction(ActionEvent event) {
//
//    }
//
//    private void loadDateAndTime() {
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        lblDate.setText(simpleDateFormat.format(date));
//
//
//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.ZERO, e -> {
//                    LocalTime now = LocalTime.now();
//                    lblTime.setText(now.getHour() + ":" + now.getMinute() + ":" + now.getSecond());
//                }),
//                new KeyFrame(Duration.seconds(1))
//        );
//
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
//
//
//    }
//
//    private void loadCustomerIds() {
//        List<String> customerIds = customerService.getCustomerIds();
//        cmbCustomerId.setItems(FXCollections.observableArrayList(customerIds));
//    }
//
//    private void loadItemIds() {
//        cmbItemCode.setItems(FXCollections.observableArrayList(itemService.getAllItemIds()));
//    }
//
//    private void calNetTotal(){
//        Double netTotal =0.0;
//        for (CartTM tm : cartTMS){
//            netTotal+= tm.getTotal();
//        }
//
//        lblNetTotal.setText(netTotal.toString());
//    }
//
//}
//
