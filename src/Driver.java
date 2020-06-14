

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Driver extends Person  {
//private  tripsAssigned;
    private String  username;
    private String password;

    public ArrayList<Trip> getAssignedTrips() {
        return assignedTrips;
    }

    public void setAssignedTrips(ArrayList<Trip> assignedTrips) {
        this.assignedTrips = assignedTrips;
    }

    private ArrayList<Trip> assignedTrips=new ArrayList<>();

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
    public int checkassign(String name)throws IOException {
        int in=0;
        FileReader fr=new FileReader("drivertrips1.txt");
        BufferedReader br=new BufferedReader(fr);
        while (br.ready()) {
            String l=br.readLine();
            StringTokenizer st=new StringTokenizer(l," ");
            if(st.nextToken().equals(name)){
                Trip trip=new InternalTrip();
                trip.setTypev(st.nextToken());
                trip.setTripTime(st.nextToken());
                trip.setSource(st.nextToken());
                trip.setDestination(st.nextToken());
                trip.setNo_of_stops(st.nextToken());
                assignedTrips.add(trip);
                in=1;
            }
        }
        if(in==1)
            return 1;
        else
            return 0;
    }

}
