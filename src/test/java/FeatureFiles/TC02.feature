@tag
Feature: TC02

  @tag1
  Scenario Outline: OpenCart  TC02
    Given Launching site1
    When Login "<email>" "<pswd>"
    And Search "<search>"
    And Product Compare
    And Checkout
    Then Logout1

    Examples: 
      | email                   | pswd       | search   |
      | ericleshner03@gmail.com | eric123456 | monitors |
