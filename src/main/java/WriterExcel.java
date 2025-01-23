import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriterExcel {
    public void writeToExcel(int row, int cell, String result) {
        try (FileInputStream fileIn = new FileInputStream("/home/german/snap/libreoffice/334/Deposit.xlsx")){
            Workbook workbook = WorkbookFactory.create(fileIn);
            Sheet sheet = workbook.getSheetAt(0);

            Row newRow = sheet.getRow(row);
            Cell cell1 =  newRow.getCell(cell);
            cell1.setCellValue(result);


            try (FileOutputStream fileOut = new FileOutputStream("/home/german/snap/libreoffice/334/Deposit.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Данные успешно добавлены в файл!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
