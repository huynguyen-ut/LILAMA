import java.util.ArrayList;

public class Teacher {
       String id; // 
       ArrayList<Course> Cs;
       Calendar Ca;
       public Teacher() {
    	   
       }
       public Teacher(String id)  {
    	this.id=id;
    	this.Ca=new Calendar();
       }
       public void addAvailable(int a) {
    	   this.Ca.addAvailable(a);
       }
       public void addAvailables(int []a) {
    	   this.Ca.addAvailables(a);
       }
}
