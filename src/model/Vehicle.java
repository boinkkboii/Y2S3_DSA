package model;

import java.util.*;

public abstract class Vehicle {
    protected String vehicleId;
    protected int capacity;
    protected int remainingCapacity;
    protected List<Group> assignedGroups;

    public Vehicle(String vehicleId, int capacity) {
        this.vehicleId = vehicleId;
        this.capacity = capacity;
        this.remainingCapacity = capacity;
        this.assignedGroups = new ArrayList<>();
    }

    public boolean canFit(Group group) {
        return group.getSize() <= remainingCapacity;
    }

    public boolean assignGroup(Group group) {
        if (remainingCapacity >= group.getSize()) {
            assignedGroups.add(group);
            remainingCapacity -= group.getSize();
            return true;
        }
        return false;
    }

    public List<Group> getAssignedGroups() {
        return assignedGroups;
    };

    public String getVehicleId() {
        return vehicleId;
    }

    public int getCapacity () {
        return capacity;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    @Override
    public String toString() {
        String output = vehicleId + " [" + (capacity - remainingCapacity) + "/" + capacity + "] \n";
        int count = 0;
        for (Group group : assignedGroups) {
            output += group.getId() + "(" + group.getSize() + ") ";
                count++;
            if (count % 5 == 0) {
                output += "\n";
            }
        }

        return output.trim() + "\n";
    }
}