package com.qa.Presidents;

public class President {
String name;
String birthDate;
String birthPlace;
String deathDate;
String deathPlace;


public President (String name, String birthDate, String birthPlace, String deathDate, String deathPlace) {
	this.name = name;
	this.birthDate = birthDate;
	this.birthPlace = birthPlace;
	this.deathDate = deathDate;
	this.deathPlace = deathPlace;
	
	
}

public String toString() {
	return name + " " + birthDate +  " " + birthPlace + " " + deathDate + " " + deathPlace;
}
}
