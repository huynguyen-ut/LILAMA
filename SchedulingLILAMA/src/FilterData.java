import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FilterData {
   Workbook workbook;
  
   public FilterData(String file) throws EncryptedDocumentException, IOException {
	   FileInputStream fis = new FileInputStream("C:\\pathX\\Data_TK_bieu.xlsx");
       workbook=WorkbookFactory.create(fis);
       
   }
   public void readExcel(String excelFilePath) throws IOException {
	   
       // list schedule
	   List<Schedule> listTeacher = new ArrayList<Schedule>();
	   // Danh sach Giao Vien
       List<Teacher> listTeacher = new ArrayList<Teacher>();
       // Danh sach lop hoc
       List<Class> listClass = new ArrayList<Class>();
       // Danh mon hoc
       List<Subject> listSubject = new ArrayList<Subject>();

       // Get file
       InputStream inputStream = new FileInputStream(new File(excelFilePath));

       // Get workbook
       Workbook workbook = getWorkbook(inputStream, excelFilePath);

       // Get sheet
       Sheet sheetSchedule = workbook.getSheetAt(0);
       Sheet sheetTeacher = workbook.getSheetAt(1);
       Sheet sheetClass = workbook.getSheetAt(2);
       Sheet sheetSubject = workbook.getSheetAt(3);

       // Get all rows
       Iterator<Row> iterator = sheetSchedule.iterator();
       while (iterator.hasNext()) {
           Row nextRow = iterator.next();
           if (nextRow.getRowNum() == 0) {
               // Ignore header
               continue;
           }

           // Get all cells
           Iterator<Cell> cellIterator = nextRow.cellIterator();

           // Read cells and set value for book object
           Teacher teacher = new Teacher();
           while (cellIterator.hasNext()) {
               //Read cell
               Cell cell = cellIterator.next();
               Object cellValue = getCellValue(cell);
               if (cellValue == null || cellValue.toString().isEmpty()) {
                   continue;
               }
               // Set value for book object
               int columnIndex = cell.getColumnIndex();
               switch (columnIndex) {
               case 1:
                  // Teacher.setId(new BigDecimal((double) cellValue).intValue());
                   break;
               case 2:
                  // teacher.setTitle((String) getCellValue(cell));
                   break;
              
               default:
                   break;
               }

           }
           listTeacher.add(teacher);
       }

       workbook.close();
       inputStream.close();

     
   }

   // Get Workbook
   private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
       Workbook workbook = null;
       if (excelFilePath.endsWith("xlsx")) {
           workbook = new XSSFWorkbook(inputStream);
       } else if (excelFilePath.endsWith("xls")) {
           workbook = new HSSFWorkbook(inputStream);
       } else {
           throw new IllegalArgumentException("The specified file is not Excel file");
       }

       return workbook;
   }

   // Get cell value
   private static Object getCellValue(Cell cell) {
       CellType cellType = cell.getCellTypeEnum();
       Object cellValue = null;
       switch (cellType) {
       case BOOLEAN:
           cellValue = cell.getBooleanCellValue();
           break;
       case FORMULA:
           Workbook workbook = cell.getSheet().getWorkbook();
           FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
           cellValue = evaluator.evaluate(cell).getNumberValue();
           break;
       case NUMERIC:
           cellValue = cell.getNumericCellValue();
           break;
       case STRING:
           cellValue = cell.getStringCellValue();
           break;
       case _NONE:
       case BLANK:
       case ERROR:
           break;
       default:
           break;
       }

       return cellValue;
   }
}
