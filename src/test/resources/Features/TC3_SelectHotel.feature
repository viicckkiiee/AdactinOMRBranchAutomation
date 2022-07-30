@Select
Feature: Validating Adactin SelectHotel Page

  Scenario Outline: Validating adactin select hotel page
    Given User is on the adactin login page
    When User should login using "<userName>" and "<passWord>"
    Then After login User should verify successful login message "Hello viicckkiiee!"
    And User should search hotel using "<location>" , "<hotel>" , "<roomType>" , "<noOfRoom>" , "<dateIn>" , "<dateOut>" , "<adultCount>" and "<childCount>"
    Then After searching hotel User should verify "Select Hotel" message
    And User should select a hotel and click continue
    Then After selecting a hotel successfully User should verify "Book A Hotel" message

    Examples: 
      | userName    | passWord | location | hotel       | roomType | noOfRoom | adultCount | childCount | dateIn     | dateOut    |
      | viicckkiiee | EQ5857   | Sydney   | Hotel Creek | Standard | 2 - Two  | 2 - Two    | 0 - None   | 22-06-2022 | 22-06-2022 |

  Scenario Outline: Validating adactin select hotel page without selecting a hotel
    Given User is on the adactin login page
    When User should login using "<userName>" and "<passWord>"
    Then After login User should verify successful login message "Hello viicckkiiee!"
    And User should search hotel using "<location>" , "<hotel>" , "<roomType>" , "<noOfRoom>" , "<dateIn>" , "<dateOut>" , "<adultCount>" and "<childCount>"
    Then After searching hotel User should verify "Select Hotel" message
    And User should click continue without selecting a hotel
    Then After clicking continue User should verify error message "Please Select a Hotel"

    Examples: 
      | userName    | passWord | location | hotel       | roomType | noOfRoom | adultCount | childCount | dateIn     | dateOut    |
      | viicckkiiee | EQ5857   | Sydney   | Hotel Creek | Standard | 2 - Two  | 2 - Two    | 0 - None   | 22-06-2022 | 22-06-2022 |
