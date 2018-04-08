package com.testerfabrik.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {
    public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException {

        //Crea un objeto de la clase File para abrir el archivo excel
        File file =    new File(filePath+"/"+fileName);

        //Crea un objeto de la clase FileInoutStream para leer el archivo excel
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workBook = null;

        //Encuentre la extensión de archivo dividiendo el nombre de archivo en la subcadena y obteniendo solo el nombre de la extensión
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        // Condición para checar si es un archivo .xlsx
        if(fileExtensionName.equals(".xlsx")){
            //Si es un archivo .xlsx, entonces crea un objeto de la clase XSSFWorbook
            workBook = new XSSFWorkbook(inputStream);
        // Condición para checar si es un archivo .xls
        }else if(fileExtensionName.equals(".xls")){
            //Si es un archivo .xls, entonces crea un objeto de la clase HSSFWorbook
            workBook = new HSSFWorkbook(inputStream);
        }

        // Lea la hoja dentro del libro de trabajo por su nombre
        Sheet sheet = workBook.getSheet(sheetName);
        return sheet;
    }
}
