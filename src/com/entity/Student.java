package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "info")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	private int id;

	@Column(name = "student_Name")
	private String firstName;
	@Column(name = "student_lastName")
	private String lastName;

	// connecting course with student
	@OneToMany(mappedBy = "student",
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Course> course = new ArrayList<Course>();

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public Student() {

	}

	// constructor w/o course
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// constructor with course
	public Student(String firstName, String lastName, List<Course> course) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", course=" + course + "]";
	}
	
	// add convenience method for bi-directional relationship
		public void add(Course tempCourse) {
			if(course ==null) {
				course = new ArrayList<>();
			}
			course.add(tempCourse);
			tempCourse.setStudent(this);
		}

}
