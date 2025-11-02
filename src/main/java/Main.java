import Model.Customer;
import Model.Item;
import dbConnection.DbConnection;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        try {
//            Connection connection = DbConnection.getInstance().getConnection();
//            PreparedStatement psTm = connection.prepareStatement("SELECT * FROM  item");
//            ResultSet resultSet = psTm.executeQuery();
//            ArrayList<Item> arrayOfBooks = new ArrayList<>();
//            while (resultSet.next()) {
//                resultSet.getString(2);
//                arrayOfBooks.add(new Item(resultSet.getString(1),resultSet.getString(2),Double.parseDouble(resultSet.getString(3)),resultSet.getString(4)));
//                System.out.println(arrayOfBooks);
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        Starter.main();


    }
}