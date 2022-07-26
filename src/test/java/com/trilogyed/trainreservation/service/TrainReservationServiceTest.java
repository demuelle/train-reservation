package com.trilogyed.trainreservation.service;

import com.trilogyed.trainreservation.model.Customer;
import com.trilogyed.trainreservation.repository.*;
import com.trilogyed.trainreservation.viewModel.CustomerViewModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrainReservationServiceTest {

    private TrainReservationService service;
    private CustomerRepository customerRepository;
    private RouteRepository routeRepository;
    private RouteStationRepository routeStationRepository;
    private StationRepository stationRepository;
    private TicketRepository ticketRepository;
    private TrainRepository trainRepository;

    private Customer testCustomer;
    private CustomerViewModel testCustomerViewModel;
    private static final Long TEST_CUSTOMER_ID = new Long(1);

    @Before
    public void setUp() throws Exception {
        setupCustomerRepositoryMock();
        setupRouteRepositoryMock();
        setupStationRepositoryMock();
        setupRouteStationRepositoryMock();
        setupTicketRepositoryMock();
        setupTrainRepositoryMock();

        service = new TrainReservationService(customerRepository, trainRepository, stationRepository, routeRepository, routeStationRepository, ticketRepository);
    }

    private void setupCustomerRepositoryMock() {
        customerRepository = mock(CustomerRepository.class);
        testCustomer = new Customer();
        testCustomer.setId(TEST_CUSTOMER_ID);
        testCustomer.setFirstName("Jess");
        testCustomer.setLastName("Jablonsky");
        testCustomer.setEmail("jj@jimmy.com");
        testCustomer.setMobile("8765434565");
        testCustomer.setPassword("pass");

        testCustomerViewModel = new CustomerViewModel();
        testCustomerViewModel.setId(TEST_CUSTOMER_ID);
        testCustomerViewModel.setFirstName("Jess");
        testCustomerViewModel.setLastName("Jablonsky");
        testCustomerViewModel.setEmail("jj@jimmy.com");
        testCustomerViewModel.setMobile("8765434565");
        testCustomerViewModel.setPassword("pass");

        when(customerRepository.findById(TEST_CUSTOMER_ID)).thenReturn(Optional.of(testCustomer));
    }

    private void setupRouteRepositoryMock() {
        routeRepository = mock(RouteRepository.class);
    }

    private void setupRouteStationRepositoryMock() {
        routeStationRepository = mock(RouteStationRepository.class);
    }

    private void setupStationRepositoryMock() {
        stationRepository = mock(StationRepository.class);
    }

    private void setupTicketRepositoryMock() {
        ticketRepository = mock(TicketRepository.class);
    }

    private void setupTrainRepositoryMock() {
        trainRepository = mock(TrainRepository.class);
    }

    @Test
    public void shouldGetCustomerById() {
        // Arrange
        CustomerViewModel expectedCustomer = testCustomerViewModel;

        // Act
        CustomerViewModel actualResult = service.getCustomer(TEST_CUSTOMER_ID);

        // Assert
        assertEquals(expectedCustomer, actualResult);
    }
}