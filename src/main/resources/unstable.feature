Feature: Unstable
  As a user
  I want to test main site functionality
  So that I can be sure site works correctly

  Scenario Outline: Check that price sorting from high to low works correctly
    Given User open '<homePage>' page
    And User clicks 'Women' clothes button
    When User clicks 'New in' button
    And User clicks 'Face + Body' button
    And User clicks sort drop-down list
    And User clicks 'Price high to low' option
    Then User checks that prices is in descending order

    Examples:
    | homePage             |
    | https://www.asos.com |

  Scenario Outline: Check that error notification appears after entering invalid e-mail while signing in
    Given User open '<homePage>' page
    And User checks 'My Account' button visibility
    When User clicks 'My Account' button
    And User checks 'Sing in' button visibility
    And User clicks 'Sing in' button
    And User enters email '<email>'
    And User clicks button to sign into account
    Then User should have error message

    Examples:
    | homePage             | email   |
    | https://www.asos.com |fdgvbgba |

  Scenario Outline: Check registration form
    Given User open '<homePage>' page
    And User checks 'My Account' button visibility
    When User clicks 'My Account' button
    And User checks 'Join' button visibility
    And User clicks 'Join' button
    And User enters email '<email>' in register form
    And User enters password '<password>' in register form
    And User enters first name '<firstName>' in register form
    And User enters last name '<lastName>' in register form
    And User selects day of birth
    And User selects month of birth
    And User selects year of birth
    Then User checks 'Join Asos' button is enabled

    Examples:
      | homePage             | email   | password    | firstName | lastName |
      | https://www.asos.com |fdgvbgba | dkg95nckt9v | Zoe       | Miller   |