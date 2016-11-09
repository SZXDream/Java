package cs2013.dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cs2013.entry1.User;
import cs2013.utilV1.DBUtilities;

public class UserDaoForDBImp implements IBaseDao<User, Integer,Timestamp> {
	
//	private static final int user_id = 0;

	final String configFile = "jdbc.conf";	//配置文件
	
	private Connection conn= null;
	
	private void getConnection() {
		//获得数据库连接
		//取得配置文件存储的路径,此外约定文件是存放在项目的“根”下
		String strFile =this.getClass().getResource("/").getPath();
		conn = DBUtilities.connect( strFile + configFile);
	}
	
	
	
	public Boolean insert(User user) {
		boolean result = false;
		//1.判断数据库的连接是否已经获取
		if(conn == null ) {
			getConnection() ;
		}
		
		if(conn != null ) {
			//2.创建SQL语句对象：
			String sql = "Insert Into userslogin(User_Id, User_Name,User_Password,User_Authority) value(?,?,?,?)";
			
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, user.getUser_id());
				pst.setString(2, user.getUser_name());
				pst.setString(3, user.getUser_password());
				pst.setString(4, user.getUser_authority());
				//3.执行SQL语句
				int count = pst.executeUpdate();
				//4.处理执行结果，并返回
				if(count >=1 ) {
					result = true;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					pst.close();
				}catch(SQLException e) {}
			}
		}
		
		return result;
	}

	public Boolean delete(Integer id) {
		boolean result = false;
		//1.判断数据库的连接是否已经获取
		if(conn == null ) {
			getConnection() ;
		}
		
		if(conn != null ) {
			//2.创建SQL语句对象：
			String sql = "Delete From userslogin where User_Id=? ";
			
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, id);

				//3.执行SQL语句
				int count = pst.executeUpdate();
				//4.处理执行结果，并返回
				if(count >=1 ) {
					result = true;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					pst.close();
				}catch(SQLException e) {}
			}
		}
		
		return result;
	}

	public Boolean update(User user) {
		boolean result = false;
		//1.判断数据库的连接是否已经获取
		if(conn == null ) {
			getConnection() ;
		}
		
		if(conn != null ) {
			//2.创建SQL语句对象：
			String sql = "Update userslogin set User_Password=?  where User_Id=?";
			
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);				
				pst.setString(1, user.getUser_password());
				pst.setInt(2, user.getUser_id());
				//3.执行SQL语句
				int count = pst.executeUpdate();
				//4.处理执行结果，并返回
				if(count >=1 ) {
					result = true;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					pst.close();
				}catch(SQLException e) {}
			}
		}
		
		return result;
	}

	public List<User> findAll() {
		List<User> list = null;

		//1.判断数据库的连接是否已经获取
		if(conn == null ) {
			getConnection() ;
		}
		
		if(conn != null ) {
			//2.创建SQL语句对象：
			String sql = "Select * from userslogin ";
			
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				pst = conn.prepareStatement(sql);				

				//3.执行SQL语句
				rs = pst.executeQuery();
				//4.处理执行结果，并返回
				if(rs != null) {
					list = new ArrayList<User>();
					
					while(rs.next()) {
						User user = new User(rs.getInt("User_Id"),
											rs.getString("User_Name"),
											rs.getString("User_Password"),
											rs.getString("User_Authority"));
						list.add(user);
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					rs.close();
					pst.close();
				}catch(SQLException e) {}
			}
		}
		
		return list;
	}

	public User findById(Integer id) {
		User user = null;
		//1.判断数据库的连接是否已经获取
		if(conn == null ) {
			getConnection() ;
		}
		
		if(conn != null ) {
			//2.创建SQL语句对象：
			String sql = "Select * from userslogin  where User_Id=?";
			
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				pst = conn.prepareStatement(sql);				

				pst.setInt(1, id);
				//3.执行SQL语句
				rs = pst.executeQuery();
				//4.处理执行结果，并返回
				if(rs.next()) {
					user = new User(rs.getInt("user_id"),
									rs.getString("user_name"),rs.getString("user_password"),
									rs.getString("user_authority"));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					rs.close();
					pst.close();
				}catch(SQLException e) {}
			}
		}
		
		return user;
	}



	public User findByDeparture_Time(Timestamp departure) {
		// TODO Auto-generated method stub
		return null;
	}



	public User findByFly_Id(Integer fly_id) {
		// TODO Auto-generated method stub
		return null;
	}



}
