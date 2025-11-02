package service.custom.impl;

import Model.Customer;
import service.custom.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
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
