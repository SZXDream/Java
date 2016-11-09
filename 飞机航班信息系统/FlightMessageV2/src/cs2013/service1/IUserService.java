/**
 * 
 */
package cs2013.service1;

import java.util.List;

/**
 * @author Flying
 *
 */
public interface IUserService<T,ID> extends IService<T,ID> {
//	public abstract List<T> browse();
	public abstract Boolean register(T obj);
	public abstract Boolean login(T obj);
}
