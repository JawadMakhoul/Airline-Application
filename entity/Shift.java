package entity;


import java.util.Objects;

public class Shift {
	
	private String shiftNum;
	private String startTime;
	private String finishTime;
	public Shift(String shiftNum, String startTime, String finishTime) {
		super();
		this.shiftNum = shiftNum;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
	public String getShiftNum() {
		return shiftNum;
	}
	public void setShiftNum(String shiftNum) {
		this.shiftNum = shiftNum;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	@Override
	public int hashCode() {
		return Objects.hash(finishTime, shiftNum, startTime);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shift other = (Shift) obj;
		return Objects.equals(finishTime, other.finishTime) && Objects.equals(shiftNum, other.shiftNum)
				&& Objects.equals(startTime, other.startTime);
	}
	@Override
	public String toString() {
		return "Shift [shiftNum=" + shiftNum + ", startTime=" + startTime + ", finishTime=" + finishTime + "]";
	}
	
	
	
	

}
