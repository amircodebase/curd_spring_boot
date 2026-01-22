package com.example.crud_spring_boot.service;

import com.example.crud_spring_boot.entity.CustomerBO;

import java.util.List;

public interface CustomerService {

    CustomerBO saveCustomer(CustomerBO customerBO);

    List<CustomerBO> getAllCustomer();

    CustomerBO getCustomerById(Long id);

    CustomerBO updateCustomer(CustomerBO customerBO);

    void deleteCustomer(Long id);
}
