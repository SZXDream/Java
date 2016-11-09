/**
 *  DBUtilities.java
 *  JAVA的JDBC数据库应用程序设计方法示例
 *
 *  详见代码及注释
 */
package cs2013.utilV1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//import sun.io.ByteToCharConverter;

/**
 * @author Administrator
 *
 */
public class DBUtilities {

		/**
		 * @param DriverName
		 * @param URL
		 * @param UserName
		 * @param PassWord
		 * @return
		 */
		public static Connection connect(String DriverName,String URL,String UserName, String PassWord){
				
			Connection conn=null;
			try {
					Class.forName(DriverName).newInstance();		//MySQL5.0的用法
					conn = DriverManager.getConnection(
										URL, UserName , PassWord);
				}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return  conn;
		}

		/**
		 * @param configFileName
		 * @return
		 */
		public static Connection connect(String configFileName){
			Connection conn=null;
			String URL=null;
			Properties prop=new Properties();

			try{
					prop.load(new FileInputStream(configFileName));
					String driverName = prop.getProperty("dbDriver");
					String db = prop.getProperty("dbDataBase");
					String ip = prop.getProperty("dbIP");
					String port = prop.getProperty("dbPort");
					String username = prop.getProperty("dbUserName");
					String passwd = prop.getProperty("dbPassword");
					String defaultDB = prop.getProperty("defaultDbName");
					//构造URL,形式如:
					//			jdbc:mysql://localhost:3306/test?user=root&password=
					//													&useUnicode=true&characterEncoding=gb2312
					URL = "jdbc:" + db +"://" + ip + ":" + port + "/" +
							defaultDB + "?user=" +
							username + "&password=" + 
							passwd + "&useUnicode=true&characterEncoding=gb2312"; 
					
					Class.forName(driverName).newInstance();		//MySQL5.0的用法
					conn = DriverManager.getConnection(URL);
			}catch (Exception e ){
					e.printStackTrace();
			}
			return  conn;
		}

		//从配置文件中读入数据库配置信息,生成URL		
		/**
		 * @param configFileName
		 * @return
		 */
		public  static String getURL(String configFileName){
			String URL=null;
			Properties prop=new Properties();
			
			try{
					prop.load(new FileInputStream(configFileName));
					String driver = prop.getProperty("dbDriver");
					String db = prop.getProperty("dbDataBase");
					String dbname = prop.getProperty("defaultDbName");
					String ip = prop.getProperty("dbIP");
					String port = prop.getProperty("dbPort");
					String username = prop.getProperty("dbUserName");
					String passwd = prop.getProperty("dbPassword");
					String defaultDB = prop.getProperty("defaultDbName");
					//构造URL
					URL = "jdbc:" + db +"://" + ip + ":" + port + "/"+ defaultDB +
						"?localhost:3306/" + dbname + "test?user=" +
						username + "&password=" + 
						passwd + "&useUnicode=true&characterEncoding=gb2312"; 
			}catch (Exception e ){
					e.printStackTrace();
			}
			return URL;
		}
		
		/**
		 * @param conn
		 * @param SQL
		 * @return
		 */
		public static ResultSet querySQL(Connection conn, String SQL){
			ResultSet  rs=null;
			try{
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                                   ResultSet.CONCUR_UPDATABLE);
				rs = stmt.executeQuery(SQL);
			}
			catch (Exception e )
			{
				e.printStackTrace();
				}
			return rs ;
		}

		/**
		 * @param conn
		 * @param UpdateSQL
		 * @return
		 */
		public static boolean excuteSQL(Connection conn, String UpdateSQL){
			boolean result = false;
			try{
				Statement stmt=conn.createStatement();
				stmt.executeUpdate(UpdateSQL);
				result = true;
			}
			catch (Exception e )
			{
				e.printStackTrace();
				}
			return result ;
		}	
}
