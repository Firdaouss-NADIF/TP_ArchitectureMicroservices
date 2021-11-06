package com.enset.billingservice.services;

import com.enset.billingservice.dto.InvoiceRequestDTO;
import com.enset.billingservice.dto.InvoiceResponseDTO;
import com.enset.billingservice.exception.CustomerNotFoundException;
import com.enset.billingservice.feign.CustomerRestClient;
import com.enset.billingservice.mappers.InvoiceMapper;
import com.enset.billingservice.entities.Customer;
import com.enset.billingservice.entities.Invoice;
import com.enset.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService{
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException {
        Invoice invoice = invoiceMapper.fromInvoiceResponseDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        Invoice save = invoiceRepository.save(invoice);
        return invoiceMapper.invoiceToInvoiceResponseDTO(save);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        Customer customer = customerRestClient.customerById(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceResponseDTO(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepository.findCustomerById(customerId);
        for (Invoice invoice :invoices) {
            Customer customer = customerRestClient.customerById(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream()
                .map(invoice->invoiceMapper.invoiceToInvoiceResponseDTO(invoice))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> getAllInvoice() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for (Invoice invoice :invoices) {
            Customer customer = customerRestClient.customerById(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return  invoices.stream()
                .map(invoice->invoiceMapper.invoiceToInvoiceResponseDTO(invoice))
                .collect(Collectors.toList());
    }
}

