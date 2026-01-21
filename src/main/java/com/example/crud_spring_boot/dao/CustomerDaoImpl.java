package com.example.crud_spring_boot.dao;

import com.example.crud_spring_boot.entity.CustomerBO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext
    private EntityManager entityManager;

    private static  final Logger logger= LoggerFactory.getLogger(CustomerDaoImpl.class);

    @Override
    public CustomerBO saveCustomer(CustomerBO customerBO) {
        entityManager.persist(customerBO);
        logger.info("Customer saved successFully, Customer Details={}", customerBO);
        return customerBO;
    }

    @Override
    public List<CustomerBO> findAll() {
        return entityManager
                .createQuery("SELECT c FROM CustomerBO c", CustomerBO.class)
                .getResultList();
    }
}
