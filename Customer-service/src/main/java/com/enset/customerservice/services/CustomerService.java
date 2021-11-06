package com.enset.customerservice.services;

import com.enset.customerservice.dto.CustomerRequestDTO;
import com.enset.customerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();
}
