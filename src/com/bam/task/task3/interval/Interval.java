/**
 * Project: Tasks Interval.java
 */
package com.bam.task.task3.interval;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Interval {
	private int		begin, end, id;
	private boolean	beginInclude, endInclude;

	public Interval(int id) {
		Random rnd = new Random();
		this.id = id;
		beginInclude = rnd.nextBoolean();
		endInclude = rnd.nextBoolean();
		begin = randomInterval(99)[0];
		end = randomInterval(99)[1];
	}

	public Interval(int id, int begin, int end, boolean beginInclude, boolean endInclude) {
		this.id = id;
		this.begin = begin;
		this.end = end;
		this.beginInclude = beginInclude;
		this.endInclude = endInclude;
	}

	private int[] randomInterval(int bound) {
		Random rnd = new Random();
		int num1 = rnd.nextInt(bound * 2) - (bound);
		int num2 = rnd.nextInt(bound * 2) - (bound);
		while (num1 >= num2) {
			num1 = rnd.nextInt(bound * 2) - (bound);
		}
		return new int[]{num1,num2};
	}

	public static Interval associationInterval(Interval in1, Interval in2) {
		if (isIntervalsIntersection(in2, in1)) {
			Interval newI = new Interval(-1);
			int b1 = in1.isBeginInclude() ? in1.getBegin() : in1.getBegin() + 1;
			int b2 = in2.isBeginInclude() ? in2.getBegin() : in2.getBegin() + 1;
			newI.setBegin(b1 > b2 ? b2 : b1);
			newI.setBeginInclude(true);
			int e1 = in1.isEndInclude() ? in1.getEnd() : in1.getEnd() - 1;
			int e2 = in2.isEndInclude() ? in2.getEnd() : in2.getEnd() - 1;
			newI.setEnd(e1 > e2 ? e1 : e2);
			newI.setEndInclude(true);
			return newI;
		}
		if (isIntervalsIntersection(in1, in2)) {
			Interval newI = new Interval(-1);
			int b1 = in1.isBeginInclude() ? in1.getBegin() : in1.getBegin() + 1;
			int b2 = in2.isBeginInclude() ? in2.getBegin() : in2.getBegin() + 1;
			newI.setBegin(b1 > b2 ? b2 : b1);
			newI.setBeginInclude(true);
			int e1 = in1.isEndInclude() ? in1.getEnd() : in1.getEnd() - 1;
			int e2 = in2.isEndInclude() ? in2.getEnd() : in2.getEnd() - 1;
			newI.setEnd(e1 > e2 ? e1 : e2);
			newI.setEndInclude(true);
			return newI;
		} else {
			Interval newI = new Interval(0);
			newI.setBegin(0);
			newI.setEnd(0);
			newI.setBeginInclude(false);
			newI.setEndInclude(false);
			return newI;
		}
	}

	public static Interval generalInterval(Interval in1, Interval in2) {
		if (isIntervalsIntersection(in2, in1)) {
			Interval newI = new Interval(-1);
			int b1 = in1.isBeginInclude() ? in1.getBegin() : in1.getBegin() + 1;
			int b2 = in2.isBeginInclude() ? in2.getBegin() : in2.getBegin() + 1;
			newI.setBegin(b1 > b2 ? b1 : b2);
			int e1 = in1.isEndInclude() ? in1.getEnd() : in1.getEnd() - 1;
			int e2 = in2.isEndInclude() ? in2.getEnd() : in2.getEnd() - 1;
			newI.setEnd(e1 > e2 ? e2 : e1);
			newI.setBeginInclude(true);
			newI.setEndInclude(true);
			return newI;
		}
		if (isIntervalsIntersection(in1, in2)) {
			Interval newI = new Interval(-1);
			int b1 = in1.isBeginInclude() ? in1.getBegin() : in1.getBegin() + 1;
			int b2 = in2.isBeginInclude() ? in2.getBegin() : in2.getBegin() + 1;
			newI.setBegin(b1 > b2 ? b1 : b2);
			int e1 = in1.isEndInclude() ? in1.getEnd() : in1.getEnd() - 1;
			int e2 = in2.isEndInclude() ? in2.getEnd() : in2.getEnd() - 1;
			newI.setEnd(e1 > e2 ? e2 : e1);
			newI.setBeginInclude(true);
			newI.setEndInclude(true);
			return newI;
		} else {
			Interval newI = new Interval(0);
			newI.setBegin(0);
			newI.setEnd(0);
			newI.setBeginInclude(false);
			newI.setEndInclude(false);
			return newI;
		}
	}
	

	public static boolean isIntervalsIntersection(Interval in1, Interval in2) {
		boolean isIntersection = false;
		if (in1.isBeginInclude()) {
			if (in1.getBegin() > (in2.isBeginInclude() ? in2.getBegin() : in2.getBegin() + (in2.getBegin() < 0? 1: -1))
					&& in1.getBegin() < (in2.isEndInclude() ? in2.getEnd() : in2.getEnd() - (in2.getEnd() > 0? 1: -1))) {
				isIntersection = true;
			}
		} else {
			if (in1.getBegin() + 1 > (in2.isBeginInclude() ? in2.getBegin() : in2.getBegin() + (in2.getBegin() < 0? 1: -1))
					&& in1.getBegin() + 1 < (in2.isEndInclude() ? in2.getEnd() : in2.getEnd() - (in2.getEnd() > 0? 1: -1))) {
				isIntersection = true;
			}
		}		
		return isIntersection;
	}

	public static boolean isPointInInterval(Interval in, int point) {
		boolean isPointIn = false;
		if (in.isBeginInclude() && in.isEndInclude()) {
			isPointIn = in.getBegin() >= point && in.getEnd() <= point ? true : false;
		}
		if (!(in.isBeginInclude()) && in.isEndInclude()) {
			isPointIn = in.getBegin() > point && in.getEnd() <= point ? true : false;
		}
		if (!(in.isBeginInclude()) && !(in.isEndInclude())) {
			isPointIn = in.getBegin() > point && in.getEnd() < point ? true : false;
		}
		if (in.isBeginInclude() && !(in.isEndInclude())) {
			isPointIn = in.getBegin() >= point && in.getEnd() < point ? true : false;
		}
		return isPointIn;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Interval clone() throws CloneNotSupportedException {
		return new Interval(id, begin, end, beginInclude, endInclude);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Interval) {
			Interval i = (Interval) obj;
			if (i.getId() == id && i.getBegin() == begin && i.getEnd() == end && i.isBeginInclude() == beginInclude
					&& i.isEndInclude() == endInclude) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 457;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Interval [begin=" + begin + ", end=" + end + ", id=" + id + ", beginInclude=" + beginInclude
				+ ", endInclude=" + endInclude + "]";
	}

	/** Getter */
	public int getId() {
		return id;
	}

	/** Setter */
	public void setBegin(int begin) {
		this.begin = begin;
	}

	/** Setter */
	public void setEnd(int end) {
		this.end = end;
	}

	/** Setter */
	public void setBeginInclude(boolean beginInclude) {
		this.beginInclude = beginInclude;
	}

	/** Setter */
	public void setEndInclude(boolean endInclude) {
		this.endInclude = endInclude;
	}

	/** Getter */
	public int getBegin() {
		return begin;
	}

	/** Getter */
	public int getEnd() {
		return end;
	}

	/** Getter */
	public boolean isBeginInclude() {
		return beginInclude;
	}

	/** Getter */
	public boolean isEndInclude() {
		return endInclude;
	}

}
