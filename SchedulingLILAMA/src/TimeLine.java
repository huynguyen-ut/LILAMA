import java.util.Date;

public class TimeLine {
     private boolean morning;
     private boolean afternoon;
     private Date first_hocky, last_hocky ; 
     private byte timeline[];
     
     public TimeLine() {
    	 setMorning(false);
    	 setAfternoon(false);
     }
     public TimeLine(Date first_hocky,Date last_hocky) {
    	 this.first_hocky=first_hocky;
    	 this.last_hocky=last_hocky;
    	 
     }
	public Date getFirst_hocky() {
		return first_hocky;
	}
	public void setFirst_hocky(Date first_hocky) {
		this.first_hocky = first_hocky;
	}
	public Date getLast_hocky() {
		return last_hocky;
	}
	public void setLast_hocky(Date last_hocky) {
		this.last_hocky = last_hocky;
	}
	boolean isAfternoon() {
		return afternoon;
	}
	void setAfternoon(boolean afternoon) {
		this.afternoon = afternoon;
	}
	boolean isMorning() {
		return morning;
	}
	void setMorning(boolean morning) {
		this.morning = morning;
	}
	
	public byte getPositionDay(Date d) {
		
		return 0;
	}
	 public byte getStament(byte st) {
     	// initial 2 not schedule
     	// 1 is not available, 0 available
     	return this.timeline[st];
     }
	 public void setStament(byte index,byte st) {
		 this.timeline[index]=st;
	 }
	 
}
