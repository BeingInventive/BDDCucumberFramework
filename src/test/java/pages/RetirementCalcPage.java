package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class RetirementCalcPage {
	WebDriver driver;
	private By txt_current_age = By.id("current-age");
	private By txt_retirement_age = By.id("retirement-age");
	private By txt_current_annual_income = By.id("current-income");
	private By txt_spouse_annual_income = By.id("spouse-income");
	private By txt_current_retirement_savings = By.id("current-total-savings");
	private By txt_current_retirement_contribution = By.id("current-annual-savings");
	private By txt_annual_retirement_contribution_increase = By.id("savings-increase-rate");
	private By chkbox_social_security_benefits = By.cssSelector("#include-social-container > ul > li:nth-child(1) > label");
	private By chkbox_marital_status = By.cssSelector("#marital-status-ul > li:nth-child(2) > label");
	private By txt_security_overrider = By.id("social-security-override");
	private By link_Adjust_default_values = By.xpath("//*[contains(text(),'Adjust default values')]"); 
    private By txt_other_income = By.id("additional-income");
    private By txt_no_of_year_retirement_needed = By.id("retirement-duration");
    private By chkbox_inflation_increase = By.cssSelector("#include-inflation-container > ul > li:nth-child(1) > label");
    private By txt_desired_income = By.id("expected-inflation-rate");
    private By txt_final_annual_amount = By.id("retirement-annual-income");
    private By txt_pre_retirement_prec = By.id("pre-retirement-roi");
    private By txt_post_retirement_prec = By.id("post-retirement-roi"); 
    private By btn_save_changes = By.cssSelector("#default-values-form > div:nth-child(3) > div > div.col-sm-4 > button");
    private By btn_calculate = By.cssSelector("#retirement-form > div:nth-child(7) > div:nth-child(2) > div.col-sm-4 > button");
    private By val_result = By.cssSelector("#calculator-results-container > h3"); 
    private By btn_editInfo = By.xpath("//*[@class='dsg-btn-secondary btn-block']");

    
    public RetirementCalcPage(WebDriver driver) {
	
		this.driver = driver;
	}
	
	public void openBrowser() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.securian.com/insights-tools/retirement-calculator.html");
		
	}	

	public void age(String current_age, String retirement_age, String current_annual_income ) throws InterruptedException {
		driver.findElement(txt_current_age).sendKeys(current_age);
		driver.findElement(txt_retirement_age).sendKeys(retirement_age);
		
		driver.findElement(txt_current_annual_income).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(txt_current_annual_income).sendKeys(current_annual_income);
	
	}
	
	public void income (String spouse_annual_income, String current_retirement_savings, String current_retirement_contribution, String annual_retirement_contribution_increase ) throws InterruptedException {
		driver.findElement(txt_spouse_annual_income).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(txt_spouse_annual_income).sendKeys(spouse_annual_income);
		driver.findElement(txt_current_retirement_savings).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(txt_current_retirement_savings).sendKeys(current_retirement_savings);
		driver.findElement(txt_current_retirement_contribution).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(txt_current_retirement_contribution).sendKeys(current_retirement_contribution);
		driver.findElement(txt_annual_retirement_contribution_increase).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(txt_annual_retirement_contribution_increase).sendKeys(annual_retirement_contribution_increase);
	}
	public void  SocialSecurityincome(String security_overrider) throws InterruptedException {
		driver.findElement(chkbox_social_security_benefits).click();
		Thread.sleep(500);
		driver.findElement(chkbox_marital_status).click();
		driver.findElement(txt_security_overrider).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(txt_security_overrider).sendKeys(security_overrider);
	}
	
	public void Adjustdefaultvalues(String other_income, String no_of_year_retirement_needed ) throws InterruptedException {
		driver.findElement(link_Adjust_default_values).click();
		Thread.sleep(500);
		driver.findElement(txt_other_income).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(txt_other_income).sendKeys(other_income);
		driver.findElement(txt_no_of_year_retirement_needed).sendKeys(no_of_year_retirement_needed);
	
	}
	
	public void InvestExp (String final_annual_amount, String desired_income, String pre_retirement_prec, String post_retirement_prec ) throws InterruptedException {
		driver.findElement(chkbox_inflation_increase).click();
		driver.findElement(txt_desired_income).sendKeys(desired_income);
		driver.findElement(txt_desired_income).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(txt_final_annual_amount).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(txt_final_annual_amount).sendKeys(desired_income);
		driver.findElement(txt_pre_retirement_prec).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(txt_pre_retirement_prec).sendKeys(pre_retirement_prec);
		driver.findElement(txt_post_retirement_prec).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(txt_post_retirement_prec).sendKeys(post_retirement_prec);
		driver.findElement(btn_save_changes).click();

	}

	
	
	public void RetirementCalcValues() throws InterruptedException {
		driver.findElement(btn_calculate).click();
		
	}
	
	@SuppressWarnings("deprecation")
	public void PreRetirementValues() throws InterruptedException {
		Thread.sleep(500);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "How Much to Save for Retirement | Securian Financial";
		Assert.assertEquals(ExpectedTitle, ActualTitle);	
	    driver.close();
	}

public void Editinfo() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(btn_editInfo).click();
		Thread.sleep(1000);
}

public void Defaultvalues(String other_income, String no_of_year_retirement_needed ) throws InterruptedException {
	
	Thread.sleep(1000);
	driver.findElement(link_Adjust_default_values).click();
	Thread.sleep(500);
	driver.findElement(txt_other_income).sendKeys(Keys.ARROW_RIGHT);
	driver.findElement(txt_other_income).sendKeys(other_income);
	driver.findElement(txt_no_of_year_retirement_needed).sendKeys(no_of_year_retirement_needed);
	driver.findElement(btn_save_changes).click();

}


} 
