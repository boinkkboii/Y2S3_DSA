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
        return group.getGroupSize() <= remainingCapacity;
    }

    public void assignGroup(Group group) {
        if (canFit(group)) {
            assignedGroups.add(group);
            remainingCapacity -= group.getGroupSize();
        }
    }

    public List<Group> getAssignedGroups() {
        return assignedGroups;
    };

    public String getVehicleId() {
        return vehicleId;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    @Override
    public String toString() {
        String output = vehicleId + " [" + (capacity - remainingCapacity) + "/" + capacity + "] ";

        for (Group group : assignedGroups) {
            output += "[" + group.getGroupId() + "(" + group.getGroupSize() + ")] ";
        }

        return output.trim();
    }
}