#Author Manimaran Ravichandran

Feature: Pre-retirement calculator, user figure out how much savings he or she needs to make in light of their retirement plans and ambitions

  @CalcWithSocialSecurity
  Scenario Outline: Verify the pre-retirement calculator functionality with Soical Security benefit
    Given user is on the pre-retirement calculator page
    When user enter <current_age> , <retirement_age> , <current_annual_income>
    And user supply the <spouse_annual_income>, <current_retirement_savings>, <current_retirement_contribution>, <annual_retirement_contribution_increase>
    And user set the social security income to yes and input values to relationship status and <security_overrider>
    And user click on the Adjust default values and enters <other_income>, <no_of_year_retirement_needed>
    And user set the inflation_rate to yes and provided <inflation_rate>, <desired_income>, <pre_retirement_prec>, <post_retirement_prec>
    When user click on the calculate button is clicked
    Then based on the users input results should be displayed

    Examples: 
      | current_age | retirement_age | current_annual_income | spouse_annual_income | current_retirement_savings | current_retirement_contribution | annual_retirement_contribution_increase | security_overrider | other_income | no_of_year_retirement_needed | final_annual_amount | desired_income | pre_retirement_prec | post_retirement_prec |
      |          35 |             60 |                 50000 |                75000 |                     558000 |                              20 |                                       7 |             655000 |        35000 |                        25000 |                   2 |             20 |                   5 |                   10 |

  @CalcWithoutSocialSecurity
  Scenario Outline: Verify the pre-retirement calculator functionality without Soical Security benefit
    Given user is on the pre-retirement calculator page
    When user enter <current_age> , <retirement_age> , <current_annual_income>
    And user supply the <spouse_annual_income>, <current_retirement_savings>, <current_retirement_contribution>, <annual_retirement_contribution_increase>
    And user set the social security income to yes and input values to relationship status and <security_overrider>
    And user click on the Adjust default values and enters <other_income>, <no_of_year_retirement_needed>
    And user set the inflation_rate to yes and provided <inflation_rate>, <desired_income>, <pre_retirement_prec>, <post_retirement_prec>
    When user click on the calculate button is clicked
    Then based on the users input results should be displayed

    Examples: 
      | current_age | retirement_age | current_annual_income | spouse_annual_income | current_retirement_savings | current_retirement_contribution | annual_retirement_contribution_increase | other_income | no_of_year_retirement_needed | final_annual_amount | desired_income | pre_retirement_prec | post_retirement_prec |
      |          28 |             58 |                 98000 |                37500 |                     695000 |                              15 |                                       8 |        45600 |                        25000 |                   3 |             17 |                   6 |                   20 |

  @UpdateDefaultCalc
  Scenario Outline: Verify the successfull updation of calcualted values
    Given user is on the pre-retirement calculator page
    When user enter <current_age> , <retirement_age> , <current_annual_income>
    And user supply the <spouse_annual_income>, <current_retirement_savings>, <current_retirement_contribution>, <annual_retirement_contribution_increase>
    When user click on the calculate button is clicked
    Then user should be should be able to edit the calculated values
    When click on the Adjust default values and enters <other_income>, <no_of_year_retirement_needed>
    Then user should see the recalculated values successfully

    Examples: 
      | current_age | retirement_age | current_annual_income | spouse_annual_income | current_retirement_savings | current_retirement_contribution | annual_retirement_contribution_increase | other_income | no_of_year_retirement_needed |
      |          45 |             50 |                 60000 |                85000 |                     550000 |                              20 |                                       7 |        35000 |                        25000 |
