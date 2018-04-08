package com.testerfabrik.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;

public class UIOperations {
    WebDriver driver;

    public UIOperations(WebDriver driver){
        this.driver = driver;
    }

    //Método para realizar acciones en los objetos de la UI
    public void perform(Properties p,String operation,String objectName,String objectType,String value) throws Exception{
        System.out.println("");
        switch(operation.toLowerCase()){
            case "click":
                this.getObject(p,objectName, objectType).click();
                break;
            case "settext":
                this.getObject(p,objectName, objectType).sendKeys(value);
                break;
            case "gotourl":
                driver.get(p.getProperty(value));
                break;
            case "gettext":
                this.getObject(p,objectName, objectType).getText();
                break;
            case "selectbytext":
                new Select(this.getObject(p,objectName, objectType)).selectByVisibleText(value);
                break;
            case "close":
                driver.quit();
                break;
            default:
                throw new Exception("Wrong action keyword!");
        }
    }

    /**
     * Find element BY using object type and value
     * @param p
     * @param objectName
     * @param objectType
     * @return
     * @throws Exception
     */

    //Método que regresa un WebElement dependiendo del Locator que se elija
    private WebElement getObject(Properties p, String objectName, String objectType) throws Exception{
        switch(objectType.toLowerCase()) {
            case "id":
                return driver.findElement(By.id(p.getProperty(objectName)));
            case "xpath":
                return driver.findElement(By.xpath(p.getProperty(objectName)));
            case "name":
                return driver.findElement(By.name(p.getProperty(objectName)));
            case "link":
                return driver.findElement(By.linkText(p.getProperty(objectName)));
            case "partiallink":
                return driver.findElement(By.partialLinkText(p.getProperty(objectName)));
            case "css":
                return driver.findElement(By.cssSelector(p.getProperty(objectName)));
            case "class":
                return driver.findElement(By.className(p.getProperty(objectName)));
            case "tagname":
                return driver.findElement(By.tagName(p.getProperty(objectName)));
            default:
                throw new Exception("Wrong object type");
        }
    }
}
