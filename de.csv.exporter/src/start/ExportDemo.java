package start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.csv.exporter.BookEntryExporterImpl;
import de.csv.exporter.UserExporterImpl;
import de.csv.model.BookEntry;
import de.csv.model.User;
import de.csv.model.header.CSVHeader;
import de.csv.model.header.CSVHeaderBookEntry;
import de.csv.model.header.CSVHeaderUser;
import de.csv.model.header.ExportValue;

public class ExportDemo {

	public static void main(String[] args) {

		List<CSVHeader> bookEntriesHeader = new ArrayList<>();

		bookEntriesHeader.add(new CSVHeaderBookEntry(ExportValue.BOOKENTRY_AMOUNT, "amount"));
		bookEntriesHeader.add(new CSVHeaderBookEntry(ExportValue.BOOKENTRY_OFFER, "angebot"));

		final List<BookEntry> bookEntries = Arrays.asList(new BookEntry("Klobuerste 3000", 20),
				new BookEntry("Zahnbuerste", 5));

		final BookEntryExporterImpl bookEntryExporter = new BookEntryExporterImpl(); 
		bookEntryExporter.createExportFile("C:\\Users\\Jens\\Desktop\\bookEntries.csv", bookEntries, bookEntriesHeader);

		List<CSVHeader> userHeader = new ArrayList<>();
		userHeader.add(new CSVHeaderUser(ExportValue.USER_NAME, "name"));
		userHeader.add(new CSVHeaderUser(ExportValue.USER_IQ, "iq"));
		userHeader.add(new CSVHeaderBookEntry(ExportValue.BOOKENTRY_AMOUNT, "XX"));

		final List<User> userListe = Arrays.asList(new User("Karl Ess", 110, 7), new User("Tim Gabel", 100, 12));

		final UserExporterImpl userExporter = new UserExporterImpl();
		userExporter.createExportFile("C:\\Users\\Jens\\Desktop\\users.csv", userListe, userHeader);

	}

}
