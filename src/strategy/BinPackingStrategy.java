package strategy;

import model.Group;
import model.Vehicle;

import java.util.*;

public interface BinPackingStrategy {
    ArrayList<Vehicle> pack(List<Group> groups, ArrayList<Vehicle> emptyVehicles);
}
