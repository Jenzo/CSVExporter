package de.csv.exporter;

import de.csv.base.CSVExporter;
import de.csv.model.User;
import de.csv.model.header.ExportValue;

public class UserExporterImpl extends CSVExporter<User> implements UserExporter{


	@Override
	protected String getValueForHeader(User user, ExportValue exportValue) {

		
		switch (exportValue) {
		case USER_NAME:
			return user.getName();
		case USER_IQ:
			return String.valueOf(user.getIQ());
		case USER_ALTER:
			return String.valueOf(user.getAlter());
		default:
			return "" ;
		}
	}

}
