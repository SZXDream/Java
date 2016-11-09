package cs2013.dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cs2013.entry1.FlightMessage;
import cs2013.entry1.User;
import cs2013.utilV1.DBUtilities;

public class FlightMessageDaoForDBImp implements
		IBaseDao<FlightMessage, Integer, Timestamp> {

	final String configFile = "jdbc.conf"; // �����ļ�

	private Connection conn = null;

	private void getConnection() {
		// ������ݿ�����
		// ȡ�������ļ��洢��·��,����Լ���ļ��Ǵ������Ŀ�ġ�������
		String strFile = this.getClass().getResource("/").getPath();
		conn = DBUtilities.connect(strFile + configFile);
	}

	public Boolean insert(FlightMessage flight) {
		boolean result = false;
		// 1.�ж����ݿ�������Ƿ��Ѿ���ȡ
		if (conn == null) {
			getConnection();
		}

		if (conn != null) {
			// 2.����SQL������
			String sql = "Insert Into flightmessage(Fly_Id, Fly_Number,Departure_Time,"
					+ "Arrivival_Time,Off_Place,Arrivival_Place,Ticket_Price,"
					+ "Ticket_Number,Remanent_Ticket) value(?,?,?,?,?,?,?,?,?)";

			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, flight.getFly_id());
				pst.setString(2, flight.getFly_number());
				pst.setTimestamp(3, flight.getDeparture_time());
				pst.setTimestamp(4, flight.getArrvival_time());
				pst.setString(5, flight.getOff_place());
				pst.setString(6, flight.getArrivival_place());
				pst.setDouble(7, flight.getTicket_price());
				pst.setInt(8, flight.getTiceket_number());
				pst.setInt(9, flight.getRemanent_ticket());
				// 3.ִ��SQL���
				int count = pst.executeUpdate();
				// 4.����ִ�н����������
				if (count >= 1) {
					result = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pst.close();
				} catch (SQLException e) {
				}
			}
		}

		return result;
	}

	public Boolean delete(Integer id) {
		boolean result = false;
		// 1.�ж����ݿ�������Ƿ��Ѿ���ȡ
		if (conn == null) {
			getConnection();
		}

		if (conn != null) {
			// 2.����SQL������
			String sql = "Delete From flightmessage where Fly_Id=? ";

			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, id);

				// 3.ִ��SQL���
				int count = pst.executeUpdate();
				// 4.����ִ�н����������
				if (count >= 1) {
					result = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pst.close();
				} catch (SQLException e) {
				}
			}
		}

		return result;
	}

	public Boolean update(FlightMessage flight) {
		boolean result = false;
		// 1.�ж����ݿ�������Ƿ��Ѿ���ȡ
		if (conn == null) {
			getConnection();
		}

		if (conn != null) {
			// 2.����SQL������
			String sql = "Update flightmessage set Fly_Number=?,Departure_Time=?,"
					+ "Arrivival_Time=?,Off_Place=?,Arrivival_Place=?,Ticket_Price=?,"
					+ "Ticket_Number=?,Remanent_Ticket=? where Fly_Id = ?";

			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);

				pst.setString(1, flight.getFly_number());
				pst.setTimestamp(2, flight.getDeparture_time());
				pst.setTimestamp(3, flight.getArrvival_time());
				pst.setString(4, flight.getOff_place());
				pst.setString(5, flight.getArrivival_place());
				pst.setDouble(6, flight.getTicket_price());
				pst.setInt(7, flight.getTiceket_number());
				pst.setInt(8, flight.getRemanent_ticket());
				pst.setInt(9, flight.getFly_id());

				// 3.ִ��SQL���
				int count = pst.executeUpdate();
				// 4.����ִ�н����������
				if (count >= 1) {
					result = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pst.close();
				} catch (SQLException e) {
				}
			}
		}

		return result;
	}

	public List<FlightMessage> findAll() {
		List<FlightMessage> list = null;

		// 1.�ж����ݿ�������Ƿ��Ѿ���ȡ
		if (conn == null) {
			getConnection();
		}

		if (conn != null) {
			// 2.����SQL������
			String sql = "Select * from flightmessage ";

			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				pst = conn.prepareStatement(sql);

				// 3.ִ��SQL���
				rs = pst.executeQuery();
				// 4.����ִ�н����������
				if (rs != null) {
					// list = new ArrayList<FlightMessage>();
					list = new ArrayList<FlightMessage>();
					while (rs.next()) {
						FlightMessage flight = new FlightMessage(
								rs.getInt("Fly_Id"),
								rs.getString("Fly_Number"),
								rs.getTimestamp("Departure_Time"),
								rs.getTimestamp("Arrivival_Time"),
								rs.getString("Off_Place"),
								rs.getString("Arrivival_Place"),
								rs.getInt("Ticket_Price"),
								rs.getInt("Ticket_Number"),
								rs.getInt("Remanent_Ticket"));

						list.add(flight);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pst.close();
				} catch (SQLException e) {
				}
			}
		}

		return list;
	}

	public FlightMessage findByFly_Id(Integer fly_id) {
		FlightMessage flight = null;
		// 1.�ж����ݿ�������Ƿ��Ѿ���ȡ
		if (conn == null) {
			getConnection();
		}

		if (conn != null) {
			// 2.����SQL������
			String sql = "Select * from flightmessage  where Fly_Id=?";

			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				pst = conn.prepareStatement(sql);

				pst.setInt(1, fly_id);
				// 3.ִ��SQL���
				rs = pst.executeQuery();
				// 4.����ִ�н����������
				if (rs.next()) {
					flight = new FlightMessage(rs.getInt("Fly_Id"),
							rs.getString("Fly_Number"),
							rs.getTimestamp("Departure_Time"),
							rs.getTimestamp("Arrivival_Time"),
							rs.getString("Off_Place"),
							rs.getString("Arrivival_Place"),
							rs.getInt("Ticket_Price"),
							rs.getInt("Ticket_Number"),
							rs.getInt("Remanent_Ticket"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pst.close();
				} catch (SQLException e) {
				}
			}
		}

		return flight;
	}

	public FlightMessage findByDeparture_Time(Timestamp departure_Time) {
		FlightMessage flight = null;
		// 1.�ж����ݿ�������Ƿ��Ѿ���ȡ
		if (conn == null) {
			getConnection();
		}

		if (conn != null) {
			// 2.����SQL������
			String sql = "Select * from flightmessage  where Departure_Time > ?";

			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				pst = conn.prepareStatement(sql);

				pst.setTimestamp(1, departure_Time);
				// 3.ִ��SQL���
				rs = pst.executeQuery();
				// 4.����ִ�н����������
				if (rs.next()) {
					flight = new FlightMessage(rs.getInt("Fly_Id"),
							rs.getString("Fly_Number"),
							rs.getTimestamp("Departure_Time"),
							rs.getTimestamp("Arrivival_Time"),
							rs.getString("Off_Place"),
							rs.getString("Arrivival_Place"),
							rs.getInt("Ticket_Price"),
							rs.getInt("Ticket_Number"),
							rs.getInt("Remanent_Ticket"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pst.close();
				} catch (SQLException e) {
				}
			}
		}

		return flight;
	}

	public FlightMessage findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
