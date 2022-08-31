package entity;

import java.util.Objects;

public class GroundAttendantInShift {

	private String AttendantId;
	private String shiftid;
	private String role;
	public GroundAttendantInShift(String attendantId, String shiftid, String role) {
		super();
		AttendantId = attendantId;
		this.shiftid = shiftid;
		this.role = role;
	}
	public String getAttendantId() {
		return AttendantId;
	}
	public void setAttendantId(String attendantId) {
		AttendantId = attendantId;
	}
	public String getShiftid() {
		return shiftid;
	}
	public void setShiftid(String shiftid) {
		this.shiftid = shiftid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		return Objects.hash(AttendantId, role, shiftid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroundAttendantInShift other = (GroundAttendantInShift) obj;
		return Objects.equals(AttendantId, other.AttendantId) && role == other.role
				&& Objects.equals(shiftid, other.shiftid);
	}
	@Override
	public String toString() {
		return "GroundAttendantInShift [AttendantId=" + AttendantId + ", shiftid=" + shiftid + ", role=" + role + "]";
	}
	
	
}
