package de.csv.base;

import java.util.List;

public interface Exporter<T> {

	
	public void createRecords(List<T> liste);
}
