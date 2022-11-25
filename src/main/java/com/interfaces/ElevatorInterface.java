package com.interfaces;

import com.Elevator;

import java.util.List;

public interface ElevatorInterface {

    String getClosestElevator(List<Elevator> elevators,int numberOfFloors, int requestedFloor);
    void changeElevatorState(List<Elevator> elevators,String idElevator,String state);

}
