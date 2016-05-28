package com.bam.pattern;

import com.bam.pattern.factorymethod.Animal;
import com.bam.pattern.factorymethod.AnimalName;
import com.bam.pattern.factorymethod.AnimalSelector;
import com.bam.pattern.sigleton.User;

public class Runner {

	public static void main(String[] args) {
		// Singleton
		System.out.println(User.getInstance());
		// Factory Method + singleton
		Animal tiger = AnimalSelector.getInstance().getAnimal(AnimalName.TIGER);
		Animal cat = AnimalSelector.getInstance().getAnimal(AnimalName.CAT);
		tiger.eat();
		cat.eat();
	}
}
