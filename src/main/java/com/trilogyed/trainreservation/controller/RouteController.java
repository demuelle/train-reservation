package com.trilogyed.trainreservation.controller;

import com.trilogyed.trainreservation.viewModel.RouteViewModel;
import com.trilogyed.trainreservation.service.TrainReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/route")
public class RouteController {

    @Autowired
    TrainReservationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RouteViewModel createRoute(@RequestBody @Valid RouteViewModel routeViewModel) {
        routeViewModel = service.createRoute(routeViewModel);
        return routeViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RouteViewModel getRoute(@PathVariable("id") long routeId) {
        RouteViewModel routeViewModel = service.getRoute(routeId);
        if (routeViewModel == null) {
            throw new IllegalArgumentException("Route could not be retrieved for id " + routeId);
        } else {
            return routeViewModel;
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRoute(@RequestBody @Valid RouteViewModel routeViewModel) {

        if (routeViewModel==null || routeViewModel.getId()< 1) {
            throw new IllegalArgumentException("Id in path must match id in view model");
        } else if (routeViewModel.getId() > 0) {
            service.updateRoute(routeViewModel);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoute(@PathVariable("id") long routeId) {
        service.deleteRoute(routeId);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<RouteViewModel> getAllRoutes() {
        List<RouteViewModel> routes = service.getAllRoutes();
        if (routes == null || routes.isEmpty()) {
            throw new IllegalArgumentException("No routes were found");
        } else
            return routes;
    }
}
