package com.trilogyed.trainreservation.service;

import com.trilogyed.trainreservation.model.Customer;
import com.trilogyed.trainreservation.repository.CustomerRepository;
import com.trilogyed.trainreservation.viewModel.CustomerViewModel;
import com.trilogyed.trainreservation.model.Train;
import com.trilogyed.trainreservation.repository.TrainRepository;
import com.trilogyed.trainreservation.viewModel.TrainViewModel;
import com.trilogyed.trainreservation.model.Station;
import com.trilogyed.trainreservation.repository.StationRepository;
import com.trilogyed.trainreservation.viewModel.StationViewModel;
import com.trilogyed.trainreservation.model.Route;
import com.trilogyed.trainreservation.repository.RouteRepository;
import com.trilogyed.trainreservation.viewModel.RouteViewModel;
import com.trilogyed.trainreservation.model.RouteStation;
import com.trilogyed.trainreservation.repository.RouteStationRepository;
import com.trilogyed.trainreservation.viewModel.RouteStationViewModel;
import com.trilogyed.trainreservation.model.Ticket;
import com.trilogyed.trainreservation.repository.TicketRepository;
import com.trilogyed.trainreservation.viewModel.TicketViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TrainReservationService {

    CustomerRepository customerRepo;
    TrainRepository trainRepo;
    StationRepository stationRepo;
    RouteRepository routeRepo;
    RouteStationRepository routeStationRepo;
    TicketRepository ticketRepo;

    @Autowired
    public TrainReservationService(CustomerRepository customerRepo, TrainRepository trainRepo, StationRepository stationRepo,
                                   RouteRepository routeRepo, RouteStationRepository routeStationRepo, TicketRepository ticketRepo)
    {
        this.customerRepo = customerRepo;
        this.trainRepo = trainRepo;
        this.stationRepo = stationRepo;
        this.routeRepo = routeRepo;
        this.routeStationRepo = routeStationRepo;
        this.ticketRepo = ticketRepo;
    }

    //CUSTOMER SERVICE LAYER

    public CustomerViewModel createCustomer(CustomerViewModel customerViewModel) {

        if (customerViewModel==null) throw new IllegalArgumentException("No Customer is passed! Customer object is null!");

        Customer customer = new Customer();
        customer.setFirstName(customerViewModel.getFirstName());
        customer.setLastName(customerViewModel.getLastName());
        customer.setEmail(customerViewModel.getEmail());
        customer.setPassword(customerViewModel.getPassword());
        customer.setMobile(customerViewModel.getMobile());

        customer = customerRepo.save(customer);

        return buildCustomerViewModel(customer);
    }

    public CustomerViewModel getCustomer(long id) {
        Optional<Customer> tCustomer = customerRepo.findById(id);
        if (tCustomer == null)
            return null;
        else
            return buildCustomerViewModel(tCustomer.get());
    }

    public void updateCustomer(CustomerViewModel customerViewModel) {

        if (customerViewModel==null) throw new IllegalArgumentException("No Customer is passed! Customer object is null!");

        //make sure the Customer exists. and if not, throw exception...
        if (this.getCustomer(customerViewModel.getId())==null)
            throw new IllegalArgumentException("No such Customer to update.");

        Customer customer = new Customer();
        customer.setId(customerViewModel.getId());
        customer.setFirstName(customerViewModel.getFirstName());
        customer.setLastName(customerViewModel.getLastName());
        customer.setEmail(customerViewModel.getEmail());
        customer.setPassword(customerViewModel.getPassword());
        customer.setMobile(customerViewModel.getMobile());

        customerRepo.save(customer);
    }

    public void deleteCustomer(long id) {
        customerRepo.deleteById(id);
    }

    public List<CustomerViewModel> getAllCustomers() {
        List<Customer> tShirtList = customerRepo.findAll();
        List<CustomerViewModel> tvmList = new ArrayList<>();

        if (tShirtList == null)
            return null;
        else
            tShirtList.stream().forEach(t -> tvmList.add(buildCustomerViewModel(t)));
        return tvmList;
    }

    //TRAIN SERVICE LAYER

    public TrainViewModel createTrain(TrainViewModel trainViewModel) {

        if (trainViewModel==null) throw new IllegalArgumentException("No Train is passed! Train object is null!");

        Train train = new Train();
        train.setName(trainViewModel.getName());
        train.setModel(trainViewModel.getModel());
        train.setManufacturer(trainViewModel.getManufacturer());
        train.setYear(trainViewModel.getYear());
        train.setTotalSeats(trainViewModel.getTotalSeats());
        train.setSeatLayout(trainViewModel.getSeatLayout());
        train.setPowerType(trainViewModel.getPowerType());

        train = trainRepo.save(train);

        return buildTrainViewModel(train);
    }

    public TrainViewModel getTrain(long id) {
        Optional<Train> tTrain = trainRepo.findById(id);
        if (tTrain == null)
            return null;
        else
            return buildTrainViewModel(tTrain.get());
    }

    public void updateTrain(TrainViewModel trainViewModel) {

        if (trainViewModel==null) throw new IllegalArgumentException("No Train is passed! Train object is null!");

        //make sure the Train exists. and if not, throw exception...
        if (this.getTrain(trainViewModel.getId())==null)
            throw new IllegalArgumentException("No such Train to update.");

        Train train = new Train();
        train.setId(trainViewModel.getId());
        train.setName(trainViewModel.getName());
        train.setModel(trainViewModel.getModel());
        train.setManufacturer(trainViewModel.getManufacturer());
        train.setYear(trainViewModel.getYear());
        train.setTotalSeats(trainViewModel.getTotalSeats());
        train.setSeatLayout(trainViewModel.getSeatLayout());
        train.setPowerType(trainViewModel.getPowerType());

        trainRepo.save(train);
    }

    public void deleteTrain(long id) {
        trainRepo.deleteById(id);
    }

    public List<TrainViewModel> getAllTrains() {
        List<Train> tTrainList = trainRepo.findAll();
        List<TrainViewModel> tvmList = new ArrayList<>();

        if (tTrainList == null)
            return null;
        else
            tTrainList.stream().forEach(t -> tvmList.add(buildTrainViewModel(t)));
        return tvmList;
    }

    //ROUTE SERVICE LAYER

    public RouteViewModel createRoute(RouteViewModel routeViewModel) {

        if (routeViewModel==null) throw new IllegalArgumentException("No Route is passed! Route object is null!");

        Route route = new Route();
        route.setRouteName(routeViewModel.getRouteName());
        route.setTrainId(routeViewModel.getTrainId());
        route.setSourceStationId(routeViewModel.getSourceStationId());
        route.setDestinationStationId(routeViewModel.getDestinationStationId());

        route = routeRepo.save(route);

        return buildRouteViewModel(route);
    }

    public RouteViewModel getRoute(long id) {
        Optional<Route> tRoute = routeRepo.findById(id);
        if (tRoute == null)
            return null;
        else
            return buildRouteViewModel(tRoute.get());
    }

    public void updateRoute(RouteViewModel routeViewModel) {

        if (routeViewModel==null) throw new IllegalArgumentException("No Route is passed! Route object is null!");

        //make sure the Route exists. and if not, throw exception...
        if (this.getRoute(routeViewModel.getId())==null)
            throw new IllegalArgumentException("No such Route to update.");

        Route route = new Route();
        route.setId(routeViewModel.getId());
        route.setRouteName(routeViewModel.getRouteName());
        route.setTrainId(routeViewModel.getTrainId());
        route.setSourceStationId(routeViewModel.getSourceStationId());
        route.setDestinationStationId(routeViewModel.getDestinationStationId());

        routeRepo.save(route);
    }

    public void deleteRoute(long id) {
        routeRepo.deleteById(id);
    }

    public List<RouteViewModel> getAllRoutes() {
        List<Route> tRouteList = routeRepo.findAll();
        List<RouteViewModel> tvmList = new ArrayList<>();

        if (tRouteList == null)
            return null;
        else
            tRouteList.stream().forEach(t -> tvmList.add(buildRouteViewModel(t)));
        return tvmList;
    }

    //STATION SERVICE LAYER

    public StationViewModel createStation(StationViewModel stationViewModel) {

        if (stationViewModel==null) throw new IllegalArgumentException("No Station is passed! Station object is null!");

        Station station = new Station();
        station.setName(stationViewModel.getName());
        station.setStationCode(stationViewModel.getStationCode());

        station = stationRepo.save(station);

        return buildStationViewModel(station);
    }

    public StationViewModel getStation(long id) {
        Optional<Station> tStation = stationRepo.findById(id);
        if (tStation == null)
            return null;
        else
            return buildStationViewModel(tStation.get());
    }

    public void updateStation(StationViewModel stationViewModel) {

        if (stationViewModel==null) throw new IllegalArgumentException("No Station is passed! Station object is null!");

        //make sure the Station exists. and if not, throw exception...
        if (this.getStation(stationViewModel.getId())==null)
            throw new IllegalArgumentException("No such Station to update.");

        Station station = new Station();
        station.setId(stationViewModel.getId());
        station.setName(stationViewModel.getName());
        station.setStationCode(stationViewModel.getStationCode());

        stationRepo.save(station);
    }

    public void deleteStation(long id) {
        stationRepo.deleteById(id);
    }

    public List<StationViewModel> getAllStations() {
        List<Station> tStationList = stationRepo.findAll();
        List<StationViewModel> tvmList = new ArrayList<>();

        if (tStationList == null)
            return null;
        else
            tStationList.stream().forEach(t -> tvmList.add(buildStationViewModel(t)));
        return tvmList;
    }

    //ROUTE STATION SERVICE LAYER

    public RouteStationViewModel createRouteStation(RouteStationViewModel routeStationViewModel) {

        if (routeStationViewModel==null) throw new IllegalArgumentException("No Route Station is passed! Route Station object is null!");

        RouteStation routeStation = new RouteStation();
        routeStation.setRouteId(routeStationViewModel.getRouteId());
        routeStation.setStationId(routeStationViewModel.getStationId());
        routeStation.setScheduledArrival(routeStationViewModel.getScheduledArrival());
        routeStation.setScheduledDeparture(routeStationViewModel.getScheduledDeparture());

        routeStation = routeStationRepo.save(routeStation);

        return buildRouteStationViewModel(routeStation);
    }

    public RouteStationViewModel getRouteStation(long id) {
        Optional<RouteStation> tRouteStation = routeStationRepo.findById(id);
        if (tRouteStation == null)
            return null;
        else
            return buildRouteStationViewModel(tRouteStation.get());
    }

    public void updateRouteStation(RouteStationViewModel routeStationViewModel) {

        if (routeStationViewModel==null) throw new IllegalArgumentException("No Route Station is passed! Station object is null!");

        //make sure the Route Station exists. and if not, throw exception...
        if (this.getRouteStation(routeStationViewModel.getId())==null)
            throw new IllegalArgumentException("No such Route Station to update.");

        RouteStation routeStation = new RouteStation();
        routeStation.setId(routeStationViewModel.getId());
        routeStation.setRouteId(routeStationViewModel.getRouteId());
        routeStation.setStationId(routeStationViewModel.getStationId());
        routeStation.setScheduledArrival(routeStationViewModel.getScheduledArrival());
        routeStation.setScheduledDeparture(routeStationViewModel.getScheduledDeparture());

        routeStationRepo.save(routeStation);
    }

    public void deleteRouteStation(long id) {
        routeStationRepo.deleteById(id);
    }

    public List<RouteStationViewModel> getAllRouteStations() {
        List<RouteStation> tRouteStationList = routeStationRepo.findAll();
        List<RouteStationViewModel> tvmList = new ArrayList<>();

        if (tRouteStationList == null)
            return null;
        else
            tRouteStationList.stream().forEach(t -> tvmList.add(buildRouteStationViewModel(t)));
        return tvmList;
    }

    //TICKET SERVICE LAYER

    public TicketViewModel createTicket(TicketViewModel ticketViewModel) {

        if (ticketViewModel==null) throw new IllegalArgumentException("No Ticket is passed! Ticket object is null!");

        Ticket ticket = new Ticket();
        ticket.setRouteId(ticketViewModel.getRouteId());
        ticket.setCustomerId(ticketViewModel.getCustomerId());
        ticket.setFirstName(ticketViewModel.getFirstName());
        ticket.setSourceStationId(ticketViewModel.getSourceStationId());
        ticket.setDestinationStationId(ticketViewModel.getDestinationStationId());
        ticket.setPrice(ticketViewModel.getPrice());
        ticket.setTicketDate(ticketViewModel.getTicketDate());
        ticket.setSeatNo(ticketViewModel.getSeatNo());

        ticket = ticketRepo.save(ticket);

        return buildTicketViewModel(ticket);
    }

    public TicketViewModel getTicket(long id) {
        Optional<Ticket> tTicket = ticketRepo.findById(id);
        if (tTicket == null)
            return null;
        else
            return buildTicketViewModel(tTicket.get());
    }

    public void updateTicket(TicketViewModel ticketViewModel) {

        if (ticketViewModel==null) throw new IllegalArgumentException("No Ticket is passed! Ticket object is null!");

        //make sure the Ticket exists. and if not, throw exception...
        if (this.getTicket(ticketViewModel.getId())==null)
            throw new IllegalArgumentException("No such Ticket to update.");

        Ticket ticket = new Ticket();
        ticket.setId(ticketViewModel.getId());
        ticket.setRouteId(ticketViewModel.getRouteId());
        ticket.setCustomerId(ticketViewModel.getCustomerId());
        ticket.setFirstName(ticketViewModel.getFirstName());
        ticket.setSourceStationId(ticketViewModel.getSourceStationId());
        ticket.setDestinationStationId(ticketViewModel.getDestinationStationId());
        ticket.setPrice(ticketViewModel.getPrice());
        ticket.setTicketDate(ticketViewModel.getTicketDate());
        ticket.setSeatNo(ticketViewModel.getSeatNo());

        ticketRepo.save(ticket);
    }

    public void deleteTicket(long id) {
        ticketRepo.deleteById(id);
    }

    public List<TicketViewModel> getAllTickets() {
        List<Ticket> tTicketList = ticketRepo.findAll();
        List<TicketViewModel> tvmList = new ArrayList<>();

        if (tTicketList == null)
            return null;
        else
            tTicketList.stream().forEach(t -> tvmList.add(buildTicketViewModel(t)));
        return tvmList;
    }

    //Helper Methods...

    public CustomerViewModel buildCustomerViewModel(Customer customer) {
        CustomerViewModel customerViewModel = new CustomerViewModel();
        customerViewModel.setId(customer.getId());
        customerViewModel.setFirstName(customer.getFirstName());
        customerViewModel.setLastName(customer.getLastName());
        customerViewModel.setEmail(customer.getEmail());
        customerViewModel.setPassword(customer.getPassword());
        customerViewModel.setMobile(customer.getMobile());

        return customerViewModel;
    }

    public TrainViewModel buildTrainViewModel(Train train) {
        TrainViewModel trainViewModel = new TrainViewModel();
        trainViewModel.setId(train.getId());
        trainViewModel.setName(train.getName());
        trainViewModel.setModel(train.getModel());
        trainViewModel.setManufacturer(train.getManufacturer());
        trainViewModel.setYear(train.getYear());
        trainViewModel.setTotalSeats(train.getTotalSeats());
        trainViewModel.setSeatLayout(train.getSeatLayout());
        trainViewModel.setPowerType(train.getPowerType());

        return trainViewModel;
    }

    public StationViewModel buildStationViewModel(Station station) {
        StationViewModel stationViewModel = new StationViewModel();
        stationViewModel.setId(station.getId());
        stationViewModel.setName(station.getName());
        stationViewModel.setStationCode(station.getStationCode());

        return stationViewModel;
    }

    public RouteViewModel buildRouteViewModel(Route route) {
        RouteViewModel routeViewModel = new RouteViewModel();
        routeViewModel.setId(route.getId());
        routeViewModel.setRouteName(route.getRouteName());
        routeViewModel.setTrainId(route.getTrainId());
        routeViewModel.setSourceStationId(route.getSourceStationId());
        routeViewModel.setDestinationStationId(route.getDestinationStationId());

        return routeViewModel;
    }

    public RouteStationViewModel buildRouteStationViewModel(RouteStation routeStation) {
        RouteStationViewModel routeStationViewModel = new RouteStationViewModel();
        routeStationViewModel.setId(routeStation.getId());
        routeStationViewModel.setRouteId(routeStation.getRouteId());
        routeStationViewModel.setStationId(routeStation.getStationId());
        routeStationViewModel.setScheduledArrival(routeStation.getScheduledArrival());
        routeStationViewModel.setScheduledDeparture(routeStation.getScheduledDeparture());

        return routeStationViewModel;
    }

    public TicketViewModel buildTicketViewModel(Ticket ticket) {
        TicketViewModel ticketViewModel = new TicketViewModel();
        ticketViewModel.setId(ticket.getId());
        ticketViewModel.setRouteId(ticket.getRouteId());
        ticketViewModel.setCustomerId(ticket.getCustomerId());
        ticketViewModel.setFirstName(ticket.getFirstName());
        ticketViewModel.setSourceStationId(ticket.getSourceStationId());
        ticketViewModel.setDestinationStationId(ticket.getDestinationStationId());
        ticketViewModel.setPrice(ticket.getPrice());
        ticketViewModel.setTicketDate(ticket.getTicketDate());
        ticketViewModel.setSeatNo(ticket.getSeatNo());

        return ticketViewModel;
    }
}
