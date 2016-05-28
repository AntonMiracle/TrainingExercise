package com.bam.pattern.sigleton;

public class User {
	private String		name, surname;
	private int			id;
	private static User	instance;

	public static synchronized User getInstance() {
		if (instance == null) {
			instance = new User();
		}
		return instance;
	}

	private User(String name, String surname, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
	}

	private User() {
		id = 1;
		name = "Anton";
		surname = "Bondarenko";
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			return (((User) obj).getName().equals(name) && ((User) obj).getSurname().equals(surname)
					&& ((User) obj).getId() == id) ? true : false;
		}
		return false;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "User name: " + name + ", surname " + surname;
	}

	/** Getter */
	public String getName() {
		return name;
	}

	/** Getter */
	public String getSurname() {
		return surname;
	}

	/** Getter */
	public int getId() {
		return id;
	}

}
