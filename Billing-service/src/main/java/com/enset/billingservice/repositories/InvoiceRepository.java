package com.enset.billingservice.repositories;


import com.enset.billingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,String> {
    List<Invoice> findCustomerById(String customerId);

}

