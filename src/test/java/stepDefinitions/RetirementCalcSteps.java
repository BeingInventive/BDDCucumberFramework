package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RetirementCalcPage;


public class RetirementCalcSteps {

	WebDriver driver = null;
	RetirementCalcPage Obj = new RetirementCalcPage(driver);

	@Given("^user is on the pre-retirement calculator page$")
	public void user_is_on_the_pre_retirement_calculator_page() throws InterruptedException {
		 Obj.openBrowser();
	}
     @When("^user enter (.*) , (.*) , (.*)$")
	public void user_enter(String current_age, String retirement_age, String current_annual_income) throws InterruptedException {
		Obj.age(current_age, retirement_age, current_annual_income);
	}
	@And("^user supply the (.*), (.*), (.*), (.*)$")
	public void user_supply_the(String spouse_annual_income, String current_retirement_savings, String current_retirement_contribution, String annual_retirement_contribution_increase) throws InterruptedException {
		Obj.income(spouse_annual_income, current_retirement_savings, current_retirement_contribution, annual_retirement_contribution_increase);
	}
	
	@And("^user set the social security income to yes and input values to relationship status and (.*)$")
	public void user_set_the_social_security_income_to_yes_and_input_values_to_relationship_status_and_security_overrider(String security_overrider) throws InterruptedException {
	   Obj.SocialSecurityincome(security_overrider);
	}
	
	@And("^user click on the Adjust default values and enters (.*), (.*)$")
	public void user_click_on_the_Adjust_default_values_and_enters_other_income_no_of_year_retirement_needed(String other_income, String no_of_year_retirement_needed) throws InterruptedException {
		Obj.Adjustdefaultvalues(other_income, no_of_year_retirement_needed);
	}
	
	@And("^user set the inflation_rate to yes and provided (.*), (.*), (.*), (.*)$")
	public void user_set_the_inflation_rate_to_yes_and_provided_inflation_rate(String final_annual_amount, String desired_income, String pre_retirement_prec, String post_retirement_prec ) throws InterruptedException {
		Obj.InvestExp(final_annual_amount, desired_income, pre_retirement_prec, post_retirement_prec);
	}
	@When("^user click on the calculate button is clicked$")
	public void user_click_on_the_calculate_button_is_clicked() throws InterruptedException {
	    Obj.RetirementCalcValues();
	    Thread.sleep(1000);
	}

	@Then("^based on the users input results should be displayed$")
	public void based_on_the_users_input_results_should_be_displayed() throws InterruptedException {
	   Obj.PreRetirementValues(); 
	}

	/* Recently added steps */
	@Then("user should be should be able to edit the calculated values")
	public void user_should_be_should_be_able_to_edit_the_calculated_values() throws InterruptedException {
	   Obj.Editinfo();
	}

	@Then("user should see the recalculated values successfully")
	public void user_should_see_the_recalculated_values_successfully() throws InterruptedException {
		Obj.RetirementCalcValues();

		}	
		
	@And("^click on the Adjust default values and enters (.*), (.*)$")
	public void click_on_the_Adjust_default_values_and_enters(String other_income, String no_of_year_retirement_needed) throws InterruptedException {
	Obj.Defaultvalues(other_income, no_of_year_retirement_needed);
	}
}
	