import java.util.*;
import model.*;
import strategy.*;
import util.GroupLoader;

public class Main {
    public static void main(String[] args) {
        //Insert number of buses and trains to fit the groups in
        int numBuses;
        int numTrains;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of trains to use: ");
            numTrains = scanner.nextInt();
            System.out.print("Enter the number of buses to use: ");
            numBuses = scanner.nextInt();
        }

        //Load groups from external csv file "groups.csv"
        List<Group> groups = GroupLoader.loadGroups("data/groups.csv");

        //Create and insert both buses and trains into a list
        List<Vehicle> firstFitVehicles = new ArrayList<>(); //List of vehicle for First Fit strategy
        for (int i = 1; i <= numTrains; i++) firstFitVehicles.add(new Train("Train " + i));
        for (int i = 1; i <= numBuses; i++) firstFitVehicles.add(new Bus("Bus " + i));
        
        List<Vehicle> bestFitVehicles = new ArrayList<>(); //List of vehicle for Best Fit strategy
        for (int i = 1; i <= numTrains; i++) bestFitVehicles.add(new Train("Train " + i));
        for (int i = 1; i <= numBuses; i++) bestFitVehicles.add(new Bus("Bus " + i));

        //Run First Fit Decreasing strategy
        System.out.println("First Fit :");
        BinPackingStrategy ff = new FirstFit();
        List<Vehicle> firstFitResults = ff.pack(new ArrayList<>(groups), new ArrayList<>(firstFitVehicles));
        printResults(firstFitResults);

        //Run Best Fit Strategy
        System.out.println("\nBest Fit :");
        BinPackingStrategy bf = new BestFit();
        List<Vehicle> bestFitResult = bf.pack(new ArrayList<>(groups), new ArrayList<>(bestFitVehicles));
        printResults(bestFitResult);
    }

    private static void printResults(List<Vehicle> vehicles) {
        int usedVehicles = 0;
        int totalGroups = 0;
        int totalUnusedSeats = 0;
        
        for (Vehicle v : vehicles) {
            if (!v.getAssignedGroups().isEmpty()) {
                System.out.println(v);
                usedVehicles++;
                totalGroups += v.getAssignedGroups().size();
                totalUnusedSeats += v.getRemainingCapacity();
            }
        }

        System.out.println("Summary for ");
        System.out.println("Total Vehicles Used: " + usedVehicles);
        System.out.println("Total Groups Assigned: " + totalGroups);
        System.out.println("Unused Seats: " + totalUnusedSeats);
    }
}