package com.example.crud_spring_boot.service;

import com.example.crud_spring_boot.dao.CustomerDao;
import com.example.crud_spring_boot.entity.CustomerBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("customerService")

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Override
    public CustomerBO saveCustomer(CustomerBO customerBO) {
        return customerDao.saveCustomer(customerBO);
    }

    @Override
    public List<CustomerBO> getAllCustomer() {
        return customerDao.findAll();
    }

    @Override
    public CustomerBO getCustomerById(Long id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public CustomerBO updateCustomer(CustomerBO customerBO) {
        return customerDao.updateCustomer(customerBO);
    }

    @Override
    public void deleteCustomer(Long id){
        customerDao.deleteCustomer(id);
    }
}
