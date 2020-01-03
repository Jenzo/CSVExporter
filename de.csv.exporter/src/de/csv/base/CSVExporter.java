package de.csv.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import de.csv.model.header.CSVHeader;
import de.csv.model.header.ExportValue;

public abstract class CSVExporter<T> implements Exporter<T> {

	final protected static CSVFormat FILE_FORMAT = CSVFormat.EXCEL.withDelimiter(';');

	protected List<CSVHeader> csvHeader = Collections.emptyList();
	protected List<List<String>> records = new ArrayList<>();

	public void createExportFile(String fileName, List<T> exportList, List<CSVHeader> csvHeader) {

		this.csvHeader = csvHeader;

		try (final FileOutputStream fos = new FileOutputStream(fileName);
				final OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
				final CSVPrinter csvPrinter = new CSVPrinter(osw, FILE_FORMAT)) {

			File csv = new File(fileName);

			createRecords(exportList);
			csvPrinter.printRecord(getCSVHeader());
			csvPrinter.printRecords(records);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("CSV erfolgreich erstellt.");

	}

	protected String getAsString(boolean isTrue) {
		return isTrue ? "WAHR" : "FALSCH";
	}

	private List<String> getCSVHeader() {
		return csvHeader.stream().map(h -> h.getDisplayName()).collect(Collectors.toList());
	}

	protected abstract String getValueForHeader(T t, ExportValue exportValue);

	@Override
	public void createRecords(List<T> exportList) {

		for (T t : exportList) {

			List<String> record = new ArrayList<>();
			for (CSVHeader csvHeader : csvHeader) {

				record.add(getValueForHeader(t, csvHeader.getExportValue()));

			}
			records.add(record);
		}

	}
}
