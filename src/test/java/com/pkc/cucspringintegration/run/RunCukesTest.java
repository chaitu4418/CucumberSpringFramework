package com.pkc.cucspringintegration.run;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Class that just does the plumbing to run Cucumber tests with the Maven test
 * goal
 * 
 * It can be run from the command line passing the cucumber options from command
 * line using the following command: mvn test -Dspring.profiles.active=rest
 * -Dcucumber.options="src/test/resources/features --tags @Rest --glue
 * com.pkc.cucumber.glue.rest --plugin
 * html:C:\Users\Pius\Documents\TestAutomation\cuke-spring-framework\cuke-spring
 * -session-blog-master\target\cucumber"
 */
@RunWith(Cucumber.class)

// this may be used for testing the code otherwise use the attached batch file
// or use the command given below from command line
//
//@CucumberOptions(plugin = { "pretty",
//		"html:target/cucumber" }, features = "src/test/resources/features", tags = "@Login", glue = "com.pkc.cucspringintegration.glue.web")

public class RunCukesTest {
}
