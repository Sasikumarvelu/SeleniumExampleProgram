package gmail_login;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingExcelData {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    public void Get_data(String path,String sheet_name) throws IOException {

        workbook = new XSSFWorkbook(new FileInputStream(path));

         sheet = workbook.getSheet(sheet_name);
    }
    public String data(int row_no,int col_no){

       XSSFCell cell = sheet.getRow(row_no).getCell(col_no);
       return cell.getStringCellValue();
}
    public int Get_RowCount(){
        int row_count = sheet.getLastRowNum()-sheet.getFirstRowNum();
        return row_count;
}
    public int Get_cellCount(){
        int cells = row.getPhysicalNumberOfCells();
        return cells;
}

}
