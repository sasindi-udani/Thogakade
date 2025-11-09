package service.custom;

import Model.Item;
import service.SuperService;
import java.sql.SQLException;
import java.util.List;

public interface ItemService extends SuperService {
    boolean addItem(Item item) throws SQLException;
    boolean updateItem(Item item)throws SQLException;
    boolean deleteItem(String code)throws SQLException;
    Item searchItemById(String code) throws SQLException;
    List<String> getAllItemIds() throws SQLException;
    List<Item> getAll() throws SQLException;
}
