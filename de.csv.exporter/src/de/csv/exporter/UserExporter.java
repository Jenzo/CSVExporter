package de.csv.exporter;

import java.util.List;

import de.csv.model.User;

public interface UserExporter {

	
	public void createRecords(List<User> liste);
}
