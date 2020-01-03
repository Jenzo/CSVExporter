package de.csv.exporter;

import de.csv.base.CSVExporter;
import de.csv.model.BookEntry;
import de.csv.model.header.ExportValue;

public class BookEntryExporterImpl extends CSVExporter<BookEntry> implements BookEntryExporter {

	@Override
	protected String getValueForHeader(BookEntry be, ExportValue exportValue) {

		switch (exportValue) {
		case BOOKENTRY_AMOUNT:
			return String.valueOf(be.getAmount());
		case BOOKENTRY_OFFER:
			return be.getOfferName();
		default:
			return "";
		}

	}

}
