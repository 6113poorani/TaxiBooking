package dto;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
        static int id=1;
        private int taxiId;
    private  int freeTime;
    private  int totalEarning;
    private  char currentSpot;
    private  List<String> trip;



    public void setTaxiId() {
        this.taxiId = id++;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public void setTotalEarning(int totalEarning) {
        this.totalEarning = totalEarning;
    }

    public void setCurrentSpot(char currentSpot) {
        this.currentSpot = currentSpot;
    }

    public void setTrip(List<String> trip) {
        this.trip = trip;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public int getTotalEarning() {
        return totalEarning;
    }

    public char getCurrentSpot() {
        return currentSpot;
    }

    public List<String> getTrip() {
        return trip;
    }
}
