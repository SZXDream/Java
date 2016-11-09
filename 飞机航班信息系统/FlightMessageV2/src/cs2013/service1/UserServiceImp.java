package cs2013.service1;

import java.util.List;

import cs2013.dao1.IBaseDao;
import cs2013.entry1.User;

public class UserServiceImp implements IUserService<User, Integer> {
	
	private IBaseDao userDao;
	
	public void setDao(IBaseDao userDao) {
		// TODO Auto-generated method stub
		this.userDao = userDao;
		
	}

	public Boolean update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return (User) userDao.findById(id);
	}

	public Boolean register(User user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}

	public Boolean login(User user) {
		boolean result = false;
		
		User u = (User) userDao.findById(user.getUser_id());
		
		if(u != null) {
			if(user.getUser_password().equals(u.getUser_password()) &&
					user.getUser_authority().equals(u.getUser_authority())) {
				result = true;
			}
		}
		
		return result;
	}






 
}
 
