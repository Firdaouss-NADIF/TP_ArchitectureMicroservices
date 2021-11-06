package com.enset.billingservice.mappers;


import com.enset.billingservice.dto.InvoiceRequestDTO;
import com.enset.billingservice.dto.InvoiceResponseDTO;
import com.enset.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceResponseDTO invoiceToInvoiceResponseDTO(Invoice invoice);
    Invoice fromInvoiceResponseDTO(InvoiceRequestDTO invoiceRequestDTO);
}

