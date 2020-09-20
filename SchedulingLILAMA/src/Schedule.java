import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Schedule {
        private Integer id;
	    public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}

		private Date start,end ,first ,last ; // Ngay bat dau, ngay ket thuc, ngay dau hoc ky, ngay cuoi hk
        private Integer day;
        private int nday_learn; // so ngay hoc
        private int first_last; // so ngay hoc tu dau ky den cuoi ky
		public int getDay() {
			return day;
		}
		public void setDay(Integer day) {
			this.day = day;
		}

		private byte schedule[];
        private int nWeek;
        public Schedule() {
        	
        }
        public Date getStart() {
			return start;
		}
		public void setStart(Date start) {
			this.start = start;
		}
		public Date getEnd() {
			return end;
		}
		public void setEnd(Date end) {
			this.end = end;
		}
		public Date getFirst() {
			return first;
		}
		public void setFirst(Date first) {
			this.first = first;
		}
		public Date getLast() {
			return last;
		}
		public void setLast(Date last) {
			this.last = last;
		}
		public byte[] getScheule() {
        	
			
        	//this.nWeek=this.getWeeksBetween(first, last);
        	// so ngay HK
        	this.first_last=this.getnDaysBetween(first, last);
        	// 
        	int first_start=this.getnDaysBetween(first, start);
        	int end_last=this.getnDaysBetween(end, last);
        	
        	nday_learn=this.getnDaysBetween(start, end);
        	
        	this.schedule=new byte[this.first_last];
        	       		
        	for(int i=0;i<this.first_last;i++)
        		if(((i+1) % day == 0) & i>first_start & i<this.first_last-end_last)
        	       this.schedule[i]=1;
        		else  this.schedule[i]=0;
        	
            return this.schedule;
		}
       
        public boolean check(Date d) {
        	return true;
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
        
        public int getWeeksBetween (Date a, Date b) {

            if (b.before(a)) {
                return -getWeeksBetween(b, a);
            }
            a = resetTime(a);
            b = resetTime(b);

            Calendar cal = new GregorianCalendar();
            cal.setTime(a);
            int weeks = 0;
            while (cal.getTime().before(b)) {
                // add another week
                cal.add(Calendar.WEEK_OF_YEAR, 1);
                weeks++;
            }
            return weeks;
        }

        public Date resetTime (Date d) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(d);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            return cal.getTime();
        }
        @Override
        public String toString() {
            return "Schedule [id=" + id +"]["+this.start+"]";
        }
        
}
