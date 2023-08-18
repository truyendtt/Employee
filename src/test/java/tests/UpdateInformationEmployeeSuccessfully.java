package tests;

import Pages.*;
import org.testng.Assert;

import org.testng.annotations.Test;


public class UpdateInformationEmployeeSuccessfully extends TestCase {

	@Test
//	public void UpdateInformationEmployeeSuccessfully ()  {
//		String inputNickName= "auto Test";
//		String inputDate = "10/01/2020";
//		String inputGender="male";
//		String inputDerpartment= "phòng Kinh doanh";
//		String inputPathImage= "C:\\Users\\truyendtt\\Pictures\\ảnh\\a.jpg";
//		String expectedToastmessage="Cập nhật nhân viên thành công";
//
//		HomePage homePage = new HomePage(testBase.driver);
//		PageEmployee pageEmployee = homePage.clickFromEmployee();
//		UpdateEmployeePage updatEmployeePage = pageEmployee.clickFormUpdateInformationEmployee();
//		updatEmployeePage.updateNickName(inputNickName);
//		updatEmployeePage.updateGender(inputGender);
//		updatEmployeePage.updateDerpartment(inputDerpartment);
//		updatEmployeePage.updateImage(inputPathImage);
//		updatEmployeePage.updateBirthday(inputDate);
//		updatEmployeePage.clickSaveInformationUpdaed();
//		Assert.assertEquals(pageEmployee.getTexMessage(), expectedToastmessage);
//	}
	public void settingPayrateSuccssefully(){
		String salaryType="Theo ca làm việc";
		String inputMainSalary="50000";
		String inputPayrateTemplateName= "mẫu lương auto";
		HomePage homePage = new HomePage(testBase.driver);
		PageEmployee pageEmployee = homePage.clickFromEmployee();
		SettingSalaryTab settingSalaryTab= pageEmployee.clickSettingSalaryTab();
		SalarySettingPage salarySettingPage= settingSalaryTab.clickSettingSalary();
		salarySettingPage.setMainSalary(salaryType,inputMainSalary );
		CreatePayrateTemplatePage createPayrateTemplatePage= salarySettingPage.clickCreatePayrate();
		createPayrateTemplatePage.creatPayrateTemplate(inputPayrateTemplateName);

	}


}