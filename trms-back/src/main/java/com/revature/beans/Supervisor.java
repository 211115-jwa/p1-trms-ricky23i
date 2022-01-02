package com.revature.beans;

public class Supervisor extends Employee{
	public Supervisor() {
		this.setEmpId(0);
		this.setFirstName("First");
		this.setLastName("Last");
		this.setUsername("");
		this.setPassword("");
		this.setRole(new Role());
		this.setFunds(1000.00);
		this.setSupervisor(null);
		this.setDepartment(new Department());
	}	
	public Supervisor(int id, String fname, String dname, String us,String pw, Role r, double f, Department d) {
		this.setEmpId(id);
		this.setFirstName(fname);
		this.setLastName(dname);
		this.setUsername(us);
		this.setPassword(pw);
		this.setRole(r);
		this.setFunds(f);
		this.setSupervisor(null);
		this.setDepartment(d);
	}	
	
	
}
