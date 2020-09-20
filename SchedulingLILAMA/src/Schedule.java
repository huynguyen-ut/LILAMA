import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Schedule {
        private Date start,end ,first ,last ; // Ngay bat dau, ngay ket thuc, ngay dau hoc ky, ngay cuoi hk
        private byte schedule[];
        private int nWeek;
        public Schedule(Date start, Date end, Date first,Date last,byte day) {
        	this.start=start;
        	this.end=end;
        	this.nWeek=this.getWeeksBetween(first, last);
        	this.schedule=new byte[7*this.nWeek];
        	       		
        	for(int i=0;i<7*this.nWeek;i++)
        		if((i+1) % day == 0)
        	       this.schedule[i]=1;
        		else  this.schedule[i]=0;
        }
       
        public boolean check(Date d) {
        	return true;
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
        
}
