package com.trilogyed.trainreservation.viewModel;

import com.trilogyed.trainreservation.model.Ticket;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class TicketViewModel {
    private Long id;

    @NotNull(message = "Route id is required")
    @Min(value = 1, message = "Min route id is 1")
    private int routeId;

    @NotNull(message = "Customer id is required")
    @Min(value = 1, message = "Min customer id is 1")
    private int customerId;

    @NotEmpty(message = "First name is required")
    private String firstName;

    @NotNull(message = "Source station id is required")
    @Min(value = 1, message = "Min source station id is 1")
    private int sourceStationId;

    @NotNull(message = "Destination station id is required")
    @Min(value = 1, message = "Min destination station id is 1")
    private int destinationStationId;

    @NotNull(message = "Ticket date is required")
    private Date ticketDate;

    // Fixed from NotEmpty
    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotEmpty(message = "Seat no is required")
    private String seatNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) { this.routeId = routeId; }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getSourceStationId() {
        return sourceStationId;
    }

    public void setSourceStationId(int sourceStationId) {
        this.sourceStationId = sourceStationId;
    }

    public int getDestinationStationId() {
        return destinationStationId;
    }

    public void setDestinationStationId(int destinationStationId) {
        this.destinationStationId = destinationStationId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketViewModel that = (TicketViewModel) o;
        return routeId == that.routeId && customerId == that.customerId && sourceStationId == that.sourceStationId && destinationStationId == that.destinationStationId && Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(ticketDate, that.ticketDate) && Objects.equals(price, that.price) && Objects.equals(seatNo, that.seatNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId, customerId, firstName, sourceStationId, destinationStationId, ticketDate, price, seatNo);
    }

    @Override
    public String toString() {
        return "TicketViewModel{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", sourceStationId=" + sourceStationId +
                ", destinationStationId=" + destinationStationId +
                ", ticketDate=" + ticketDate +
                ", price=" + price +
                ", seatNo='" + seatNo + '\'' +
                '}';
    }
}
