import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Class {
      Integer id;
      String name;
      ArrayList<Course> Cs;
      Calendar ca;
      Schedule schClass;
      List<Schedule> schedules;
      TimeLine timeline;
      
    public List<Schedule> getSchedules() {
		return schedules;
	}
    public byte[] getSchedule(Date d1,Date d2) {
    	byte sche[];
    	byte p1=timeline.getPositionDay(d1);
		   byte p2=timeline.getPositionDay(d1);
		   sche=new byte[p2-p1];
		   int st=0;
		   for(byte i=p1;i<p2;i++)
		   {
			   st=0;
			   for(Schedule sc:this.schedules) {
				   if(sc.getTimeline().getStament(p1)==1)
					   st=1;     // not available
			   }
			   if(st==0)
			    sche[i]=0; //
			   else
				   sche[i]=1;//
		   }
		 return sche;
    }
	public void setSchedule(List<Schedule> schedule) {
		this.schedules = schedule;
	}
	List<Schedule> reSchedule;
      public Integer getId() {
		return id;
	  }
	  public void setId(Integer id) {
		this.id = id;
	  }
	  public String getName() {
		return name;
	  }
      public void setName(String name) {
		this.name = name;
	  }
	
      public Class(Integer id) {
    	  this.id=id;
    	  schedules=new ArrayList<Schedule>();
    	  reSchedule=new ArrayList<Schedule>();
      }
      public Class() {
    	  
      }
      public void addAvailable(int a) {
    	  ca.addAvailable(a);
      }
      public void addSchedule(Schedule sc) {
    	  this.schedules.add(sc);
      }
      public void reSchedule() {
    	  
      }
      
}
