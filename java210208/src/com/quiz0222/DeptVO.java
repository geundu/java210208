package com.quiz0222;

public class DeptVO {
	public EmpVO getEvo() {
		return evo;
	}
	public void setEvo(EmpVO evo) {
		this.evo = evo;
	}
	
	private int deptno = 0;
	private String dname = null;
	private String loc = null;
	private EmpVO evo = null;				//Department ⊃ Employee
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}