package service.custom.impl;

import Model.Customer;
import Model.Item;
import repository.RepositoryFactory;
import repository.custom.CustomerRepository;
import service.custom.CustomerService;
import utill.RepositoryType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = RepositoryFactory.getInstance().getRepositoryType(RepositoryType.CUSTOMER);
    @Override
    public boolean addCustomer(Customer customer) throws SQLException {
        return customerRepository.save(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.update(customer);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerRepository.delete(id);
    }

    @Override
    public Customer searchCustomerById(String id) throws SQLException {
        return customerRepository.searchById(id);
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        return List.of();
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        return customerRepository.getAll();
    }

    @Override
    public List<String> getCustomerIds() throws SQLException {
        List<Customer> all = getAll();
        ArrayList<String> customerIdList = new ArrayList<>();
        System.out.println(customerIdList.toString());
        all.forEach(customer -> customerIdList.add(customer.getId()));
        return customerIdList;
    }
}
