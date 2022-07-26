package com.trilogyed.trainreservation.controller;

import com.trilogyed.trainreservation.viewModel.StationViewModel;
import com.trilogyed.trainreservation.service.TrainReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/station")
public class StationController {

    @Autowired
    TrainReservationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StationViewModel createStation(@RequestBody @Valid StationViewModel stationViewModel) {
        stationViewModel = service.createStation(stationViewModel);
        return stationViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StationViewModel getStation(@PathVariable("id") long stationId) {
        StationViewModel stationViewModel = service.getStation(stationId);
        if (stationViewModel == null) {
            throw new IllegalArgumentException("Station could not be retrieved for id " + stationId);
        } else {
            return stationViewModel;
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStation(@RequestBody @Valid StationViewModel stationViewModel) {

        if (stationViewModel==null || stationViewModel.getId()< 1) {
            throw new IllegalArgumentException("Id in path must match id in view model");
        } else if (stationViewModel.getId() > 0) {
            service.updateStation(stationViewModel);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStation(@PathVariable("id") long stationId) {
        service.deleteStation(stationId);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<StationViewModel> getAllStations() {
        List<StationViewModel> stations = service.getAllStations();
        if (stations == null || stations.isEmpty()) {
            throw new IllegalArgumentException("No stations were found");
        } else
            return stations;
    }
}
