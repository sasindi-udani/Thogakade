package repository.custom;

import Model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    boolean save(Customer customer) throws SQLException;

    boolean update(Customer customer);

    boolean delete(String s);

    Customer searchById(String id) throws SQLException;

    List<Customer> getAll() throws SQLException;

    Integer getCount();
}
