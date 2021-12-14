package dataDrivenTest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ReadExcelFile {
     XSSFSheet sheet;
     XSSFWorkbook workbook;

    public void Set_Excel(String File_path,String Sheet_Name) throws IOException {
        File file = new File(File_path);

        FileInputStream inputStream = new FileInputStream(file);

         workbook = new XSSFWorkbook(inputStream);

         sheet = workbook.getSheet(Sheet_Name);
    }

    public String get_cellData(int row_num,int cell_num){

         XSSFCell cell = sheet.getRow(row_num).getCell(cell_num);

         switch (cell.getCellType()){
             case STRING :
                 return cell.getStringCellValue();
             case NUMERIC:
                 return String.valueOf(cell.getNumericCellValue()).replace(".","");

         }
        return null;
    }

    public  int get_rowCount(){

          int row_count = sheet.getLastRowNum()-sheet.getFirstRowNum();

          return row_count;
    }


}
