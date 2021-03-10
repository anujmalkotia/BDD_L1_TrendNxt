@tag
Feature: TC01

  @tag1
  Scenario Outline: Open Cart TC01
    Given Launch site
    When Register "<Fname>" "<Lname>" "<email>" "<tele>" "<pswd>"
    And Enquiry "<enquiry>"
    And Samsung Tab "<review>" "<rating>"
    And Currency
    And Wish List
    Then Logout

    Examples: 
      | Fname | Lname    | email                             | tele       | pswd       | enquiry                     | review       | rating |
      | Rohan | tripathi | shub69696969@gmail.com | 9999123221 | helloworld | Cannot access some products | Nice Product |      3 |
