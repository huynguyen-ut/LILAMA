public class Course {
         private String id;
         private Subject sub;
         private Calendar schedule;
         public Course(String id,Subject sub,Calendar Ns) {
        	 this.id=id;
        	 this.sub=sub;
        	schedule=Ns;
         }
		public Calendar getCalendar() {
			return this.schedule;
		}
		
}
