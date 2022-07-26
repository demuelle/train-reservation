package com.trilogyed.trainreservation.viewModel;

import com.trilogyed.trainreservation.model.Station;

import javax.validation.constraints.*;
import java.util.Objects;

public class StationViewModel {
    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Station code is required")
    private String stationCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationViewModel that = (StationViewModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(stationCode, that.stationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stationCode);
    }

    @Override
    public String toString() {
        return "StationViewModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stationCode='" + stationCode + '\'' +
                '}';
    }
}
