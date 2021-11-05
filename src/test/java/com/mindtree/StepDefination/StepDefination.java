
package com.mindtree.StepDefination;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.*;

import com.mindtree.exception.*;
import com.mindtree.reusablecomponents.*;
import com.mindtree.pageobject.*;
import com.mindtree.utilities.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.en.*;



public class StepDefination extends Base {
	public StepDefination() throws UtilityException, Exception {
		//super();
	}

	static Logger log;
	static ExtentTest test;
	static ExtentReports report;

	@Before
	public void initilize() throws InterruptedException, IOException {
		
System.out.println("Before");
	}

	@Given("^BookStore Url Open$")
	public void bookstore_Url_Open() throws Exception  {
		report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
				+ System.currentTimeMillis() + "-.html");
		log = Logger.getLogger(StepDefination.class.getName());
		driver = initialize();
		test = report.startTest("Home Page");
		driver.get(GetProperties.get.getProperty("url"));
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
		report.endTest(test);
		report.flush();
	}

	@When("^Validate Url$")
	public void validate_Url() throws PageObjectException, Exception {
		test = report.startTest("Validate Page");
		new ValidatePageTitle(driver, log, test).validate();
		report.endTest(test);
		report.flush();
	}

	@Then("^Order One Hindi Book \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void order_One_Hindi_Book(String BookName, String Author, String language, String quant) throws Throwable {
		test = report.startTest("Home Page");
		new HindiBook(driver, log, test).buyHindiBook(language, BookName, Author);
		Thread.sleep(1000);
		new CartPage(driver, log, test).addToCart(quant);
		Thread.sleep(1000);
		report.endTest(test);
		report.flush();
	}

	@Then("^Order Book drop down \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void order_book_drop_dow(String BookName, String type, String Author, String language, String quant) throws PageObjectException, Exception {
		test = report.startTest("Drop Down List");
		new BooksDropDown(driver, log, test).addBookCart(BookName, type, Author, language);
		Thread.sleep(1000);
		new CartPage(driver, log, test).addToCart(quant);
		Thread.sleep(1000);
		report.endTest(test);
		report.flush();
	}

	@Then("^Search Book And order it \"([^\"]*)\",\"([^\"]*)\"$")
	public void search_Book_And_order_it(String bookName, String quanty) throws ReusableComponentException, Exception  {
		test = report.startTest("Search Book");
		new SearchBook(driver, log, test).searchAndAdd(bookName);
		Thread.sleep(1000);
		new CartPage(driver, log, test).addToCart(quanty);
		Thread.sleep(1000);
		report.endTest(test);
		report.flush();
	}

	@Then("^Order one Backcover \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void order_one_Backcover(String BrandName, String Model, String quantity) throws PageObjectException, Exception {
		test = report.startTest("Cover Page");
		new MobileCoverOrder(driver, log, test).orderCover(BrandName, Model);
		Thread.sleep(1000);
		new CartPage(driver, log, test).addToCart(quantity);
		Thread.sleep(1000);
		report.endTest(test);
		report.flush();
	}



	@After
	public void terminate() throws InterruptedException {

		Thread.sleep(1000);
		driver.quit();

	}
}