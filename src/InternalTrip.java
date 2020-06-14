
public class InternalTrip extends Trip implements BuyTicket {
	Vehicle vehicle;
	private Ticket ticket;

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	String source=super.getSource();
	    public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getNo_of_stops() {
		return no_of_stops;
	}


	public void setNo_of_stops(String no_of_stops) {
		this.no_of_stops = no_of_stops;
	}


	public String getTypev() {
		return typev;
	}


	public void setTypev(String typev) {
		this.typev = typev;
	}



		String destination=super.getDestination();
	   String no_of_stops=super.getNo_of_stops();
	    private String tripTime=super.getTripTime();
	    private String typev=super.getTypev();
    
  
	public String getTripTime() {
			return tripTime;
		}


		public void setTripTime(String tripTime) {
			this.tripTime = tripTime;
		}



	
	@Override
    public double buyMiniBusTicket() {
    //	Vehicle xmini=new MiniBus();
    	 if(ticket.getType()=="round") {
             ticket.setPrice(200);
         }
         else  {
             ticket.setPrice(100);
         }
   return ticket.getPrice();
    }

    @Override
    public double buyBusTicket() {
    	  if(ticket.getType().equals("round")) {
              ticket.setPrice(100);
          }
          else  {
              ticket.setPrice(50);
          }
          return ticket.getPrice();
    }

    @Override
    public double buyLimosineTicket() {
    	if(ticket.getType().equals("round")) {
            ticket.setPrice(400);
        }
        else if(ticket.getType().equals("oneway")) {
            ticket.setPrice(300);
        }
return ticket.getPrice();
    }
}
