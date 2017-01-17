#Author: piuskurianau@gmail.com
#Keywords Summary : Login
# This feature file documents the search functionality for the country details with ISO Code
# website
Feature: Login feature for nopcommerce
  As a user I want to the system for the country details when I provide ISOCode for the country

  @Rest
  Scenario Outline: Search the web service with ISOCode
    Given I have the "<ISOCode>" for the country
    When I send a get request to "<url>"
    Then Verify retrieved message with "<url>" contains my "<Country>"

    Examples: 
      | url                                                 | ISOCode | Country   |
      | http://services.groupkt.com/country/get/iso2code/AU | AU      | Australia |
      | http://services.groupkt.com/country/get/iso2code/IN | IN      | India     |
