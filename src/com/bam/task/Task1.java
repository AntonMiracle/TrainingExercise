/**
 * Project: Tasks Task1.java
 */
package com.bam.task;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @since 31 december 2016
 *
 */
public class Task1 {

	Scanner			scan		= new Scanner(System.in);
	private String	password	= "name";
	private int		numbers[];

	/**
	 * Construction create arrays with custom numbers
	 */
	public Task1() {
		numbers = new int[22];
		numbers[0] = -10;
		numbers[1] = 1;
		numbers[2] = 56;
		numbers[3] = 34;
		numbers[4] = 55;
		numbers[5] = 89;
		numbers[6] = 111;
		numbers[7] = 99;
		numbers[8] = -50;
		numbers[9] = -70;
		numbers[10] = 201;
		numbers[11] = 161;
		numbers[12] = 121;
		numbers[13] = 1221;
		numbers[14] = 900;
		numbers[15] = 2277;
		numbers[16] = 333;
		numbers[17] = -156;
		numbers[18] = 900;
		numbers[19] = 0;
		numbers[20] = 1221;
		numbers[21] = 900;
	}

	/**
	 * Construction arrays with input options by user
	 * 
	 * @param bount
	 */
	public Task1(int bount) {
		Scanner scan = new Scanner(System.in);
		numbers = new int[bount];
		for (int i = 0; i < numbers.length; i++) {
			System.out.print("Enter number �" + (i + 1) + " : ");
			numbers[i] = scan.nextInt();
		}
		scan.close();
	}

	/**
	 * A1 Greeting users after input name by console
	 */
	public void helloName() {
		String name;
		System.out.print("Enter your name and press  \"Enter\": ");
		name = scan.next();
		System.out.print("\nHello " + name);
	}

	/**
	 * A2 Print in console arguments command line in revers order
	 * 
	 * @param args
	 *        arguments of command line
	 */
	public void printConsolArguments(String args) {
		String[] text = args.split(" ");
		for (String str : text) {
			System.out.printf("Argument -> %s%n", str);
		}
	}

	/**
	 * A3 Print in console different numbers without and with new line
	 */
	public void variousNumbers() {
		int x = 10, y = 2, z = 300, t = 100;
		System.out.print("\nWith next line: " + x + " " + z + " " + y + " " + t);
		System.out.print("\nWithout next line: " + x + " " + z + " " + y + " " + t);
	}

	/**
	 * A4.1 Return password
	 * 
	 * @return password word
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * A4.2 Enter password
	 */
	public void setPassword() {
		System.out.print("\nEnter password and press \"Enter\": ");
		this.password = scan.next();
	}

	/**
	 * A4.3 Compare word with template word
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Task1) {
			if (((Task1) obj).getPassword().equals(this.password)) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	/**
	 * A5 Enter numbers like argument command line and do math with them
	 */
	public void collectNumbers() {
		int number1, number2;
		System.out.print("\nEnter 2 numbers:");
		number1 = scan.nextInt();
		number2 = scan.nextInt();
		System.out.print("\nSum of this numbers = " + (number1 + number2));
		System.out.print("\nComposition of this numbers = " + (number1 * number2));

	}

	/**
	 * A6 Print users surname and name.
	 */
	public void surnameDateTimeTask() {
		System.out.print("\nAuthor: Bondarenko Anton" + "\nTask was accept in 9 january 2016 year."
				+ "\nTask need finish to 10 january 2016 year.\n\n");

	}

	/**
	 * Return links of arrays of this.numbers
	 * 
	 * @return int[] links of arrays
	 */
	public int[] getNumbers() {
		return numbers;
	}

	/**
	 * Create copy of original array
	 * 
	 * @return int[] links of arrays
	 */
	private int[] copyNumbers() {
		int[] newNumbers = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			newNumbers[i] = numbers[i];
		return newNumbers;
	}

	/**
	 * Create double copy of original array
	 * 
	 * @return double[] links of arrays
	 */
	private double[] copyNumbersDouble() {
		double[] newNumbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			newNumbers[i] = numbers[i];
		return newNumbers;
	}

	/**
	 * Find odd and even numbers of numbers
	 */
	public void evenOddNumbers() {
		String odd = "odd numbers: ", even = "even numbers: ";
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				even += " " + numbers[i];
			} else {
				odd += " " + numbers[i];
			}
		}
		System.out.print("\n" + even + " \n" + odd);
	}

	/**
	 * B2 Find maximum and minimum number
	 */
	public void maxMinNumber() {
		int maxNumber = numbers[0], minNumber = numbers[0];
		for (int i = numbers.length - 1; i > 0; i--) {
			if (maxNumber <= numbers[i]) maxNumber = numbers[i];
			if (minNumber >= numbers[i]) minNumber = numbers[i];
		}
		System.out.print("\nMinimum number is " + minNumber + ", maximum number is " + maxNumber);
	}

	/**
	 * B3 find numbers wich divide by 3 or by 9 B4 find numbers wich divide by 5
	 * and by 7
	 */
	public void division() {
		String division3 = "Number that division on 3 : ", division9 = "Number that division on 9 : ",
				division57 = "Number that division on 5 and 7: ";
		for (int num : numbers) {
			if (num % 3 == 0) division3 += " " + num;
			if (num % 9 == 0) division9 += " " + num;
			if (num % 5 == 0 && num % 7 == 0) division57 += " " + num;
		}
		System.out.print("\n" + division3 + "\n" + division9 + "\n" + division57);
	}

	/**
	 * B5 Sort array by buble
	 */
	public void bubble() {
		int[] newNumbers = copyNumbers();
		int tmp;

		for (int i = newNumbers.length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)

				if (Math.abs(newNumbers[j]) < Math.abs(newNumbers[j + 1])) {
					tmp = newNumbers[j];
					newNumbers[j] = newNumbers[j + 1];
					newNumbers[j + 1] = tmp;
				}
		System.out.print("\nBuble sort from hight of numbers modul: \n");
		for (int num : newNumbers)
			System.out.print(" " + num);
	}

	/**
	 * B6 Find three-digit numbers wich have different numbers
	 */
	public void threeDigitNumber() {
		String number, threeDigitalNumbers = "All three-digitals numbers that have non-recurring numeral:";
		for (int i = 0; i < numbers.length; i++) {
			number = new Integer(numbers[i]).toString();
			if (numbers[i] > 99 && numbers[i] < 1000 && number.charAt(0) != number.charAt(1)
					&& number.charAt(0) != number.charAt(2) && number.charAt(1) != number.charAt(2)) {
				threeDigitalNumbers += " " + numbers[i];
			}
		}
		System.out.print("\n" + threeDigitalNumbers);
	}

	/**
	 * B7.1 Maximum common divisor of numbers
	 */
	public void commonDivisor() {
		int[] newNumbers = copyNumbers();
		int max = 0, count = 0, maxCommonDivisor = 0;

		for (int num : newNumbers) {
			if (max <= num) {
				max = num;
			}
		}
		for (int i = 1; i <= max; i++) {
			for (int j = 0; j < newNumbers.length; j++) {
				if (newNumbers[j] % i == 0) {
					count++;
				}
			}
			if (count == newNumbers.length) {
				maxCommonDivisor = i;
				count = 0;
			} else {
				maxCommonDivisor = i - 1;
				System.out.print("\nMaximum common divisor: " + maxCommonDivisor);
				break;
			}
		}
	}

	/**
	 * B7.2 Smallest fold of numbers
	 */
	public void smallestFold() {
		int[] newNumbers = copyNumbers();
		int count = 0, smallestFold = 0, max = 0;

		for (int num : newNumbers) {
			if (max <= num) {
				max = num;
			}
		}
		for (int i = max; i < 2147483647; i++) {
			for (int j = 0; j < newNumbers.length; j++) {
				if (newNumbers[j] % i == 0) {
					count++;
				}
			}
			if (count == newNumbers.length) {
				smallestFold = i;
			} else {
				smallestFold = 0;
			}
		}

		System.out.print("\nSmallest fold is: " + smallestFold);
	}

	/**
	 * B8 Find simple number from numbers array
	 */
	public void simpleNumbers() {
		String simpleNumbers = "Simple numbers : ";
		int max = numbers[0], count;

		for (int i = numbers.length - 1; i > 0; i--)
			if (max <= numbers[i]) max = numbers[i];
		for (int i = 0; i < numbers.length; i++) {
			count = 0;
			for (int j = 2; j < max + 1; j++)
				if (numbers[i] > 0 && numbers[i] % j == 0) count++;
			if (count == 1) simpleNumbers += " " + numbers[i];
		}
		System.out.print("\n" + simpleNumbers);
	}

	/**
	 * B9 Sort numbers from small to big and from big to small
	 */
	public void sortBigSmall() {
		String fromBig = "Sort from big to small: ", fromSmall = "Sort from small to big: ";
		int index = 0;
		int[] tmp = new int[numbers.length];
		int[] newNumbers = copyNumbers();

		Arrays.sort(newNumbers);
		for (int i = newNumbers.length - 1; i >= 0; i--) {
			tmp[index] = newNumbers[i];
			index++;
		}
		for (int num : newNumbers)
			fromSmall += " " + num;
		for (int num : tmp)
			fromBig += " " + num;
		System.out.print("\n" + fromSmall + "\n" + fromBig);
	}

	/**
	 * B10 Sort numbers by frequency number
	 */
	public void frequencyNumber() {
		int count, index, number;
		int[][] frequency;
		String frequencyText = "\nFrequency numbers: ";
		int[] newNumbers = copyNumbers();

		Arrays.sort(newNumbers);
		count = 1;
		number = newNumbers[0];
		for (int i = 0; i < newNumbers.length; i++) {
			if (number != newNumbers[i]) count++;
			number = newNumbers[i];
		}
		frequency = new int[2][count];
		count = 0;
		index = 0;
		number = newNumbers[0];
		for (int i = 0; i < newNumbers.length; i++) {
			if (number == newNumbers[i]) {
				count++;
				frequency[0][index] = newNumbers[i];
				frequency[1][index] = count;
			} else {
				count = 1;
				index++;
				frequency[0][index] = newNumbers[i];
				frequency[1][index] = count;
			}
			number = newNumbers[i];
		}
		for (int i = frequency[1].length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				if (frequency[1][j] > frequency[1][j + 1]) {
					int tmpCount = frequency[1][j];
					int tmpNum = frequency[0][j];
					frequency[1][j] = frequency[1][j + 1];
					frequency[0][j] = frequency[0][j + 1];
					frequency[1][j + 1] = tmpCount;
					frequency[0][j + 1] = tmpNum;
				}
		frequencyText += "\nAfter sort:";
		for (int i = 0; i <= index; i++)
			frequencyText += "\nNumber: " + frequency[0][i] + " occurs: " + frequency[1][i];
		System.out.print(frequencyText);
	}

	/**
	 * B11 Find lucky number
	 */
	public void luckyNumbers() {
		int[] twinNumbers;
		int count, index, partOne, partTwo, notNegative;
		String number, luckyNumbers;

		count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0)
				notNegative = numbers[i] * (-1);
			else
				notNegative = numbers[i];
			number = new Integer(notNegative).toString();
			if (number.length() % 2 == 0) count++;
		}
		twinNumbers = new int[count];
		index = 0;
		number = "";
		for (int i = 0; i < numbers.length; i++) {
			number = new Integer(numbers[i]).toString();
			if (numbers[i] < 0 && (number.length() - 1) % 2 == 0) {
				twinNumbers[index] = numbers[i];
				index++;
			}
			if (numbers[i] >= 0 && number.length() % 2 == 0) {
				twinNumbers[index] = numbers[i];
				index++;
			}
		}
		luckyNumbers = "";
		for (int i = 0; i < twinNumbers.length; i++) {
			number = new Integer(twinNumbers[i]).toString();
			partOne = 0;
			partTwo = 0;
			if (twinNumbers[i] < 0)
				for (int j = 1; j < number.length(); j++) {
					if (j <= ((number.length() / 2)))
						partOne += Character.getNumericValue(number.charAt(j));
					else
						partTwo += Character.getNumericValue(number.charAt(j));
				}
			else
				for (int j = 0; j < number.length(); j++) {
					if (j <= ((number.length() / 2) - 1))
						partOne += Character.getNumericValue(number.charAt(j));
					else
						partTwo += Character.getNumericValue(number.charAt(j));
				}
			if (partOne == partTwo) luckyNumbers += " " + number;
		}
		System.out.print("\nLucky number : " + luckyNumbers);
	}

	/**
	 * B12 Search Fobinachi numbers
	 */
	public void fobinachiNumbers() {
		String fibonachiNum = "Fibonachi numbers: ";

		for (int i = 0; i < numbers.length; i++)
			if (i > 1 && numbers[i - 1] + numbers[i - 2] == numbers[i]) fibonachiNum += " " + numbers[i];
		System.out.print("\n" + fibonachiNum);
	}

	/**
	 * B13 Find polindrom number
	 */
	public void polindromNumbers() {
		String number, reversNumber, polindromNumber = "Polindrom numbers:";

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 9) {
				number = "";
				reversNumber = "";
				number = new Integer(numbers[i]).toString();
				if (numbers[i] >= 0)
					for (int j = number.length() - 1; j >= 0; j--)
						reversNumber += number.charAt(j);
				else
					for (int j = number.length() - 1; j > 0; j--)
						reversNumber += number.charAt(j);
				if (number.equals(reversNumber)) polindromNumber += " " + number;
			}
		}
		System.out.print("\n" + polindromNumber);
	}

	/**
	 * B14 Find number that equals half sum of adjacent number
	 */
	public void numbersHalfSumOfAdjacent() {
		int[] newNumbers = copyNumbers();
		String halfSumNumbers = "Numbers that equals to the half sum adjacent: ";

		for (int i = 1; i < newNumbers.length - 1; i++)
			if (newNumbers[i] == ((newNumbers[i - 1] + newNumbers[i + 1]) / 2)) halfSumNumbers += " " + newNumbers[i];
		System.out.print("\n" + halfSumNumbers);
	}

	/**
	 * B15 Print decimal period of first and second numbers which above zero and
	 * follow each other
	 */
	public void decimalPeriod() {
		double[] newNumbers = copyNumbersDouble();
		double firstNumber = 0, secondNumber = 1;
		int point;
		String period, checkPeriod, beforePeriod = "", beforePointNumber = "", afterPointNumbers = "", number = "",
				numOne, numTwo;

		point = 0;
		for (int i = 0; i < newNumbers.length; i++) {
			if (newNumbers[i] > 0) {
				point++;
				switch (point) {
					case 1:
						firstNumber = newNumbers[i];
						break;
					case 2:
						secondNumber = newNumbers[i];
						break;
				}
			}
			if (point == 2) break;
		}
		if (secondNumber != 0) {
			number = Double.toString(firstNumber / secondNumber);
		} else
			System.err.print("\nDivision is = 0");
		point = 0;
		for (int i = 0; i < number.length(); i++) {
			if (point == 1) {
				afterPointNumbers += number.charAt(i);
			}
			if (number.charAt(i) == '.') {
				point = 1;
			}
			if (point < 1) {
				beforePointNumber += number.charAt(i);
			}
		}
		if (afterPointNumbers.length() < 2) {
			period = "0";
		} else {
			period = "";
			numOne = "";
			numTwo = "";
			checkPeriod = "";
			point = 1;

			for (int i = 0; i < afterPointNumbers.length(); i++) {
				numOne += afterPointNumbers.charAt(i);
				numTwo += afterPointNumbers.charAt(i + point);
				if (numOne.length() == point && numTwo.length() == point && period.length() == 0) {
					if (numOne.equals(numTwo)) {
						period += numOne;
					} else {
						i = i - point + 1;
					}
					numOne = "";
					numTwo = "";
				}
				if (period.length() > 0 && period.equals(checkPeriod)) {
					break;
				}
				if (i == afterPointNumbers.length() - point - 1) {
					point++;
					i = -1;
					numOne = "";
					numTwo = "";
				}
				if (period.length() > 0) {
					checkPeriod += period;
					period = "";
				}
				if (afterPointNumbers.length() < (2 * point)) {
					break;
				}
				if (checkPeriod.length() != 0 && afterPointNumbers.length() / (4 * point) < 1) {
					if (i < afterPointNumbers.length() - point - 1) {
						int index = 1;
						for (int j = i + 1; j < afterPointNumbers.length(); j++) {
							if (index <= point) {
								period += afterPointNumbers.charAt(j);
								index++;
							}
						}
						if (!period.equals(checkPeriod)) {
							period = "";
						}
					}
					break;
				}
			}
			point = 0;
			beforePeriod = "";
			numOne = "";
			for (int i = 0; i < afterPointNumbers.length() - period.length(); i++) {
				for (int j = 0; j < period.length(); j++) {
					numOne += afterPointNumbers.charAt(i + j);
				}
				if (numOne.equals(period)) {
					for (int k = 0; k < i; k++) {
						beforePeriod += afterPointNumbers.charAt(k);
					}
					break;
				} else {
					numOne = "";
				}
			}
			if (beforePeriod.length() != 0) {
				String newBeforePeriod = ".";
				newBeforePeriod += beforePeriod;
				beforePeriod = "";
				beforePeriod += newBeforePeriod;
			}
		}
		System.out.print("\nNumber with decimal period " + firstNumber + "/" + secondNumber + " = " + beforePointNumber
				+ beforePeriod + "(" + period + ")");

	}

	/**
	 * B16 Build pascal triangle
	 */
	public void trianglePascal() {
		int[] newNumbers = copyNumbers();
		int[][] trianglePascal = new int[5][9];
		int number, freeIndexCount, step;
		String emptyIndex;

		number = 0;
		for (int i = 0; i < newNumbers.length; i++) {
			if (newNumbers[i] > 0 && number > 1) {
				number = newNumbers[i];
				break;
			}
			number++;
		}
		step = 0;
		freeIndexCount = (trianglePascal[0].length - 1) / 2;
		for (int i = 0; i < trianglePascal.length; i++) {
			for (int j = 0; j < trianglePascal[i].length; j++) {
				if (step == 0 && j == freeIndexCount) {
					trianglePascal[i][j] = number;
				}
				if (step == 1 && (j == freeIndexCount + step || j == freeIndexCount - step)) {
					trianglePascal[i][j] = number;
				}
				if (step == 2) {
					if (j == freeIndexCount + step || j == freeIndexCount - step) {
						trianglePascal[i][j] = number;
					}
					if (j == freeIndexCount) {
						trianglePascal[i][j] = trianglePascal[i - 1][j - 1] + trianglePascal[i - 1][j + 1];
					}
				}
				if (step == 3) {
					if (j == freeIndexCount + step || j == freeIndexCount - step) {
						trianglePascal[i][j] = number;
					}
					if (j == freeIndexCount - 1 || j == freeIndexCount + 1) {
						trianglePascal[i][j] = trianglePascal[i - 1][j - 1] + trianglePascal[i - 1][j + 1];
					}
				}
				if (step == 4) {
					if (j == freeIndexCount + step || j == freeIndexCount - step) {
						trianglePascal[i][j] = number;
					}
					if (j == freeIndexCount - 2 || j == freeIndexCount + 2) {
						trianglePascal[i][j] = trianglePascal[i - 1][j - 1] + trianglePascal[i - 1][j + 1];
					}
					if (j == freeIndexCount) {
						trianglePascal[i][j] = trianglePascal[i - 1][j - 1] + trianglePascal[i - 1][j + 1];
					}
				}
			}
			step++;
		}
		emptyIndex = "    ";
		System.out.print("\nPascal`s triangle of 3d number: \n");
		for (int i = 0; i < trianglePascal.length; i++) {
			for (int j = 0; j < trianglePascal[i].length; j++) {
				if (trianglePascal[i][j] > 0) {
					if (trianglePascal[i][j] < 10) {
						System.out.print("    " + trianglePascal[i][j]);
					}
					if (trianglePascal[i][j] >= 10 && trianglePascal[i][j] < 100) {
						System.out.print("   " + trianglePascal[i][j]);
					}
					if (trianglePascal[i][j] >= 100 && trianglePascal[i][j] < 1000) {
						System.out.print("  " + trianglePascal[i][j]);
					}
					if (trianglePascal[i][j] >= 1000 && trianglePascal[i][j] < 10000) {
						System.out.print(" " + trianglePascal[i][j]);
					}
					if (trianglePascal[i][j] >= 10000) {
						System.out.print(" " + trianglePascal[i][j]);
					}
				} else {
					System.out.print(emptyIndex);
				}
			}
			System.out.print("\n");
		}
	}

}