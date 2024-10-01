package screens.booking;

import dto.Taxi;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookingScreen {
    private BookingViewModel viewModel;
    public BookingScreen(){
        viewModel=new BookingViewModel(this);
    }
    public void onCreate(List<Taxi> taxis) {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the Starting station : ");
        char source=scn.next().charAt(0);
        System.out.println("Enter the destination : ");
        char destination=scn.next().charAt(0);
        System.out.println("Enter the pickupTime : ");
        int pickUpTime=scn.nextInt();
       if( !viewModel.isValid(source,destination,pickUpTime)){
           System.out.println("Wrong source or destination or time!");
           return;
       }
       List<Taxi> availableTaxi=viewModel.getFreeTaxi(pickUpTime,taxis,source);
       if(availableTaxi.size()==0){
           System.out.println("No Taxi Available at that time");
           return;
       }
        Collections.sort(availableTaxi,
                (a,b)-> a.getTotalEarning()-b.getTotalEarning());
        viewModel.bookTaxi(availableTaxi,source,destination,pickUpTime);

    }

    public void navigateToSuccessfull(String s) {
        System.out.println(s);
    }
}
