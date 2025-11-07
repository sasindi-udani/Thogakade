package repository.custom;

import Model.Customer;
import Model.Item;
import repository.CrudUtill;
import repository.SuperRepository;

import java.sql.SQLException;
import java.util.List;

public interface ItemRepository extends CrudUtill {
    boolean save(Item item) throws SQLException;

    boolean update(Item item);

    boolean delete(String s);

    Customer searchById(String id) throws SQLException;

    List<Customer> getAll() throws SQLException;

    Integer getCount();
}
