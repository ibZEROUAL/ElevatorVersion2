package com;

public class Elevator {

      private String id;
      private State state;
      int currentFloor;

      Elevator(String id, int currentFloor) {
        this.id = id;
        this.state = State.REST;
        this.currentFloor = currentFloor;
     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(String state) {
        this.state = State.valueOf(state);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
