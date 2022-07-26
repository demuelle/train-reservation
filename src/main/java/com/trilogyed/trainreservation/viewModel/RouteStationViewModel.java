package com.trilogyed.trainreservation.viewModel;

import com.trilogyed.trainreservation.model.RouteStation;

import javax.validation.constraints.*;
import java.sql.Time;
import java.util.Objects;

public class RouteStationViewModel {
    private Long id;

    @NotNull(message = "Route id is required")
    @Min(value = 1, message = "Min route id is 1")
    private int routeId;

    @NotNull(message = "Station id is required")
    @Min(value = 1, message = "Min station id is 1")
    private int stationId;

    private Time scheduledArrival;
    private Time scheduledDeparture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public Time getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(Time scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public Time getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(Time scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteStationViewModel that = (RouteStationViewModel) o;
        return routeId == that.routeId && stationId == that.stationId && Objects.equals(id, that.id) && Objects.equals(scheduledArrival, that.scheduledArrival) && Objects.equals(scheduledDeparture, that.scheduledDeparture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId, stationId, scheduledArrival, scheduledDeparture);
    }

    @Override
    public String toString() {
        return "RouteStationViewModel{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", stationId=" + stationId +
                ", scheduledArrival=" + scheduledArrival +
                ", scheduledDeparture=" + scheduledDeparture +
                '}';
    }
}
