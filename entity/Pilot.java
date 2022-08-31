package entity;


import java.util.Date;
import java.util.Objects;

public class Pilot {

	private String pilotID;
	private String fisrtName;
	private String lastName;
	private String hireDate;
	private String finishDate;
	private String licenseNum;
	private String releaseLicenseDate;
	public Pilot(String pilotID, String fisrtName, String lastName, String hireDate, String finishDate, String licenseNum,
			String releaseLicenseDate) {
		super();
		this.pilotID = pilotID;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.hireDate = hireDate;
		this.finishDate = finishDate;
		this.licenseNum = licenseNum;
		this.releaseLicenseDate = releaseLicenseDate;
	}
	public String getPilotID() {
		return pilotID;
	}
	public void setPilotID(String pilotID) {
		this.pilotID = pilotID;
	}
	public String getFisrtName() {
		return fisrtName;
	}
	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
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
	public String getLicenseNum() {
		return licenseNum;
	}
	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}
	public String getReleaseLicenseDate() {
		return releaseLicenseDate;
	}
	public void setReleaseLicenseDate(String releaseLicenseDate) {
		this.releaseLicenseDate = releaseLicenseDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(finishDate, fisrtName, hireDate, lastName, licenseNum, pilotID, releaseLicenseDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pilot other = (Pilot) obj;
		return Objects.equals(finishDate, other.finishDate) && Objects.equals(fisrtName, other.fisrtName)
				&& Objects.equals(hireDate, other.hireDate) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(licenseNum, other.licenseNum) && Objects.equals(pilotID, other.pilotID)
				&& Objects.equals(releaseLicenseDate, other.releaseLicenseDate);
	}
	@Override
	public String toString() {
		return "Pilot [pilotID=" + pilotID + ", fisrtName=" + fisrtName + ", lastName=" + lastName + ", hireDate="
				+ hireDate + ", finishDate=" + finishDate + ", licenseNum=" + licenseNum + ", releaseLicenseDate="
				+ releaseLicenseDate + "]";
	}
	
	
}
