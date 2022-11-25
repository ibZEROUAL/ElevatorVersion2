package com.interfaces;

import com.Elevator;
import com.State;

import java.util.Comparator;
import java.util.List;

public class ElevatorInterfaceImpl implements ElevatorInterface {

    @Override
    public String getClosestElevator(List<Elevator> elevators, int numberOfFloors, int requestedFloor) {

        String ElevatorId = null;

        if (requestedFloor!=10){

            int min = numberOfFloors;
            for (Elevator elevator : elevators) {
                if (Math.abs(elevator.getCurrentFloor() - requestedFloor) < min) {
                    min = Math.abs(elevator.getCurrentFloor() - requestedFloor);
                    ElevatorId = elevator.getId();
                }
            }
        }else {
            int ElevatorFloor = elevators.parallelStream()
                    .filter(e->e.getState() == State.REST || e.getState() == State.UP)
                    .map(Elevator::getCurrentFloor)
                    .max(Comparator.naturalOrder())
                    .get();

            ElevatorId = elevators.stream()
                    .filter(elevator -> elevator.getCurrentFloor() == ElevatorFloor)
                    .findFirst()
                    .get()
                    .getId();

        }
        return  ElevatorId;
    }

    @Override
    public void changeElevatorState(List<Elevator> elevators, String idElevator, String state) {
        Elevator elevatorWithId = elevators.parallelStream()
                .filter(elevator -> elevator.getId().equals(idElevator))
                .findFirst()
                .get();

        elevatorWithId.setState(state.toUpperCase());
    }
}
