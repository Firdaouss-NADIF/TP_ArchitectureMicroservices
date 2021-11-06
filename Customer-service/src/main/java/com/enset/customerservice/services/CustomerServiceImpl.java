package com.enset.customerservice.services;

import com.enset.customerservice.dto.CustomerRequestDTO;
import com.enset.customerservice.dto.CustomerResponseDTO;
import com.enset.customerservice.mappers.CustomerMapper;
import com.enset.customerservice.entities.Customer;
import com.enset.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{


    private CustomerRepository customerRepository;

    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOCustom(customerRequestDTO);
        Customer savecustomer =  customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(savecustomer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOCustom(customerRequestDTO);
        Customer savecustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(savecustomer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers
                .stream()
                .map(customer->customerMapper.customerToCustomerResponseDTO(customer)).
                collect(Collectors.toList());
    }
}
