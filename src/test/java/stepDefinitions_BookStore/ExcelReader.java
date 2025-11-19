package stepDefinitions_BookStore;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static String getCellData(String filepath, String sheetname, int rownum, int colnum) throws IOException {
		FileInputStream file = new FileInputStream(filepath);
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(sheetname);
		String celldata = sheet.getRow(rownum).getCell(colnum).getStringCellValue();

		workbook.close();
		return celldata;
	}

}
