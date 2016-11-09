/**
 * 
 */
package cs2013.service1;

import java.util.Date;

/**
 * @author Flying
 *
 */
public interface IFlightMessageService<T, ID ,D> extends IService<T,ID> {
	public abstract boolean add(T obj);
	public abstract T findByFly_Id(ID fly_id);
	public abstract T findByDeparture_Time(D departure_time);
//	public abstract T findByArrvival_Place(S arrvival_place);
}
