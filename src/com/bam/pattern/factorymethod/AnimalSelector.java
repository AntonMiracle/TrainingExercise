/**
 * Project: TrainingExercise AnimalSelector.java
 */
package com.bam.pattern.factorymethod;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class AnimalSelector {
	private static AnimalSelector instance;

	private AnimalSelector() {
	}

	public static synchronized AnimalSelector getInstance() {
		if (instance == null) {
			instance = new AnimalSelector();
		}
		return instance;
	}

	public Animal getAnimal(AnimalName animalName) {
		Animal animal = null;
		switch (animalName) {
			case TIGER:
				animal = new Tiger();
				break;
			case CAT:
				animal = new Cat();
				break;
			case ELEPHANT:
				animal = new Elephant();
				break;
			case OWL:
				animal = new Owl();
				break;
			case PEACOCK:
				animal = new Peacock();
				break;
			case WOLF:
				animal = new Wolf();
				break;
		}
		return animal;
	}
}
