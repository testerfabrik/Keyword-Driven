package com.testerfabrik.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class TestData {
    Object tableArray[][] = null;
    String filePath = System.getProperty("user.dir")+"/resources/";
    String fileName = "TestCase.xlsx";
    String sheetName = "KeywordFramework";
    ReadExcelFile file;
    Row row;

    @DataProvider(name="ParserData")
    public Object[][] getData(){
        file = new ReadExcelFile();
        // Declaración de Variables
        int startRow, startCol;

        // Leer la hoja de palabras clave
        try {
            Sheet dataSheet = file.readExcel(filePath,fileName,sheetName);

            // Encontrar el número de fílas en el archivo excel
            int totalRows = dataSheet.getLastRowNum()-dataSheet.getFirstRowNum();
            // Encontrar el número de columnas
            int totalCols = dataSheet.getRow(0).getLastCellNum();
            tableArray = new Object[totalRows][totalCols];

            for (startRow = 0; startRow < totalRows; startRow++){
                // Iterar sobre todas las filas
                row = dataSheet.getRow(startRow+1);
                // Crear un ciclo para imprimir los valores de la celda en una columna
                for (startCol=0;startCol < totalCols; startCol++){
                    // Imprimir los datos de excel en la consola
                    tableArray[startRow][startCol]=row.getCell(startCol).toString();
                }
            }

            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableArray;
    }
}
