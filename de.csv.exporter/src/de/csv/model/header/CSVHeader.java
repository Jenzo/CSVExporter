package de.csv.model.header;

public abstract class CSVHeader {

	private final HeaderType headerType;
	private final ExportValue exportValue;
	private String displayName;

	public CSVHeader(HeaderType headerType, ExportValue exportValue, String displayName) {
		this.displayName = displayName;
		this.headerType = headerType;
		this.exportValue = exportValue;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public HeaderType getHeaderType() {
		return headerType;
	}

	public ExportValue getExportValue() {
		return exportValue;
	}

}
