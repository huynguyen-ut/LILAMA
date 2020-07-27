import java.util.ArrayList;

public class Class {
      String id;
      ArrayList<Course> Cs;
      Calendar ca;
      public Class(String id) {
    	  this.id=id;
    	  ca=new Calendar();
      }
      public void addAvailable(int a) {
    	  ca.addAvailable(a);
      }
}
