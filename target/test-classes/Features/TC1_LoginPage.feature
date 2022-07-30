@Login
Feature: Validating Adactin Login Page
  
  Scenario Outline: Validating adactin login page with valid credentials
    Given User is on the adactin login page
    When User should login using "<userName>" and "<passWord>"
    Then After login User should verify successful login message "Hello viicckkiiee!"

    Examples: 
      | userName    | passWord |
      | viicckkiiee | EQ5857   |

  Scenario Outline: Validating adactin login page with valid credentials using Enter Key
    Given User is on the adactin login page
    When User should login using "<userName>" and "<passWord>" with the help of Enter key
    Then After login User should verify successful login message "Hello viicckkiiee!"

    Examples: 
      | userName    | passWord |
      | viicckkiiee | EQ5857   |

  Scenario Outline: Validating adactin login page with invalid credentials
    Given User is on the adactin login page
    When User should login using "<invUserName>" and "<invPassword>"
    Then After login User should verify  login error message contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | invUserName  | invPassword |
      | viicckkiieee | GYM631      |
