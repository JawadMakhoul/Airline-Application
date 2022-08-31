package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import entity.AirAttendant;
import entity.Airplane;
import entity.Airport;
import entity.Consts;
import entity.Flight;
import entity.GroundAttendant;
import entity.Pilot;
import entity.Seat;

public class FlightLogic {

	private static FlightLogic _instance;

	private FlightLogic() {
	}

	public static FlightLogic getInstance() {
		if (_instance == null)
			_instance = new FlightLogic();
		return _instance;
	}

	public  ArrayList<Airplane> getPlanes() {

		ArrayList<Airplane> results = new ArrayList<Airplane>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			String Name = Consts.CONN_STR;
			System.out.println(Name);
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_AIRPLANES);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new Airplane(rs.getString(i++), rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	public  ArrayList<Pilot> getPilots() {

		ArrayList<Pilot> results = new ArrayList<Pilot>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			String Name = Consts.CONN_STR;
			System.out.println(Name);
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_PILOTS);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new Pilot(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
							rs.getString(i++), rs.getString(i++), rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	public  ArrayList<AirAttendant> getAirAttendants() {

		ArrayList<AirAttendant> results = new ArrayList<AirAttendant>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			String Name = Consts.CONN_STR;
			System.out.println(Name);
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_AIRATTENDANTS);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new AirAttendant(rs.getString(i++), rs.getString(i++), rs.getString(i++),
							rs.getString(i++), rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	public  ArrayList<GroundAttendant> getGroundAttendant() {

		ArrayList<GroundAttendant> results = new ArrayList<GroundAttendant>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			String Name = Consts.CONN_STR;
			System.out.println(Name);
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_GROUNDATTENDANTS);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new GroundAttendant(rs.getString(i++), rs.getString(i++), rs.getString(i++),
							rs.getString(i++), rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	public  ArrayList<Airport> getPorts() {

		ArrayList<Airport> results = new ArrayList<Airport>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_AIRPORTS);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new Airport(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getDate(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	public  ArrayList<Flight> getFlights() {

		ArrayList<Flight> results = new ArrayList<Flight>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_FLIGHTS);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new Flight(rs.getString(i++), rs.getDate(i++), rs.getDate(i++), rs.getString(i++),
							rs.getString(i++), rs.getString(i++), rs.getString(i++), null, null));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	public  ArrayList<Seat> getSeats() {
		ArrayList<Seat> results = new ArrayList<Seat>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_SEATS);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new Seat(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	public  ArrayList<Flight> getBigFlights() {

		ArrayList<Flight> results = new ArrayList<Flight>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_BIG_FLIGHTS);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new Flight(rs.getString(i++), rs.getDate(i++), rs.getDate(i++), rs.getString(i++),
							rs.getString(i++), rs.getString(i++), rs.getString(i++), null, null));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	public  boolean addFlight(String flightNum, Date departureDate, Date landingDate, String status, String srcAirport,
			String destAirport, String tailNum, String p1, String p2) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_FLIGHT)) {

				// int i = 1;
				stmt.setString(1, flightNum); // can't be null

				if (departureDate != null) {
					stmt.setDate(2, (java.sql.Date) departureDate);
				} else {
					stmt.setNull(2, java.sql.Types.DATE);
				}
				if (landingDate != null) {
					stmt.setDate(3, new java.sql.Date(landingDate.getTime()));
				} else {
					stmt.setNull(3, java.sql.Types.DATE);
				}
				if (status != null) {
					stmt.setString(4, status);
				} else {
					stmt.setNull(4, java.sql.Types.VARCHAR);
				}
				if (srcAirport != null) {
					stmt.setString(5, srcAirport);
				} else {
					stmt.setNull(5, java.sql.Types.VARCHAR);
				}
				if (destAirport != null) {
					stmt.setString(6, destAirport);
				} else {
					stmt.setNull(6, java.sql.Types.VARCHAR);
				}
				if (tailNum != null) {
					stmt.setString(7, tailNum);
				} else {
					stmt.setNull(7, java.sql.Types.VARCHAR);
				}
				if (p1 != null) {
					stmt.setString(8, p1);
				} else {
					stmt.setNull(8, java.sql.Types.VARCHAR);
				}

				if (p2 != null) {
					stmt.setString(9, p2);
				} else {
					stmt.setNull(9, java.sql.Types.VARCHAR);
				}

				stmt.executeUpdate();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public  boolean addAirAttendantsInFlight(String id, String flightNum) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_AIRATTENDANTINFLIGHT)) {
				// int i = 1;
				stmt.setString(1, id); // can't be null

				if (flightNum != null) {
					
					stmt.setString(2, flightNum);
					
				} else {
					stmt.setNull(2, java.sql.Types.VARCHAR);
				}

				stmt.executeUpdate();
				
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public  boolean addShift(String shiftId, String startTime, String endTime) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_SHIFT)) {

				// int i = 1;
				stmt.setString(1, shiftId); // can't be null

				if (startTime != null) {
					
					stmt.setString(2, startTime);
				} else {
					stmt.setNull(2, java.sql.Types.VARCHAR);
				}

				if (endTime != null) {
					
					stmt.setString(3, endTime);
				} else {
					stmt.setNull(3, java.sql.Types.VARCHAR);
				}

				stmt.executeUpdate();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public  boolean addGroundInShift(String AttendantId, String shiftNum, String role) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_GroundInShift)) {

				// int i = 1;
				stmt.setString(1, AttendantId); // can't be null

				if (shiftNum != null) {
					
					stmt.setString(2, shiftNum);
				} else {
					stmt.setNull(2, java.sql.Types.VARCHAR);
				}

				if (role != null) {
					
					stmt.setString(3, role);
				} else {
					stmt.setNull(3, java.sql.Types.VARCHAR);
				}

				stmt.executeUpdate();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
