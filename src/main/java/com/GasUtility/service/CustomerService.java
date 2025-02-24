package com.GasUtility.service;

import com.GasUtility.entity.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
}
