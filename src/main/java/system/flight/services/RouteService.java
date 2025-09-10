package system.flight.services;

import system.flight.dto.RouteDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface RouteService {

	public RouteDTO createRoute(RouteDTO routeDTO);

	public List<RouteDTO> getAllRoutes();

	public List<RouteDTO> getRoutesBySourceCity(String sourceCity);

	public List<RouteDTO> getRoutesByDestinationCity(String destinationCity);

	public List<RouteDTO> getRoutesByArrivalTime(LocalDateTime arrivalTime);

	public List<RouteDTO> getRoutesByDepartureTime(LocalDateTime departureTime);

	public RouteDTO getRouteById(int id);

	public RouteDTO updateRoute(int routeId, RouteDTO routeDTO);

	public void deleteRoute(int routeId);
}