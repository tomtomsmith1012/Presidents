package com.qa.Presidents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read {

	public ArrayList<President> bufferedRead(String inFile) throws IOException {
		BufferedReader bfrIn = new BufferedReader(new FileReader(inFile));
		ArrayList<President> presidents = new ArrayList<President>();
		String line;
		String name;
		String birthDate;
		String birthPlace;
		String deathDate;
		String deathPlace;

		while ((line = bfrIn.readLine()) != null) {

			President p = new President(" ", " ", " ", " ", " ");
			String[] parts = line.split(",");
			name = parts[0];
			birthDate = parts[1];
			birthPlace = parts[2];
			deathDate = parts[3];
			deathPlace = parts[4];

			p.name = name;
			p.birthDate = birthDate;
			p.birthPlace = birthPlace;
			p.deathDate = deathDate;
			p.deathPlace = deathPlace;
			presidents.add(p);

		}

		bfrIn.close();
		return presidents;

	}

	public int[] getBirthYears(ArrayList<President> presidents) {
		int[] years = new int[43];
		String yearString;
		int year;
		int i = 0;
		char y1;
		char y2;
		char y3;
		char y4;
		for (President p : presidents) {
			if (!p.name.equals("PRESIDENT")) {
				StringBuilder sb = new StringBuilder();
				y1 = p.birthDate.charAt(p.birthDate.length() - 1);
				y2 = p.birthDate.charAt(p.birthDate.length() - 2);
				y3 = p.birthDate.charAt(p.birthDate.length() - 3);
				y4 = p.birthDate.charAt(p.birthDate.length() - 4);
				sb.append(y4);
				sb.append(y3);
				sb.append(y2);
				sb.append(y1);
				yearString = sb.toString();
				year = Integer.parseInt(yearString);
				years[i] = year;
				i++;

			}

		}
		return years;
	}

	public int[] getDeathYears(ArrayList<President> presidents) {
		int[] years = new int[43];
		String yearString;
		int year;
		int i = 0;
		char y1;
		char y2;
		char y3;
		char y4;
		for (President p : presidents) {
			if (!p.name.equals("PRESIDENT") && p.deathDate.length() > 1) {
				StringBuilder sb = new StringBuilder();
				y1 = p.deathDate.charAt(p.deathDate.length() - 1);
				y2 = p.deathDate.charAt(p.deathDate.length() - 2);
				y3 = p.deathDate.charAt(p.deathDate.length() - 3);
				y4 = p.deathDate.charAt(p.deathDate.length() - 4);
				sb.append(y4);
				sb.append(y3);
				sb.append(y2);
				sb.append(y1);
				yearString = sb.toString();
				year = Integer.parseInt(yearString);
				years[i] = year;
				i++;
			}

		}
		return years;
	}
}