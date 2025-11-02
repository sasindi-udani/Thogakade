package repository;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository<T,ID> extends SuperRepository {
    boolean save(T t) throws SQLException;
    boolean update(T t);
    boolean delete(ID id);
    T searchById(ID id) throws SQLException;
    List<T> getAll() throws SQLException;
    Integer getCount();
}
