

public abstract class Trip{
	Vehicle vehicle;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	private String source;
private String typev;
    public String getTypev() {
	return typev;
}

public void setTypev(String typev) {
	this.typev = typev;
}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getNo_of_stops() {
        return no_of_stops;
    }

    private String destination;
    public void setDestination(String destination) {
		this.destination = destination;
	}

	private String no_of_stops;
    public void setNo_of_stops(String no_of_stops) {
		this.no_of_stops = no_of_stops;
	}

	private String tripTime;
	
    public void setTripTime(String tripTime) {
		this.tripTime = tripTime;
	}

	private Ticket ticket;

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getTripTime() {
		return tripTime;
	}

	
  
}
