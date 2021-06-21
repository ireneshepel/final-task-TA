Feature: Smoke
  As a user
  I want to test main site functionality
  So that I can be sure site works correctly

  Scenario Outline: Check signing into account
    Given User open '<homePage>' page
    And User checks 'My Account' button visibility
    When User clicks 'My Account' button
    And User checks 'Sing in' button visibility
    And User clicks 'Sing in' button
    And User enters email '<email>'
    And User enters password '<password>'
    Then User checks button to sign into account visibility

    Examples:
      | homePage             | email          | password        |
      | https://www.asos.com | dggf@gmail.com | NLrdB3u2T,-AJg? |

  Scenario Outline: Check add product to bag
    Given User open '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User clicks on size drop-down list
    And User clicks on first available size
    And User clicks on 'Add to Bag' button
    And User checks 'My bag' pop-up visibility
    And User clicks on 'My bag' pop-up close button
    Then User checks that amount of products in bag are '<amountOfProducts>'

    Examples:
      | homePage             | keyword | amountOfProducts |
      | https://www.asos.com | jeans   | Bag 1 item       |

  Scenario Outline: Check add product to wishlist
    Given User open '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks wish list on first product
    And User clicks wish list button
    Then User checks that amount of products in wish list are '<amountOfProducts>'

    Examples:
      | homePage             | keyword | amountOfProducts |
      | https://www.asos.com | dress   | 1 item           |




  Scenario Outline: Check currency change
    Given User open '<homePage>' page
    When User clicks 'Country select' button
    And User clicks currency drop-down list
    And User clicks 'USD' currency option
    And User clicks 'Update Preferences' button
    Then User clicks 'Country select' button
    And User checks that correct currency is selected

    Examples:
      | homePage             |
      | https://www.asos.com |



  Scenario Outline: Check that if the request is invalid, 'Nothing matches your search' message appears on the site
    Given User open '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User should have 'Nothing matches your search' message appears on the site

    Examples:
      | homePage             | keyword |
      | https://www.asos.com | sdfhngvoifhf|


  Scenario Outline: Check delete product from bag
    Given User open '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User clicks on size drop-down list
    And User clicks on first available size
    And User clicks on 'Add to Bag' button
    And User checks 'My bag' pop-up visibility
    And User deletes product from bag
    Then User clicks on bag button on 'My bag' pop-up
    And User checks that bag empty

    Examples:
      | homePage             | keyword    |
      | https://www.asos.com | nike shoes |

  Scenario Outline: Check main parts of site
    Given User open '<homePage>' page
    When User clicks 'Women' clothes button
    Then User checks header visibility
    And User checks footer visibility
    And User checks search field visibility
    And User checks 'My Account' button visibility

    Examples:
      | homePage             |
      | https://www.asos.com |





