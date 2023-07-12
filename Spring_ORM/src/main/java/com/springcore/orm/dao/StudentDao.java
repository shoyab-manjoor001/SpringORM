package com.springcore.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.springcore.orm.entity.Student;

@Transactional
public class StudentDao 
{
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() 
	{
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) 
	{
		this.hibernateTemplate = hibernateTemplate;
	}


	// creating a new object... 
	
	public int insert(Student student)
	{
		 Integer result =  (Integer) this.hibernateTemplate.save(student);
		return result;	
	}
	
	// getting a single object... 
	
	public Student getStudent(int studentId)
	{
		return this.hibernateTemplate.get(Student.class, studentId);
	}
	
	// getting list of all students..
	
	public List<Student> getStudents()
	{
		return this.hibernateTemplate.loadAll(Student.class);
	
	}
	
	// updating a student... 
	
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.saveOrUpdate(student);
	}
	
	//deleting a student...
	
	public void deleteStudent(Student student)
	{
		this.hibernateTemplate.delete(student);
	}	
}
