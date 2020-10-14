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
}
