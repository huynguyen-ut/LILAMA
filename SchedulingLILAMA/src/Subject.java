
public class Subject {
       private Integer id;
       private String name;
       public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Subject(Integer id) {
    	   this.setId(id);
       }
       public Subject() {
    	   
       }
	@SuppressWarnings("unused")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
