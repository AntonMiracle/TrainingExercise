/**
 * Project: Tasks HumanNames.java
 */
package com.bam.task.task3.generalclasses;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 9 лют. 2016 р.
 *
 */
public class Names {
	Random					rnd				= new Random();
	final private int		ID				= 563;
	final private String	NAMES[]			= new String[]{"Jacob","Michael","Joshua"};
	final private String	SURNAMES[]		= new String[]{"Abramson","Hoggarth","Adamson"};
	final private String	PATRONYMICS[]	= new String[]{"Liame","Noah","Ethan",};
	private String			name;
	private String			patronymic;
	private String			surname;
	
	public Names() {
		this.name = randomName();
		this.patronymic = randomPatronymic();
		this.surname = randomSurname();
	}

	private Names(String name, String patronymic, String surname) {
		this.name = name;
		this.patronymic = patronymic;
		this.surname = surname;
	}

	public String randomPatronymic() {
		return PATRONYMICS[rnd.nextInt(PATRONYMICS.length)];
	}

	public String randomSurname() {
		return SURNAMES[rnd.nextInt(SURNAMES.length)];
	}

	public String randomName() {
		return NAMES[rnd.nextInt(NAMES.length)];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Names clone() throws CloneNotSupportedException {
		Names names = new Names(name, patronymic, surname);
		return names;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Names) {
			if (((Names) obj).getName().equals(name) && ((Names) obj).getPatronymic().equals(patronymic)
					&& ((Names) obj).getSurname().equals(surname)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 1;
		result = result * 5 * ID * (name.length() + patronymic.length() + surname.length());
		return result;
	}

	public String toStringSimpleName() {
		return name + " " + patronymic.charAt(0) + ". " + surname.charAt(0) + ".";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + " " + patronymic + " " + surname;
	}

	/**
	 * Getting this.name from Names.java
	 * 
	 * @return this.name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getting this.patronymic from Names.java
	 * 
	 * @return this.patronymic
	 */
	public String getPatronymic() {
		return patronymic;
	}

	/**
	 * Getting this.surname from Names.java
	 * 
	 * @return this.surname
	 */
	public String getSurname() {
		return surname;
	}

}
