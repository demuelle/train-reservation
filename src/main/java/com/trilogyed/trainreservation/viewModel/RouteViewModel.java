package com.trilogyed.trainreservation.viewModel;

import com.trilogyed.trainreservation.model.Route;

import javax.validation.constraints.*;
import java.util.Objects;

public class RouteViewModel {
    private Long id;

    @NotEmpty(message = "Route name is required")
    private String routeName;

    @NotNull(message = "Train id is required")
    @Min(value = 1, message = "Min train id is 1")
    private int trainId;

    @NotNull(message = "Source station id is required")
    @Min(value = 1, message = "Min source station id is 1")
    private int sourceStationId;

    @NotNull(message = "Destination station id is required")
    @Min(value = 1, message = "Min destination station id is 1")
    private int destinationStationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) { this.routeName = routeName; }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
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

    @Override
    public String toString() {
        return "RouteViewModel{" +
                "id=" + id +
                ", routeName='" + routeName + '\'' +
                ", trainId=" + trainId +
                ", sourceStationId=" + sourceStationId +
                ", destinationStationId=" + destinationStationId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteViewModel that = (RouteViewModel) o;
        return trainId == that.trainId && sourceStationId == that.sourceStationId && destinationStationId == that.destinationStationId && Objects.equals(id, that.id) && Objects.equals(routeName, that.routeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeName, trainId, sourceStationId, destinationStationId);
    }
}
