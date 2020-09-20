import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

import gurobi.GRBException;

public class SchedulingLILAMA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      /* try {
		@SuppressWarnings("unused")
		MathModel mathmodel=new MathModel("data\\test_1",0);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (GRBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
		try {
			FilterData readfile=new FilterData("data\\test_.xlsx");
			List<Schedule> s=readfile.getListSchedule();
			for (Schedule i : s) 
	            System.out.println(i);
			
			
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
