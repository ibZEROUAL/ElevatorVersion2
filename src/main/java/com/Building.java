package com;

import com.interfaces.ElevatorInterface;
import com.interfaces.ElevatorInterfaceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Building {

    public List<Elevator> elevators = new ArrayList<>();
    public int numberOfFloors;

     ElevatorInterface elevatorInterface = new ElevatorInterfaceImpl();

     public Building(int numberOfFloors, String ...elevatorsInfos) {

        this.numberOfFloors = numberOfFloors;

        Arrays.stream(elevatorsInfos).forEach(e->{
            elevators.add(ElevatorFactory.createElevator(e));
        });
    }
        public String requestElevator () {
            return requestElevator(10);
        }
         public String requestElevator( int requestedFloor){
           return this.elevatorInterface.getClosestElevator(elevators,numberOfFloors,requestedFloor);
         }

        public void move (String id, String state){
             this.elevatorInterface.changeElevatorState(elevators,id,state);
         }


        public void stopAt (String id,int i){
            this.elevatorInterface.changeElevatorState(elevators,id,String.valueOf(State.STOP));
        }
}

