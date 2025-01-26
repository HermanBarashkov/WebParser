import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class WriterExcel {
    public void writeToExcel(MonthPOJO month) {
        try (FileInputStream fileIn = new FileInputStream("Результат.xlsx")){
            Workbook workbook = WorkbookFactory.create(fileIn);
            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(1);
            row.createCell(12).setCellValue(month.getMonth1());
            row.createCell(13).setCellValue(month.getMonth2());
            row.createCell(14).setCellValue(month.getMonth3());
            row.createCell(15).setCellValue(month.getMonth4());
            row.createCell(16).setCellValue(month.getMonth5());
            row.createCell(17).setCellValue(month.getMonth6());
            row.createCell(18).setCellValue(month.getMonth7());
            row.createCell(19).setCellValue(month.getMonth8());
            row.createCell(20).setCellValue(month.getMonth9());
            row.createCell(21).setCellValue(month.getMonth10());
            row.createCell(22).setCellValue(month.getMonth11());
            row.createCell(23).setCellValue(month.getMonth12());
            row.createCell(24).setCellValue(month.getYear1_5());
            row.createCell(25).setCellValue(month.getYear2());
            row.createCell(26).setCellValue(month.getYear3());

            try (FileOutputStream fileOut = new FileOutputStream("Результат.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Данные успешно добавлены в файл!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
