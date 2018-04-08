package com.testerfabrik.test;

import com.testerfabrik.operations.ReadObject;
import com.testerfabrik.operations.UIOperations;
import com.testerfabrik.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class ExecuteTest {
    WebDriver driver;
    String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
    ReadObject object;
    UIOperations operations;
    Properties allObjects;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "ParserData")
    public void driverEngine(String... perform) throws Exception {
        object = new ReadObject();
        operations = new UIOperations(driver);
        allObjects = object.getObjectRepository();

        //Indicar si es un caso de prueba nuevo
        if (perform[0] != null && perform[0].length() != 0) {
            System.out.println("Starting Test Case: " + perform[0]);
        } else {
            // Llamar el método perform para realizar las operaciones en la UI
            operations.perform(allObjects, perform[1], perform[2], perform[3], perform[4]);
        }
    }
}
