package repository;

import Model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CrudUtill<T,ID> extends SuperRepository {
    boolean save(T t) throws SQLException;
    boolean update(T t)throws SQLException;
    boolean delete(ID id) throws SQLException;
    T searchById(ID id) throws SQLException;
    List<T> getAll() throws SQLException;
    Integer getCount();
}
