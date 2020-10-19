package Optimization.SimulatedAnnealing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Route {

    private List<City> route;
    private double totalDistance;

    public Route(List<City> cities) {
        this.route = new ArrayList<City>(cities);
        this.totalDistance = 0;
    }

    public Route(Route other) {
        this.route = new ArrayList<City>(other.getRoute());
        this.totalDistance = 0;
    }

    public List<City> getRoute() {
        return this.route;
    }

    public City getCity(int index) {
        return this.route.get(index);
    }

    public void setCity(int index, City city) {
        this.route.set(index, city);
        this.totalDistance = 0;
    }

    public void generateNewRoute(List<City> cities) {
        this.route = new ArrayList<City>(cities);
        Collections.shuffle(this.route);
        this.totalDistance = 0;
    }

    public double getTotalDistance() {
        if (this.totalDistance == 0) {
            for (int i = 0; i < this.route.size(); i++) {
                if (i + 1 != this.route.size()) {
                    this.totalDistance += Utility.distance(this.route.get(i), this.route.get(i + 1));
                } else {
                    this.totalDistance += Utility.distance(this.route.get(i), this.route.get(0));
                }

            }
        }

        return this.totalDistance;
    }

    @Override
    public String toString() {
        String answer = this.route.get(0).getName();
        for (int i = 1; i < this.route.size(); i++) {
            answer = answer + " -> " + this.route.get(i).getName();
        }

        answer = answer + "; Total distance: " + getTotalDistance();
        return answer;
    }
}
