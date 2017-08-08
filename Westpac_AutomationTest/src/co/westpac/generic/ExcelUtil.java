package co.westpac.generic;

import java.io.File;
import java.io.FileInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class implements the methods to
 * read the test data from excel sheet
 * 
 * @author shruthi
 *
 */
  public class ExcelUtil {
    	
    private static Logger log= LogManager.getLogger(ExcelUtil.class.getName());
    	
        private static XSSFSheet ExcelWSheet;
        private static XSSFWorkbook ExcelWBook;
        private static XSSFCell Cell;

     /**
      * Description: This method is to set the File path and to open the Excel file
      * @param Path
      * @param SheetName
      * @throws Exception
      */
       private static String  path = new File("src\\Test Data\\TestData.xlsx").getAbsolutePath();
        
        public static void setExcelFile(String Path) throws Exception{	
                FileInputStream ExcelFile = new FileInputStream(Path);
                ExcelWBook = new XSSFWorkbook(ExcelFile);         
        }

        /**
         * Description:This method is to read the test data from the Excel cell
         * @param RowNum
         * @param ColNum
         * @return cellData
         * @throws Exception
         */        
        public static String getCellData(int RowNum, int ColNum, String sheetName){
        	String cellData=null;
        	try{
        	  setExcelFile(ExcelUtil.path);
              DataFormatter formatter = new DataFormatter();
              ExcelWSheet=ExcelWBook.getSheet(sheetName);
              Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
              cellData = formatter.formatCellValue(Cell);
              return cellData;
        	}catch(Exception e){
        		log.error("unable to get excel data from excel"+e);
        	}
			return cellData;

       }
    }