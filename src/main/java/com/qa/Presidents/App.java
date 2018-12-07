package com.qa.Presidents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class App {

	private static Logger logger = Logger.getLogger(App.class.getName());
	
	public static void main(String[] args) throws IOException {
		Read read = new Read();
		ArrayList<President> presidents = new ArrayList<President>();
		try {
			presidents = read.bufferedRead("C:\\Users\\Admin\\eclipse-workspace\\Presidents\\presidents.txt");
		} catch (IOException e) {
			System.out.println(e);
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


		FileHandler fh;
		try { 
			fh = new FileHandler("C:\\Users\\Admin\\eclipse-workspace\\Presidents\\PresidentsLog.txt");
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
			logger.setLevel(Level.FINE);
		for (String s : mostPresidents) {
			logger.fine(s);}}
		catch (Exception e) { logger.severe(e.toString()); }
		
		
	}

}
