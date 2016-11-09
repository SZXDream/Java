package cs2013.entry1;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;


public class FlightMessage {
 
	private int fly_id;
	 
	private String fly_number;
	 
	private Timestamp departure_time;
	 
	private Timestamp arrvival_time;
	 
	private String off_place;
	 
	private String arrivival_place;
	 
	private double ticket_price;
	 
	private int ticeket_number;
	 
	private int remanent_ticket;
	 

	public int getFly_id() {
		return fly_id;
	}

	public void setFly_id(int fly_id) {
		this.fly_id = fly_id;
	}

	public String getFly_number() {
		return fly_number;
	}

	public void setFly_number(String fly_number) {
		this.fly_number = fly_number;
	}

	public Timestamp getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(Timestamp departure_time) {
		this.departure_time = departure_time;
	}

	public Timestamp getArrvival_time() {
		return arrvival_time;
	}

	public void setArrvival_time(Timestamp arrvival_time) {
		this.arrvival_time = arrvival_time;
	}

	public String getOff_place() {
		return off_place;
	}

	public void setOff_place(String off_place) {
		this.off_place = off_place;
	}

	public String getArrivival_place() {
		return arrivival_place;
	}

	public void setArrivival_place(String arrivival_place) {
		this.arrivival_place = arrivival_place;
	}

	public double getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}

	public int getTiceket_number() {
		return ticeket_number;
	}

	public void setTiceket_number(int ticeket_number) {
		this.ticeket_number = ticeket_number;
	}

	public int getRemanent_ticket() {
		return remanent_ticket;
	}

	public void setRemanent_ticket(int remanent_ticket) {
		this.remanent_ticket = remanent_ticket;
	}


	public FlightMessage() {
		super();
	}

	public FlightMessage(int fly_id, String fly_number, Timestamp departure_time,
			Timestamp arrvival_time, String off_place, String arrivival_place,
			double ticket_price, int ticeket_number, int remanent_ticket) {
		super();
		this.fly_id = fly_id;
		this.fly_number = fly_number;
		this.departure_time = departure_time;
		this.arrvival_time = arrvival_time;
		this.off_place = off_place;
		this.arrivival_place = arrivival_place;
		this.ticket_price = ticket_price;
		this.ticeket_number = ticeket_number;
		this.remanent_ticket = remanent_ticket;
	}

	@Override
	public String toString() {
		return "FlightMessage [fly_id=" + fly_id + ", fly_number=" + fly_number
				+ ", departure_time=" + departure_time + ", arrvival_time="
				+ arrvival_time + ", off_place=" + off_place
				+ ", arrivival_place=" + arrivival_place + ", ticket_price="
				+ ticket_price + ", ticeket_number=" + ticeket_number
				+ ", remanent_ticket=" + remanent_ticket 
				+ "]";
	}
	 
	
	 
}
 
