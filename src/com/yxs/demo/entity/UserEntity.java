package com.yxs.demo.entity;

public class UserEntity {

	public UserEntity(){
		this.name     = "";
		this.age      = 0;
		this.hasChild = false;		
	}
	public UserEntity(String name, int age, boolean hasChild){
		this.name     = name;
		this.age      = age;
		this.hasChild = hasChild;
	}
	
	private String        id = "";
	private String      name = "";
	private int          age = 0;
	private boolean hasChild = false;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isHasChild() {
		return hasChild;
	}
	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}
	
	public String toString(){
		return this.name+" : "+this.age+" : "+this.hasChild;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
