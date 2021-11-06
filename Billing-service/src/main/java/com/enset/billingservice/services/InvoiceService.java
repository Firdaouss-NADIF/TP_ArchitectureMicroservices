package com.enset.billingservice.services;

import com.enset.billingservice.dto.InvoiceRequestDTO;
import com.enset.billingservice.dto.InvoiceResponseDTO;
import com.enset.billingservice.exception.CustomerNotFoundException;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException;
    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);
    List<InvoiceResponseDTO> getAllInvoice();
}
