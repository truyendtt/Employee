package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatePayrateTemplatePage extends Page{
    By txtPayrateName= By.id("templateName");
    public CreatePayrateTemplatePage(WebDriver dr) {
        super(dr);
        this.driverWeb= dr;
    }
    public void creatPayrateTemplate(String inputPayrateTemplateName){
        driverWeb.findElement(txtPayrateName).sendKeys(inputPayrateTemplateName);

    }
}
