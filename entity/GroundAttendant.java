package entity;

import java.util.Date;
import java.util.Objects;

public class GroundAttendant{

	private String id;
	private String firstName;
	private String lastName;
	private String hireDate;
	private String finishDate;
	public GroundAttendant(String id, String firstName, String lastName, String hireDate, String finishDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hireDate = hireDate;
		this.finishDate = finishDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(finishDate, firstName, hireDate, id, lastName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroundAttendant other = (GroundAttendant) obj;
		return Objects.equals(finishDate, other.finishDate) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(hireDate, other.hireDate) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}
	@Override
	public String toString() {
		return "GroundAttendant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hireDate="
				+ hireDate + ", finishDate=" + finishDate + "]";
	}

	
	
}
