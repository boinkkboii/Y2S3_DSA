package strategy;

import java.util.*;
import model.Group;
import model.Vehicle;

public class BestFit implements BinPackingStrategy {
    @Override
    public ArrayList<Vehicle> pack(List<Group> groups, ArrayList<Vehicle> emptyVehicles) {
        for (Group group : groups) {
            Vehicle bestFit = null;
            int minRemaining = Integer.MAX_VALUE;

            for (Vehicle v : emptyVehicles) {
                if (v.canFit(group)) {
                    int remaining = v.getRemainingCapacity() - group.getGroupSize();
                    if (remaining < minRemaining) {
                        minRemaining = remaining;
                        bestFit = v;
                    }
                }
            }

            if (bestFit != null) {
                bestFit.assignGroup(group);
            } else {
                System.out.println(group.getGroupId() + " could not be assigned.");
            }
        }

        return emptyVehicles;
    }
}
