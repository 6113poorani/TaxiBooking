package screens.taxiview;

import dto.Taxi;

import java.util.ArrayList;
import java.util.List;

public class TaxiViewModel {
    private TaxiViewScreen taxiViewScreen;
    TaxiViewModel(TaxiViewScreen taxiViewScreen){
        this.taxiViewScreen=taxiViewScreen;
    }
    public List<Taxi> createTaxi(int n) {
        List<Taxi> taxis=new ArrayList<>();
        for(int i=0;i<n;i++){
            Taxi newTaxi=new Taxi();
            newTaxi.setTaxiId();
            newTaxi.setCurrentSpot('A');
            newTaxi.setTotalEarning(0);
            newTaxi.setFreeTime(6);
            newTaxi.setTrip(new ArrayList<>());
            taxis.add(newTaxi);
        }
        return taxis;
    }


}
