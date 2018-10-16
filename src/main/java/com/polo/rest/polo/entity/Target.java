package com.polo.rest.polo.entity;

//@Entity
public class Target {

	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String target;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	@Override
	public String toString() {
		return "Target [id=" + id + ", target=" + target + "]";
	}
	
}
