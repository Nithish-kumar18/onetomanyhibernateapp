package com.hibernate.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;
public class EmpDeptMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dept dept1 = new Dept();
		dept1.setDeptno(11);
		dept1.setDeptname("Education");
		
		
		Dept dept2 = new Dept();
		dept2.setDeptno(12);
		dept2.setDeptname("Research");
		
		Employee emp1 = new Employee();		
		
		emp1.setEmpname("Satyam");
		emp1.setJob("Manager");

		Employee emp2 = new Employee();		
		
		emp2.setEmpname("Ravi Kumar");
		emp2.setJob("Developer");
		
		Employee emp3 = new Employee();		
		
		emp3.setEmpname("Narayan");
		emp3.setJob("Tester");

		Employee emp4 = new Employee();		
		
		emp4.setEmpname("Maha Lakshmi");
		emp4.setJob("HR-Manager");

		List<Employee> d1emps = new ArrayList<Employee>();
		d1emps.add(emp1);
		d1emps.add(emp3);
		
		List<Employee> d2emps = new ArrayList<Employee>();
		d2emps.add(emp2);
		d2emps.add(emp4);
		
		dept1.setEmps(d1emps);
		dept2.setEmps(d2emps);
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");// reading content from config file
		SessionFactory sf = cfg.buildSessionFactory(); // making connection to database
		
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		s.save(dept1);
		s.save(dept2);
		
		t.commit();
		sf.close();
		s.close();
		
		System.out.println("Row is Inserted....");
	}
}
