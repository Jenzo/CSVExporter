package de.csv.model;

public class BookEntry {

	private final String offerName;
	private final int amount;

	public BookEntry(String offerName, int amount) {
		this.offerName = offerName;
		this.amount = amount;
	}

	public String getOfferName() {
		return offerName;
	}

	public int getAmount() {
		return amount;
	}

}
