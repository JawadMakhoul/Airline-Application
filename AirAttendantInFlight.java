package entity;

import java.util.Objects;

public class AirAttendantInFlight {
	
	private String id;
	private String flightNum;
	public AirAttendantInFlight(String id, String flightNum) {
		super();
		this.id = id;
		this.flightNum = flightNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	@Override
	public int hashCode() {
		return Objects.hash(flightNum, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirAttendantInFlight other = (AirAttendantInFlight) obj;
		return Objects.equals(flightNum, other.flightNum) && Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "AirAttendantInFlight [id=" + id + ", flightNum=" + flightNum + "]";
	}
	
	

}
