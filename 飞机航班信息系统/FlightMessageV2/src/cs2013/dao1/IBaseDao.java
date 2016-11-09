package cs2013.dao1;

import java.util.Date;
import java.util.List;

public interface IBaseDao < T , ID,D>{
	public abstract Boolean insert(T obj);
	public abstract Boolean delete(ID id);
	public abstract Boolean update(T obj);
	public abstract List<T> findAll();
	public abstract T findById(ID id);
	
	public abstract T findByFly_Id(ID fly_id);
	public abstract T findByDeparture_Time(D departure);
//	public abstract T findByArrvival_Place(S arrvival_place);
}
 
