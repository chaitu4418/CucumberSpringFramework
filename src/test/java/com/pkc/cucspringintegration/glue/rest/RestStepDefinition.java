package com.pkc.cucspringintegration.glue.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This class represents the Step definitions for the Country search feature.
 * 
 * @author Pius Kurian
 *
 */

public class RestStepDefinition {
	
	private static final String HTTP_SERVICES_GROUPKT_COM_COUNTRY_GET_ALL = "http://services.groupkt.com/country/get/all";
	/**
	 * Rest template is initialised from the Spring applicationContext file
	 * 
	 * Usage: mvn test -Dspring.profiles.active=rest. Here it initializes
	 * rest template.
	 * 
	 */
	@Autowired
	private RestTemplate restTemplate;


	Logger logger = LoggerFactory.getLogger(RestStepDefinition.class);
	HttpHeaders headers;
	HttpEntity<String> entity;
	/**
	 * Before hook for the feature.
	 */
	@Before
	public void open() {

		logger.info("entered the @Before segment ...");
		headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    entity = new HttpEntity<String>(headers);
	}

	/**
	 * After hook or the feature
	 */

	@After
	public void close() {
		
		// for this user story not much needs to be done at this point
		logger.info("entered the @After segment, may add additional clean up operation be done here ...");
		restTemplate = null;
	}
	
	/**
	 * This method checks if the alpha2_code for the country is available
	 * 
	 * @param isoCode
	 * @throws Throwable
	 */
	@Given("^I have the \"([^\"]*)\" for the country$")
	public void checkForISOAlpha2Code(String isoCode) throws Throwable {

	    String alpha2Code = "\"alpha2_code\" : " + "\"" + isoCode + "\"";
	    ResponseEntity<String> response = 
	    	      restTemplate.exchange(HTTP_SERVICES_GROUPKT_COM_COUNTRY_GET_ALL, HttpMethod.GET, entity, String.class);
	    assertTrue(response.getBody().contains(alpha2Code));
	}
	/**
	 * This method retrieves the details for the country
	 * 
	 * @param url
	 * @throws Throwable
	 */
		
	@When("^I send a get request to \"([^\"]*)\"$")
	public void checkForCountryDetailsWithAlpha2Code(String url) throws Throwable {
	    ResponseEntity<String> response = 
	    	      restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	    assertThat(response.getStatusCode().value(), equalTo(200));
	    assertTrue(response.getBody()!= null);
	}
	/**
	 * Verify the retrieved details are correct
	 * 
	 * @param countryName
	 * @throws Throwable
	 */

	@Then("^Verify retrieved message with \"([^\"]*)\" contains my \"([^\"]*)\"$")
	public void verifyTheDetailsOfRetrievedCountry(String url, String countryName) throws Throwable {
	    ResponseEntity<String> response = 
	    	      restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	    assertThat(response.getStatusCode().value(), equalTo(200));
	    assertTrue(response.getBody().contains(countryName));
	}
	



}