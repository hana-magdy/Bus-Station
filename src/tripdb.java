
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class tripdb {
	HashMap<Integer, Trip> detailsint = new HashMap<>();
	HashMap<Integer, Trip> detailsexternal = new HashMap<>();
	HashMap<Integer, Trip> detailsinternal = new HashMap<>();
	Vehicle objv;
	String typev = new String();

	public HashMap<Integer, Trip> getDetailsint() {
		return detailsint;
	}

	public void setDetailsint(HashMap<Integer, Trip> detailsint) {
		this.detailsint = detailsint;
	}

	public void loadtrip() throws IOException {
		int i = 0;


		File f = new File("inttripdb.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		while (br.ready()) {
			String line = br.readLine();
			String delimiters = " ";
			StringTokenizer str = new StringTokenizer(line, delimiters);

			while (str.hasMoreTokens()) {
				Trip objtrip = new InternalTrip();

				objtrip.setTypev(str.nextToken());
				objtrip.setTripTime(str.nextToken());
				objtrip.setSource(str.nextToken());
				objtrip.setDestination(str.nextToken());
				objtrip.setNo_of_stops(str.nextToken());
				detailsinternal.put(i, objtrip);
				i++;

			}

		}
		for (int count : detailsinternal.keySet()) {
			if (detailsinternal.get(count).getTypev().equals("limousine"))
				detailsinternal.get(count).setVehicle(new Limousine());
			else if (detailsinternal.get(count).getTypev().equals("minibus"))
				detailsinternal.get(count).setVehicle(new MiniBus());
			else
				detailsinternal.get(count).setVehicle(new Bus());

		}



		File f2 = new File("exttripdb.txt");
		FileReader fr2 = new FileReader(f2);
		BufferedReader br2 = new BufferedReader(fr2);
		while (br2.ready()) {
			String line = br2.readLine();
			String delimiters = " ";
			StringTokenizer str2 = new StringTokenizer(line, delimiters);

			Trip objtrip2 = new ExternalTrip();
			Vehicle l = new Limousine();
			l.setVehicleType("limousine");
			Vehicle m = new MiniBus();
			m.setVehicleType("minibus");
			Vehicle b = new Bus();
			b.setVehicleType("Bus");
			String typev = str2.nextToken();
			if (typev.equals("limousine")) {
				objtrip2.setTypev("limousine");
				//objtrip.setVehicle(l);
			} else if (typev.equals("minibus")) {
				objtrip2.setTypev("minibus");
				// objtrip.setVehicle(m);
			} else if (typev.equals("bus")) {
				//objtrip.setVehicle(b);
				objtrip2.setTypev("bus");
			}

			objtrip2.setTripTime(str2.nextToken());
			objtrip2.setSource(str2.nextToken());
			objtrip2.setDestination(str2.nextToken());
			objtrip2.setNo_of_stops(str2.nextToken());
			detailsexternal.put(i, objtrip2);
			i++;
		}
		for (int count2 : detailsexternal.keySet()) {
			if (detailsexternal.get(count2).getTypev().equals("limousine"))
				detailsexternal.get(count2).setVehicle(new Limousine());
			else if (detailsexternal.get(count2).getTypev().equals("minibus"))
				detailsexternal.get(count2).setVehicle(new MiniBus());
			else
				detailsexternal.get(count2).setVehicle(new Bus());

		}






	}

	public void useint (){
		detailsint = detailsinternal;
	}
	public void useext(){
		detailsint=detailsexternal;
	}
}
	
