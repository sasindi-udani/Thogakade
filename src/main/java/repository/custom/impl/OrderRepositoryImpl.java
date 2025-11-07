package repository.custom.impl;

import Model.Customer;
import utill.CrudUtill;

import java.sql.SQLException;
import java.util.List;

public class OrderRepositoryImpl extends CrudUtill {
    @Override
    public boolean save(Customer customer) throws SQLException {
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
}
