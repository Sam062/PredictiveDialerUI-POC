package base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import base.model.DialerData;

public class DialerUtils {
	public static final List<DialerData> readCsvData(InputStream inputStream) {
		BufferedReader fileReader;
		CSVParser csvParser = null;

		try {
			fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			ArrayList<DialerData> dataList = new ArrayList<>();
			for (CSVRecord csvRecord : csvRecords) {
				DialerData data = new DialerData(csvRecord.get(0), csvRecord.get(1), csvRecord.get(2), csvRecord.get(3),
						csvRecord.get(4), Integer.valueOf(csvRecord.get(5)), csvRecord.get(6));
				dataList.add(data);
			}
			return dataList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (csvParser != null)
					csvParser.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

//	public static final List<DialerData> readCsv(String filePath) {
//		List<DialerData> dataList = null;
//		CSVReader reader = null;
//		try {
//			reader = new CSVReader(new FileReader(filePath));
//			String[] line;
//			dataList = new ArrayList<>();
//			while ((line = reader.readNext()) != null) {
//				dataList.add(
//						new DialerData(line[0], line[1], line[2], line[3], line[4], Integer.valueOf(line[5]), line[6]));
//
//			}
//			return dataList;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (reader != null)
//					reader.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return dataList;
//	}

}
