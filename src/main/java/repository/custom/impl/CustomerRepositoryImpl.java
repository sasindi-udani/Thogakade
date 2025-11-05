package repository.custom.impl;

import Model.Customer;
import repository.RepositoryFactory;
import repository.custom.CustomerRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utill.CrudUtill;
import utill.RepositoryType;

public class CustomerRepositoryImpl implements CustomerRepository {

    CustomerRepository customerRepository = RepositoryFactory.getInstance().getRepositoryType(RepositoryType.CUSTOMER);

    @Override
    public boolean save(Object o) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public Object searchById(Object o) throws SQLException {
        return null;
    }

    @Override
    public List getAll() throws SQLException {
        return List.of();
    }

    @Override
    public Integer getCount() {
        return 0;
    }

//    @Override
//    public boolean save(Customer customer) throws SQLException {
//        return CrudUtill.execute("INSERT INTO customer VALUES(?,?,?,?)",
//                customer.getId(),
//                customer.getName(),
//                customer.getAddress(),
//                customer.getSalary()
//        );
//    }
//
//    @Override
//    public boolean update(Customer customer) {
//        return false;
//    }
//
//    @Override
//    public boolean delete(String s) {
//        return false;
//    }
//
//    @Override
//    public Customer searchById(String id) throws SQLException {
//        ResultSet resultSet = CrudUtill.execute("SELECT * FROM customer WHERE id=?", id);
//        resultSet.next();
//        return new Customer(
//                resultSet.getString(1),
//                resultSet.getString(2),
//                resultSet.getString(3),
//                resultSet.getDouble(4)
//        );
//    }
//
//    @Override
//    public List<Customer> getAll() throws SQLException {
//        List<Customer> customerList = new ArrayList<>();
//        ResultSet resultSet = CrudUtill.execute("SELECT * FROM customer");
//
//        while (resultSet.next())
//            customerList.add(new Customer(
//                    resultSet.getString(1),
//                    resultSet.getString(2),
//                    resultSet.getString(3),
//                    resultSet.getDouble(4)
//            ));
//        return customerList;
//    }
//
//    @Override
//    public Integer getCount() {
//        return 0;
//    }
////    @Override
////    public boolean save(Customer customer) throws SQLException {
//////        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
//////        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
//////        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
////
////        Connection connection = DbConnection.getInstance().getConnection();
////        ArrayList<Customer> customerArrayList = new ArrayList<>();
////        try{
////            PreparedStatement prt = connection.prepareStatement("SELECT * FROM customer");
////            ResultSet resultSet = prt.executeQuery();
////            while (resultSet.next()) {
////                customer = new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4));
////                customerArrayList.add(customer);
////            }
////        }catch (SQLException e){
////            throw new RuntimeException(e);
////        }
//////        tblCustomer.setItems(DbConnection.getInstance().getCustomerList());
////        tblCustomer.setItems(FXCollections.observableArrayList(customerArrayList));
////        return false;
////    }
}
