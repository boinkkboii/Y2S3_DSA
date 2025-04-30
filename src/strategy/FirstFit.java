package strategy;

import model.Group;
import model.Vehicle;

import java.util.*;

public class FirstFit implements BinPackingStrategy {
    @Override
    public ArrayList<Vehicle> pack(List<Group> groups, ArrayList<Vehicle> emptyVehicles) {
        groups.sort((a, b) -> b.getGroupSize() - a.getGroupSize());

        for (Group group : groups) {
            boolean placed = false;
            for (Vehicle v : emptyVehicles) {
                if (v.canFit(group)) {
                    v.assignGroup(group);
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                System.out.println("Group " + group.getGroupId() + " could not be assigned.");
            }
        }

        return emptyVehicles;
    }
}
