
public class ExternalTrip extends Trip implements BuyTicket {
    Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    String source=super.getSource();
    String destination=super.getDestination();
   String no_of_stops=super.getNo_of_stops();
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    private String tripTime=super.getTripTime();
    
 
    public String getTripTime() {
		return tripTime;
	}

	public void setTripTime(String tripTime) {
		this.tripTime = tripTime;
	}


	@Override
    public double buyMiniBusTicket() {
        if(ticket.getType()=="round") {
            ticket.setPrice(300);
        }
        else if(ticket.getType().equals("oneway")) {
            ticket.setPrice(200);
        }
        return ticket.getPrice();

    }

    @Override
    public double buyBusTicket() {
    	  if(ticket.getType().equals("round")) {
              ticket.setPrice(150);
          }
          else if(ticket.getType().equals("oneway")) {
              ticket.setPrice(100);
          }
        return ticket.getPrice();

    }

    @Override
    public double buyLimosineTicket() {
    	if(ticket.getType().equals("round")) {
            ticket.setPrice(500);
        }
        else if(ticket.getType().equals("oneway")) {
            ticket.setPrice(400);
        }
        return ticket.getPrice();
    }
    
}
