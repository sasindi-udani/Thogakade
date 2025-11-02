package service.custom;

import Model.Customer;

import java.util.List;

public interface CustomerService {

    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String id);
    boolean searchCustomerById(String id);
    List<Customer> searchCustomerByName(String name);
    List<Customer> getAll();

    List<String> getCustomerIds();
}
