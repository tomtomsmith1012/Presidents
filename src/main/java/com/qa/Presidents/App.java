package com.qa.Presidents;

import java.io.IOException;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) throws IOException {
		Read read = new Read();
		ArrayList<President> presidents = new ArrayList<President>();
		try {
			presidents = read.bufferedRead("C:\\Users\\Admin\\Documents\\presidents.txt");
		} catch (IOException e) {
			System.out.println(e);
		}

		for (President p : presidents) {
		}

		int[] deathYears = read.getDeathYears(presidents);
		int[] birthYears = read.getBirthYears(presidents);
		ArrayList<String> livingPresidents = new ArrayList<String>();
		ArrayList<String> mostPresidents = new ArrayList<String>();
		int x = 0;
		int presAlive = 0;
		for (int y = 1732; y < 2019; y++) {
			for (int i : birthYears) {
				if (i == y) {
					presAlive += 1;
				}
			}
			for (int j : deathYears) {
				if (j == y) {
					presAlive -= 1;
				}
			}

			livingPresidents.add("Presidents alive in " + y + ": " + presAlive);
			if (presAlive == 18) {
				mostPresidents.add("Presidents alive in " + y + ": " + presAlive);
			}
		}


		for (String s : mostPresidents) {
			System.out.println(s);
		}
	}

}
