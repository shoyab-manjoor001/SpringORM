package com.springcore.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.orm.dao.StudentDao;
import com.springcore.orm.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
       ApplicationContext context =  new ClassPathXmlApplicationContext("config.xml");
       StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//       Student student = new Student(125, "Demo Name5", "Meerut");
//       int r = studentDao.insert(student);
//       System.out.println(r);
    
       BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
       
       boolean flag = true;
       
       while(flag)
       {
    	   System.out.println("########################################");
    	   System.out.println(
    			   "Press 1 to add new Student data"+"\n"+
    			   "Press 2 to get data of a student"+"\n"+
    			   "Press 3 to get all student data"+"\n"+
    			   "Press 4 to update student data"+"\n"+
    			   "Press 5 to delete student data"+"\n"+
    			   "Press 6 to exit the program"
    			   );
    	   System.out.println("########################################");
    	   
    	   try 
    	   {
    		   int input = Integer.parseInt(br.readLine());
    		   int id;
    		   String name,city;
    		   Student st;
    		   switch (input)
    		   {
    		   	case 1:
    		   		System.out.println("***************************************");
    		   		System.out.println("Enter Student id: ");
    		   		id = Integer.parseInt(br.readLine());
    		   		
    		   		System.out.println("Enter Student Name:");
    		   		name = br.readLine();
    		   		
    		   		System.out.println("Enter Student's City:");
    		   		city = br.readLine();
    		   		
    		   		 st = new Student(id, name, city);
    		   		int r = studentDao.insert(st);
    		   		System.out.println("Enter the Student with id: "+r);  
				break;
				
    		   	case 2: 
    		   		System.out.println("***************************************");
    		   		System.out.println("Enter student id:");
    		   		id = Integer.parseInt(br.readLine());
    		   		st = studentDao.getStudent(id);
    		   		System.out.println(
		   					"Student Id: "+st.getId()+"\n"+
		   					"Student Name: "+st.getName()+"\n"+
		   				    "Student City: "+st.getCity()+"\n"
		   			);
    		   		break;
    		   	
    			case 3: 
    				System.out.println("***************************************");
    				List<Student> students = studentDao.getStudents();
    		   		for(Student s :students)
    		   		{
    		   			System.out.println("-------------------------------------");
    		   			System.out.println(
    		   					"Student Id: "+s.getId()+"\n"+
    		   					"Student Name: "+s.getName()+"\n"+
    		   				    "Student City: "+s.getCity()+"\n"
    		   			);
    		   		}
    		   		break;
    		   		
    			case 4: 
    				System.out.println("***************************************"+"\nInside Update Flow");
    				System.out.println("Enter Student id: ");
    		   		id = Integer.parseInt(br.readLine());
    		   		
    		   		System.out.println("Enter Student Name:");
    		   		name = br.readLine();
    		   		
    		   		System.out.println("Enter Student's City:");
    		   		city = br.readLine();
    		   		
    		   		st = new Student(id, name, city);
    		   		studentDao.updateStudent(st);
    		   		System.out.println("Updated Student Details Successfully...");
    		   		break;
    		   		
    			case 5: 
    				System.out.println("***************************************");
    				System.out.println("Enter student id");
    				id = Integer.parseInt(br.readLine());
    		   		st = new Student();
    		   		st.setId(id);
    		   		studentDao.deleteStudent(st);
    		   		System.out.println("Deleted student:"+st);
    		   		break;
    		   		
    			case 6: 
    				System.out.println("***************************************");
    		   		System.out.println("inside 6 method...\n");
    		   		flag=false;
    		   		break;
    		   		
    		   	default:
				break;
			}
    	   } 
    	   catch (Exception e)
    	   {
			System.out.println("Invalid Input Please try with other values..");
			System.out.println(e.toString()+"\n\n");
		}
       }
    }
}
