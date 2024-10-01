import dto.Taxi;
import screens.booking.BookingScreen;
import screens.taxiview.TaxiViewScreen;

import java.util.List;
import java.util.Scanner;

public class TaxiBooking {
    public static void main(String[] args) {
        boolean loop=true;
        TaxiViewScreen taxiViewScreen=new TaxiViewScreen();
        List<Taxi> taxis= taxiViewScreen.createTaxi(4);
        while(loop){
            System.out.println("Enter Your Choice \n1.Book\n2.print TaxiDetails\n3.Exit");
            Scanner scn=new Scanner(System.in);
            int choice=scn.nextInt();
            switch(choice){
                case 1: {
                    BookingScreen bookingScreen=new BookingScreen();
                    bookingScreen.onCreate(taxis);
                    break;
                }
                case 2:
                {
                    taxiViewScreen.printTaxiDetails(taxis);
                    taxiViewScreen.printTripDetails(taxis);

                    break;
                }
                case 3:{
                    loop=false;
                    break;
                }
            }
        }
    }
}
