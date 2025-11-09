package repository.custom.impl;

import Model.Customer;
import Model.Item;
import repository.custom.ItemRepository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utill.CrudUtill;

public class ItemRepositoryImpl implements ItemRepository {

    @Override
    public boolean save(Item item) throws SQLException {
        return CrudUtill.execute("INSERT INTO item VALUES(?,?,?,?)",
                item.getCode(),
                item.getDescription(),
                item.getUnitPrice(),
                item.getQtyOnHand());
    }

    @Override
    public boolean update(Item item) throws SQLException {
        return CrudUtill.execute(
                "UPDATE item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                item.getCode(),
                item.getDescription(),
                item.getUnitPrice(),
                item.getQtyOnHand()
        );
    }

    @Override
    public boolean delete(String code) throws SQLException {
        return CrudUtill.execute("DELETE FROM item WHERE code='"+code+"'");
    }

    @Override
    public Item searchById(String code) throws SQLException {
        ResultSet resultSet= CrudUtill.execute("SELECT * FROM item WHERE code='"+code+"'");
        resultSet.next();
        return new Item(resultSet.getString(1),resultSet.getString(2), resultSet.getDouble(3),resultSet.getString(4) );
    }

    @Override
    public List<Item> getAll() throws SQLException {
        List<Item> itemList = new ArrayList<>();

        ResultSet resultSet = CrudUtill.execute("SELECT * FROM item");

        while (resultSet.next())
            itemList.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4)
            ));


        return itemList;
    }

    @Override
    public Integer getCount() {
        return 0;
    }
}
