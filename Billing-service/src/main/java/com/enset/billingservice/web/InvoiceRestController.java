package com.enset.billingservice.web;

import com.enset.billingservice.dto.InvoiceRequestDTO;
import com.enset.billingservice.dto.InvoiceResponseDTO;
import com.enset.billingservice.exception.CustomerNotFoundException;
import com.enset.billingservice.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {

    private InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoices/")
    public List<InvoiceResponseDTO> getAllInvoice(){
        return invoiceService.getAllInvoice();
    }

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable String id){
        return invoiceService.getInvoice(id);
    }

    @GetMapping(path = "/invoiceByCustomer/{id}")
    public List<InvoiceResponseDTO> getInvoicesByCustomers(@PathVariable String id){
        return invoiceService.invoicesByCustomerId(id);
    }

    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException {
        return invoiceService.save(invoiceRequestDTO);
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e){
        return e.getMessage();
    }

}
