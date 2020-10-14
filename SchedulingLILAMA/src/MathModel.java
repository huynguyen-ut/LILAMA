import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;

public class MathModel {
		
	  private int time_=0;
      private int nG; // so luong GV
      private int nL; // so luong lop hoc
      private int nM; // so luong mon hoc
      private int nO; // so luong lop hoc phan
      private int nR; // phong hoc
      
      private ArrayList<Teacher> Ts; // DS GV
      private ArrayList<Subject> Ss;// DS Mon hoc
      private ArrayList<Course> Cs;  // DS khoa hoc
      private ArrayList<Room> Rs;   // DS phong hoc
      private ArrayList<Class> Ls;  //Lop hoc
      private Calendar Ca;
      
      private GRBVar[][][] x; // Bien quyet dinh
      GRBModel model;
      
      public void readData(String fileName) throws FileNotFoundException {
    	  @SuppressWarnings("resource")
		  Scanner inFile = new Scanner(new File(fileName+".txt"));
    	  
    	  this.Ts=new ArrayList<Teacher>();
    	  this.Cs=new ArrayList<Course>();
    	  this.Rs=new ArrayList<Room>();
    	  this.Ss=new ArrayList<Subject>();
    	  this.Ls=new ArrayList<Class>();
    	  /////////////////////////// data Teacher
    	  String s = inFile.nextLine(); // Doc dong dau tien Teacher
     	  String[] tokens = s.split("\t");
     	  this.nG=Integer.parseInt(tokens[0]); // so luong GV
     	  for (int i = 0; i < this.nG; i++) {
     	  s = inFile.nextLine();
     	  tokens = s.split("\t");
     	
     	  Teacher t=new Teacher(Integer.parseInt(tokens[0]));
     	  Ts.add(t);
     	  	for(int j=1;j<tokens.length;j++)
     		  t.addAvailable(Integer.parseInt(tokens[j]));
     	  }
     	  //////////////////////////// Data mon hoc
     	  s = inFile.nextLine(); //
   	      tokens = s.split("\t");
   	      this.nM=Integer.parseInt(tokens[0]);
   	      Subject sub;
   	      for (int i = 0; i < this.nM; i++)
   	      {
   	    	 s = inFile.nextLine();
   	    	 tokens = s.split("\t");
   	    	 sub=new Subject(Integer.parseInt(tokens[0]));
   	    	 this.Ss.add(sub);
   	      }
   	      //////////////////////////// Data Class
   	       s = inFile.nextLine(); // Doc dong dau tien
   	       tokens = s.split("\t");
  	       this.nL=Integer.parseInt(tokens[0]);
  	       Class cl;
  	       for (int i = 0; i < this.nL; i++) {
  	    	 s = inFile.nextLine(); // Doc dong dau tien course
      	     tokens = s.split("\t");
      	     cl=new Class(Integer.parseInt(tokens[0]));
      	     Ls.add(cl);
  	       }
     	  //////////////////////////// data course
     	   s = inFile.nextLine(); // Doc dong dau tien course
     	   Course course;
     	   Calendar cal;
     	   tokens = s.split("\t");
     	   this.nO=Integer.parseInt(tokens[0]); // so luong course
     	   for (int i = 0; i < this.nO; i++) {
     		   s = inFile.nextLine(); // Doc dong dau tien course
        	   tokens = s.split("\t");
        	   cal=new Calendar();
        	   for(int j=2;j<tokens.length;j++) 
        		   cal.addAvailable(Integer.parseInt(tokens[j]));
        	   course=new Course(tokens[0],this.findSubject(Integer.parseInt(tokens[1])) ,cal);
        	   this.Cs.add(course);
        	   
     	   }
     	   //////////////////////////// data Room
    	   s = inFile.nextLine(); // Doc dong dau tien course  
    	   Room room;
    	   tokens=s.split("\t");
    	   this.nR=Integer.parseInt(tokens[0]);
    	   for (int i = 0; i < this.nR; i++) 
    	   {
    		   s = inFile.nextLine();
    		   tokens=s.split("\t");
    		   cal=new Calendar();
    		   for(int j=1;j<tokens.length;j++) 
        		   cal.addAvailable(Integer.parseInt(tokens[j]));
    		   room=new Room(tokens[0],cal);
    		   this.Rs.add(room);
    	   }
    	   ////////////////////////////
      }
      public boolean checkAvailable(int i,int j,int t) {
    	  if(this.Cs.get(i).getCalendar().CheckAvailable(t)==1&&this.Rs.get(j).getCalendar().CheckAvailable(t)==1)
             return true;
    	  else return false;
      }
      public MathModel(String fileName,int time) throws FileNotFoundException, GRBException{
    	 
    	  if(time==0)
    		  time_=6;
    		  else
    			  if(time==1)
    				  time_=12; 
    	  this.readData(fileName);
    	  GRBEnv env = new GRBEnv();
  		  model = new GRBModel(env);
  		  x = new GRBVar[this.nO][this.nR][time_];
  		  
  		for (int i = 0; i < this.nO; i++)
			for (int j = 0; j < this.nR; j++)
				for (int t = 0; t <time_ ; t++)
					if(checkAvailable(i,j,t))
					x[i][j][t] = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, "x_" + i + "_" + j + "_" + t);   
        model.update();  
        this.constraint1();
        this.constraint2();
        this.constraint3();
        this.objective();
  		
      }
      private Subject findSubject(int id) {
    	  for(Subject s:this.Ss) {
    		  if(s.getId()==id)
    			  return s;
    		  
    	  }
    	  return null;
      }
      public void constraint1() throws GRBException {
    	  // 1 course chi hoc tai 1 phong tai 1 thoi diem
    		GRBLinExpr expr = null;
    		for (int i = 0; i < this.nO; i++) {
    			expr=new GRBLinExpr();
    			for (int j = 0; j < this.nR; j++)
    				for (int t = 0; t <time_ ; t++)
    					if(checkAvailable(i,j,t))
    					expr.addTerm(1, x[i][j][t]);
    		model.addConstr(expr, GRB.LESS_EQUAL, 1, "contr_1");	
    		}
    		
      }
      public void constraint2() throws GRBException {
    	  // 1 room chi co 1 lop hoc tai 1 thoi diem
    	  GRBLinExpr expr = null;
    	  for (int j = 0; j < this.nR; j++){
  			expr=new GRBLinExpr();
  			for (int i = 0; i < this.nO; i++)
  				for (int t = 0; t <time_ ; t++)
  					if(checkAvailable(i,j,t))
  					expr.addTerm(1, x[i][j][t]);
  		     model.addConstr(expr, GRB.LESS_EQUAL, 1, "contr_2");	
  		}
      }
      public void constraint3() throws GRBException {
    	  // 1 thoi diem chi co 1 lop hoc tai 1 phong
    	  GRBLinExpr expr = null;
    	  for (int t = 0; t <time_ ; t++){
  			expr=new GRBLinExpr();
  			for (int i = 0; i < this.nO; i++)
  				 for (int j = 0; j < this.nR; j++)
  					if(checkAvailable(i,j,t))
  					expr.addTerm(1, x[i][j][t]);
  		     model.addConstr(expr, GRB.LESS_EQUAL, 1, "contr_2");	
  		}
      }
      
      public void objective() throws GRBException {
    	  // tong cac matching nhieu nhat
    	  GRBLinExpr func = new GRBLinExpr();
    	  for (int i = 0; i < this.nO; i++)
  			for (int j = 0; j < this.nR; j++)
  				for (int t = 0; t <time_ ; t++)
  					if(checkAvailable(i,j,t))
  					func.addTerm(1.0, x[i][j][t]);
    	  
    		model.setObjective(func, GRB.MAXIMIZE);
    		model.optimize();
      }
}
