
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Passenger extends Person {
    private String  username;
    private String password;
    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Trip> getHistoryOfTrips() {
        return historyOfTrips;
    }

    public void setHistoryOfTrips(ArrayList historyOfTrips) {
        this.historyOfTrips = historyOfTrips;
    }

    private ArrayList<Trip> historyOfTrips=new ArrayList<>();

    public double booktrip( int index,tripdb database,String type,String ticketType) {
        historyOfTrips.add(database.getDetailsint().get(index));
        int y = database.getDetailsint().get(index).getVehicle().getSeats();

        if(y>0){
           y = y - 1;
            historyOfTrips.get(historyOfTrips.size()-1).getVehicle().setSeats(y);
            System.out.println(historyOfTrips.get(historyOfTrips.size()-1).getVehicle().getSeats());
           database.getDetailsint().get(index).getVehicle().setSeats(y);
           //System.out.println();
           Trip trip1 = new InternalTrip();
           Trip trip2=new ExternalTrip();
           Ticket ticket = new Ticket();
           ticket.setType(ticketType);
           trip1.setTicket(ticket);
           trip2.setTicket(ticket);
           trip1.getTicket().setType(ticketType);
           if (type.equals("internal")) {
               if (database.getDetailsint().get(index).getVehicle().getVehicleType().equals("limousine")) {
                   ((InternalTrip) trip1).buyLimosineTicket();
               } else if (database.getDetailsint().get(index).getVehicle().getVehicleType().equals("minibus")) {
                   ((InternalTrip) trip1).buyMiniBusTicket();
               } else
                   ((InternalTrip) trip1).buyBusTicket();
           }else if(type.equals("external")){
               if (database.getDetailsint().get(index).getVehicle().getVehicleType().equals("limousine")) {
                   ((ExternalTrip) trip2).buyLimosineTicket();
               } else if (database.getDetailsint().get(index).getVehicle().getVehicleType().equals("minibus")) {
                   ((ExternalTrip) trip2).buyMiniBusTicket();
               } else
                   ((ExternalTrip) trip2).buyBusTicket();
           }
           System.out.println(trip1.getTicket().getPrice());
            if(y==0){
                database.getDetailsint().remove(index);
            }
           return trip1.getTicket().getPrice();
       }
      else if (y==0)
          return 1;
        return -1;
    }
    public void cancelTrip(int i){
        historyOfTrips.remove(i);
    }

    public ArrayList<Trip> notification()throws IOException{
            ArrayList<Trip> x=new ArrayList<>();
            FileReader fr=new FileReader("canceledtrips.txt");
            BufferedReader br=new BufferedReader(fr);
            while(br.ready()){
                String read=br.readLine();
                StringTokenizer str=new StringTokenizer(read," ");
                Trip trip=new InternalTrip();
                trip.setTypev(str.nextToken());
                trip.setTripTime(str.nextToken());
                trip.setSource(str.nextToken());
                trip.setDestination(str.nextToken());
                trip.setNo_of_stops(str.nextToken());
                x.add(trip);

            }
            return x;


    }
}
