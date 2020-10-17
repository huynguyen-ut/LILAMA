import java.util.Date;

public class DayCourse implements Comparable<DayCourse>
{
	private int beginning; // tiet bat dau
    private int number;   // so tiet
    private Date date;       // Ngay hoc
    
    
    public DayCourse(Date d,int beginning,int number) {    // hoc ngay, buoi sang
    	this.date=d;
    	this.beginning=beginning;
    	this.number=number;
    }
	public int getBeginning() {
		return beginning;
	}
	public void setBeginning(int beginning) {
		this.beginning = beginning;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date d) {
		this.date = d;
	}
	public int compareTo(DayCourse c) {
		// TODO Auto-generated method stub
		if(this.date==c.getDate())
			if(this.beginning==c.getBeginning())
		      return 0;
			else if(this.getBeginning()>c.beginning)
		    	return 1;
		        else  return -1;
		
		
		if(this.date.before(c.getDate())) {
			return -1;
		}
		
		return 1;
	}
	

	
}
