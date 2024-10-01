package screens.taxiview;

import dto.Taxi;

import java.util.List;

public class TaxiViewScreen {
    private TaxiViewModel viewModel;
    public TaxiViewScreen(){
        viewModel=new TaxiViewModel(this);
    }

    public  List<Taxi> createTaxi(int i) {
        return viewModel.createTaxi(i);
    }

    public void printTaxiDetails(List<Taxi> taxis) {
        for(int i=0;i<taxis.size();i++){
            Taxi t=taxis.get(i);
            System.out.println("Taxi Id : "+t.getTaxiId()+"   "+"Taxi CurrentSpot : "+t.getCurrentSpot()+"    Taxi Free Time "+t.getFreeTime()+"  Taxi totalEarning : "+t.getTotalEarning());


        }
        System.out.println("-----------------");
    }


    public void printTripDetails(List<Taxi> taxis) {
        System.out.println("TaxiId      pickUpTime      DropTime       From        To       cost");
        for(int i=0;i<taxis.size();i++){
            Taxi t=taxis.get(i);
            for(int j=0;j<t.getTrip().size();j++){
                System.out.println(t.getTrip().get(j));
            }
        }
        System.out.println("----------------------");
    }
}
