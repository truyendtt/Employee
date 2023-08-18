package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingSalaryTab extends Page{
    By btnSettingSalary= By.id("btnPayment");
    public SettingSalaryTab(WebDriver dr) {
        super(dr);
        this.driverWeb= dr;
    }
    public SalarySettingPage clickSettingSalary(){
        clickFromElement(btnSettingSalary);
        return new SalarySettingPage(driverWeb);
    }
}
