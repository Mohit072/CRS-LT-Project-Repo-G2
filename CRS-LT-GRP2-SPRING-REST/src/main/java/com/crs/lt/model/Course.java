package com.crs.lt.model;



public class Course {
	private String courseCode;
	private String name;
	private Boolean isOffered=false;
	private int instructorId;
	private int seats=10;
	private int fees=1000;

	public Course() {

	}

	public Course(String courseCode, String courseName, int instructorId, int seats,int fees) {
		super();
		this.courseCode = courseCode;
		this.name = courseName;
		this.setInstructorId(instructorId);
		this.seats = seats;
		this.fees=fees;
	}
	
	

	public Boolean getIsOffered() {
		return isOffered;
	}

	public void setIsOffered(Boolean isOffered) {
		this.isOffered = isOffered;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOffered() {
		return isOffered;
	}

	public void setOffered(Boolean offered) {
		isOffered = offered;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
}
