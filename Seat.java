package entity;

import java.util.Objects;


public class Seat {
	
	private String RowNum;
	private String ColNum;
	private String tailNum;
	private String seatClass;
	public Seat(String rowNum, String colNum, String tailNum, String seatClass) {
		super();
		RowNum = rowNum;
		ColNum = colNum;
		this.tailNum = tailNum;
		this.seatClass = seatClass;
	}
	public String getRowNum() {
		return RowNum;
	}
	public void setRowNum(String rowNum) {
		RowNum = rowNum;
	}
	public String getColNum() {
		return ColNum;
	}
	public void setColNum(String colNum) {
		ColNum = colNum;
	}
	public String getTailNum() {
		return tailNum;
	}
	public void setTailNum(String tailNum) {
		this.tailNum = tailNum;
	}
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ColNum, RowNum, seatClass, tailNum);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return ColNum == other.ColNum && RowNum == other.RowNum && seatClass == other.seatClass
				&& Objects.equals(tailNum, other.tailNum);
	}
	@Override
	public String toString() {
		return "Seat [RowNum=" + RowNum + ", ColNum=" + ColNum + ", tailNum=" + tailNum + ", seatClass=" + seatClass
				+ "]";
	}
	
	
	

}
