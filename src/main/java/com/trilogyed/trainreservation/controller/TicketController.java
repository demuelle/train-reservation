package com.trilogyed.trainreservation.controller;

import com.trilogyed.trainreservation.viewModel.TicketViewModel;
import com.trilogyed.trainreservation.service.TrainReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    @Autowired
    TrainReservationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketViewModel createTicket(@RequestBody @Valid TicketViewModel ticketViewModel) {
        ticketViewModel = service.createTicket(ticketViewModel);
        return ticketViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TicketViewModel getTicket(@PathVariable("id") long ticketId) {
        TicketViewModel ticketViewModel = service.getTicket(ticketId);
        if (ticketViewModel == null) {
            throw new IllegalArgumentException("Ticket could not be retrieved for id " + ticketId);
        } else {
            return ticketViewModel;
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTicket(@RequestBody @Valid TicketViewModel ticketViewModel) {

        if (ticketViewModel==null || ticketViewModel.getId()< 1) {
            throw new IllegalArgumentException("Id in path must match id in view model");
        } else if (ticketViewModel.getId() > 0) {
            service.updateTicket(ticketViewModel);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicket(@PathVariable("id") long ticketId) {
        service.deleteTicket(ticketId);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TicketViewModel> getAllTickets() {
        List<TicketViewModel> tickets = service.getAllTickets();
        if (tickets == null || tickets.isEmpty()) {
            throw new IllegalArgumentException("No tickets were found");
        } else
            return tickets;
    }
}
