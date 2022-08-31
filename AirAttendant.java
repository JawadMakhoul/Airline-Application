package entity;

import java.util.Date;
import java.util.Objects;


public class AirAttendant {

	private String id;
	private String firstname;
	private String lastname;
	private String startOfConnection;
	private String endOfConnection;
	public AirAttendant(String id, String firstname, String lastname, String startOfConnection, String endOfConnection) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.startOfConnection = startOfConnection;
		this.endOfConnection = endOfConnection;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStartOfConnection() {
		return startOfConnection;
	}
	public void setStartOfConnection(String startOfConnection) {
		this.startOfConnection = startOfConnection;
	}
	public String getEndOfConnection() {
		return endOfConnection;
	}
	public void setEndOfConnection(String endOfConnection) {
		this.endOfConnection = endOfConnection;
	}
	@Override
	public int hashCode() {
		return Objects.hash(endOfConnection, firstname, id, lastname, startOfConnection);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirAttendant other = (AirAttendant) obj;
		return Objects.equals(endOfConnection, other.endOfConnection) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(id, other.id) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(startOfConnection, other.startOfConnection);
	}
	@Override
	public String toString() {
		return "AirAttendant [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", startOfConnection="
				+ startOfConnection + ", endOfConnection=" + endOfConnection + "]";
	}
	
	

}
