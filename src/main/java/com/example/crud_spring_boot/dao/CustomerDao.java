package com.example.crud_spring_boot.dao;

import com.example.crud_spring_boot.entity.CustomerBO;

import java.util.List;

public interface CustomerDao {

    CustomerBO saveCustomer(CustomerBO customerBO);

    List<CustomerBO> findAll();
}
