import java.io.FileNotFoundException;

import gurobi.GRBException;

public class SchedulingLILAMA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try {
		@SuppressWarnings("unused")
		MathModel mathmodel=new MathModel("e:/test",0);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (GRBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
