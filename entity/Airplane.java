package entity;


import java.util.Objects;

//import org.apache.xpath.operations.String;


public class Airplane {
	
	private String tailNum;
	private String numOfAttendants;
	public Airplane(String tailNum, String numOfAttendants) {
		super();
		this.tailNum = tailNum;
		this.numOfAttendants = numOfAttendants;
	}
	public String getTailNum() {
		return tailNum;
	}
	public void setTailNum(String tailNum) {
		this.tailNum = tailNum;
	}
	public String getNumOfAttendants() {
		return numOfAttendants;
	}
	public void setNumOfAttendants(String numOfAttendants) {
		this.numOfAttendants = numOfAttendants;
	}
	@Override
	public int hashCode() {
		return Objects.hash(numOfAttendants, tailNum);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		return Objects.equals(numOfAttendants, other.numOfAttendants) && Objects.equals(tailNum, other.tailNum);
	}
	@Override
	public String toString() {
		return "Airplane [tailNum=" + tailNum + ", numOfAttendants=" + numOfAttendants + "]";
	}
	
	
	
	
}
