package com.aws.pocketmoney.excel;

import com.aws.pocketmoney.config.StandardSpringTest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExcelCC extends StandardSpringTest {



    @Test
    void name() throws IOException {
        FileInputStream fis = new FileInputStream(new File("C:\\새 폴더\\이름.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(0);
        XSSFCell cell = row.getCell(0);

        int totalRowCount = sheet.getPhysicalNumberOfRows();
        int rowIndex = 0;

        for (int i = 1; i < totalRowCount ; i++) {
            Row row1 = sheet.getRow(i);
            System.out.println((int)row1.getCell(0).getNumericCellValue());
            System.out.println(row1.getCell(1).getStringCellValue());
            System.out.println(row1.getCell(2).getStringCellValue());
        }




    }

}
