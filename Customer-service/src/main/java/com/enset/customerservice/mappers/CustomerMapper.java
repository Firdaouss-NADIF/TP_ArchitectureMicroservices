package com.enset.customerservice.mappers;

import com.enset.customerservice.dto.CustomerRequestDTO;
import com.enset.customerservice.dto.CustomerResponseDTO;
import com.enset.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOCustom(CustomerRequestDTO customerRequestDTO);
}
