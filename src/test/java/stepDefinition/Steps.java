package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.GooglePage;
import pageObject.HomePage;
import pageObject.BaseClass;
import pageObject.CustDetailsPage;

public class Steps extends BaseClass {

	@Before
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger = Logger.getLogger("paisaBazaar");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@Given("User navigates to Google")
	public void user_navigates_to_Google() {
		driver.get("https://www.google.com/");
		gp = new GooglePage(driver);
		logger.info("Google Accessed");
	}

	@When("User types String")
	public void user_types_String() {
	    gp.enterText();
	    logger.info("Srch String Entered");
	}

	@Then("All prompts should be displayed in screen")
	public void all_prompts_should_be_displayed_in_screen() throws InterruptedException {
	    gp.displayEntries();
	    logger.info("Entries Displayed");
	}

	@When("User clicks enter and selects policy bazaar website")
	public void user_clicks_enter_and_selects_policy_bazaar_website() {
	    gp.clickLink();
	    logger.info("Policy Bazaar Accessed");
	   
	}

	@Then("User should be redirected to policy bazaar website")
	public void user_should_be_redirected_to_policy_bazaar_website() {
		 hp = new HomePage(driver);
	}

	@When("User types Vehicle Number")
	public void user_types_Vehicle_Number() {
	    hp.type_VNumber();
	    logger.info("Vehicle Number Searched");
	}

	@When("User types Vehicle Make")
	public void user_types_Vehicle_Make() {
	    hp.select_VMake();
	    logger.info("Vehicle Make Selected");
	}

	@When("User types Vehicle Model")
	public void user_types_Vehicle_Model() {
	    hp.select_VModel();
	    logger.info("Vehicle Model Selected");
	}

	@When("User types Vehicle Version")
	public void user_types_Vehicle_Version() {
	    hp.select_Vversion();
	    logger.info("Vehicle Version Selected");
	}

	@When("User types Vehicle Year")
	public void user_types_Vehicle_Year() {
	    hp.select_Vyear();
	    logger.info("Vehicle Year Selected");
	}

	@When("User types Vehicle Contract")
	public void user_types_Vehicle_Contract() throws InterruptedException {
	    hp.select_Vcntrct();
	    logger.info("Vehicle Contract Selected");
	}

	@When("User types Vehicle Last Detail")
	public void user_types_Vehicle_Last_Detail() {
	   hp.select_Vlast();
	   logger.info("Vehicle Detail Selected");
	}

	@Then("All Quotes Should be displayed in Screen")
	public void all_Quotes_Should_be_displayed_in_Screen() throws InterruptedException {
	    hp.displayPriceandSelect7th();
	    cdp = new CustDetailsPage(driver);
	    logger.info("Quotes Displayed");
	}

	@When("User types value for Customer Name")
	public void user_types_value_for_Customer_Name() {
	    cdp.typeName();
	    logger.info("Customer Name Printed");
	}

	@When("User types value for Mobile Number")
	public void user_types_value_for_Mobile_Number() {
	    cdp.typeMobile();
	    logger.info("Mobile Number Printed");
	}

	@When("User types value for Email")
	public void user_types_value_for_Email() {
	   cdp.typeEmail();
	   logger.info("Email ID Printed");
	}

	@When("User types value for Address1")
	public void user_types_value_for_Address1() {
	   cdp.typeAddress();
	   logger.info("Mailin Address Printed");
	}

	@When("User types value for Pincode")
	public void user_types_value_for_Pincode() {
	    cdp.typePinCode();
	    cdp.clickNext();
	    logger.info("Pin Code Printed");
	}

	@When("User types value for Nominee name")
	public void user_types_value_for_Nominee_name() throws InterruptedException {
	   cdp.typeNomineeName();
	   cdp.clickNext();
	   logger.info("Nominee Name Printed");
	}

	@When("User types value for Chasis Number")
	public void user_types_value_for_Chasis_Number() {
	    cdp.typeChasisNumber();
	    logger.info("Chasis Number Printed");
	}

	@When("User types value for Engine Number")
	public void user_types_value_for_Engine_Number() {
	   cdp.typeEngineNumber();
	   logger.info("Engine Number Printed");
	}

	@Then("User is able to see the Insurance details")
	public void user_is_able_to_see_the_Insurance_details() throws IOException, InterruptedException {
	   cdp.clickNext();
	   logger.info("Last Step Reached");
	   
	}

    @After
    public void tearDown() throws IOException
    {
    	tkscrnsht();
    	driver.quit();
    }

}
