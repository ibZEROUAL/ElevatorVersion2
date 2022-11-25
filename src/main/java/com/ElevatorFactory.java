package com;

public class ElevatorFactory {
    public static Elevator createElevator(String id, int currentFloor) {
        return new Elevator(id, currentFloor);
    }
}
