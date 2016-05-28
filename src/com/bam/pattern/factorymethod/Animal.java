/**
 * Project: TrainingExercise Animal.java
 */
package com.bam.pattern.factorymethod;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public abstract class Animal implements Vital {
	private int			id;
	private AnimalName	name;
	private int			age;
	private int			health;
	private int			price;
	private FoodType	foodType;
	private String nick;
	
	/** Getter */
	public int getId() {
		return id;
	}
	
	/** Setter */
	public void setId(int id) {
		this.id = id;
	}
	
	/** Getter */
	public AnimalName getName() {
		return name;
	}
	
	/** Setter */
	public void setName(AnimalName name) {
		this.name = name;
	}
	
	/** Getter */
	public int getAge() {
		return age;
	}
	
	/** Setter */
	public void setAge(int age) {
		this.age = age;
	}
	
	/** Getter */
	public int getHealth() {
		return health;
	}
	
	/** Setter */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/** Getter */
	public int getPrice() {
		return price;
	}
	
	/** Setter */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/** Getter */
	public FoodType getFoodType() {
		return foodType;
	}
	
	/** Setter */
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
	
	/** Getter */
	public String getNick() {
		return nick;
	}
	
	/** Setter */
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
}
