package dbConnection;

import Model.Customer;
import Model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection  {

    private static DbConnection instance;
    private Connection connection;

    private DbConnection() throws SQLException {

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade","root","1234");
    }

    public Connection getConnection(){
        return connection;
    }

    public static DbConnection getInstance() throws SQLException {
        if(instance==null){
            return instance = new DbConnection();
        }
        return instance;
    }
//    private static DbConnection instance;
//    private ObservableList<Customer> customerList;
//    private ObservableList<Item> itemList;
//    private Connection connection;
//
//    private DbConnection() throws SQLException {
//        customerList = FXCollections.observableArrayList();
//        itemList= FXCollections.observableArrayList();
//        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade","root","1234");
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//
//    public ObservableList<Customer> getCustomerList() {
//        return customerList;
//    }
//    public ObservableList<Item> getItemList() {
//        return itemList;
//    }
//
//    public static DbConnection getInstance() throws SQLException {
//        return instance == null ? instance = new DbConnection() : instance;
//    }
}
