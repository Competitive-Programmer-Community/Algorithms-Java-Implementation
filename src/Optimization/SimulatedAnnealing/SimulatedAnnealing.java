package Optimization.SimulatedAnnealing;

import java.util.ArrayList;
import java.util.List;

public class SimulatedAnnealing {

    public static void main(String[] args) {

        List<City> cities = new ArrayList<>();
        cities.add(new City(5298, 3001, "Los Angeles"));
        cities.add(new City(814, 6223, "Beijing"));
        cities.add(new City(4808, 5675, "Shanghai"));
        cities.add(new City(3716, 8648, "New York"));
        cities.add(new City(3464, 5035, "San Frisco"));
        cities.add(new City(115, 5141, "Seattle"));
        cities.add(new City(3983, 1263, "Shenzhen"));

        Route curRoute = new Route(cities);
        Route bestRoute = new Route(curRoute);
        System.out.println(curRoute.toString());
        System.out.println();

        double temperature = 1000;
        double coolingRate = 0.01;
        double min_temperature = 1;

        while(temperature > min_temperature) {
            Route newRoute = new Route(curRoute);
            int index1 = Utility.randomInt(0, newRoute.getRoute().size());
            int index2 = Utility.randomInt(0, newRoute.getRoute().size());
            while (index1 == index2) {
                index2 = Utility.randomInt(0, newRoute.getRoute().size());
            }

            City city1 = newRoute.getCity(index1);
            City city2 = newRoute.getCity(index2);
            newRoute.setCity(index1, city2);
            newRoute.setCity(index2, city1);

            double curDistance = curRoute.getTotalDistance();
            double newDistance = newRoute.getTotalDistance();

            if (Utility.acceptProbability(curDistance, newDistance, temperature) > Utility.randomDouble()) {
                curRoute = newRoute;
            }

            System.out.println(curRoute.toString());

            if (curRoute.getTotalDistance() < bestRoute.getTotalDistance()) {
                bestRoute = new Route(curRoute);
            }

            temperature = temperature * (1 - coolingRate);
        }

        System.out.println();
        System.out.println(bestRoute.toString());
    }
}
