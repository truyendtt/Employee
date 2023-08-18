package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalarySettingPage extends Page{
    By ddSalaryType= By.xpath("//span//span//span[contains(.,'--- Chọn loại lương ---')]");
    By btnCreatePayrate = By.id("btnCreateTemplate");
    By txtmainSalaryInput= By.id("mainSalaryInput");
    public SalarySettingPage(WebDriver dr) {
        super(dr);
        this.driverWeb= dr;
    }
    public void setMainSalary(String salaryType, String inputMainSalary){
        clickFromElement(ddSalaryType);
        String xpathSalaryType= String.format("//li[contains(.,'%s')]", salaryType);
        clickFromElement(By.xpath(xpathSalaryType));
        driverWeb.findElement(txtmainSalaryInput).sendKeys(inputMainSalary);

    }
    public CreatePayrateTemplatePage clickCreatePayrate(){
        clickFromElement(btnCreatePayrate);
        return new CreatePayrateTemplatePage(driverWeb);
    }
}
