/**
 * Project: Tasks SortAbiturient.java
 */
package com.bam.task.task3.abiturient;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @date 12.02.2016 ð.
 *
 */
public class SortAbiturient {
	final private int PRIME = 769;

	public static Abiturient[] lessMark(int mark, Abiturient abi[]) {
		int count = 0;
		for (int i = 0; i < abi.length; i++) {
			for (int j = 0; j < abi[i].getCertificate().getMarks().length; j++) {
				if (abi[i].getCertificate().getMarks()[j].getMark() <= new Integer(mark)) {
					count++;
					break;
				}
			}
		}
		Abiturient newA[] = new Abiturient[count];
		count = 0;
		for (int i = 0; i < abi.length; i++) {
			for (int j = 0; j < abi[i].getCertificate().getMarks().length; j++) {
				if (abi[i].getCertificate().getMarks()[j].getMark() <= new Integer(mark)) {
					try {
						newA[count++] = abi[i].clone();
					} catch (CloneNotSupportedException ex) {
						System.out.println(ex);
					}
					break;
				}
			}
		}
		return newA;
	}

	public static Abiturient[] sumOfMarksUpperValue(int value, Abiturient abi[]) {
		int count = 0;
		for (int i = 0; i < abi.length; i++) {
			count += sumAllMarks(abi[i]) > value ? 1 : 0;
		}
		Abiturient newA[] = new Abiturient[count];
		count = 0;
		for (int i = 0; i < abi.length; i++) {
			if (sumAllMarks(abi[i]) > value) {
				try {
					newA[count++] = abi[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return newA;
	}

	public static Abiturient[] maxValueOfMarks(int numberOfAbiturient, Abiturient abi[]) {
		Abiturient newA[] = new Abiturient[numberOfAbiturient];
		for (int i = 0; i < newA.length; i++) {
			Integer maxMarks = maxValueOfMarks(abi);
			for (int j = 0; j < abi.length; j++) {
				int index = 0;
				if (maxMarks == sumAllMarks(abi[j])) {
					try {
						newA[i] = abi[j].clone();
					} catch (CloneNotSupportedException ex) {
						System.out.println(ex);
					}
					Abiturient tmp[] = new Abiturient[abi.length - 1];
					for (int k = 0; k < abi.length; k++) {
						if (!(abi[k].equals(abi[j]))) {
							try {
								tmp[index++] = abi[k].clone();
							} catch (CloneNotSupportedException ex) {
								System.out.println(ex);
							}
						}
					}
					abi = tmp;
				}
			}
		}
		return newA;
	}

	private static Integer maxValueOfMarks(Abiturient abi[]) {
		Integer max = sumAllMarks(abi[0]);
		for (int i = 0; i < abi.length; i++) {
			max = max < sumAllMarks(abi[i]) ? sumAllMarks(abi[i]) : max;
		}
		return max;
	}

	private static Integer sumAllMarks(Abiturient abi) {
		Integer count = 0;
		for (int i = 0; i < abi.getCertificate().getMarks().length; i++) {
			count += abi.getCertificate().getMarks()[i].getMark();
		}
		return count;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SortAbiturient clone() throws CloneNotSupportedException {
		return new SortAbiturient();
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object arg0) {
		return true;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 7 * PRIME;
	}

}
