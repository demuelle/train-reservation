package com.trilogyed.trainreservation.controller;

import com.trilogyed.trainreservation.viewModel.CustomerViewModel;
import com.trilogyed.trainreservation.service.TrainReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    TrainReservationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerViewModel createCustomer(@RequestBody @Valid CustomerViewModel customerViewModel) {
        customerViewModel = service.createCustomer(customerViewModel);
        return customerViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerViewModel getCustomer(@PathVariable("id") long customerId) {
        CustomerViewModel customerViewModel = service.getCustomer(customerId);
        if (customerViewModel == null) {
            throw new IllegalArgumentException("Customer could not be retrieved for id " + customerId);
        } else {
            return customerViewModel;
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody @Valid CustomerViewModel customerViewModel) {

        if (customerViewModel==null || customerViewModel.getId()< 1) {
            throw new IllegalArgumentException("Id in path must match id in view model");
        } else if (customerViewModel.getId() > 0) {
            service.updateCustomer(customerViewModel);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") long customerId) {
        service.deleteCustomer(customerId);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerViewModel> getAllCustomers() {
        List<CustomerViewModel> customers = service.getAllCustomers();
        if (customers == null || customers.isEmpty()) {
            throw new IllegalArgumentException("No customers were found");
        } else
            return customers;
    }
}
