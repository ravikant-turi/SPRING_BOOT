package com.example.EmployeeManagementSystem.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="emp_Id")
	private Long emp_Id;
	@Column(name="emp_name")

	private String emp_name;
	@Column(name="emp_salary")

	private Float emp_salary;
	@Column(name="emp_age")

	private int emp_age;
	@Column(name="emp_city")

	private String emp_city;
	/**
	 * @param emp_Id
	 * @param emp_name
	 * @param emp_salary
	 * @param emp_age
	 * @param emp_city
	 */
	public Employee(Long emp_Id, String emp_name, Float emp_salary, int emp_age, String emp_city) {
		super();
		this.emp_Id = emp_Id;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.emp_age = emp_age;
		this.emp_city = emp_city;
	}
	public Long getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(Long emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Float getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(Float emp_salary) {
		this.emp_salary = emp_salary;
	}
	public int getEmp_age() {
		return emp_age;
	}
	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}
	public String getEmp_city() {
		return emp_city;
	}
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}
	@Override
	public String toString() {
		return "Emplyee [emp_Id=" + emp_Id + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary + ", emp_age="
				+ emp_age + ", emp_city=" + emp_city + "]";
	}
	/**
	 * 
	 */
	public Employee() {
		
	}
	
	
  
	

}
