package com;

public class ElevatorFactory {
    public static Elevator createElevator(String elevator) {
        String idElevator = elevator.split(":")[0];
        int currentFloor = Integer.parseInt(elevator.split(":")[1]);
        return new Elevator(idElevator, currentFloor);
    }
}
