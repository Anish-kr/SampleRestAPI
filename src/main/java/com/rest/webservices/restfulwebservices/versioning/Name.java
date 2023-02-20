package com.rest.webservices.restfulwebservices.versioning;

public class Name {
	
	private String fname;
	private String sname;
	
	public Name(String fname, String sname) {
		super();
		this.fname = fname;
		this.sname = sname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Name [fname=" + fname + ", sname=" + sname + "]";
	}
	
	

}
