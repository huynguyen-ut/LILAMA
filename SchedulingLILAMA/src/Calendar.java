import java.util.ArrayList;

public class Calendar {
        ArrayList<Node> date;
        ArrayList<Integer> dAvailable;
        public Calendar(){
        	this.date=new ArrayList<Node>();
        	this.dAvailable=new ArrayList<Integer>();
        }
        public void addAvailable(int a) {
        	this.dAvailable.add(a);
        }
        public void addAvailables(int []a) {
        	for(int i=0;i<a.length;i++)
        	this.dAvailable.add(a[i]);
        }
        public int CheckAvailable(int index) {
        	return this.dAvailable.get(index);
        }
        
}
