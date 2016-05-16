/**
 * Project: Tasks ShowAbiturient.java
 */
package com.bam.task.task3.abiturient;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12.02.2016 ð.
 *
 */
public class ShowAbiturient {
	final private int	PRIME	= 223;
	private String		show;

	public ShowAbiturient(Abiturient abi) {
		show = showOneAbiturient(abi);
	}

	public ShowAbiturient(Abiturient abi[]) {
		show = "";
		for (int i = 0; i < abi.length; i++) {
			show += showOneAbiturient(abi[i]);
		}
	}

	private ShowAbiturient(String show) {
		this.show = new String(show);
	}

	private String showOneAbiturient(Abiturient abi) {
		String show = "";
		show += "\n--------------------------" + "\n|     Abiturient ID      | " + abi.getId().toString()
				+ "\n|       Full name        | " + abi.getHuman().toString() + "\n|         Adress         | "
				+ abi.getAdress().toString() + "\n|         Phone          | " + abi.getPhone().toString()
				+ "\n--------------------------" + "\n|       Certificate      | " + abi.getCertificate().toString();
		return show;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected ShowAbiturient clone() throws CloneNotSupportedException {
		return new ShowAbiturient(show);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof ShowAbiturient) {
			if (((ShowAbiturient) obj).getShow().equals(show)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return show;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		show = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 5;
	}

	/** Getter */
	public String getShow() {
		return show;
	}

}
