import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class eulerSolutions {
	public static void main(String[] args) {
		problemOne();
		problemTwo();
		problemThree();
		problemFour();
		problemFive();
		problemSix();
		problemSeven();
		problemEight();
		problemNine();
		problemTen();
	}

	private static void problemOne() {
		System.out.println("Solving Project Euler problem 1");
		System.out.println("The sum of all natural numbers below 1000 and divisible by 3 or 5 is:");
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		System.out.println(sum);
		System.out.println();
	}

	private static void problemTwo() {
		System.out.println("Solving Project Euler problem 2");
		System.out.println("The sum of all even Fibonacci terms below 4,000,000 is:");
		int i = 1;
		int j = 1;
		int temp = 0;
		int sum = 0;
		while (i < 4000000) {
			if (i % 2 == 0) {
				sum += i;
			}
			temp = i;
			i = i + j;
			j = temp;
		}
		System.out.println(sum);
		System.out.println();
	}

	private static void problemThree() {
		System.out.println("Solving Project Euler problem 3");
		System.out.println("The largest prime factor of the number 600851475143 is:");
		int i = 3;
		double rem = 600851475143.0;
		double remRoot = Math.sqrt(rem);
		while (i < remRoot) {
			if (rem % i == 0) {
				rem = rem / i;
				remRoot = Math.sqrt(rem);
			}
			i += 2;
		}
		System.out.println((int) rem);
		System.out.println();
	}

	private static void problemFour() {
		System.out.println("Solving Project Euler problem 4");
		System.out.println("The largest palindromic product of two three digit numbers is:");
		int product = 0;
		int palProduct = 0;
		int min = 0;
		for (int i = 999; i > min; i--) {
			for (int j = i; j > min; j--) {
				product = i * j;
				if ((product > palProduct) && ((product / 1000) == ((100 * (product % 10)
						+ (((product % 100) / 10) * 10) + ((product % 1000) / 100))))) {
					palProduct = product;
					min = j;
				}
			}
		}
		System.out.println(palProduct);
		System.out.println();
	}

	private static void problemFive() {
		System.out.println("Solving Project Euler problem 5");
		System.out.println("The smallest number evenly divisible by every number between 1 and 20 inclusive is:");
		int product = 1;
		int remainder = 0;
		int[] factors = new int[20];
		int[] temp;
		for (int i = 2; i <= 20; i++) {
			if (product % i != 0) {
				remainder = i;
				temp = factors.clone();
				for (int j = 2; j <= i; j++) {
					while (remainder % j == 0 && temp[j] != 0) {
						temp[j]--;
						remainder = (remainder / j);
					}
				}
				factors[remainder]++;
				product *= remainder;
			}
		}
		System.out.println(product);
		System.out.println();
	}

	private static void problemSix() {
		System.out.println("Solving Project Euler problem 6");
		System.out.println(
				"The difference between the sum of the squares and the square of the sum of the first hundred natural numbers is:");
		int sum = 0;
		int sumSq = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			sumSq += (i * i);
		}
		System.out.println((sum * sum) - sumSq);
		System.out.println();
	}

	private static void problemSeven() {
		System.out.println("Solving Project Euler problem 7");
		System.out.println("The 10,001st prime number is:");
		int current = 13;
		int primeCount = 6;
		while (primeCount < 10001) {
			boolean isPrime = true;
			current += 2;
			for (int i = 3; i <= Math.sqrt(current); i += 2) {
				if (current % i == 0) {
					isPrime = false;
					i = current;
				}
			}
			if (isPrime) {
				primeCount++;
			}
		}
		System.out.println(current);
		System.out.println();
	}

	private static void problemEight() {
		System.out.println("Solving Project Euler problem 8");
		System.out.println("The largest product of the thirteen adjacent digits is:");
		File number = new File("problem8.txt");
		long product = 0;
		long tempProd = 1;
		try {
			Scanner fileScan = new Scanner(number);
			String line = fileScan.nextLine();
			int streak = 0;
			int[] factors = new int[13];

			for (int currentLine = 0; currentLine < 20; currentLine++) {
				for (int currentChar = 0; currentChar < 50; currentChar++) {
					if (line.charAt(currentChar) == '0') {
						streak = 0;
					} else {
						factors[streak % 13] = Character.getNumericValue(line.charAt(currentChar));
						streak++;
						if (streak >= 13) {
							for (int index = 0; index < 13; index++) {
								tempProd = tempProd * factors[index];
								if (tempProd > product) {
									product = tempProd;
								}
							}
							tempProd = 1;
						}
					}
				}
				if (fileScan.hasNext())
					line = fileScan.nextLine();
			}
			fileScan.close();
		} catch (IOException e) {
			System.out.println("IOExcepetion found");
		}
		System.out.println(product);
		System.out.println();
	}

	private static void problemNine() {
		System.out.println("Solving Project Euler problem 9");
		System.out.println("The product of the unique Pythagorean triplet that sums to 1000 is:");
		int a = 332;
		int b = 333;
		int c = 335;
		while ((a * a + b * b) != c * c) {
			if ((a * a + b * b) > c * c) {
				a--;
				b--;
				c += 2;
			} else {
				b++;
				c--;
			}
		}
		System.out.println(a * b * c);
		System.out.println();
	}

	private static void problemTen() {
		System.out.println("Solving Project Euler problem 10");
		System.out.println("The sum of all prime numbers below 2,000,000 is:");
		long sum = 2;
		for (int current = 3; current < 2000000; current += 2) {
			boolean isPrime = true;
			for (int i = 3; i <= Math.sqrt(current); i += 2) {
				if ((current % i) == 0) {
					isPrime = false;
					i = current;
				}
			}
			if (isPrime) {
				sum += current;
			}
		}
		System.out.println(sum);
		System.out.println();
	}
}
