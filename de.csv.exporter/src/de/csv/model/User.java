package de.csv.model;

public class User {

	private final String name;
	private final int iq;
	private final int alter;

	public User(String name, int iq, int alter) {
		this.name = name;
		this.iq = iq;
		this.alter = alter;
	}

	public int getAlter() {
		return alter;
	}

	public String getName() {
		return name;
	}

	public int getIQ() {
		return iq;
	}

}
