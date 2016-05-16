/**
 * Project: Tasks Task2.java
 */
package com.bam.task;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 * @since 22 january 2016 �.
 *
 */
public class Task2 implements Cloneable {
	Scanner				scn	= new Scanner(System.in);
	Random				rnd	= new Random();
	DecimalFormat		df	= new DecimalFormat("#.##");
	final private int	_ID	= 3_654_987, $MAXLIMIT = 100;
	private String		numbers[];
	private int			someK, amountOfNumbers = 20, matrix[][];;
	private double		averageLength;
	

	/**
	 * Construction of numbers array, with quantityOfNumbers numbers that input
	 * from keyboard by user. $MAXLIMIT
	 * 
	 * @param quantityOfNumbers
	 */
	public Task2(int quantityOfNumbers) {
		numbers = new String[quantityOfNumbers];
		for (int i = 0; i < numbers.length; numbers[i++] = Integer.valueOf(scn.nextInt()).toString());
		scn.close();
	}

	/**
	 * Construction of numbers array, with amountOfNumbers numbers from 0 to
	 * $MAXLIMIT
	 * 
	 */
	public Task2() {
		numbers = new String[amountOfNumbers];
		for (int i = 0; i < numbers.length; numbers[i++] = Integer.valueOf($MAXLIMIT - rnd.nextInt($MAXLIMIT))
				.toString());
	}

	/**
	 * Make a String[] array copy of original int[] array
	 */
	public String[] copyNumbersArray() {
		String newNumbers[] = new String[numbers.length];
		for (int i = 0; i < newNumbers.length; newNumbers[i] = new String(numbers[i++].toString()));
		return newNumbers;
	}

	/**
	 * Make an int[] array copy of original String[] array
	 */
	public int[] intCopyNumbersArray() {
		int newNumbers[] = new int[numbers.length];
		for (int i = 0; i < newNumbers.length; newNumbers[i] = Integer.parseInt(numbers[i++].toString()));
		return newNumbers;
	}

	/**
	 * A1 Find the shortest and longest number in numbers array Output this
	 * numbers and there length
	 * 
	 * @see copyNumbersArray()
	 */
	public void maxAndMinLengthNumbers() {
		String minNumber = "", maxNumber = "", newNumbers[] = copyNumbersArray();
		int max = 0, min = newNumbers[0].length(), count = 1;

		for (String num : newNumbers) {
			max = max >= num.length() ? max : num.length();
			min = min <= num.length() ? min : num.length();
		}
		for (int i = 0; i < newNumbers.length; i++) {
			maxNumber += newNumbers[i].length() == max
					? newNumbers[i] + "(" + Integer.valueOf(newNumbers[i].length()).toString() + ") " : "";
			if (newNumbers[i].length() == max) {
				maxNumber += count++ % 10 == 0 ? "\n" : "";
			}
		}
		count = 1;
		for (int i = 0; i < newNumbers.length; i++) {
			minNumber += newNumbers[i].length() == min
					? newNumbers[i] + "(" + Integer.valueOf(newNumbers[i].length()).toString() + ") " : "";
			if (newNumbers[i].length() == min) {
				minNumber += count++ % 10 == 0 ? "\n" : "";
			}
		}
		System.out.println(
				"Number(s) with longest length : \n" + maxNumber + "\nNumber(s) with shortest length : \n" + minNumber);
	}

	/**
	 * A2 Sort numbers. From longest to shortest leght of numbers and from
	 * shortest to longest length of Numbers 25
	 * 
	 * @see copyNumbersArray()
	 */
	public void sortByNumbersLength() {
		String fromLongLength = "", fromShortLength = "", tmp = "", newNumbers[] = copyNumbersArray();
		int count = 1;

		for (int i = newNumbers.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (newNumbers[j].length() < newNumbers[j + 1].length()) {
					tmp = newNumbers[j];
					newNumbers[j] = newNumbers[j + 1];
					newNumbers[j + 1] = tmp;
				}
			}
		}
		for (String num : newNumbers) {
			fromLongLength += num + "(" + Integer.valueOf(num.length()).toString() + ") ";
			fromLongLength += count % 10 == 0 ? "\n" : "";
			count++;
		}
		count = 1;
		for (int i = newNumbers.length - 1; i >= 0; i--) {
			fromShortLength += newNumbers[i] + "(" + Integer.valueOf(newNumbers[i--].length()).toString() + ") ";
			fromShortLength += count % 10 == 0 ? "\n" : "";
			count++;
		}
		System.out.println("\nSort numbers from longest to shortest there length (Buble) : \n" + fromLongLength
				+ "\nSort numbers from shortest to longest there length : \n" + fromShortLength);
	}

	/**
	 * A3 Numbers that have less and more length then average length of all
	 * numbers
	 * 
	 * @see copyNumbersArray()
	 */
	public void lessOrMoreAverageLength() {
		String numbersLessAverageLength = "", numbersMoreAverageLength = "", newNumbers[] = copyNumbersArray();
		double sumLength = 0;
		int count = 1;
		for (int i = 0; i < newNumbers.length; sumLength += newNumbers[i++].length());
		averageLength = sumLength / newNumbers.length;

		for (int i = 0; i < newNumbers.length; i++) {
			numbersLessAverageLength += newNumbers[i].length() < averageLength
					? newNumbers[i] + "(" + newNumbers[i].length() + ") " : "";
			if (newNumbers[i].length() < averageLength) {
				numbersLessAverageLength += count++ % 10 == 0 ? "\n" : "";
			}
		}
		count = 1;
		for (int i = 0; i < newNumbers.length; i++) {
			numbersMoreAverageLength += newNumbers[i].length() > averageLength
					? newNumbers[i] + "(" + newNumbers[i].length() + ") " : "";
			if (newNumbers[i].length() > averageLength) {
				numbersMoreAverageLength += count++ % 10 == 0 ? "\n" : "";
			}
		}
		System.out.println("\nNumbers that have length less then average length(" + averageLength + ") :" + "\n"
				+ numbersLessAverageLength + "\nNumbers that have length more then average length(" + averageLength
				+ ") :" + "\n" + numbersMoreAverageLength);
	}

	/**
	 * A4 Find first number, in array, which consist of different number, that
	 * different is less .
	 * 
	 * @see countDifferentDigit(), copyNumbersArray()
	 */
	public void numberConsistOf() {
		String numberWithMinimumDigit = "", newNumbers[] = copyNumbersArray();
		int minimumDifferentDigit = countDifferentDigit(newNumbers[0]);

		for (int i = 0; i < newNumbers.length; minimumDifferentDigit = minimumDifferentDigit > countDifferentDigit(
				newNumbers[i]) ? countDifferentDigit(newNumbers[i]) : minimumDifferentDigit, i++)
			for (String num : newNumbers) {
				if (minimumDifferentDigit == countDifferentDigit(num)) {
					numberWithMinimumDigit = num;
					break;
				}
			}
		System.out.println("\nFirst number which consist of less like different digits :\n" + numberWithMinimumDigit);
	}

	/**
	 * A5 Find even numbers and find from them number which consist of equals
	 * 
	 * @see copyNumbersArray(), isEqualsPartsOfEvenAndOddDigits() even and odd
	 *      digits
	 */
	public void numbersWithEqualsEvenAndOddDigits() {
		String evenNumbersWithEqualsEvenOddDigits = "", newNumbers[] = copyNumbersArray();
		int countEvenNumbers = 0, nextLine = 0;

		for (String num : newNumbers) {
			if (Integer.parseInt(num) % 2 == 0) {
				countEvenNumbers++;
				evenNumbersWithEqualsEvenOddDigits += isEqualsPartsOfEvenAndOddDigits(num) ? num + " " : "";
				nextLine += isEqualsPartsOfEvenAndOddDigits(num) ? 1 : 0;
				evenNumbersWithEqualsEvenOddDigits += nextLine == 10 ? "\n" : "";
				nextLine = nextLine == 10 ? 0 : nextLine;
			}
		}
		System.out.println("\nFind " + countEvenNumbers + " even numbers. This array of numbers has numbers "
				+ "\nwhich consist of equals even and odd digit :\n" + evenNumbersWithEqualsEvenOddDigits);
	}

	/**
	 * A6 Find first number with strict sequence digits from small to big 25
	 * 
	 * 
	 * @see copyNumbersArray()
	 */
	public void strictSequence() {
		String numberWithStrictSequenceOfDigits = "", newNumbers[] = copyNumbersArray();
		for (String num : newNumbers) {
			numberWithStrictSequenceOfDigits += isNumberWithStrictSequenceOfDigits(num) ? num : "";
			if (numberWithStrictSequenceOfDigits.length() > 0) {
				break;
			}
		}
		System.out.println("\nFirst number with strict sequence of digits:\n" + numberWithStrictSequenceOfDigits);
	}

	/**
	 * A7 Find first number which consist of all different digit .
	 * 
	 * @see isAllDigitsDifferent(), copyNumbersArray()
	 */
	public void numberWithDifferentDigits() {
		String numberWithDifferentDigit = "", newNumbers[] = copyNumbersArray();
		for (String num : newNumbers) {
			numberWithDifferentDigit += isAllDigitsDifferent(num) ? num : "";
			if (numberWithDifferentDigit.length() > 0) {
				break;
			}
		}
		System.out.println("\nFirst number with different digits :\n" + numberWithDifferentDigit);
	}

	/**
	 * A8 Find first (if only one) or second (if more then one) polindrom number
	 * 
	 * @see copyNumbersArray()
	 */
	public void polindromNumbers() {
		String polindromNumber = "", reversNumber = "", newNumbers[] = copyNumbersArray();
		int count = 0;
		for (String num : newNumbers) {
			for (int i = num.length() - 1; i >= 0; reversNumber += num.charAt(i--));
			if (isEqualsNumber(reversNumber, num) && count < 2) {
				count++;
				polindromNumber = count == 1 ? num : "";
				polindromNumber = count == 2 ? new String(num) : "";
			}
			reversNumber = "";
		}
		System.out.println("\nFirst (if only 1) or second (if more then 1) polindrom number :\n" + polindromNumber);
	}

	/**
	 * B1 Check some variable "k" is it in range (n, m], [n, m), (n, m), [n,
	 * m].
	 * 
	 * @see randomNumberFromNumbers()
	 */
	public void isNumberInRange() {
		someK = randomNumberFromNumbers();
		int n = randomNumberFromNumbers(), m = n + randomNumberFromNumbers();
		boolean isInRange = false;
		System.out.println("\nIs k = " + someK + " belongs to the interval:");
		isInRange = someK > n && someK <= m ? true : false;
		System.out.println("(" + n + ", " + m + "]" + isInRange);
		isInRange = someK >= n && someK < m ? true : false;
		System.out.println("[" + n + ", " + m + ")" + isInRange);
		isInRange = someK > n && someK < m ? true : false;
		System.out.println("(" + n + ", " + m + ")" + isInRange);
		isInRange = someK >= n && someK <= m ? true : false;
		System.out.println("[" + n + ", " + m + "]" + isInRange);
	}

	/**
	 * B2 Create matrix[][] which has number in rage from 1 to someK
	 * 
	 * @see matrixNxNtoString()
	 */
	public void matrixNxN() {
		int n = (int) Math.sqrt(someK) + 1, matrix[][] = new int[n][n], number = 1;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = number;
				number = number > 0 && number < someK ? ++number : 0;
			}
		}
		System.out.println(
				"\nCreate matrix which has number from 1 to " + someK + "\n" + matrixNxNtoString(" ", "", matrix));
	}

	/**
	 * B3 Searching result quadratic equation
	 * 
	 * @see calculateDiscriminant()
	 */
	public void quadraticEquation() {
		char quad = 178;
		int a = 0, b = 0, c = 0;
		double d = 0;

		System.out.println("Enter quadratic equation (ax" + quad + " + bx + c = 0) options");
		System.out.println("Enter variable a :");
		a = scn.nextInt();
		System.out.println("Enter variable b :");
		b = scn.nextInt();
		System.out.println("Enter variable c :");
		c = scn.nextInt();
		d = calculateDiscriminant(a, b, c);
		if (d < 0) {
			System.out.println("Discriminant (" + df.format(d) + ") < 0, expration hasn`t quadrans variable");
		}
		if (d == 0) {
			double x = (-b + Math.sqrt(d)) / (2 * a);
			System.out.println("Discriminant (" + df.format(d) + ") = 0, expration hasn 1 quadrans variable \"x\" = "
					+ df.format(x));
		}
		if (d > 0) {
			double x1 = (-b + Math.sqrt(d)) / (2 * a);
			double x2 = (-b - Math.sqrt(d)) / (2 * a);
			System.out.println("Discriminant (" + df.format(d) + ") > 0, expration hasn 1 quadrans variable \"x1\" = "
					+ df.format(x1) + ", \"x2\" = " + df.format(x2));
		}
	}

	/**
	 * B4 Searching month by number
	 */
	public void enterMonthNumber() {
		String month = "";
		int monthNumber = 0;
		do {
			System.out.println("Enter number of month :");
			monthNumber = scn.nextInt();
			if (monthNumber < 1 || monthNumber > 12) {
				System.out.println("You enter not exist number of month. try again.");
			}
		} while (monthNumber < 1 || monthNumber > 12);
		switch (monthNumber) {
			case (1):
				month = "January";
				break;
			case (2):
				month = "Fabruary";
				break;
			case (3):
				month = "March";
				break;
			case (4):
				month = "April";
				break;
			case (5):
				month = "May";
				break;
			case (6):
				month = "June";
				break;
			case (7):
				month = "July";
				break;
			case (8):
				month = "August";
				break;
			case (9):
				month = "September";
				break;
			case (10):
				month = "October";
				break;
			case (11):
				month = "November";
				break;
			case (12):
				month = "December";
				break;
			default:
				month = "Numbered month (" + Integer.valueOf(monthNumber).toString() + ") dont exist!";
		}

		if (monthNumber > 0 && monthNumber < 13) {
			System.out.println("You enter : " + monthNumber + ", it is " + month + "\n");
		}

	}

	/**
	 * C0 Creating matrix[][] type of int
	 * 
	 * @see matrixNxNtoString()
	 */
	public void matrix() {
		System.out.println("Create matrix, size of matrix NxN, "
				+ "\nand random add numbers in range from \"-N\" to \"N\"." + "\nEnter value of N :");
		int n = scn.nextInt();
		System.out.println("N = " + n);
		matrix = new int[n][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; matrix[i][j++] = rnd.nextInt(2 * n + 1) - n);
		}
		System.out.println(matrixNxNtoString(" ", "0", matrix));
	}

	/**
	 * C1 Sort lines, columns of int matrix[][]
	 * 
	 * @see copyMatrix()
	 */
	public void sortLineAndColumn() {
		int newMatrix[][] = copyMatrix();
		int tmp = 0;

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = newMatrix[i].length - 1; j >= 0; j--) {
				for (int k = 0; k < j; k++) {
					if (newMatrix[i][k] > newMatrix[i][k + 1]) {
						tmp = newMatrix[i][k];
						newMatrix[i][k] = newMatrix[i][k + 1];
						newMatrix[i][k + 1] = tmp;
					}
				}
			}
		}
		System.out.println("Sort lines of matrix[][] from small to big:\n" + matrixNxNtoString(" ", "0", newMatrix));
		for (int j = 0; j < newMatrix[0].length; j++) {
			for (int i = newMatrix.length - 1; i >= 0; i--) {
				for (int k = 0; k < i; k++) {
					if (newMatrix[k][j] > newMatrix[k + 1][j]) {
						tmp = newMatrix[k][j];
						newMatrix[k][j] = newMatrix[k + 1][j];
						newMatrix[k + 1][j] = tmp;
					}
				}
			}
		}
		System.out.println("Sort column of matrix[][] from small to big:\n" + matrixNxNtoString(" ", "0", newMatrix));
	}

	/**
	 * C2 Move int matrix[][] up,down, to the right or to the left.
	 */
	public void moveMatrixRightLeftUpOrDowne() {
		System.out.println("matrix[][] which need to move:\n" + matrixNxNtoString(" ", "0", matrix)
				+ "\nEnter diraction ( right, left, up, down :");
		String whereNeedToMove = scn.next();
		System.out.println("How many steps need to do :");
		int numberOfSteps = scn.nextInt();

		if (whereNeedToMove.equalsIgnoreCase("right") || whereNeedToMove.equalsIgnoreCase("left")) {
			moveMatrixOneStepToTheLeftOrRight(whereNeedToMove, numberOfSteps);
		}
		if (whereNeedToMove.equalsIgnoreCase("up") || whereNeedToMove.equalsIgnoreCase("down")) {
			moveMatrixOneStepUpOrDown(whereNeedToMove, numberOfSteps);
		}
	}

	/**
	 * C3 Find longest sequence length from big to small and from small to big
	 * 
	 */
	public void longestSequenceLengthInColumnsAndLines() {
		System.out.println("Maximum sequence length in columns and lines:");
		longestSequenceOfLinesAndColumnsFromSmallToBig();
		longestSequenceOfLinesAndColumnsFromBigToSmall();
	}

	/**
	 * C4 Get sum between first and second number above zero
	 */
	public void sumOfFirstAndSecondNumberThatAboveZero() {
		int sum = 0, newMatrix[][] = copyMatrix();
		boolean isFirstNumberPick = false, isSecondNumberPick = false;
		String result = "";

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				sum += isFirstNumberPick && newMatrix[i][j] <= 0 ? newMatrix[i][j] : 0;
				if (newMatrix[i][j] > 0) {
					isSecondNumberPick = isFirstNumberPick ? true : false;
					isFirstNumberPick = true;
				}
				j = isSecondNumberPick ? newMatrix[i].length - 1 : j;
			}
			result += "Lines (with index " + i + ") sum =" + Integer.valueOf(sum).toString() + "\n";
			sum = 0;
			isFirstNumberPick = false;
			isSecondNumberPick = false;
		}
		System.out.println(result);
	}

	/**
	 * C5 Transponation matrix[][]
	 */
	public void transponationOfMatrix() {
		int newMatrix[][] = new int[matrix.length][];

		for (int i = 0; i < newMatrix.length; newMatrix[i] = new int[matrix[i++].length]);

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				newMatrix[i][j] = matrix[j][i];
			}
		}
		System.out.println("Transponation of matrix[][]: \n" + matrixNxNtoString(" ", "0", newMatrix));
	}

	/**
	 * C6 Find in different way norm of matrix[][]
	 */
	public void normOfMatrix() {
		System.out.println("Find in different way norm of matrix[][]:");
		firstNormOfMatrix();
		infinityNormOfMatrix();
		euclidNormOfMatrix();
	}

	/**
	 * C7 Turn counterclockwise matrix[][] for 90, 180 and 270 degrees
	 */
	public void turnMatrixCounterclockwise90180270Degrees() {
		int turnedMatrix90[][] = turnCounterClockWiseFor90DegreesMatrix(matrix),
				turnedMatrix180[][] = turnCounterClockWiseFor90DegreesMatrix(turnedMatrix90),
				turnedMatrix270[][] = turnCounterClockWiseFor90DegreesMatrix(turnedMatrix180);

		System.out.println("Turn matrix counterclockwise for " + ":\n90 degrees :" + "\n"
				+ matrixNxNtoString(" ", "0", turnedMatrix90) + ":\n180 degrees :" + "\n"
				+ matrixNxNtoString(" ", "0", turnedMatrix180) + ":\n270 degrees :" + "\n"
				+ matrixNxNtoString(" ", "0", turnedMatrix270));
	}

	/**
	 * C8 Calculate determinant of matrix.
	 */
	public void calculateDeterminantOfTheMatrix() {
		double newMatrix[][] = copyMatrixIntoDouble(), calculateDeterminant = 1;
		int lineIndex = 1, columnIndex = 0;
		boolean isMatrixUpperTriagularMatrix = false;

		// newMatrix = changeFirstElementOfTheMatrixIfItEqualZero(newMatrix);
		while (!isMatrixUpperTriagularMatrix) {
			newMatrix = newMatrix[lineIndex][lineIndex] == 0 ? changeFirstElementOfTheMatrixIfItEqualZero(newMatrix)
					: newMatrix;
			for (int i = lineIndex; i < newMatrix.length; i++) {

				double coefficient = (-1.0) * (newMatrix[i][columnIndex] / newMatrix[lineIndex - 1][columnIndex]);
				for (int j = columnIndex; j < newMatrix[i].length; j++) {
					newMatrix[i][j] += newMatrix[lineIndex - 1][j] * coefficient;
				}
				if (i == newMatrix.length - 1) {
					columnIndex = columnIndex < newMatrix[0].length - 1 ? ++columnIndex : columnIndex;
					lineIndex = lineIndex < newMatrix.length - 1 ? ++lineIndex : lineIndex;
					isMatrixUpperTriagularMatrix = columnIndex == newMatrix[0].length - 1
							&& lineIndex == newMatrix.length - 1 ? true : false;
				}
			}
		}
		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				calculateDeterminant *= i == j ? newMatrix[i][j] : 1;
			}
		}
		System.out.println(matrixNxNtoString(" ", "0.0", newMatrix));
		System.out.println("Determinant : " + df.format(calculateDeterminant));
	}

	/**
	 * C9 Create new matrix, subtract average value of numbers in line from each
	 * element in this line
	 */
	public void averageArithmeticMatrix() {
		double sumOfLine = 0, averageNumberOfLine = 0, newMatrix[][] = copyMatrixIntoDouble();

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; sumOfLine += newMatrix[i][j++]);
			averageNumberOfLine = sumOfLine / newMatrix[i].length;
			sumOfLine = 0;
			for (int j = 0; j < matrix[i].length; newMatrix[i][j++] -= averageNumberOfLine);
		}
		System.out.println(matrixNxNtoString(" ", "0.0", newMatrix));
	}

	/**
	 * C10 Delete from matrix lines and columns where is maximum element
	 */
	public void deleteColumnAndLinesWhichHaveMaximumElementOfMatrixElements() {
		int newMatrix[][] = copyMatrix(), maximumElementOfAllElements = newMatrix[0][0], reservMatrix[][];
		boolean isMaximumElementFind = false;

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				maximumElementOfAllElements = maximumElementOfAllElements < newMatrix[i][j] ? newMatrix[i][j]
						: maximumElementOfAllElements;
			}
		}
		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				if (newMatrix[i][j] == maximumElementOfAllElements && !isMaximumElementFind) {
					reservMatrix = deletColumnAndLinesWhereIsElementIs(i, j, newMatrix);
					isMaximumElementFind = true;
					newMatrix = reservMatrix;
					break;
				}
			}
			if (isMaximumElementFind) {
				i = 0;
				isMaximumElementFind = false;
			}
		}
		System.out.println("Maximum element is : " + maximumElementOfAllElements
				+ "\nMatrix without column and lines where was maximum element :\n"
				+ matrixNxNtoString(" ", "0", newMatrix));
	}

	/**
	 * C11 Delete from matrix column and lines where all elements equals zero
	 */
	public void deleteColumnAndLinesWhereisAllZero() {
		int countZeroElements = 0, newMatrix[][] = new int[matrix.length][], reservMatrix[][] = copyMatrix();

		newMatrix = createRandomCountLinesAndColumnWithAllElementEqualsZero(reservMatrix);
		System.out.println("Before delete zero elements : \n" + matrixNxNtoString(" ", "0", newMatrix));
		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				countZeroElements = newMatrix[i][j] == 0 ? ++countZeroElements : countZeroElements;
			}
			if (countZeroElements == newMatrix[i].length) {
				countZeroElements = 0;
				newMatrix = deleteLineFromMatrix(i, newMatrix);
				i = -1;
			} else {
				countZeroElements = 0;
			}
		}
		int j = 0;
		for (int i = 0; i < newMatrix[j].length; i++) {
			for (; j < newMatrix.length; j++) {
				countZeroElements = newMatrix[j][i] == 0 ? ++countZeroElements : countZeroElements;
			}
			if (countZeroElements == newMatrix.length) {
				countZeroElements = 0;
				newMatrix = deleteColumnFromMatrix(i, newMatrix);
				i = -1;
			} else {
				countZeroElements = 0;
			}
			j = 0;
		}
		System.out.println("After delete zero elements : \n" + matrixNxNtoString(" ", "0", newMatrix));
	}

	/**
	 * C12 Find first minimum element in matrix, and move it to input coordinats
	 * by user
	 */
	public void moveMinimumElementOfMatrixToThePositionByInputCoordinats() {
		int newMatrix[][] = copyMatrix(), minimumElement = newMatrix[0][0], minLineIndex = 0, minColumnIndex = 0,
				minElement = 0;
		boolean isFindMinimumElement = false;
		System.out.println("Input coordinat, where need to move minimum element we have matrix[" + newMatrix.length
				+ "][" + newMatrix[0].length + "]");
		System.out.println("Enter number of array(№ line) in matrix :");
		int lineIndex = scn.nextInt();
		System.out.println("Enter number of element(№ column) in array :");
		int columnIndex = scn.nextInt();

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				minimumElement = newMatrix[i][j] < minimumElement ? newMatrix[i][j] : minimumElement;
			}
		}

		for (int i = 0; i < newMatrix.length && !isFindMinimumElement; i++) {
			for (int j = 0; j < newMatrix[i].length && !isFindMinimumElement; j++) {
				if (newMatrix[i][j] == minimumElement) {
					isFindMinimumElement = true;
					minElement = newMatrix[i][j];
					minLineIndex = i;
					minColumnIndex = j;
				}
			}
		}
		int stepsLeftOrRight = columnIndex - minColumnIndex - 1;
		int stepsUpOrDown = lineIndex - minLineIndex - 1;
		String moRightOrLeft = stepsLeftOrRight < 0 ? "left" : "right";
		String moveUpOrDown = stepsUpOrDown < 0 ? "up" : "Down";
		newMatrix = moveMatrixOneStepUpOrDown(moveUpOrDown, Math.abs(stepsUpOrDown), newMatrix);
		newMatrix = moveMatrixOneStepToTheLeftOrRight(moRightOrLeft, Math.abs(stepsLeftOrRight), newMatrix);
		System.out.println("After move, first minimum element \"" + minElement + "\", on coordinat [" + lineIndex + "]["
				+ columnIndex + "]" + "\n" + matrixNxNtoString(" ", "0", newMatrix));
	}

	/**
	 * C13 Refactory matrix. Move zero elements in the end of line in which they
	 * are
	 */
	public void moveZeroElementInLineInTheEndThereOwnerLine() {
		int newMatrix[][] = copyMatrix(), countZeroElement = 0, howManyZeroElementsInMatrix = 0;;
		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length - countZeroElement; j++) {
				if (newMatrix[i][j] == 0) {
					newMatrix = moveOnceZeroElementInLineInTheEnd(i, newMatrix);
					countZeroElement++;
					howManyZeroElementsInMatrix++;
					j = -1;
				}
			}
			countZeroElement = 0;
		}
		System.out.println(
				"Find " + howManyZeroElementsInMatrix + " zero elements\nAfter move zero elements in the end of line:\n"
						+ matrixNxNtoString(" ", "0", newMatrix));
	}

	/**
	 * C14 Round all elements of the matrix
	 */
	public void roundAllElementsOfTheMatrix() {
		double newMatrix[][] = copyMatrixIntoDouble();

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				newMatrix[i][j] = Math.round(newMatrix[i][j]);
			}
		}
		System.out.println("After round \n" + matrixNxNtoString(" ", "0.0", newMatrix));
	}

	/**
	 * C15 Find count of saddle point of the matrix. Minimum element in line
	 * mast be maximum element in column where it is *
	 */
	public void saddlePointOfTheMatrix() {
		int newMatrix[][] = copyMatrix(), minimumElementInLine = 0, countSaddlePointOfTheMatrix = 0;
		String seddleElementOfTheMatrix = "";

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				minimumElementInLine = j == 0 ? newMatrix[i][j] : minimumElementInLine;
				minimumElementInLine = newMatrix[i][j] < minimumElementInLine ? newMatrix[i][j] : minimumElementInLine;
			}
			for (int n = 0; n < newMatrix[i].length; n++) {
				if (newMatrix[i][n] == minimumElementInLine) {
					countSaddlePointOfTheMatrix += newMatrix[i][n] == isMaximumElementInColumnOfThematrix(n, newMatrix)
							? 1 : 0;
					seddleElementOfTheMatrix += newMatrix[i][n] == isMaximumElementInColumnOfThematrix(n, newMatrix)
							? Integer.valueOf(newMatrix[i][n]).toString() + " [" + i + "][" + n + "]" : "";
				}
			}
		}
		seddleElementOfTheMatrix = seddleElementOfTheMatrix.length() == 0 ? "Null" : seddleElementOfTheMatrix;
		System.out.println("Find " + countSaddlePointOfTheMatrix + " saddle point of the matrix is number "
				+ seddleElementOfTheMatrix);
	}

	/**
	 * C16 Sort matrix by sum of elements in each lines
	 */
	public void sortLinesInTheMatrixFromSmallToBigSumOfAllElements() {
		int newMatrix[][] = copyMatrix(), tmp[] = new int[newMatrix[0].length];

		for (int i = newMatrix.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (countSumOfAllElementInLine(j, newMatrix) > countSumOfAllElementInLine(j + 1, newMatrix)) {
					tmp = newMatrix[j];
					newMatrix[j] = newMatrix[j + 1];
					newMatrix[j + 1] = tmp;
				}
			}
		}
		System.out.println("After sort\n" + matrixNxNtoString(" ", "0", newMatrix));
	}

	/**
	 * C17 Find local minimum of matrix. Local minimum is smaller than all its
	 * neighbors
	 */
	public void countLocalMinimumInTheMatrix() {
		int newMatrix[][] = copyMatrix(), countAllLocalMinimum = 0;
		String valueAndCoordinatOfLocalMinimum = "";
		boolean isLocalMinimum = false;

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				if (i == 0 && j == 0) {
					int numbers[] = new int[]{newMatrix[i][j + 1],newMatrix[i + 1][j + 1],newMatrix[i + 1][j]};
					isLocalMinimum = isNumberSmallerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMinimum += isLocalMinimum ? 1 : 0;
					valueAndCoordinatOfLocalMinimum += isLocalMinimum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					isLocalMinimum = false;
				}
				if (i == 0 && j > 0 && j < newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i][j - 1],newMatrix[i + 1][j - 1],newMatrix[i + 1][j],
							newMatrix[i][j + 1],newMatrix[i + 1][j + 1]};
					isLocalMinimum = isNumberSmallerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMinimum += isLocalMinimum ? 1 : 0;
					valueAndCoordinatOfLocalMinimum += isLocalMinimum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					isLocalMinimum = false;
				}
				if (i == 0 && j == newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i][j - 1],newMatrix[i + 1][j],newMatrix[i + 1][j - 1]};
					isLocalMinimum = isNumberSmallerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMinimum += isLocalMinimum ? 1 : 0;
					valueAndCoordinatOfLocalMinimum += isLocalMinimum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					isLocalMinimum = false;
				}
				if (i > 0 && i < newMatrix.length - 1 && j == 0) {
					int numbers[] = new int[]{newMatrix[i - 1][j],newMatrix[i - 1][j + 1],newMatrix[i][j + 1],
							newMatrix[i + 1][j + 1],newMatrix[i + 1][j]};
					isLocalMinimum = isNumberSmallerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMinimum += isLocalMinimum ? 1 : 0;
					valueAndCoordinatOfLocalMinimum += isLocalMinimum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					isLocalMinimum = false;
				}
				if (i > 0 && i < newMatrix.length - 1 && j > 0 && j < newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i - 1][j - 1],newMatrix[i - 1][j],newMatrix[i - 1][j + 1],
							newMatrix[i][j + 1],newMatrix[i + 1][j + 1],newMatrix[i + 1][j],newMatrix[i - 1][j - 1],
							newMatrix[i][j - 1]};
					isLocalMinimum = isNumberSmallerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMinimum += isLocalMinimum ? 1 : 0;
					valueAndCoordinatOfLocalMinimum += isLocalMinimum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					isLocalMinimum = false;
				}
				if (i > 0 && i < newMatrix.length - 1 && j == newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i - 1][j],newMatrix[i - 1][j - 1],newMatrix[i][j - 1],
							newMatrix[i + 1][j - 1],newMatrix[i + 1][j]};
					isLocalMinimum = isNumberSmallerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMinimum += isLocalMinimum ? 1 : 0;
					valueAndCoordinatOfLocalMinimum += isLocalMinimum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					isLocalMinimum = false;
				}
				if (i == newMatrix.length - 1 && j == 0) {
					int numbers[] = new int[]{newMatrix[i - 1][j],newMatrix[i - 1][j + 1],newMatrix[i][j + 1]};
					isLocalMinimum = isNumberSmallerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMinimum += isLocalMinimum ? 1 : 0;
					valueAndCoordinatOfLocalMinimum += isLocalMinimum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					isLocalMinimum = false;
				}
				if (i == newMatrix.length - 1 && j > 0 && j < newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i][j - 1],newMatrix[i - 1][j - 1],newMatrix[i - 1][j],
							newMatrix[i - 1][j + 1],newMatrix[i][j + 1]};
					isLocalMinimum = isNumberSmallerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMinimum += isLocalMinimum ? 1 : 0;
					valueAndCoordinatOfLocalMinimum += isLocalMinimum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					isLocalMinimum = false;
				}
				if (i == newMatrix.length - 1 && j == newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i][j - 1],newMatrix[i - 1][j - 1],newMatrix[i - 1][j]};
					isLocalMinimum = isNumberSmallerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMinimum += isLocalMinimum ? 1 : 0;
					valueAndCoordinatOfLocalMinimum += isLocalMinimum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					isLocalMinimum = false;
				}
			}
		}
		System.out.println(
				"Find " + countAllLocalMinimum + " locals minimum of matrix\n" + valueAndCoordinatOfLocalMinimum);
	}

	/**
	 * C18 Find minimum of local maximum.
	 */
	public void searchMinimumOfLocalMaximumInTheMatrix() {
		int newMatrix[][] = copyMatrix(), countAllLocalMaximum = 0;
		String valueAndCoordinatOfLocalMaximum = "", valueOfAllLocalMaximum = "";
		boolean isLocalMaximum = false;

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				if (i == 0 && j == 0) {
					int numbers[] = new int[]{newMatrix[i][j + 1],newMatrix[i + 1][j + 1],newMatrix[i + 1][j]};
					isLocalMaximum = isNumberBiggerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMaximum += isLocalMaximum ? 1 : 0;
					valueAndCoordinatOfLocalMaximum += isLocalMaximum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					valueOfAllLocalMaximum += isLocalMaximum ? Integer.valueOf(newMatrix[i][j]).toString() + " " : "";
					isLocalMaximum = false;
				}
				if (i == 0 && j > 0 && j < newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i][j - 1],newMatrix[i + 1][j - 1],newMatrix[i + 1][j],
							newMatrix[i][j + 1],newMatrix[i + 1][j + 1]};
					isLocalMaximum = isNumberBiggerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMaximum += isLocalMaximum ? 1 : 0;
					valueAndCoordinatOfLocalMaximum += isLocalMaximum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					valueOfAllLocalMaximum += isLocalMaximum ? Integer.valueOf(newMatrix[i][j]).toString() + " " : "";
					isLocalMaximum = false;
				}
				if (i == 0 && j == newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i][j - 1],newMatrix[i + 1][j],newMatrix[i + 1][j - 1]};
					isLocalMaximum = isNumberBiggerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMaximum += isLocalMaximum ? 1 : 0;
					valueAndCoordinatOfLocalMaximum += isLocalMaximum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					valueOfAllLocalMaximum += isLocalMaximum ? Integer.valueOf(newMatrix[i][j]).toString() + " " : "";
					isLocalMaximum = false;
				}
				if (i > 0 && i < newMatrix.length - 1 && j == 0) {
					int numbers[] = new int[]{newMatrix[i - 1][j],newMatrix[i - 1][j + 1],newMatrix[i][j + 1],
							newMatrix[i + 1][j + 1],newMatrix[i + 1][j]};
					isLocalMaximum = isNumberBiggerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMaximum += isLocalMaximum ? 1 : 0;
					valueAndCoordinatOfLocalMaximum += isLocalMaximum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					valueOfAllLocalMaximum += isLocalMaximum ? Integer.valueOf(newMatrix[i][j]).toString() + " " : "";
					isLocalMaximum = false;
				}
				if (i > 0 && i < newMatrix.length - 1 && j > 0 && j < newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i - 1][j - 1],newMatrix[i - 1][j],newMatrix[i - 1][j + 1],
							newMatrix[i][j + 1],newMatrix[i + 1][j + 1],newMatrix[i + 1][j],newMatrix[i - 1][j - 1],
							newMatrix[i][j - 1]};
					isLocalMaximum = isNumberBiggerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMaximum += isLocalMaximum ? 1 : 0;
					valueAndCoordinatOfLocalMaximum += isLocalMaximum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					valueOfAllLocalMaximum += isLocalMaximum ? Integer.valueOf(newMatrix[i][j]).toString() + " " : "";
					isLocalMaximum = false;
				}
				if (i > 0 && i < newMatrix.length - 1 && j == newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i - 1][j],newMatrix[i - 1][j - 1],newMatrix[i][j - 1],
							newMatrix[i + 1][j - 1],newMatrix[i + 1][j]};
					isLocalMaximum = isNumberBiggerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMaximum += isLocalMaximum ? 1 : 0;
					valueAndCoordinatOfLocalMaximum += isLocalMaximum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					valueOfAllLocalMaximum += isLocalMaximum ? Integer.valueOf(newMatrix[i][j]).toString() + " " : "";
					isLocalMaximum = false;
				}
				if (i == newMatrix.length - 1 && j == 0) {
					int numbers[] = new int[]{newMatrix[i - 1][j],newMatrix[i - 1][j + 1],newMatrix[i][j + 1]};
					isLocalMaximum = isNumberBiggerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMaximum += isLocalMaximum ? 1 : 0;
					valueAndCoordinatOfLocalMaximum += isLocalMaximum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					valueOfAllLocalMaximum += isLocalMaximum ? Integer.valueOf(newMatrix[i][j]).toString() + " " : "";
					isLocalMaximum = false;
				}
				if (i == newMatrix.length - 1 && j > 0 && j < newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i][j - 1],newMatrix[i - 1][j - 1],newMatrix[i - 1][j],
							newMatrix[i - 1][j + 1],newMatrix[i][j + 1]};
					isLocalMaximum = isNumberBiggerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMaximum += isLocalMaximum ? 1 : 0;
					valueAndCoordinatOfLocalMaximum += isLocalMaximum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					valueOfAllLocalMaximum += isLocalMaximum ? Integer.valueOf(newMatrix[i][j]).toString() + " " : "";
					isLocalMaximum = false;
				}
				if (i == newMatrix.length - 1 && j == newMatrix[i].length - 1) {
					int numbers[] = new int[]{newMatrix[i][j - 1],newMatrix[i - 1][j - 1],newMatrix[i - 1][j]};
					isLocalMaximum = isNumberBiggerThanElse(newMatrix[i][j], numbers) ? true : false;
					countAllLocalMaximum += isLocalMaximum ? 1 : 0;
					valueAndCoordinatOfLocalMaximum += isLocalMaximum ? "Local minimum "
							+ Integer.valueOf(newMatrix[i][j]).toString() + "[" + i + "][" + j + "]\n" : "";
					valueOfAllLocalMaximum += isLocalMaximum ? Integer.valueOf(newMatrix[i][j]).toString() + " " : "";
					isLocalMaximum = false;
				}
			}
		}
		String numbers[] = valueOfAllLocalMaximum.split(" ");
		int smallerFromBiggerLocalMaximum = Integer.parseInt(numbers[0]);
		for (int i = 0; i < numbers.length; i++) {
			smallerFromBiggerLocalMaximum = Integer.parseInt(numbers[i]) < smallerFromBiggerLocalMaximum
					? Integer.parseInt(numbers[i]) : smallerFromBiggerLocalMaximum;
		}
		System.out.println(
				"Find " + countAllLocalMaximum + " locals maximum of matrix\n" + valueAndCoordinatOfLocalMaximum);
		System.out.println("Minimum from local maximum : " + smallerFromBiggerLocalMaximum);
	}

	/**
	 * C19 Sort column of the matrix by value of sum moduls elements from bigger
	 * to small.
	 */
	public void sortColumnOfTheMatrixByValueOfSumNumbersModuls() {
		int newMatrix[][] = copyMatrix(), i = 0, firstSumofNumbersModul = 0, secondSumofNumbersModul = 0, tmp = 0;

		for (int j = 0; j < newMatrix[i].length - 1; j++) {
			for (; i < newMatrix.length; i++) {
				firstSumofNumbersModul += Math.abs(newMatrix[i][j]);
			}
			i = 0;
			for (; i < newMatrix.length; i++) {
				secondSumofNumbersModul += Math.abs(newMatrix[i][j + 1]);
			}
			i = 0;
			if (firstSumofNumbersModul < secondSumofNumbersModul) {
				for (int k = 0; k < newMatrix.length; k++) {
					tmp = newMatrix[k][j];
					newMatrix[k][j] = newMatrix[k][j + 1];
					newMatrix[k][j + 1] = tmp;
				}
				j = -1;
			}
			firstSumofNumbersModul = 0;
			secondSumofNumbersModul = 0;
		}
		System.out.println("After sort\n" + matrixNxNtoString(" ", "0", newMatrix));
	}

	/**
	 * C20 Move biggest number in prime diagonal from bigger to smaller
	 */
	public void formationPrimeDiagonalByBggerNumberOfMatrix() {
		int newMatrix[][] = copyMatrix(), biggerNumberForprimeDiagonal[] = new int[newMatrix.length];

		for (int i = 0; i < biggerNumberForprimeDiagonal.length; biggerNumberForprimeDiagonal[i++] = 0
				- biggerNumberForprimeDiagonal.length);

		for (int k = 0; k < biggerNumberForprimeDiagonal.length; k++) {
			for (int i = 0; i < newMatrix.length; i++) {
				for (int j = 0; j < newMatrix[i].length; j++) {
					if (isNumberBiggerorEqualsThanAtLeastOneNumberInArray(newMatrix[i][j],
							biggerNumberForprimeDiagonal)) {
						biggerNumberForprimeDiagonal = changeSmallerNummberForNew(newMatrix[i][j],
								biggerNumberForprimeDiagonal);
					}
				}
			}
		}
		for (int num : biggerNumberForprimeDiagonal) {
			System.out.print(num + " ");
		}
		int primeDiagonalIndex = 0, tmp = 0;
		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				if (primeDiagonalIndex < biggerNumberForprimeDiagonal.length
						&& biggerNumberForprimeDiagonal[primeDiagonalIndex] == newMatrix[i][j]) {
					tmp = newMatrix[primeDiagonalIndex][primeDiagonalIndex];
					newMatrix[primeDiagonalIndex][primeDiagonalIndex] = newMatrix[i][j];
					newMatrix[i][j] = tmp;
					primeDiagonalIndex++;
					i = -1;
					break;
				}
			}
		}
		System.out.println("After sort prime diagonal\n" + matrixNxNtoString(" ", "0", newMatrix));
	}

	/**
	 * Check all numbers in array with number, and if number a bigger than at
	 * least one number in array replace them.
	 * 
	 * @param number
	 *        that need to compare
	 * @param array
	 *        with which need to compare number
	 * @return new array
	 */
	public int[] changeSmallerNummberForNew(int number, int array[]) {
		int tmp = 0;
		boolean isChangeFinish = false;

		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] < array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
		for (int i = 0; i < array.length && !isChangeFinish; i++) {
			if (number >= array[i]) {
				array[i] = number;
				isChangeFinish = true;
			}
		}
		return array;
	}

	/**
	 * Check number withh array that this number bigger or equals at least one
	 * number in array
	 * 
	 * @param number
	 *        that need to check
	 * @param array
	 *        of number with those need to check
	 * @return true if number begger or equals at least with one number from
	 *         array
	 */
	public boolean isNumberBiggerorEqualsThanAtLeastOneNumberInArray(int number, int array[]) {
		boolean isNumberOverOrEqualsAtLeastOneNumberInArray = false;

		for (int i = 0; i < array.length && !isNumberOverOrEqualsAtLeastOneNumberInArray; i++) {
			isNumberOverOrEqualsAtLeastOneNumberInArray = number >= array[i] ? true : false;
		}
		return isNumberOverOrEqualsAtLeastOneNumberInArray;
	}

	/**
	 * Check number with array of numbers
	 * 
	 * @param numberThatNeedCheck
	 *        which need to check
	 * @param numbers
	 *        with those need to check
	 * @return true if number bigger than
	 */
	public boolean isNumberBiggerThanElse(int numberThatNeedCheck, int numbers[]) {
		int countNumbersThatSmaller = 0;
		boolean isNumberSmaller = false;

		for (int i = 0; i < numbers.length; i++) {
			countNumbersThatSmaller = numbers[i] < numberThatNeedCheck ? ++countNumbersThatSmaller : 0;
		}
		isNumberSmaller = countNumbersThatSmaller == numbers.length ? true : false;
		return isNumberSmaller;
	}

	/**
	 * Check number with array of numners
	 * 
	 * @param numberThatNeedCheck
	 *        which need to chech that it is smaller
	 * @param numbers
	 *        with those need to check
	 * @return true if number smaller than all of numbers in array
	 */
	public boolean isNumberSmallerThanElse(int numberThatNeedCheck, int numbers[]) {
		int countNumbersThatSmaller = 0;
		boolean isNumberSmaller = false;

		for (int i = 0; i < numbers.length; i++) {
			countNumbersThatSmaller = numbers[i] > numberThatNeedCheck ? ++countNumbersThatSmaller : 0;
		}
		isNumberSmaller = countNumbersThatSmaller == numbers.length ? true : false;
		return isNumberSmaller;
	}

	/**
	 * Return sum of all elements in the line of the matrix
	 * 
	 * @param lineIndex
	 *        index of line in which need to count sum of all element
	 * @param matrix
	 *        where is line
	 * @return value of sum all elements in line
	 */
	public int countSumOfAllElementInLine(int lineIndex, int matrix[][]) {
		int sumOffAllElementInTheatLine = 0;
		for (int j = 0; j < matrix[lineIndex].length; j++) {
			sumOffAllElementInTheatLine += matrix[lineIndex][j];
		}
		return sumOffAllElementInTheatLine;
	}

	/**
	 * Searching maximum element in column of the matrix
	 * 
	 * @param columnIndex
	 *        index of column where need to search maximum element
	 * @param matrix
	 *        where is column
	 * @return value of maximum element
	 */
	public int isMaximumElementInColumnOfThematrix(int columnIndex, int matrix[][]) {
		int maximumElementInColumn = matrix[0][columnIndex];
		for (int i = 0; i < matrix.length; i++) {
			maximumElementInColumn = matrix[i][columnIndex] > maximumElementInColumn ? matrix[i][columnIndex]
					: maximumElementInColumn;
		}
		return maximumElementInColumn;
	}

	/**
	 * Move once zero element in line in the end.
	 * 
	 * @param lineIndex
	 *        index of line where need to move zero element
	 * @param matrix
	 *        in which find zero element
	 * @return matrix
	 */
	public int[][] moveOnceZeroElementInLineInTheEnd(int lineIndex, int matrix[][]) {
		int countFindXeroElements = 0, tmp = 0;

		for (int j = 0; j < matrix[lineIndex].length - countFindXeroElements; j++) {
			if (matrix[lineIndex][j] == 0) {
				for (int k = j; k < matrix[lineIndex].length - countFindXeroElements - 1; k++) {
					tmp = matrix[lineIndex][k];
					matrix[lineIndex][k] = matrix[lineIndex][k + 1];
					matrix[lineIndex][k + 1] = tmp;
				}
				countFindXeroElements++;
				j = -1;
			}
		}
		return matrix;
	}

	/**
	 * Create random numbers of lines and columns with all elements equals zero
	 * 
	 * @param matrix
	 *        where need create
	 * @return newMatrix[][]
	 */
	public int[][] createRandomCountLinesAndColumnWithAllElementEqualsZero(int matrix[][]) {
		int newMatrix[][] = new int[matrix.length][];

		for (int i = 0; i < newMatrix.length; i++) {
			newMatrix[i] = new int[matrix[i].length];
			for (int j = 0; j < newMatrix[i].length; j++) {
				newMatrix[i][j] = matrix[i][j];
			}
		}
		int randomColumnIndex = rnd.nextInt(matrix[0].length);
		int randomLineIndex = rnd.nextInt(matrix.length);

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				newMatrix[i][j] = i == randomLineIndex ? 0 : newMatrix[i][j];
				newMatrix[i][j] = j == randomColumnIndex ? 0 : newMatrix[i][j];
			}
		}
		return newMatrix;
	}

	/**
	 * Delete line in matrix, which has index equals lineIndex
	 * 
	 * @param lineIndex
	 *        index of line, which need to delete
	 * @param matrix
	 *        in which need to delete line
	 * @return newMatrix[][]
	 */
	public int[][] deleteLineFromMatrix(int lineIndex, int matrix[][]) {
		int newMatrix[][] = new int[matrix.length - 1][];

		for (int i = 0; i < newMatrix.length; i++) {
			newMatrix[i] = new int[matrix[i].length];
			for (int j = 0; j < newMatrix[i].length; j++) {
				newMatrix[i][j] = i >= lineIndex ? matrix[i + 1][j] : matrix[i][j];
			}
		}
		return newMatrix;
	}

	/**
	 * Delete column in matrix, which has index equals columnIndex
	 * 
	 * @param columnIndex
	 *        index of column which need to delete
	 * @param matrix
	 *        in which need to delete column
	 * @return newMatrix[][]
	 */
	public int[][] deleteColumnFromMatrix(int columnIndex, int matrix[][]) {
		int newMatrix[][] = new int[matrix.length - 1][];

		for (int i = 0; i < newMatrix.length; i++) {
			newMatrix[i] = new int[matrix[i].length - 1];
			for (int j = 0; j < newMatrix[i].length; j++) {
				newMatrix[i][j] = j >= columnIndex ? matrix[i][j + 1] : matrix[i][j];
			}
		}
		return newMatrix;
	}

	/**
	 * Delete column and line where is element
	 * 
	 * @param lineIndex
	 *        index of line where is element
	 * @param columnIndex
	 *        index of column where is element
	 * @param matrix
	 *        from which need to delete column and line
	 * @return matrix without column and lines where was element
	 */
	public int[][] deletColumnAndLinesWhereIsElementIs(int lineIndex, int columnIndex, int matrix[][]) {
		int newMatrix[][] = new int[matrix.length - 1][];

		for (int i = 0; i < matrix.length - 1; i++) {
			newMatrix[i] = new int[matrix.length - 1];
			for (int j = 0; j < matrix[i].length - 1; j++) {
				if (i >= lineIndex) {
					newMatrix[i][j] = j >= columnIndex ? matrix[i + 1][j + 1] : matrix[i + 1][j];
				} else {
					newMatrix[i][j] = j >= columnIndex ? matrix[i][j + 1] : matrix[i][j];
				}
			}
		}
		return newMatrix;
	}

	/**
	 * Check matrix first element and if it equals zero change it
	 * 
	 * @param matrix
	 *        where need to check first element
	 * @return matrix with first element which not equals zero
	 */
	public double[][] changeFirstElementOfTheMatrixIfItEqualZero(double matrix[][]) {
		if (matrix[0][0] == 0) {
			boolean isFirstElementEqualsZero = true;
			for (int i = 1; isFirstElementEqualsZero && i < matrix.length; i++) {
				if (matrix[i][0] != 0) {
					for (int j = 0; j < matrix[0].length; j++) {
						matrix[0][j] += matrix[i][j];
					}
					isFirstElementEqualsZero = false;
				}
			}
		}
		return matrix;
	}

	/**
	 * Turn matrix[][] for 90 degrees counterclockwise
	 * 
	 * @param matrix[][]
	 *        thst need to turn
	 * @return newMatrix[][] which was turned counterclockwise for 90 degrees
	 */
	public int[][] turnCounterClockWiseFor90DegreesMatrix(int matrix[][]) {
		int index = 0, newMatrix[][] = new int[matrix.length][];

		for (int i = 0; i < newMatrix.length; newMatrix[i] = new int[matrix[i++].length]);

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				newMatrix[i][j] = matrix[index++][matrix.length - 1 - i];
			}
			index = 0;
		}
		return newMatrix;
	}

	/**
	 * Calculate first norm of matrix[][]
	 */
	public void firstNormOfMatrix() {
		int result = 0, sumOfEachColumn[] = new int[matrix[0].length], sumOfAllNumbersInColumn = 0,
				newMatrix[][] = copyMatrix();

		for (int j = 0; j < matrix[0].length; j++) {
			for (int i = 0; i < newMatrix.length; i++) {
				sumOfAllNumbersInColumn += Math.abs(newMatrix[j][i]);
			}
			sumOfEachColumn[j] = sumOfAllNumbersInColumn;
			sumOfAllNumbersInColumn = 0;
		}
		result = sumOfEachColumn[0];
		for (int i = 1; i < sumOfEachColumn.length; i++) {
			result = result > sumOfEachColumn[i] ? result : sumOfEachColumn[i];
		}
		System.out.println("First norm of matrix[][] : " + Integer.valueOf(result).toString());
	}

	/**
	 * Calculate infifnity norm of matrix[]
	 */
	public void infinityNormOfMatrix() {
		int result = 0, sumOfAllNumbersInLines = 0, sumOfEachLine[] = new int[matrix.length],
				newMatrix[][] = copyMatrix();

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				sumOfAllNumbersInLines += Math.abs(newMatrix[i][j]);
			}
			sumOfEachLine[i] = sumOfAllNumbersInLines;
			sumOfAllNumbersInLines = 0;
		}
		result = sumOfEachLine[0];
		for (int i = 1; i < sumOfEachLine.length; i++) {
			result = result > sumOfEachLine[i] ? result : sumOfEachLine[i];
		}
		System.out.println("Infinity norm of matrix[][] : " + Integer.valueOf(result).toString());
	}

	/**
	 * Calculate Euclid norm of matrix[][]
	 */
	public void euclidNormOfMatrix() {
		int sumOfQuadratElement = 0, newMatrix[][] = copyMatrix();

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				sumOfQuadratElement += newMatrix[i][j] * newMatrix[i][j];
			}
		}
		System.out.println("Euclid norm of matrix : " + df.format(Math.sqrt(sumOfQuadratElement)));
	}

	/**
	 * Find longest sequence length from big to small in lines and columns. And
	 * print best result 
	 */
	public void longestSequenceOfLinesAndColumnsFromBigToSmall() {
		int maximumLineSequence = 0, maximumColumnSequence = 0, tmp = 0, count = 0, newMatrix[][] = copyMatrix();
		boolean isNextBigger = false;
		String numbers = "", testNumbers = "", maxLineSequenceLengthFromLargeToSmall = "",
				maxColumnSequenceLengthFromBigToSmall = "", result = "";

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length - 1; j++) {
				if (newMatrix[i][j] >= newMatrix[i][j + 1]) {
					isNextBigger = j < newMatrix[i].length - 2 && newMatrix[i][j + 1] >= newMatrix[i][j + 2] ? true
							: false;
					count++;
					testNumbers += Integer.valueOf(newMatrix[i][j]).toString() + " ";
					testNumbers += isNextBigger ? "" : Integer.valueOf(newMatrix[i][j + 1]).toString() + " ";
					testNumbers += j == newMatrix[i].length - 2 ? Integer.valueOf(newMatrix[i][j + 1]).toString() + " "
							: "";
					count = isNextBigger ? count : ++count;
				} else {
					numbers = count > tmp ? testNumbers.toString() : numbers;
					tmp = count > tmp ? count : tmp;
					testNumbers = "";
					count = 0;
				}
			}
			count = 0;
		}
		maxLineSequenceLengthFromLargeToSmall += numbers.toString();
		maximumLineSequence = tmp;
		testNumbers = "";
		numbers = "";
		tmp = 0;
		isNextBigger = false;

		for (int i = 0; i < newMatrix[0].length; i++) {
			for (int j = 0; j < newMatrix.length - 1; j++) {
				if (newMatrix[j][i] >= newMatrix[j + 1][i]) {
					isNextBigger = j < newMatrix.length - 2 && newMatrix[j + 1][i] >= newMatrix[j + 2][i] ? true
							: false;
					count++;
					testNumbers += Integer.valueOf(newMatrix[j][i]).toString() + " ";
					testNumbers += isNextBigger ? "" : Integer.valueOf(newMatrix[j + 1][i]).toString() + " ";
					testNumbers += j == newMatrix.length - 2 ? Integer.valueOf(newMatrix[j + 1][i]).toString() + " "
							: "";
					count = isNextBigger ? count : ++count;
				} else {
					numbers = count > tmp ? testNumbers.toString() : numbers;
					tmp = count > tmp ? count : tmp;
					testNumbers = "";
					count = 0;
				}
			}
			count = 0;
		}
		maxColumnSequenceLengthFromBigToSmall += numbers.toString();
		maximumColumnSequence = tmp;
		System.out.println("From large to small:");
		if (maximumColumnSequence == maximumLineSequence) {
			System.out.println("We have same result\nIn lines :" + maxLineSequenceLengthFromLargeToSmall
					+ "| count numbers : " + Integer.valueOf(maximumLineSequence).toString()
					+ "\nIn columns sequence length from large to small :" + maxColumnSequenceLengthFromBigToSmall
					+ "| count numbers : " + Integer.valueOf(maximumColumnSequence).toString());
		} else {
			result += maximumColumnSequence > maximumLineSequence
					? "In columns : " + maxColumnSequenceLengthFromBigToSmall + "| count numbers : "
							+ Integer.valueOf(maximumColumnSequence).toString()
					: "In lines : " + maxLineSequenceLengthFromLargeToSmall + "| count numbers : "
							+ Integer.valueOf(maximumLineSequence).toString();
			System.out.println(result);
		}
	}

	/**
	 * Find longest sequence length from small to big in lines and columns. And
	 * print best result 
	 */
	public void longestSequenceOfLinesAndColumnsFromSmallToBig() {
		int maximumLineSequence = 0, maximumColumnSequence = 0, tmp = 0, count = 0, newMatrix[][] = copyMatrix();
		boolean isNextBigger = false;
		String numbers = "", testNumbers = "", maxLineSequenceLengthFromSmallToLarge = "",
				maxColumnSequenceLengthFromSmallToBig = "", result = "";

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length - 1; j++) {
				if (newMatrix[i][j] <= newMatrix[i][j + 1]) {
					isNextBigger = j < newMatrix[i].length - 2 && newMatrix[i][j + 1] <= newMatrix[i][j + 2] ? true
							: false;
					count++;
					testNumbers += Integer.valueOf(newMatrix[i][j]).toString() + " ";
					testNumbers += isNextBigger ? "" : Integer.valueOf(newMatrix[i][j + 1]).toString() + " ";
					testNumbers += j == newMatrix[i].length - 2 ? Integer.valueOf(newMatrix[i][j + 1]).toString() + " "
							: "";
					count = isNextBigger ? count : ++count;
				} else {
					numbers = count > tmp ? testNumbers.toString() : numbers;
					tmp = count > tmp ? count : tmp;
					testNumbers = "";
					count = 0;
				}
			}
			count = 0;
		}
		maxLineSequenceLengthFromSmallToLarge += numbers.toString();
		maximumLineSequence = tmp;
		testNumbers = "";
		numbers = "";
		tmp = 0;
		isNextBigger = false;

		for (int i = 0; i < newMatrix[0].length; i++) {
			for (int j = 0; j < newMatrix.length - 1; j++) {
				if (newMatrix[j][i] <= newMatrix[j + 1][i]) {
					isNextBigger = j < newMatrix.length - 2 && newMatrix[j + 1][i] <= newMatrix[j + 2][i] ? true
							: false;
					count++;
					testNumbers += Integer.valueOf(newMatrix[j][i]).toString() + " ";
					testNumbers += isNextBigger ? "" : Integer.valueOf(newMatrix[j + 1][i]).toString() + " ";
					testNumbers += j == newMatrix.length - 2 ? Integer.valueOf(newMatrix[j + 1][i]).toString() + " "
							: "";
					count = isNextBigger ? count : ++count;
				} else {
					numbers = count > tmp ? testNumbers.toString() : numbers;
					tmp = count > tmp ? count : tmp;
					testNumbers = "";
					count = 0;
				}
			}
			count = 0;
		}
		maxColumnSequenceLengthFromSmallToBig += numbers.toString();
		maximumColumnSequence = tmp;
		System.out.println("From small to large:");
		if (maximumColumnSequence == maximumLineSequence) {
			System.out.println("We have same result\nIn lines :" + maxLineSequenceLengthFromSmallToLarge
					+ "| count numbers : " + Integer.valueOf(maximumLineSequence).toString() + "\nIn columns :"
					+ maxColumnSequenceLengthFromSmallToBig + "| count numbers : "
					+ Integer.valueOf(maximumColumnSequence).toString());
		} else {
			result += maximumColumnSequence > maximumLineSequence
					? "In columns :" + maxColumnSequenceLengthFromSmallToBig + "| count numbers : "
							+ Integer.valueOf(maximumColumnSequence).toString()
					: "In lines :" + maxLineSequenceLengthFromSmallToLarge + "| count numbers : "
							+ Integer.valueOf(maximumLineSequence).toString();
			System.out.println(result);
		}
	}

	/**
	 * Move line of int matrix[][] up or down 
	 * 
	 * @param steps
	 *        that need to move
	 * @param moveUpOrDown
	 *        diraction ("up" or "down")
	 */
	public void moveMatrixOneStepUpOrDown(String moveUpOrDown, int steps) {
		int tmp = 0, newMatrix[][] = copyMatrix();

		for (int countSteps = 0; countSteps < steps; countSteps++) {
			for (int i = 0; i < newMatrix[0].length; i++) {
				if (moveUpOrDown.equalsIgnoreCase("up")) {
					tmp = newMatrix[0][i];
					for (int j = 0; j < newMatrix.length - 1; j++) {
						newMatrix[j][i] = newMatrix[j + 1][i];
					}
					newMatrix[newMatrix.length - 1][i] = tmp;
				}
				if (moveUpOrDown.equalsIgnoreCase("down")) {
					tmp = newMatrix[newMatrix.length - 1][i];
					for (int j = newMatrix.length - 1; j > 0; j--) {
						newMatrix[j][i] = newMatrix[j - 1][i];
					}
					newMatrix[0][i] = tmp;
				}

			}
		}
		System.out.println("Move line of int matrix[][] to the " + moveUpOrDown + " for "
				+ Integer.valueOf(Math.abs(steps)).toString() + " step(s) :\n"
				+ matrixNxNtoString(" ", "0", newMatrix));
	}

	public int[][] moveMatrixOneStepUpOrDown(String moveUpOrDown, int steps, int matrix[][]) {
		int tmp = 0;

		for (int countSteps = 0; countSteps < steps; countSteps++) {
			for (int i = 0; i < matrix[0].length; i++) {
				if (moveUpOrDown.equalsIgnoreCase("up")) {
					tmp = matrix[0][i];
					for (int j = 0; j < matrix.length - 1; j++) {
						matrix[j][i] = matrix[j + 1][i];
					}
					matrix[matrix.length - 1][i] = tmp;
				}
				if (moveUpOrDown.equalsIgnoreCase("down")) {
					tmp = matrix[matrix.length - 1][i];
					for (int j = matrix.length - 1; j > 0; j--) {
						matrix[j][i] = matrix[j - 1][i];
					}
					matrix[0][i] = tmp;
				}

			}
		}
		return matrix;
	}

	/**
	 * Move column of int matrix[][] to the right or left for 1 step 
	 * 
	 * @param steps
	 *        that need to move
	 * @param moveRightOrLeft
	 *        diraction ("right" or "left"
	 */
	public void moveMatrixOneStepToTheLeftOrRight(String moveRightOrLeft, int steps) {
		int tmp = 0, newMatrix[][] = copyMatrix();

		for (int countSteps = 0; countSteps < steps; countSteps++) {
			for (int i = 0; i < newMatrix.length; i++) {
				if (moveRightOrLeft.equalsIgnoreCase("right")) {
					tmp = newMatrix[i][newMatrix[i].length - 1];
					for (int j = newMatrix[i].length - 1; j > 0; j--) {
						newMatrix[i][j] = newMatrix[i][j - 1];
					}
					newMatrix[i][0] = tmp;
				}
				if (moveRightOrLeft.equalsIgnoreCase("left")) {
					tmp = newMatrix[i][0];
					for (int j = 0; j < newMatrix[i].length - 1; j++) {
						newMatrix[i][j] = newMatrix[i][j + 1];
					}
					newMatrix[i][newMatrix[i].length - 1] = tmp;
				}
			}
		}
		System.out.println("Move column of int matrix[][] to the " + moveRightOrLeft + " for "
				+ Integer.valueOf(Math.abs(steps)).toString() + " step(s) :\n"
				+ matrixNxNtoString(" ", "0", newMatrix));
	}

	/**
	 * Move matrix to the left or to the right
	 * 
	 * @param moveRightOrLeft
	 *        where need to move String "right" or "left"
	 * @param steps
	 * @param matrix
	 * @return
	 */
	public int[][] moveMatrixOneStepToTheLeftOrRight(String moveRightOrLeft, int steps, int matrix[][]) {
		int tmp = 0;

		for (int countSteps = 0; countSteps < steps; countSteps++) {
			for (int i = 0; i < matrix.length; i++) {
				if (moveRightOrLeft.equalsIgnoreCase("right")) {
					tmp = matrix[i][matrix[i].length - 1];
					for (int j = matrix[i].length - 1; j > 0; j--) {
						matrix[i][j] = matrix[i][j - 1];
					}
					matrix[i][0] = tmp;
				}
				if (moveRightOrLeft.equalsIgnoreCase("left")) {
					tmp = matrix[i][0];
					for (int j = 0; j < matrix[i].length - 1; j++) {
						matrix[i][j] = matrix[i][j + 1];
					}
					matrix[i][matrix[i].length - 1] = tmp;
				}
			}
		}
		return matrix;
	}

	/**
	 * Copy original int matrix[][] into new int newMatrix[][] 
	 * 
	 * @return int newMatrix[][]
	 */
	public int[][] copyMatrix() {
		int newMatrix[][] = new int[matrix.length][];

		for (int i = 0; i < newMatrix.length; i++) {
			newMatrix[i] = new int[matrix[i].length];
			for (int j = 0; j < newMatrix[i].length; newMatrix[i][j] = matrix[i][j++]);
		}
		return newMatrix;
	}

	/**
	 * Copy original int matrix[][] into double newMatrix[][] 
	 * 
	 * @return double newMatrix[][]
	 */
	public double[][] copyMatrixIntoDouble() {
		double newMatrix[][] = new double[matrix.length][];

		for (int i = 0; i < newMatrix.length; i++) {
			newMatrix[i] = new double[matrix[i].length];
			for (int j = 0; j < newMatrix[i].length; newMatrix[i][j] = matrix[i][j++]);
		}
		return newMatrix;
	}

	/**
	 * Calculate discriminant of quadratic equation 
	 * 
	 * @param a
	 *        variable of quadratic equation
	 * @param b
	 *        variable of quadratic equation
	 * @param c
	 *        variable of quadratic equation
	 * @return result of calculation descriminant
	 */
	public double calculateDiscriminant(int a, int b, int c) {
		double d = 0;
		d = (b * b) - 4.0 * a * c;
		return d;
	}

	/**
	 * Create different count of char = ' ', depend of maximum number length in
	 * matrix and current number length 
	 * 
	 * @param number
	 *        current number for which create count of space
	 * @param matrix
	 *        where is current number
	 * @param whichCharacterAdd
	 *        String literal that need put on where empty (exampl " " (space))
	 * @return String which consist of needed count of space
	 */
	public String createSpace(String whichCharacterAdd, int number, int matrix[][], String endNumber) {
		int maxLengthNumber = 0, currentLengthNumber = number == 0 ? 0 : Integer.valueOf(number).toString().length();
		String creatSpace = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				maxLengthNumber = maxLengthNumber < Integer.valueOf(matrix[i][j]).toString().length()
						? Integer.valueOf(matrix[i][j]).toString().length() : maxLengthNumber;
			}
		}
		for (int i = 1; i <= (maxLengthNumber - currentLengthNumber); creatSpace += whichCharacterAdd, i++);
		return creatSpace += endNumber;
	}

	/**
	 * Create different count of char = ' ', depend of maximum number length in
	 * matrix and current number length 
	 * 
	 * @param number
	 *        current number for which create count of space
	 * @param matrix
	 *        where is current number
	 * @param whichCharacterAdd
	 *        String literal that need put on where empty (exampl " " (space))
	 * @return String which consist of needed count of space
	 */
	public String createSpace(String whichCharacterAdd, double number, double matrix[][], String endNumber) {
		int maxLengthNumber = 0, currentLengthNumber = number == 0 ? 0 : Double.valueOf(number).toString().length();
		String creatSpace = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				maxLengthNumber = maxLengthNumber < Double.valueOf(matrix[i][j]).toString().length()
						? Double.valueOf(matrix[i][j]).toString().length() : maxLengthNumber;
			}
		}
		for (int i = 1; i <= (maxLengthNumber - currentLengthNumber); creatSpace += whichCharacterAdd, i++);
		return creatSpace += endNumber;
	}

	/**
	 * Convert array int[][] .toString type 
	 * 
	 * @see createSpace()
	 * @param matrix
	 *        number array of int[][] type
	 * @param switchNull
	 *        String variable (at least 1 character of decimal digit (0 - 9)
	 *        where need to change zero in matrix,
	 * @param whichCharacterAdd
	 *        String literal that need put on where empty (exampl " " (space))
	 * @return array to String type
	 */
	public String matrixNxNtoString(String whichCharacterAdd, String switchNull, int matrix[][]) {
		String matrixToString = "|", line = "", tmpline = "";
		tmpline = createSpace("-", 0, matrix, "|");

		for (int i = 0; i < matrix.length; i++) {
			for (int k = 0; i == 0
					&& k < matrix[0].length; matrixToString += tmpline, matrixToString += k == matrix[0].length - 1
							? "\n" : "", k++);
			for (int j = 0; j < matrix[i].length; j++) {
				matrixToString += j == 0 ? "|" : "";
				matrixToString += matrix[i][j] != 0
						? Integer.valueOf(matrix[i][j]).toString()
								+ createSpace(whichCharacterAdd, matrix[i][j], matrix, "|")
						: switchNull + createSpace(whichCharacterAdd, switchNull.length(), matrix, "|");
				line += tmpline;
				matrixToString += j == matrix[i].length - 1 ? "\n|" + line + "\n" : "";
			}
			line = "";
		}
		return matrixToString;
	}

	/**
	 * Convert array int[][] .toString type 
	 * 
	 * @see createSpace()
	 * @param matrix
	 *        number array of int[][] type
	 * @param switchNull
	 *        String variable (at least 1 character of decimal digit (0 - 9)
	 *        where need to change zero in matrix,
	 * @param whichCharacterAdd
	 *        String literal that need put on where empty (exampl " " (space))
	 * @return array to String type
	 */
	public String matrixNxNtoString(String whichCharacterAdd, String switchNull, double matrix[][]) {
		String matrixToString = "|", line = "", tmpline = "";
		tmpline = createSpace("-", 0, matrix, "|");

		for (int i = 0; i < matrix.length; i++) {
			for (int k = 0; i == 0
					&& k < matrix[0].length; matrixToString += tmpline, matrixToString += k == matrix[0].length - 1
							? "\n" : "", k++);
			for (int j = 0; j < matrix[i].length; j++) {
				matrixToString += j == 0 ? "|" : "";
				matrixToString += matrix[i][j] != 0
						? Double.valueOf(matrix[i][j]).toString()
								+ createSpace(whichCharacterAdd, matrix[i][j], matrix, "|")
						: switchNull + createSpace(whichCharacterAdd, switchNull.length(), matrix, "|");
				line += tmpline;
				matrixToString += j == matrix[i].length - 1 ? "\n|" + line + "\n" : "";
			}
			line = "";
		}
		return matrixToString;
	}

	/**
	 * Choose random number from numbers 
	 * 
	 * @see intCopyNumbersArray()
	 * @return random number from numbers
	 */
	public int randomNumberFromNumbers() {
		int newNumbers[] = intCopyNumbersArray();
		int randomNumber = newNumbers[rnd.nextInt(newNumbers.length - 1)];
		return randomNumber;
	}

	/**
	 * Chech two numbers for equals
	 * 
	 * @param numberOne
	 * @param numberTwo
	 * @return true if numberOne equals numberTwo
	 */
	public boolean isEqualsNumber(String numberOne, String numberTwo) {
		int isEquals = 0;
		if (numberOne.length() == numberTwo.length()) {
			for (int i = 0; i < numberOne.length(); i++) {
				isEquals += Character.getNumericValue(numberOne.charAt(i)) == Character
						.getNumericValue(numberTwo.charAt(i)) ? 1 : 0;
			}
			return isEquals == numberOne.length() ? true : false;
		} else {
			return false;
		}

	}

	/**
	 * Check number for different digit
	 * 
	 * @param number
	 *        wich need to check
	 * @return true if number consist of all different digits
	 */
	public boolean isAllDigitsDifferent(String number) {
		String differentDigits = "";
		int isDigitDifferent = 0;
		for (char num : number.toCharArray()) {
			for (int i = 0; i < differentDigits.length(); isDigitDifferent += Character
					.getNumericValue(differentDigits.charAt(i++)) != Character.getNumericValue(num) ? 0 : 1);
			differentDigits += isDigitDifferent == 0 ? num : "";
		}
		return differentDigits.length() == number.length() ? true : false;
	}

	/**
	 * Check number for strict sequence of digits from small to big
	 * 
	 * @param number
	 *        which need to check
	 * @return true if digits of number are strict sequence from small to big
	 */
	public boolean isNumberWithStrictSequenceOfDigits(String number) {
		int isDigitSequence = 1;
		for (int i = 1; i < number.length(); isDigitSequence += Character.getNumericValue(number.charAt(i)) > Character
				.getNumericValue(number.charAt(i++ - 1)) ? 1 : 0);
		return isDigitSequence == number.length() ? true : false;
	}

	/**
	 * Check number for consist of equals parts of even and odd digits 23
	 * 
	 * @param number
	 *        which need to check
	 * @return true if number consist of equals parts of odd and even digits
	 */
	private boolean isEqualsPartsOfEvenAndOddDigits(String number) {
		int countEvenDigit = 0, countOddDigit = 0;
		for (int i = 0; i < number.length(); i++) {
			if (Character.getNumericValue(number.charAt(i)) % 2 == 0) {
				countEvenDigit += 1;
			} else {
				countOddDigit += 1;
			}
		}
		return countEvenDigit == countOddDigit ? true : false;
	}

	/**
	 * Count like different digit wich consist number
	 * 
	 * @param number
	 *        that need to check
	 * @return int number of different numbers
	 */
	private int countDifferentDigit(String number) {
		char tmp, digit[] = number.toCharArray();
		int count = 1;

		for (int i = digit.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (digit[j] > digit[j + 1]) {
					tmp = digit[j];
					digit[j] = digit[j + 1];
					digit[j + 1] = tmp;
				}
			}
		}
		for (int i = 0; i < digit.length - 1; count += digit[i] != digit[i++ + 1] ? 1 : 0);
		return count;
	}

	/**
	 * return links for numbers
	 * 
	 * @return this.numbers
	 */
	public String[] getNumbers() {
		return numbers;
	}

	/**
	 * Set new arrays for link numbers
	 * 
	 * @param numbers
	 *        set value of this.numbers
	 */
	private void setNumbers(String[] numbers) {
		this.numbers = numbers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Task2 clone = (Task2) super.clone();
		clone.setNumbers(copyNumbersArray());
		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.numbers = null;
		System.out.println("Numbers is destroyed!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		int count = 0;
		if (obj instanceof Task2) {
			for (int i = 0; i < ((Task2) obj).getNumbers().length; count = numbers[i]
					.equals(((Task2) obj).getNumbers()[i++]) ? ++count : 0);
		}
		return count == numbers.length ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int PRIME = 21;
		int result = 1;
		result = result * PRIME * _ID;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String numbersText = "We have next numbers in array :{\n";
		int count = 1;
		for (String num : numbers) {
			numbersText += count++ % 10 == 0 ? "\n" : num + ",";
		}
		numbersText += "}";
		return numbersText;
	}

}
