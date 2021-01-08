import java.util.ArrayList;

public class    Main{
    public static void main(String[] args){
        Airport airport = new Airport("Vilniaus oro uostas", "Naujininkai", "Vilnius");
        AirportDAO.insert(airport);

       ArrayList<Airport> airports = AirportDAO.searchByName("Kauno oro uostas");
        System.out.println(airports);

       // AirportDAO.deleteById(1);
     //   AirportDAO.deleteByName("Kauno oro uostas");

        //AirportDAO.updateById(airport,2);
    }
}
