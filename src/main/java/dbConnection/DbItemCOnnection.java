//package dbConnection;
//
//import Model.Customer;
//import Model.Item;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DbItemCOnnection {
//
//    private static DbItemCOnnection instance;
//    private ObservableList<Item> itemList;
//    private Connection connection;
//
//    private DbItemCOnnection() throws SQLException {
//        itemList = FXCollections.observableArrayList();
//        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade","root","1234");
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//
//    public ObservableList<Item> getCustomerList() {
//        return itemList;
//    }
//
//    public static DbConnection getInstance() throws SQLException {
//        return instance == null ? instance = new DbItemCOnnection() : instance;
//    }
//}
