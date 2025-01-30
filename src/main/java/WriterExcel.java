import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class WriterExcel {
    public void writeToExcel(int numRow, int month, String rate) {
        try (FileInputStream fileIn = new FileInputStream("/home/german/snap/libreoffice/334/Deposit.xlsx")){
            Workbook workbook = WorkbookFactory.create(fileIn);
            Sheet sheet = workbook.getSheetAt(0);
            int columnIndex = getColumnIndexForMonth(month);

            Row row = sheet.getRow(numRow);
            row.createCell(columnIndex).setCellValue(rate);


            try (FileOutputStream fileOut = new FileOutputStream("/home/german/snap/libreoffice/334/Deposit.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Данные успешно добавлены в файл!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getColumnIndexForMonth(int month) {
        List<Integer> monthsOrder = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 18, 24, 36);
        int index = monthsOrder.indexOf(month);
        return 14 + index; // 14 - индекс первого столбца с месяцами
    }

}
