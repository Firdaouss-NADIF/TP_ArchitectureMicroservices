package com.enset.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Invoice {
    @Id
    private String id;
    private Date date;
    private double amount;
    private String customerId;
    @Transient
    private Customer customer;
}

