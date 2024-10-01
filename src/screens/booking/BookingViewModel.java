package screens.booking;

import dto.Taxi;

import java.util.ArrayList;
import java.util.List;

public class BookingViewModel {
    private BookingScreen view;
    BookingViewModel(BookingScreen bookingScreen){
        this.view=bookingScreen;
    }

    public boolean isValid(char source, char destination, int pickUpTime) {
        if(source<'A'||destination>'E'){
            return false;
        }
        if(source>'E'||destination<'A'){
            return false;
        }
        if(pickUpTime<6)
            return false;
        return true;
    }

    public List<Taxi> getFreeTaxi(int pickUpTime,List<Taxi> taxis,char source) {
        List<Taxi> availableTaxi=new ArrayList<>();
        for(Taxi t:taxis){
            if(t.getFreeTime()<=pickUpTime&&(Math.abs((source-'0')-(t.getCurrentSpot()-'0'))+t.getFreeTime()<=pickUpTime)){
                availableTaxi.add(t);
            }
        }
        return availableTaxi;
    }

    public void bookTaxi(List<Taxi> availableTaxi, char source, char destination,int pickUpTime) {
        int min=999;
        Taxi booked=null;

        for(Taxi t:availableTaxi){
            if(min>Math.abs((source-'0')-(t.getCurrentSpot()-'0'))){
                min=Math.abs((source-'0')-(t.getCurrentSpot()-'0'));
                booked=t;
            }
        }
       setTaxiUpdate(booked,source,destination,pickUpTime);
       view.navigateToSuccessfull("Taxi No "+booked.getTaxiId()+" Booked Successfully!!!");

    }

    private void setTaxiUpdate(Taxi bookedTaxi, char source, char destination,int pickUpTime) {

        bookedTaxi.setCurrentSpot(destination);
        int dis=(Math.abs((destination-'0')-(source-'0')));
        bookedTaxi.setFreeTime(pickUpTime+dis);
        int cost=((dis*15)-5)*10+100;
        bookedTaxi.setTotalEarning(bookedTaxi.getTotalEarning()+cost);
        List<String> tempTrip=bookedTaxi.getTrip();
        tempTrip.add(   bookedTaxi.getTaxiId()+"              "+pickUpTime+"              "+(pickUpTime+dis)+"           "+source+"          "+destination+"         "+cost);
    }
}
