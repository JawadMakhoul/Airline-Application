package entity;

import java.net.URLDecoder;

public final class Consts {
	

		private Consts() {
			throw new AssertionError();
		}

		protected static final String DB_FILEPATH = getDBPath();
		public static final String CONN_STR = "jdbc:ucanaccess://" + getDBPath() + ";COLUMNORDER=DISPLAY";
		public static final String SQL_SEL_FLIGHTS = "SELECT * FROM TblFlight";
		public static final String SQL_SEL_AIRPORTS = "SELECT * FROM TblAirport";
		public static final String SQL_SEL_AIRPLANES = "SELECT * FROM TblAirplane";
		public static final String SQL_SEL_SEATS = "SELECT * FROM SeatsTbl";
		public static final String SQL_SEL_PILOTS = "SELECT * FROM PilotTbl";
		public static final String SQL_SEL_PILOTS1 = "SELECT * FROM PilotTbl_1";
		public static final String SQL_SEL_AIRATTENDANTS = "SELECT * FROM AirAttendantTbl";
		public static final String SQL_SEL_GROUNDATTENDANTS = "SELECT * FROM GroundAttendantTbl";
		public static final String SQL_BIG_FLIGHTS = "SELECT TblFlight.srcAirport, TblFlight.departureDate, TblFlight.destAirport, TblFlight.landingDate, TblFlight.flightNum, TblFlight.status\r\n"
				+ "FROM TblFlight\r\n"
				+ "GROUP BY TblFlight.srcAirport, TblFlight.departureDate, TblFlight.destAirport, TblFlight.landingDate, TblFlight.flightNum, TblFlight.status\r\n"
				+ "ORDER BY TblFlight.srcAirport, TblFlight.departureDate DESC;";
		public static final String SQL_INS_FLIGHT = "{ call qryInsFlight(?,?,?,?,?,?,?,?,?) }";
		public static final String SQL_INS_AIRATTENDANTINFLIGHT = "{ call qryInsAirAttendantInFlight(?,?) }";
		public static final String SQL_INS_SHIFT = "{ call qryInsShift(?,?,?) }";
		public static final String SQL_INS_GroundInShift = "{ call qryInsGroundInShift(?,?,?) }";
		public static final String UPDATE_STATUS = "{ call upd_status(?) }";
		public static final String SET_PILOTS = "{ call set_pilots(?,?) }";

		private static String getDBPath() {
			try {
				String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
				String decoded = URLDecoder.decode(path, "UTF-8");
				 System.out.println(decoded); //- Can help to check the returned path
				if (decoded.contains(".jar")) {
					decoded = decoded.substring(0, decoded.lastIndexOf('/'));
					return decoded + "/EX1.accdb";
				} else {
					decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
					System.out.println(decoded);
					return decoded + "src/entity/EX1.accdb";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
