import java.util.ArrayList;
import java.util.List;

public class Teacher {
       Integer id; // 
       String name;
       List<Schedule> schedule;
       ArrayList<Course> Cs;
       Calendar Ca;
       public String getName() {
		return name;
	   }
	   public void setName(String name) {
        		this.name = name;
	   }
	  
       public Teacher() {
    	   
       }
       public Teacher(Integer id)  {
    	this.id=id;
    	this.Ca=new Calendar();
       }
       public Integer getId() {
		return id;
       }
       public void setId(Integer id) {
		this.id = id;
       }
       public void addAvailable(int a) {
    	   this.Ca.addAvailable(a);
       }
       public void addAvailables(int []a) {
    	   this.Ca.addAvailables(a);
       }
}
