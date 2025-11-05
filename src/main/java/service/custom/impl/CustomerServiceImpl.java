package service.custom.impl;

import Model.Customer;
import repository.RepositoryFactory;
import service.custom.CustomerService;
import utill.CrudUtill;
import utill.RepositoryType;

import java.sql.ResultSet;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerService customerService = RepositoryFactory.getInstance().getRepositoryType(RepositoryType.CUSTOMER);
    @Override
    public boolean addCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public boolean searchCustomerById(String id) {
        return false;
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        return List.of();
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }

    @Override
    public List<String> getCustomerIds() {
        return List.of();
    }
}
