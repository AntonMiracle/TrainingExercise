/**
 * Project: Tasks Certificate.java
 */
package com.bam.task.task3.abiturient.certificate;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12.02.2016 ð.
 *
 */
public class Certificate {
	final private int		PRIME	= 877;
	private String			certificate;
	private SchoolObject	objects[];
	private Mark			marks[];

	public Certificate() {
		objects = randomObjects();
		marks = randomMarks();
		certificate = showSertificate(marks, objects);
	}

	private Certificate(String certificate, SchoolObject objects[], Mark marks[]) {
		this.certificate = certificate;
		this.objects = objects;
		this.marks = marks;
	}

	private String showSertificate(Mark marks[], SchoolObject objects[]) {
		String list = "\n--------------------------";
		for (int i = 0; i < marks.length; i++) {
			list += "\n|" + objects[i].toString() + countNeededSpace(objects[i].toString()) + "|  "
					+ marks[i].toString() + "  |";
		}
		list += "\n--------------------------";
		return list;
	}

	private SchoolObject[] randomObjects() {
		SchoolObject obj[] = new SchoolObject[5];
		for (int i = 0; i < obj.length; obj[i++] = new SchoolObject());
		return obj;
	}

	private Mark[] randomMarks() {
		Mark mark[] = new Mark[5];
		for (int i = 0; i < mark.length; mark[i++] = new Mark());
		return mark;
	}

	private String countNeededSpace(String word) {
		String list = "";
		for (int i = 0; i < (18 - word.length()); i++) {
			list += " ";
		}
		return list;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Certificate clone() throws CloneNotSupportedException {
		return new Certificate(certificate, objects, marks);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Certificate) {
			Certificate newC = (Certificate) obj;
			if (newC.getCertificate().equals(certificate)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		certificate = null;
		marks = null;
		objects = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 7 * PRIME;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return certificate;
	}

	/** Getter */
	public String getCertificate() {
		return certificate;
	}

	/** Getter */
	public SchoolObject[] getObjects() {
		return objects;
	}

	/** Getter */
	public Mark[] getMarks() {
		return marks;
	}

}
