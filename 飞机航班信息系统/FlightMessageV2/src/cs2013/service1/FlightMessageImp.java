package cs2013.service1;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import cs2013.dao1.IBaseDao;
import cs2013.entry1.FlightMessage;

public class FlightMessageImp implements IFlightMessageService<FlightMessage, Integer,Timestamp> {
	private IBaseDao flightDao;
	public void setDao(IBaseDao flightdao) {
		this.flightDao = flightdao;
		
	}

	public Boolean update(FlightMessage flightmessage) {
		// TODO Auto-generated method stub
		return flightDao.update(flightmessage);
	}

	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return flightDao.delete(id);
	}

	public List<FlightMessage> findAll() {
		// TODO Auto-generated method stub
		return flightDao.findAll();
	}

	public FlightMessage findById(Integer id) {
		// TODO Auto-generated method stub
		return (FlightMessage) flightDao.findById(id);
	}

	public FlightMessage findByFly_Id(Integer fly_Id) {
		// TODO Auto-generated method stub
		return (FlightMessage) flightDao.findByFly_Id(fly_Id);  ///youwenti
	}

//	public FlightMessage findByDeparture(String departure_time) {
//		// TODO Auto-generated method stub
//		return (FlightMessage) flightDao.findByDeparture_Time(departure_time);
//	}
//
//	public FlightMessage findByArrvival_Place(String arrvival_place) {
//		// TODO Auto-generated method stub
//		return (FlightMessage) flightDao.findByArrvival_Place(arrvival_place);
//	}

	public boolean add(FlightMessage flight) {
		// TODO Auto-generated method stub
		return flightDao.insert(flight);
	}

	public FlightMessage findByDeparture_Time(Timestamp departure_time) {
		// TODO Auto-generated method stub
		return  (FlightMessage) flightDao.findByDeparture_Time(departure_time);
	}




}
