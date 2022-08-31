package entity;

import java.sql.Date;

import java.util.Objects;


//import org.apache.xpath.operations.String;
//import org.joda.time.LocalDate;
public class Flight {
	
	private String flightNum;
	private Date departureDate;
	private Date landingDate;
	private String status;
	private String srcAirport;	
	private String destAirport;
	private String tailNum;
	private String mainPilot;
	private String secondPilot;
	
	public Flight(String flightNum, Date departureDate, Date landingDate, String status, String srcAirport,
			String destAirport, String tailNum, String mainPilot,String secondPilot) {
		super();
		this.flightNum = flightNum;
		this.departureDate = departureDate;
		this.landingDate = landingDate;
		this.status = status;
		this.srcAirport = srcAirport;
		this.destAirport = destAirport;
		this.tailNum = tailNum;
		this.mainPilot = mainPilot;
		this.secondPilot=secondPilot;
	}
	
	
	public String getFlightNum() {
		return flightNum;
	}


	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}


	public Date getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}


	public Date getLandingDate() {
		return landingDate;
	}


	public void setLandingDate(Date landingDate) {
		this.landingDate = landingDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getSrcAirport() {
		return srcAirport;
	}


	public void setSrcAirport(String srcAirport) {
		this.srcAirport = srcAirport;
	}


	public String getDestAirport() {
		return destAirport;
	}


	public void setDestAirport(String destAirport) {
		this.destAirport = destAirport;
	}


	public String getTailNum() {
		return tailNum;
	}


	public void setTailNum(String tailNum) {
		this.tailNum = tailNum;
	}


	public String getMainPilot() {
		return mainPilot;
	}


	public void setMainPilot(String mainPilot) {
		this.mainPilot = mainPilot;
	}


	public String getSecondPilot() {
		return secondPilot;
	}


	public void setSecondPilot(String secondPilot) {
		this.secondPilot = secondPilot;
	}


	@Override
	public int hashCode() {
		return Objects.hash(departureDate, destAirport, flightNum, landingDate, mainPilot, secondPilot, srcAirport,
				status, tailNum);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(departureDate, other.departureDate) && Objects.equals(destAirport, other.destAirport)
				&& Objects.equals(flightNum, other.flightNum) && Objects.equals(landingDate, other.landingDate)
				&& Objects.equals(mainPilot, other.mainPilot) && Objects.equals(secondPilot, other.secondPilot)
				&& Objects.equals(srcAirport, other.srcAirport) && Objects.equals(status, other.status)
				&& Objects.equals(tailNum, other.tailNum);
	}


	@Override
	public String toString() {
		return "Flight [flightNum=" + flightNum + ", departureDate=" + departureDate + ", landingDate=" + landingDate
				+ ", status=" + status + ", srcAirport=" + srcAirport + ", destAirport=" + destAirport + ", tailNum="
				+ tailNum + ", mainPilot=" + mainPilot + ", secondPilot=" + secondPilot + "]";
	}


	
	
	


}
