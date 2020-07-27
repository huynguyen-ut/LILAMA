public class Course {
         private String id;
         private Subject sub;
         private Calendar calendar; // lich hoc
         public Course(String id,Subject sub,Calendar Ns) {
        	 this.id=id;
        	 this.sub=sub;
        	calendar=Ns;
         }
		public Calendar getCalendar() {
			return calendar;
		}
		
}
