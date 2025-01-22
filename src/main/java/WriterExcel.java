import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriterExcel {
    public void writeToExcel(String segment, String result) {
        try (FileInputStream fileIn = new FileInputStream("Результат.xlsx")){
            Workbook workbook = WorkbookFactory.create(fileIn);
            Sheet sheet = workbook.getSheetAt(0);

            int lastRowNum = sheet.getLastRowNum();
            Row newRow = sheet.createRow(lastRowNum + 1);
            Cell cell =  newRow.createCell(0);
            cell.setCellValue(segment);

            cell = newRow.createCell(1);
            cell.setCellValue(result);

            try (FileOutputStream fileOut = new FileOutputStream("Результат.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Данные успешно добавлены в файл!");
            }

            // Закрываем workbook
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
