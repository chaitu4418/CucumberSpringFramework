#Author: piuskurianau@gmail.com
#Keywords Summary : Login
# This feature file documents the login functionality for the nopcommerce
# website
Feature: Login feature for nopcommerce
  As a user I want to login to the system when I provide username and password

  @Login
  Scenario Outline: Login failure with unregistered user.
    Given I launch "http://demo.nopcommerce.com/login" page
    And I am not a registered user with <email>
    When I login with unregistered <email> and <password>
    Then Verify my login <status>

    Examples: 
      | email          | password | status  |
      | abc@def.com    | asdf123  | failure |
      | abc@dfgrjj.com | fghdk123 | failure |
