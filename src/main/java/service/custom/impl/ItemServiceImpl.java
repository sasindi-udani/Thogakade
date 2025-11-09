package service.custom.impl;

import Model.Item;
import repository.RepositoryFactory;
import repository.custom.CustomerRepository;
import repository.custom.ItemRepository;
import service.custom.ItemService;
import utill.RepositoryType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository = RepositoryFactory.getInstance().getRepositoryType(RepositoryType.ITEM);


    @Override
    public boolean addItem(Item item) throws SQLException {
        return itemRepository.save(item);
    }

    @Override
    public boolean updateItem(Item item) throws SQLException {
        return itemRepository.update(item);
    }

    @Override
    public boolean deleteItem(String code) throws SQLException {
        return itemRepository.delete(code);
    }

    @Override
    public Item searchItemById(String code) throws SQLException {
        return itemRepository.searchById(code);
    }

    @Override
    public List<String> getAllItemIds() throws SQLException {
        List<Item> all = getAll();
        ArrayList<String> itemIdList = new ArrayList<>();

        all.forEach(item -> {
            itemIdList.add(item.getCode());
        });
        return itemIdList;
    }

    @Override
    public List<Item> getAll() throws SQLException {
        return itemRepository.getAll();
    }
}
