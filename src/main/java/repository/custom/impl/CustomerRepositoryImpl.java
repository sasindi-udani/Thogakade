package repository.custom.impl;

import Model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repository.custom.CustomerRepository;
import utill.CrudUtill;

public class CustomerRepositoryImpl implements CustomerRepository {

    //CustomerRepository customerRepository = RepositoryFactory.getInstance().getRepositoryType(RepositoryType.CUSTOMER);

//    @Override
//    public boolean save(Customer customer) throws SQLException {
//
//    }

//    @Override
//    public boolean save(Customer customer) throws SQLException {
//        return CrudUtill.execute("INSERT INTO customer VALUES(?,?,?,?)",
//                customer.getId(),
//                customer.getName(),
//                customer.getAddress(),
//                customer.getSalary());
//    }

    @Override
    public boolean save(Customer customer) throws SQLException {
        return CrudUtill.execute("INSERT INTO customer VALUES(?,?,?,?)",
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getSalary());
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        return CrudUtill.execute(
                "UPDATE customer SET name=?, address=?, salary=? WHERE id=?",
                customer.getName(),
                customer.getAddress(),
                customer.getSalary(),
                customer.getId()
        );
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return CrudUtill.execute("DELETE FROM customer WHERE id='"+id+"'");
    }

    @Override
    public Customer searchById(String id) throws SQLException {
        ResultSet resultSet= CrudUtill.execute("SELECT * FROM customer WHERE id='"+id+"'");
        resultSet.next();
        return new Customer(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3),resultSet.getDouble(4) );
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customerList = new ArrayList<>();

        ResultSet resultSet = CrudUtill.execute("SELECT * FROM customer");

        while (resultSet.next())
            customerList.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            ));


        return customerList;
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
