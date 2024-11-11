package com.huang.Form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PersonForm {
	
	@NotNull
	private String userId;

	@NotNull
//	@Size(min=2, max=30)
	private String name;

	@NotNull
//	@Min(18)
	private Integer age;
	
	private String pwd;

	

	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String toString() {
		return "Person(Name: " + this.name + ", Age: " + this.age + ")";
	}
}