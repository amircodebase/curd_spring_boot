package com.example.crud_spring_boot.controller;

import com.example.crud_spring_boot.entity.CustomerBO;
import com.example.crud_spring_boot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerBO> getCustomerById(@PathVariable Long id){
        CustomerBO customerBO = customerService.getCustomerById(id);
        if(customerBO == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(customerBO);
    }


    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerBO> updateCustomer(@PathVariable Long id,  @RequestBody CustomerBO customerBO){
        CustomerBO existingCustomer = customerService.getCustomerById(id);
        if(existingCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        existingCustomer.setName(customerBO.getName());
        existingCustomer.setEmail(customerBO.getEmail());
        existingCustomer.setPhone(customerBO.getPhone());
        CustomerBO updateCustomer = customerService.updateCustomer(existingCustomer);
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public  ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        CustomerBO existingCustomer = customerService.getCustomerById(id);
        if(existingCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        customerService.deleteCustomer(id);
        return  ResponseEntity.ok().build();
    }

}
