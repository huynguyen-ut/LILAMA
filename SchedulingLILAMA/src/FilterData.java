import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FilterData {
   Workbook workbook;
   public FilterData(String file) throws EncryptedDocumentException, IOException {
	   FileInputStream fis = new FileInputStream("C:\\pathX\\Data_TK_bieu.xlsx");
       workbook=WorkbookFactory.create(fis);
       
   }
}
