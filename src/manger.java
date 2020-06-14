
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class manger extends Person {
	int flag2=0;
	int i=0;
	int flag=0;
	HashMap<Integer, Trip> managerint = new HashMap<>();

	public HashMap<Integer, Trip> getManagerint() {
		return managerint;
	}

	public void setManagerint(HashMap<Integer, Trip> managerint) {
		this.managerint = managerint;
	}

	public HashMap<Integer, Trip> getManagerext() {
		return managerext;
	}

	public void setManagerext(HashMap<Integer, Trip> managerext) {
		this.managerext = managerext;
	}

	HashMap<Integer, Trip> managerext = new HashMap<>();
	private String  username="Micheal_Scott";
	private String password="1234";

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void load(String typetrip) throws IOException {
		if(typetrip.equals("internal"))
		{
			File filei = new File("inttripdb.txt");
			FileReader fr= new FileReader(filei);
			BufferedReader br = new BufferedReader(fr);
			while(br.ready()) {
				String line = br.readLine();
				String delimiters = " ";
				StringTokenizer str = new StringTokenizer(line, delimiters);
				while(str.hasMoreTokens()) {
					Trip objtrip = new InternalTrip();

					objtrip.setTypev(str.nextToken());
					objtrip.setTripTime(str.nextToken());
					objtrip.setSource(str.nextToken());
					objtrip.setDestination(str.nextToken());
					objtrip.setNo_of_stops(str.nextToken());
					managerint.put(i, objtrip);
					i++;
				}
			}
			for (int count : managerint.keySet()) {
				if (managerint.get(count).getTypev().equals("limousine"))
					managerint.get(count).setVehicle(new Limousine());
				else if (managerint.get(count).getTypev().equals("minibus"))
					managerint.get(count).setVehicle(new MiniBus());
				else
					managerint.get(count).setVehicle(new Bus());

			}

		}
		else if (typetrip.equals("external")) {
			File filei = new File("exttripdb.txt");
			FileReader fr= new FileReader(filei);
			BufferedReader br = new BufferedReader(fr);
			while(br.ready()) {
				String line = br.readLine();
				String delimiters = " ";
				StringTokenizer str = new StringTokenizer(line, delimiters);
				while(str.hasMoreTokens()) {
					Trip objtrip = new InternalTrip();

					objtrip.setTypev(str.nextToken());
					objtrip.setTripTime(str.nextToken());
					objtrip.setSource(str.nextToken());
					objtrip.setDestination(str.nextToken());
					objtrip.setNo_of_stops(str.nextToken());
					managerext.put(i, objtrip);
					i++;
				}
			}
			for (int count : managerext.keySet()) {
				if (managerext.get(count).getTypev().equals("limousine"))
					managerext.get(count).setVehicle(new Limousine());
				else if (managerext.get(count).getTypev().equals("minibus"))
					managerext.get(count).setVehicle(new MiniBus());
				else
					managerext.get(count).setVehicle(new Bus());

			}
		}
	}

	public int CancelTrip(String Type , int i ) throws IOException {
		if(Type.equals("internal")){
	if(managerint.containsKey(i)) {
		if(flag2==0) {
			FileWriter fw = new FileWriter("canceledtrips.txt", false);
			fw.write(managerint.get(i).getTypev() + " " + managerint.get(i).getTripTime()+
					" " + managerint.get(i).getSource() + " " + managerint.get(i).getDestination() + " "
					+ managerint.get(i).getNo_of_stops() );
			fw.write("\r\n");
			fw.close();
			flag2=1;
		}
		else {
			FileWriter fw = new FileWriter("canceledtrips.txt", true);
			fw.write(managerint.get(i).getTypev() + " " + managerint.get(i).getTripTime()+
					" " + managerint.get(i).getSource() + " " + managerint.get(i).getDestination() + " "
					+ managerint.get(i).getNo_of_stops() );
			fw.write("\r\n");
			fw.close();
			flag2=1;

		}
		managerint.remove(i);
	}
	else
		return 0;


			//for (int count : managerext.keySet()) {
			//		System.out.println(managerint.get(count).getDestination());
			//	}
			FileWriter fileWriter = new FileWriter("inttripdb.txt",false);
			for (int count : managerint.keySet()) {

				fileWriter.write(managerint.get(count).getTypev() + " " + managerint.get(count).getTripTime()+ " " + managerint.get(count).getSource() + " " + managerint.get(count).getDestination() + " "+ managerint.get(count).getNo_of_stops() );
				fileWriter.write("\r\n");
			}

			fileWriter.close();
			flag2=1;


		}

		else {
			if(managerext.containsKey(i)) {
				if(flag2==0) {
					FileWriter fw = new FileWriter("canceledtrips.txt", false);
					fw.write(managerext.get(i).getTypev() + " " + managerext.get(i).getTripTime()+
							" " + managerext.get(i).getSource() + " " + managerext.get(i).getDestination() + " "
							+ managerext.get(i).getNo_of_stops() );
					fw.write("\r\n");
					fw.close();
					flag2=1;

				}
				else {
					FileWriter fw = new FileWriter("canceledtrips.txt", true);
					fw.write(managerext.get(i).getTypev() + " " + managerext.get(i).getTripTime()+
							" " + managerext.get(i).getSource() + " " + managerext.get(i).getDestination() + " "
							+ managerext.get(i).getNo_of_stops() );
					fw.write("\r\n");
					fw.close();
					flag2=1;


				}
				managerext.remove(i);
			}
			else
				return 0;

			FileWriter fileWriter = new FileWriter("exttripdb.txt",false);
			for (int count : managerext.keySet()) {

				fileWriter.write(managerext.get(count).getTypev() + " " + managerext.get(count).getTripTime()+ " " + managerext.get(count).getSource() + " " + managerext.get(count).getDestination() + " "+ managerext.get(count).getNo_of_stops() + "\n");
				fileWriter.write("\r\n");
			}
			flag2=1;

			fileWriter.close();

		}return 1;}

	public void addTrip(String tripType,String VehicleType , String tripTime , String tripSource , String tripDestination , String NumberOfStops) throws IOException {
		if(tripType.equals("internal")) {
			Trip objtrip = new InternalTrip();

			objtrip.setTypev(VehicleType);
			objtrip.setTripTime(tripTime);
			objtrip.setSource(tripSource);
			objtrip.setDestination(tripDestination);
			objtrip.setNo_of_stops(NumberOfStops);
			managerint.put(i, objtrip);
			FileWriter fileWriter = new FileWriter("inttripdb.txt",true);
			fileWriter.write(managerint.get(i).getTypev() + " " + managerint.get(i).getTripTime()+ " " + managerint.get(i).getSource() + " " + managerint.get(i).getDestination() + " "+ managerint.get(i).getNo_of_stops() + "\n");
			fileWriter.write("\r\n");
			fileWriter.close();
			i++;

		}
		else {
			Trip objtrip = new ExternalTrip();
			objtrip.setTypev(VehicleType);
			objtrip.setTripTime(tripTime);
			objtrip.setSource(tripSource);
			objtrip.setDestination(tripDestination);
			objtrip.setNo_of_stops(NumberOfStops);
			managerext.put(i, objtrip);

			FileWriter fileWriter = new FileWriter("exttripdb.txt",true);
			fileWriter.write(managerext.get(i).getTypev() + " " + managerext.get(i).getTripTime()+ " " + managerext.get(i).getSource() + " " + managerext.get(i).getDestination() + " "+ managerext.get(i).getNo_of_stops() + "\n");
			fileWriter.write("\r\n");
			fileWriter.close();
			i++;


		}

	}

	public void assigntrip(String driverName,String vtype, String date, String source, String dest, String nos)throws IOException{
		Trip trip=new InternalTrip();

		trip.setTripTime(date);
		trip.setTypev(vtype);
		trip.setSource(source);
		trip.setDestination(dest);
		trip.setNo_of_stops(nos);
		if(vtype.equals("limousine")){
			Vehicle l=new Limousine();
			l.setVehicleType("limousine");
			trip.setVehicle(l);
		}else if(vtype.equals("minibus")){
			Vehicle m=new MiniBus();
			m.setVehicleType("minibus");
			trip.setVehicle(m);
		}else if(vtype.equals("bus")){
			Vehicle b=new Bus();
			b.setVehicleType("bus");
			trip.setVehicle(b);
		}
		if(flag==0) {
			FileWriter fw = new FileWriter("drivertrips1.txt", false);
			fw.write(driverName + " " + trip.getTypev() + " " + trip.getTripTime() + " " + trip.getSource() + " " + trip.getDestination()
					+ " " + trip.getNo_of_stops());
			fw.write("\r\n");
			fw.close();
			flag=1;
		}
else if(flag==1){
			FileWriter fw = new FileWriter("drivertrips1.txt", true);
			fw.write(driverName + " " + trip.getTypev() + " " + trip.getTripTime() + " " + trip.getSource() + " " + trip.getDestination()
					+ " " + trip.getNo_of_stops());
			fw.write("\r\n");
			fw.close();
		}
	}

	    
}
