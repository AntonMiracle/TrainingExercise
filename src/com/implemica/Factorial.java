/**
 * Project: TrainingExercise Factorial.java
 */
package com.implemica;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.6
 *
 */
public class Factorial {
	private String	number;
	private int		factorial;
	private int		memory;

	/**
	 * Constructor create Factorial where factorial equals 1.
	 */
	public Factorial() {
		this(1);
	}

	/**
	 * Constructor create Factorial where factorial is specified number.
	 * 
	 * @param factorial
	 *        specified number
	 */
	public Factorial(int factorial) {
		this.factorial = factorial;
		number = calculationNumber();
	}

	/**
	 * Solution of task #3 which must be solved. Find number of 100! (100
	 * factorial) and count sum value of all digits of the number.
	 */
	public static void solution() {
		Factorial f = new Factorial(100);

		System.out.printf("\n100! = %s", f.getNumber());
		System.out.printf("\nSum of all digits of number is %s", new Integer(f.countSumDigit()).toString());
	}

	/**
	 * Count sum value of all digits of the number.
	 * 
	 * @return int sum value of all digits of the number.
	 */
	private int countSumDigit() {
		int result = 0;
		for (int i = 0; i < getNumber().length(); i++) {
			result += getDigit(getNumber().charAt(i));
		}
		return result;
	}

	/**
	 * Calculation number
	 * 
	 * @return String number
	 */
	private String calculationNumber() {
		String result = "0";
		String intermediateRes = "";
		if (getFactorial() != 0) {
			result = "1";
			for (int i = 1; i <= getFactorial(); i++) {
				for (int j = 1; j < i; j++) {
					if (j == 1) {
						intermediateRes = new String(result);
					}
					result = sum(result, intermediateRes);
				}
			}
		}
		return result;
	}

	/**
	 * Stack two numbers
	 * 
	 * @param biggerValue
	 *        number which bigger than another
	 * @param smallerValue
	 *        number which smaller than first
	 * @return String sum value
	 */
	private String sum(String biggerValue, String smallerValue) {
		StringBuilder result = new StringBuilder("");

		for (int i = biggerValue.length() - 1, j = smallerValue.length() - 1; i >= 0; i--, j--) {
			int a = getDigit(biggerValue.charAt(i));
			int b = j >= 0 ? getDigit(smallerValue.charAt(j)) : 0;
			int sum = a + b + getMemory();
			result = addResult(result, sum);
		}
		result = addResult(result);
		return new String(result.reverse());
	}

	/**
	 * Stack two digits and if sum is equals or more than 10 return true and
	 * memory set to 1. If false memory set to 0
	 * 
	 * @param sum
	 *        of the two digit
	 * @return true if sum equals or more than 10
	 */
	private boolean addMemory(int sum) {
		if (sum >= 10) {
			setMemory(1);
			return true;
		} else {
			setMemory(0);
			return false;
		}
	}

	/**
	 * Add sum of the digits to intermediate result of the number
	 * 
	 * @param intermediateRes
	 *        intermediate result of the number
	 * @param sum
	 *        of the two digit
	 * @return StringBuilder new intermediate result of the number
	 */
	private StringBuilder addResult(StringBuilder intermediateRes, int sum) {
		if (addMemory(sum)) {
			intermediateRes.append(new Integer(sum % 10).toString());
		} else {
			intermediateRes.append(new Integer(sum).toString());
		}
		return intermediateRes;
	}

	/**
	 * If memory equals 1 add additional order to intermediate result of the
	 * number and set memory to 0.
	 * 
	 * @param intermediateRes
	 *        intermediate result of the number
	 * @return StringBuilder new intermediate result of the number
	 */
	private StringBuilder addResult(StringBuilder intermediateRes) {
		if (getMemory() == 1) {
			intermediateRes.append(new Integer(1).toString());
			setMemory(0);
		}
		return intermediateRes;
	}

	/**
	 * Test factorial calculation
	 */
	public void testFactorial() {
		System.out.printf("\n ---- Test factorial (20!)----");
		long longR = 1l;
		String strR = "";

		for (int i = 1; i < 20; i++) {
			setFactorial(i);
			longR *= i;
			strR = calculationNumber();
			boolean isEquals = Long.parseLong(strR) == longR;
			System.out.printf("\nstrR : %s , longR : %s . Factorial : %s . Is equals : %s", strR,
					new Long(longR).toString(), new Integer(getFactorial()).toString(),
					new Boolean(isEquals).toString());
		}
	}

	/**
	 * Test sum calculation
	 */
	public void testSum() {
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				int intRes = i + j;
				String strI = new Integer(i).toString();
				String strJ = new Integer(j).toString();
				String strRes = "";
				if (i > j) {
					strRes = sum(strI, strJ);
				} else {
					strRes = sum(strJ, strI);
				}
				boolean isEquals = Integer.parseInt(strRes) == intRes;
				System.out.printf("\nString : %s , int : %s is equals %s", strRes, new Integer(intRes).toString(),
						new Boolean(isEquals).toString());
			}
		}
	}

	/**
	 * Transformation digit from character to integer
	 * 
	 * @param charValue
	 *        char of the digit of the number
	 * @return int value of the digit of the number
	 */
	private int getDigit(char charValue) {
		String number = "" + charValue;
		return Integer.parseInt(number);
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "\nNumber = " + getNumber() + ",\nFactorial = " + getFactorial();
	}

	/**
	 * Number of the factorial
	 * 
	 * @return String value of the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * factorial of the number
	 * 
	 * @return int value of the factorial
	 */
	public int getFactorial() {
		return factorial;
	}

	/**
	 * Additional memory for stack digits
	 * 
	 * @return int value of the memory
	 */
	public int getMemory() {
		return memory;
	}

	/**
	 * Specified value of the factorial
	 * 
	 * @param factorial
	 *        specified value
	 */
	private void setFactorial(int factorial) {
		this.factorial = factorial;
	}

	/**
	 * Set value of the memory
	 * 
	 * @param memory
	 *        specified value
	 */
	private void setMemory(int memory) {
		this.memory = memory;
	}

}
