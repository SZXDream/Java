package cs2013.service1;

import java.util.List;

import cs2013.dao1.IBaseDao;
import cs2013.entry1.User;

public interface IService <T, ID>{
	public abstract void setDao(IBaseDao dao);
	public abstract Boolean update(T obj);
	public abstract Boolean delete(ID id);
	public abstract List<T> findAll();
	public abstract T findById(Integer id);
}
 
