package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {

		String cleanedString = phrase.replaceAll("\"\\\\s|,|\\\\.|-\"", "");
		String[] base = cleanedString.split("\\s|,|\\.|-");
		StringBuilder sb = new StringBuilder();

		for (String element : base) {
			sb.append(element.charAt(0));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		double[] sides = new double[] { sideOne, sideTwo, sideThree };

		public boolean isEquilateral() {
			Set<Double> uniq = new HashSet<>();
			Boolean value = false;

			uniq.add(sideOne);
			uniq.add(sideTwo);
			uniq.add(sideThree);

			switch (uniq.size()) {
			case 1:
				value = true;
				break;
			default:
				value = false;
				break;
			}
			return value;
		}

		public boolean isIsosceles() {
			Set<Double> uniq = new HashSet<>();
			Boolean value = false;

			uniq.add(sideOne);
			uniq.add(sideTwo);
			uniq.add(sideThree);

			switch (uniq.size()) {
			case 2:
				value = true;
				break;
			default:
				value = false;
				break;
			}
			return value;
		}

		public boolean isScalene() {
			Set<Double> uniq = new HashSet<>();
			Boolean value = false;

			uniq.add(sideOne);
			uniq.add(sideTwo);
			uniq.add(sideThree);

			switch (uniq.size()) {
			case 3:
				value = true;
				break;
			default:
				value = false;
				break;
			}
			return value;
		}
	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {

		String[] elements = string.toUpperCase().split("");
		int value = 0;
		for (String unit : elements) {
			if (unit.equals("A") || unit.equals("E") || unit.equals("I") || unit.equals("O") || unit.equals("U")
					|| unit.equals("L") || unit.equals("N") || unit.equals("R") || unit.equals("S")
					|| unit.equals("T")) {
				value += 1;
			}
			if (unit.equals("D") || unit.equals("G")) {
				value += 2;
			}
			if (unit.equals("B") || unit.equals("C") || unit.equals("M") || unit.equals("P")) {
				value += 3;
			}
			if (unit.equals("F") || unit.equals("H") || unit.equals("V") || unit.equals("W") || unit.equals("Y")) {
				value += 4;
			}
			if (unit.equals("K")) {
				value += 5;
			}
			if (unit.equals("J") || unit.equals("X")) {
				value += 8;
			}
			if (unit.equals("Q") || unit.equals("Z")) {
				value += 10;
			}
		}

		return value;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */

	public String cleanPhoneNumber(String string) {

		String cleanedString = string.replaceAll("\\s|-|,|\\.|\\+|\\(|\\)|[^\\d.]", "");

		if (cleanedString.length() > 10) {
			throw new IllegalArgumentException();
		} else if (cleanedString.length() < 10) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < cleanedString.length(); i++) {
			char c = cleanedString.charAt(i);
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException();
			}
		}
		return cleanedString;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {

		String[] splitArray = string.trim().replaceAll("\n", "").split("\\s|\\,|\n");
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int value = 0;

		for (String s : splitArray) {
			if (hm.containsKey(s)) {
				hm.put(s, hm.get(s) + 1);
			} else {
				hm.put(s, 1);
			}
		}
		return hm;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			int l = 0; // Lower
			int h = sortedList.size() - 1; // Higher

			while (l < h) {
				int m = l + (h - l) / 2;
				int comp = t.compareTo(sortedList.get(m));
				if (comp <= 0) {
					h = m;
				} else
					l = m + 1;
			}
			return l;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String[] words = string.toLowerCase().split("\\s");
		List<String> pigSentence = new ArrayList<>();
		String head = "";
		String tail = "";
		String newWord = "";
		String sentence = "";

		for (String lcs : words) {

			if (lcs.charAt(0) != 'a' && lcs.charAt(0) != 'e' && lcs.charAt(0) != 'i' && lcs.charAt(0) != 'o'
					&& lcs.charAt(0) != 'u') {
				if (lcs.charAt(1) != 'a' && lcs.charAt(1) != 'e' && lcs.charAt(1) != 'i' && lcs.charAt(1) != 'o'
						&& lcs.charAt(1) != 'u') {
					if (lcs.charAt(2) != 'a' && lcs.charAt(2) != 'e' && lcs.charAt(2) != 'i' && lcs.charAt(2) != 'o'
							&& lcs.charAt(2) != 'u') {
						head = lcs.substring(0, 3);
						tail = lcs.substring(3, lcs.length());
						newWord = tail.concat(head).concat("ay");
						pigSentence.add(newWord);
					} else {
						head = lcs.substring(0, 2);
						tail = lcs.substring(2, lcs.length());
						newWord = tail.concat(head).concat("ay");
						pigSentence.add(newWord);
					}

				} else if (lcs.charAt(2) == 'a' || lcs.charAt(2) == 'e' || lcs.charAt(2) == 'i' || lcs.charAt(2) == 'o'
						|| lcs.charAt(2) == 'u') {
					head = lcs.substring(0, 2);
					tail = lcs.substring(2, lcs.length());
					newWord = tail.concat(head).concat("ay");
					pigSentence.add(newWord);
				} else {

					head = lcs.substring(0, 1);
					tail = lcs.substring(1, lcs.length());
					newWord = tail.concat(head).concat("ay");
					pigSentence.add(newWord);
				}
			} else {
				newWord = lcs.concat("ay");
				pigSentence.add(newWord);
			}
		}

		for (int i = 0; i < pigSentence.size(); i++) {
			sentence = sentence + pigSentence.get(i) + " ";
		}

		return sentence.trim();
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int number = input;
		int remainder;
		int result = 0;
		int n = 0;

		for (; input != 0; input /= 10) {
			++n;
		}
		input = number;

		for (; number != 0; number /= 10) {
			remainder = number % 10;
			result += Math.pow(remainder, n);
		}

		if (result == input) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */

	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> primeFactors = new ArrayList<>();

		for (Long i = 2L; i <= l; i++) {
			while (l % i == 0) {
				primeFactors.add(i);
				l = l / i;
			}
		}
		return primeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < string.length(); i++) {
				int x = (int) string.charAt(i);
				String s = Character.toString(string.charAt(i));

				if (x > 64 && x < 91) {
					if (x + key > 90) {
						x = x + key - 26;
					} else {
						x = x + key;
					}
					sb.append(Character.toString((char) x));

				} else if (x > 96 && x < 123) {
					if (x + key > 122) {
						x = x + key - 26;
					} else {
						x = x + key;
					}
					sb.append(Character.toString((char) x));

				} else {
					sb.append(s);
				}
			}
			return sb.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */

	public static boolean checkPrime(long testNumber) {
		boolean value = false;

		if (testNumber == 1 || testNumber == 2) {
			value = true;
		}

		for (long l = 2; l < testNumber; l++) {
			if (testNumber % l == 0) {
				value = false;
				break;
			} else {
				value = true;
			}
		}
		return value;
	}

	public int calculateNthPrime(int i) {
		long n = 0L;
		long number = 1L;
		int value = 1;

		if (i < 1) {
			throw new IllegalArgumentException();
		}

		while (n <= i) {
			if (checkPrime(number)) {
				n++;
				value = (int) number;
				number++;
			} else {
				number++;
			}
		}
		return value;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String cleanedString = string.replaceAll(",|\\.|\\s", "");
			String encodedWord = "";
			Map<String, String> key = new HashMap<String, String>();
			String[] alphabet = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
					"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

			// BuildKey
			for (int i = 0; i < alphabet.length; i++) {
				key.put(alphabet[i], alphabet[alphabet.length - 1 - i]);
			}

			for (int j = 0; j < cleanedString.length(); j++) {
				char value = cleanedString.toLowerCase().charAt(j);
				String valueString = Character.toString(value);
				String encodedAlphabet = key.get(valueString);

				if (encodedAlphabet == null) {
					encodedWord += valueString;
				} else if (j != 0 && j % 5 == 0) {
					encodedWord += " " + encodedAlphabet;
				} else {
					encodedWord += encodedAlphabet;
				}
			}
			return encodedWord;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {

			String cleanedString = string.replaceAll(",|\\.|\\s", "");
			String encodedWord = "";
			Map<String, String> key = new HashMap<String, String>();
			String[] alphabet = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
					"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

			// BuildKey
			for (int i = 0; i < alphabet.length; i++) {
				key.put(alphabet[i], alphabet[alphabet.length - 1 - i]);
			}

			for (int j = 0; j < cleanedString.length(); j++) {
				char value = cleanedString.toLowerCase().charAt(j);
				String valueString = Character.toString(value);
				String encodedAlphabet = key.get(valueString);

				if (encodedAlphabet == null) {
					encodedWord += valueString;
				} else if (j != 0 && j % 5 == 0) {
					encodedWord += encodedAlphabet;
				} else {
					encodedWord += encodedAlphabet;
				}
			}
			return encodedWord;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {

		String cleanedString = string.replaceAll("\\-", "");
		Boolean valid = false;
		Boolean nextStep = false;
		int check = 0;
		int lastCharNumber = 0;
		int total;

		// Getting Value of Last Digit
		String lastChar = cleanedString.substring(cleanedString.length() - 1);
		if (lastChar.equals("0") || lastChar.equals("1") || lastChar.equals("2") || lastChar.equals("3")
				|| lastChar.equals("4") || lastChar.equals("5") || lastChar.equals("6") || lastChar.equals("7")
				|| lastChar.equals("8") || lastChar.equals("9") || lastChar.equals("X")) {
			if (lastChar.equals("X")) {
				lastCharNumber = 10;
			} else {
				lastCharNumber = Integer.parseInt(lastChar);
			}
		} else {
			nextStep = false;
		}

		// Getting cumulative value of First Series of numbers
		for (int i = 0; i < cleanedString.length() - 1; i++) {
			char value = cleanedString.charAt(i);
			String valueString = Character.toString(value);

			if (valueString.equals("0") || valueString.equals("1") || valueString.equals("2") || valueString.equals("3")
					|| valueString.equals("4") || valueString.equals("5") || valueString.equals("6")
					|| valueString.equals("7") || valueString.equals("8") || valueString.equals("9")) {
				int number = Integer.parseInt(valueString);
				int mult = number * (10 - i);
				check = check + mult;
				nextStep = true;
			} else {
				nextStep = false;
			}
		}

		// Adding Cumulative Value + Last Number
		if (nextStep == false) {
			valid = false;
		} else if (nextStep == true) {
			total = check + lastCharNumber;
			if (total % 11 == 0) {
				valid = true;
			} else {
				valid = false;
			}
		}
		return valid;

	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		Boolean valid;
		String cleanedString = string.replaceAll("\\s", "");
		Set<String> alphabets = new HashSet<>();

		for (int i = 0; i < cleanedString.length(); i++) {
			char c = cleanedString.charAt(i);
			String s = Character.toString(c);
			alphabets.add(s);
		}
		if (alphabets.size() == 26) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public LocalDateTime getGigasecondDate(Temporal given) {

//		OLD METHOD
//		Temporal newTime = given.plus(1000000000, ChronoUnit.SECONDS);
//		return newTime;

		LocalDateTime ldt = null;

		if (given instanceof LocalDate) {
			ldt = LocalDateTime.of((LocalDate) given, LocalTime.MIN);
			ldt = ldt.plusSeconds(1000000000);
		} else if (given instanceof LocalDateTime) {
			ldt = (LocalDateTime) given;
			ldt = ldt.plusSeconds(1000000000);
		}
		return ldt;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int num = i;
		int numSet[] = set;
		int total = 0;
		Set<Integer> multiples = new HashSet<>();

		for (Integer a : numSet) {
			int add = 1;
			while ((a * add) < num) {
				multiples.add(a * add);
				add++;
			}
		}

		for (int b : multiples) {
			total += b;
		}

		return total;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		String cleanedString = string.replaceAll("\\s", "");
		boolean valid = false;
		int n;
		int total = 0;

		// Main
		for (int i = 0; i < cleanedString.length(); i++) {
			String w = Character.toString(cleanedString.charAt(i));

			// Check for alphabets
			try {
				n = Integer.parseInt(w);
			} catch (Exception e) {
				valid = false;
				break;
			}

			if ((cleanedString.length() - i) % 2 == 0) {
				if (n >= 0 && n <= 4) {
					total += n * 2;
				} else {
					total = total + (2 * n - 9);
				}
			} else {
				total += n;
			}
		}

		if (total % 10 == 0) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		String cleanedString = string.replaceAll("\\?", "");
		String operator[] = cleanedString.split(" ");
		int result = 0;

		int x = Integer.parseInt(operator[2]);
		int y = Integer.parseInt(operator[operator.length - 1]);

		switch (operator[3]) {
		case "plus":
			result = x + y;
			break;
		case "minus":
			result = x - y;
			break;
		case "multiplied":
			result = x * y;
			break;
		case "divided":
			result = x / y;
			break;
		default:
			break;
		}
		return result;
	}

}
