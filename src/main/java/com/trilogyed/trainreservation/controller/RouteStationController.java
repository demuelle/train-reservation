package com.trilogyed.trainreservation.controller;

import com.trilogyed.trainreservation.viewModel.RouteStationViewModel;
import com.trilogyed.trainreservation.service.TrainReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/routestation")
public class RouteStationController {

    @Autowired
    TrainReservationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RouteStationViewModel createRouteStation(@RequestBody @Valid RouteStationViewModel routeStationViewModel) {
        routeStationViewModel = service.createRouteStation(routeStationViewModel);
        return routeStationViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RouteStationViewModel getRouteStation(@PathVariable("id") long routeStationId) {
        RouteStationViewModel routeStationViewModel = service.getRouteStation(routeStationId);
        if (routeStationViewModel == null) {
            throw new IllegalArgumentException("Route Station could not be retrieved for id " + routeStationId);
        } else {
            return routeStationViewModel;
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRouteStation(@RequestBody @Valid RouteStationViewModel routeStationViewModel) {

        if (routeStationViewModel==null || routeStationViewModel.getId()< 1) {
            throw new IllegalArgumentException("Id in path must match id in view model");
        } else if (routeStationViewModel.getId() > 0) {
            service.updateRouteStation(routeStationViewModel);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRouteStation(@PathVariable("id") long routeStationId) { service.deleteRoute(routeStationId); }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<RouteStationViewModel> getAllRouteStations() {
        List<RouteStationViewModel> routeStations = service.getAllRouteStations();
        if (routeStations == null || routeStations.isEmpty()) {
            throw new IllegalArgumentException("No route stations were found");
        } else
            return routeStations;
    }
}
