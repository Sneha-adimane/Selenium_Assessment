package Assessments;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import SauceDemo.BaseClass;
import SauceDemo.HomePage;
import SauceDemo.LoginPage;
import SauceDemo.cart;
import SauceDemo.checkout;
import SauceDemo.complete;
import SauceDemo.overview;

public class Day_10_saucedemo extends BaseClass {

	@Test(priority = 1)
	public void LoginTest() throws IOException, InterruptedException {
		//common data for username and password 
		FileInputStream file = new FileInputStream("./src/test/resources/DDT/commondata.properties");
		Properties p = new Properties();
		p.load(file);
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		LoginPage l = new LoginPage(d);
		//username
		l.getUsername(un);
		//password
		l.getPassword(pw);
		Thread.sleep(2000);
		//loginbutton
		l.getLogin();
	}
	
	@Test(priority = 2)
	public void oderPalcementTest() throws InterruptedException, IOException {
		
		HomePage h = new HomePage(d);
		//verify product page is displayed or not
		if(h.getProduct().equals("Products"))
			System.out.println("Product page is displayed");
		else
			System.out.println("Not displayed");
		Thread.sleep(2000);
		
		//add to cart
		h.getAddtocart();
		Thread.sleep(2000);
		
		//verify only 1 product is added or not
		if(h.getquantity().equals("1"))
			System.out.println("Only one product is added");
		else 
			System.out.println("many product are added");
	
		// click on cart button
		h.getCart();
		
		cart ca = new cart(d);
		
		//verigy Product back pack is added to cart or not
		if(ca.getProductverify().equals("Sauce Labs Backpack"))
			System.out.println("BackPack product is added");
		else
			System.out.println("Wrong product is added");
		Thread.sleep(2000);
		
		//click on checkout
		ca.getCheckout();
		Thread.sleep(2000);
		
		//read data from excel file
		checkout co = new checkout(d);
		FileInputStream f = new FileInputStream("./src/test/resources/DDT/saucedemo_details.xlsx");
		Workbook w = WorkbookFactory.create(f);
		Sheet sh = w.getSheet("sheet1");
		Row row = sh.getRow(1);
		
		String fn = row.getCell(0).getStringCellValue();
		String ln = row.getCell(1).getStringCellValue();
		String c = row.getCell(2).getStringCellValue();
		
		//get first name
		co.getFName(fn);
		//get last name
		co.getLName(ln);
		//get post code
		co.getCode(c);
		Thread.sleep(2000);
		
		//click on continue
		co.getContinuebtn();
		
		overview o = new overview(d);
		//verify overview page is displayed or not
		if(o.getOverview().equals("Checkout: Overview"))
			System.out.println("product overview is displayed");
		else
			System.out.println("product overview is not displayed");
		
		//click on finish
		o.getFinish();
		Thread.sleep(2000);
		
		//verify the message is displayed or not
		complete a = new complete(d);
		if(a.getMessage().equals("Thank you for your order!"))
			System.out.println("message is dispalyed");
		else 
			System.out.println("message is not displayed");
	}
}
