@Booking
Feature: Validating Adactin Book Hotel Page

  Scenario Outline: Validating adactin book hotel page with valid credentials
    Given User is on the adactin login page
    When User should login using "<userName>" and "<passWord>"
    Then After login User should verify successful login message "Hello viicckkiiee!"
    And User should search hotel using "<location>" , "<hotel>" , "<roomType>" , "<noOfRoom>" , "<dateIn>" , "<dateOut>" , "<adultCount>" and "<childCount>"
    Then After searching hotel User should verify "Select Hotel" message
    And User should select a hotel and click continue
    Then After selecting a hotel successfully User should verify "Book A Hotel" message
    And User should book the hotel with all mandatory credentials like "<firstName>","<lastName>","<address>" and save the order id
      | CreditCard Type  | CreditCard No    | Exp Month | Exp Year | CVV |
      | American Express | 5432167899876234 | June      |     2022 | 324 |
      | VISA             | 4432143899876243 | July      |     2022 | 234 |
      | Master Card      | 6432167899876278 | August    |     2022 | 456 |
    Then After booking hotel successfully User should verify "Booking Confirmation" message

    Examples: 
      | userName    | passWord | location | hotel       | roomType | noOfRoom | adultCount | childCount | dateIn     | dateOut    | firstName | lastName | address |
      | viicckkiiee | EQ5857   | Sydney   | Hotel Creek | Standard | 2 - Two  | 2 - Two    | 0 - None   | 22/06/2022 | 22/06/2022 | Rahim     | Sterling | England |

  Scenario Outline: Validating adactin book hotel page without entering any credentials
    Given User is on the adactin login page
    When User should login using "<userName>" and "<passWord>"
    Then After login User should verify successful login message "Hello viicckkiiee!"
    And User should search hotel using "<location>" , "<hotel>" , "<roomType>" , "<noOfRoom>" , "<dateIn>" , "<dateOut>" , "<adultCount>" and "<childCount>"
    Then After searching hotel User should verify "Select Hotel" message
    And User should select a hotel and click continue
    Then After selecting a hotel successfully User should verify "Book A Hotel" message
    And User should book the hotel without entering any credentials
    Then After booking hotel User should verify error messages "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName    | passWord | location | hotel       | roomType | noOfRoom | adultCount | childCount | dateIn     | dateOut    |
      | viicckkiiee | EQ5857   | Sydney   | Hotel Creek | Standard | 2 - Two  | 2 - Two    | 0 - None   | 22/06/2022 | 22/06/2022 |
