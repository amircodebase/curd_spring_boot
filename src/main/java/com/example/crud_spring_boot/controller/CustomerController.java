package com.example.crud_spring_boot.controller;

import com.example.crud_spring_boot.entity.CustomerBO;
import com.example.crud_spring_boot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public CustomerBO saveCustomer(@RequestBody CustomerBO customerBO){
        return  customerService.saveCustomer(customerBO);
    }

    @GetMapping("/customers")
    public List<CustomerBO> getAllCustomer(){
        return customerService.getAllCustomer();
    }
}
