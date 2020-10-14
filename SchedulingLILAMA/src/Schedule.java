import java.util.Date;

import java.util.Calendar;

public class Schedule {
        private Integer id;
        private Integer id_class;
        private Integer id_subject;
        private Integer id_teacher;
        private Date start_course,end_course ,first_hocky ,last_hocky ; 
        private Integer day;
        private Integer time;
        private Class cls; //  class
        private Subject subject; // subject 
        private Teacher teacher;// teacher
        private TimeLine timeline;
        public TimeLine getTimeline() {
			return timeline;
		}
		public void setTimeline(TimeLine timeline) {
			this.timeline = timeline;
		}
		public Class getCls() {
			return cls;
		}
		public void setCls(Class cls) {
			this.cls = cls;
		}

	     private int first_last; // number of between first and last
	   
        public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}

		
		public int getDay() {
			return day;
		}
		public void setDay(Integer day) {
			this.day = day;
		}

		private byte schedule[];
		private byte AvailableSchedule[];
    
        public Schedule() {
        	
        }
        public Date getStart() {
			return start_course;
		}
		public void setStart(Date start) {
			this.start_course = start;
		}
		public Date getEnd() {
			return end_course;
		}
		public void setEnd(Date end) {
			this.end_course = end;
		}
		public Date getFirst() {
			return first_hocky;
		}
		public void setFirst(Date first) {
			this.first_hocky = first;
		}
		public Date getLast() {
			return last_hocky;
		}
		public void setLast(Date last) {
			this.last_hocky = last;
		}
		public byte[] getScheule() {
        	this.first_last=this.getnDaysBetween(first_hocky, last_hocky);
        	int first_start=this.getnDaysBetween(first_hocky, start_course);
        	int end_last=this.getnDaysBetween(end_course, last_hocky);
          	this.schedule=new byte[this.first_last];
        	
        	// initial 2 not schedule
        	// 1 is not available, 0 available
        	
        	for(int i=0;i<this.first_last;i++)
        		if(((i+1) % day == 0) & i>first_start & i<this.first_last-end_last)
        	       this.schedule[i]=1;
        		else
        			if(i>first_start & i<this.first_last-end_last)
        				 this.schedule[i]=0;
        			else this.schedule[i]=2;
             	
            return this.schedule;
		}
		
		public void getAvailable(Date d1,Date d2) {
		   byte p1=getPositionDay(d1);
		   byte p2=getPositionDay(d2);
		   int st=0;
		   for(byte i=p1;i<p2;i++)
		   {
			   st=0;
			   for(Schedule sc:this.cls.getSchedules()) {
				   if(this.getStament(p1)==1)
					   st=1;     // not available
			   }
			   if(st==0)
			    this.AvailableSchedule[i]=0; //
			   else
				   this.AvailableSchedule[i]=1;//
		   }
			
		}
		public byte getPositionDay(Date d) {
			
			return 0;
		}
       
        public byte getStament(byte st) {
        	// initial 2 not schedule
        	// 1 is not available, 0 available
        	return this.schedule[st];
        }
        
        public Subject getSubject() {
			return subject;
		}
		public void setSubject(Subject subject) {
			this.subject = subject;
		}
		public Teacher getTeacher() {
			return teacher;
		}
		public void setTeacher(Teacher teacher) {
			this.teacher = teacher;
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
        
       
        @Override
        public String toString() {
            return "Schedule [id=" + id +"]["+this.id_class +"]["+this.start_course+"]["+this.day+"]";
        }
		public Integer getId_class() {
			return id_class;
		}
		public void setId_class(Integer id_class) {
			this.id_class = id_class;
		}
		public Integer getId_subject() {
			return id_subject;
		}
		public void setId_subject(Integer id_subject) {
			this.id_subject = id_subject;
		}
		public Integer getId_teacher() {
			return id_teacher;
		}
		public void setId_teacher(Integer id_teacher) {
			this.id_teacher = id_teacher;
		}
		public Integer getTime() {
			return time;
		}
		public void setTime(Integer time) {
			this.time = time;
		}
        
}
