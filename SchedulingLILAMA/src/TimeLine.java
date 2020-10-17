import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeLine {
 
     private Date first_hocky, last_hocky ; 
     private List<DayCourse> timeline;
     
     public TimeLine() {
    	 timeline=new ArrayList<DayCourse>();
     }
     @SuppressWarnings("deprecation")
	public TimeLine(Date first_hocky,Date last_hocky, int weekday,int begin,int number) {
    	 this.first_hocky=first_hocky;
    	 this.last_hocky=last_hocky;
    	 timeline=new ArrayList<DayCourse>();
      	 DayCourse d;	 
    	 Date current =first_hocky ;
    	 
    	    while (current.before(last_hocky)) {
    	        //processDate(current);
    	       if(current.getDay()==weekday) {
    	    	   d=new DayCourse(current,begin,number);  
    	    	   this.timeline.add(d);
    	       }
    	        Calendar calendar = Calendar.getInstance();
    	        calendar.setTime(current);
    	        calendar.add(Calendar.DATE, 1);
    	        current = calendar.getTime();
    	    }
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

	public byte getPositionDay(Date d) {
		
		return 0;
	}
	public int getnDaysBetween(Date a, Date b) {
    	Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(a);
        c2.setTime(b);
        int noDay;
        if(a.equals(b))
        	return 0;
        else
        noDay= (int) ((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000));
        return noDay;
    }
	 public boolean CheckAvailable(DayCourse day) {
     	
		 for(DayCourse d:this.timeline) {
			 if(day==d)
				 return false;
		 }
     	return true;
     }
	
	 
}
