package entity;

import java.sql.Date;

public class Airport {
	
	private String airportNum;
	private String country;
	private String city;
	private Date relvTimeZone;
	
	
	public Airport(String airportNum, String country, String city, Date date) {
		super();
		this.airportNum = airportNum;
		this.country = country;
		this.city = city;
		this.relvTimeZone = date;
	}
	public String getAirportNum() {
		return airportNum;
	}
	public void setAirportNum(String airportNum) {
		this.airportNum = airportNum;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getRelvTimeZone() {
		return relvTimeZone;
	}
	public void setRelvTimeZone(Date relvTimeZone) {
		this.relvTimeZone = relvTimeZone;
	}
	
	@Override
	public String toString() {
		return " [airportNum=" + airportNum + ", country=" + country + ", city=" + city + ", relvTimeZone="
				+ relvTimeZone + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airportNum == null) ? 0 : airportNum.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((relvTimeZone == null) ? 0 : relvTimeZone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		if (airportNum == null) {
			if (other.airportNum != null)
				return false;
		} else if (!airportNum.equals(other.airportNum))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (relvTimeZone == null) {
			if (other.relvTimeZone != null)
				return false;
		} else if (!relvTimeZone.equals(other.relvTimeZone))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
