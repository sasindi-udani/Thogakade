package repository.custom.impl;

import Model.Customer;
import Model.Item;
import repository.custom.ItemRepository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utill.CrudUtill;

public class ItemRepositoryImpl extends CrudUtill {
//    @Override
//    public boolean save(Item item) throws SQLException {
//        return false;
//    }
//
//    @Override
//    public boolean update(Item item) {
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
//        return null;
//    }

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
    public List<Customer> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public Integer getCount() {
        return 0;
    }
}
