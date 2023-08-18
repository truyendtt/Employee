package common;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBasic {
	public WebDriver driver;
	public  static final String FILE_CONFIG="\\src\\main\\resources\\config\\ProjectConfiguration.properties";
	String FILE_TEST_CONFIG= "\\src\\test\\resources\\testData\\testConfig.properties";
	public void openWebsite(String browser, String envi) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.gecko", readConfigValueByKey("gecko_driver", FILE_CONFIG));
			driver = new FirefoxDriver();
			System.out.print("firefoxff" + driver);
		} else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfigValueByKey("chrome_dirver", FILE_CONFIG));
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		switch (envi) {
			case "live": driver.get(readConfigValueByKey("url_LIVE", FILE_TEST_CONFIG));
				break;
			case "prelive": driver.get(readConfigValueByKey("url_PRELIVE", FILE_TEST_CONFIG));
				break;
			case "staging": driver.get(readConfigValueByKey("url_STAGING", FILE_TEST_CONFIG));
				break;
		}
	}
	private String getResultString(String envi, String variable){
		String result ="";
		String key = variable;
		switch (envi) {
			case "live": result=readConfigValueByKey(key+"_LIVE", FILE_TEST_CONFIG);
				break;
			case "prelive": result=readConfigValueByKey(key+"_PRELIVE", FILE_TEST_CONFIG);;
				break;
			case "staging": result=readConfigValueByKey(key+"_STAGING", FILE_TEST_CONFIG);;
				break;
		}
		return result;
	}
	public String getRetailerName (String envi){
		String result =getResultString(envi, "retailerName");
		return result;
	}
	public String getUserName (String envi){
		String result =getResultString(envi, "userName");
		return result;
	}
	public String getPassword (String envi){
		String result =getResultString(envi, "password");
		return result;
	}
	public String readConfigValueByKey(String Key, String fileConfig) {
		String resultValue = "";
		Properties properties = new Properties();
		InputStream inputStream=null;
		String currentDir= System.getProperty("user.dir");
		try {
			inputStream = new FileInputStream(currentDir + fileConfig);
			properties.load(inputStream);
			resultValue = properties.getProperty(Key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultValue;
	}

//	public void openWebsite(String url) {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\truyendtt\\Documents\\GitHub\\SeleniumWithMaven_v2\\DemoQA\\driver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get(url);
//		driver.manage().window().maximize();
//
//	}
	
	public void closeBrowser() {
		driver.quit();// close toàn bộ cửa sổ
	}
	public void ScrollWindow(By element) {
		
//		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement iframe= driver.findElement(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframe);	
//		js.executeScript("arguments[0].scrollIntoView(true);", iframe);
	}
	public void setWidown () {
		Dimension dm= new Dimension(700,1000);
		driver.manage().window().setSize(dm);
	}

	public By getLocatorString(String locatorType, String locatorValue) {
		By result = null;

		return result;

	}
	public ArrayList<String> getColumnValuesList(By columnLocator){
		   ArrayList<String> columnValuesList = new ArrayList();
		   
		   List<WebElement> columnElements =  driver.findElements(columnLocator);
		   
		   for (WebElement e : columnElements){//for each => chỉ áp dụng cho danh sách
		    String columnValue = e.getText();
		    columnValuesList.add(columnValue);
		   }
		   return columnValuesList;
		    
	}

}
