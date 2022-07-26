package com.trilogyed.trainreservation.controller;

import com.trilogyed.trainreservation.viewModel.TrainViewModel;
import com.trilogyed.trainreservation.service.TrainReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/train")
public class TrainController {

    @Autowired
    TrainReservationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainViewModel createTrain(@RequestBody @Valid TrainViewModel trainViewModel) {
        trainViewModel = service.createTrain(trainViewModel);
        return trainViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainViewModel getTrain(@PathVariable("id") long trainId) {
        TrainViewModel trainViewModel = service.getTrain(trainId);
        if (trainViewModel == null) {
            throw new IllegalArgumentException("Train could not be retrieved for id " + trainId);
        } else {
            return trainViewModel;
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrain(@RequestBody @Valid TrainViewModel trainViewModel) {

        if (trainViewModel==null || trainViewModel.getId()< 1) {
            throw new IllegalArgumentException("Id in path must match id in view model");
        } else if (trainViewModel.getId() > 0) {
            service.updateTrain(trainViewModel);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrain(@PathVariable("id") long trainId) {
        service.deleteTrain(trainId);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TrainViewModel> getAllTrains() {
        List<TrainViewModel> trains = service.getAllTrains();
        if (trains == null || trains.isEmpty()) {
            throw new IllegalArgumentException("No trains were found");
        } else
            return trains;
    }
}
