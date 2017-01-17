package com.pkc.cucspringintegration.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * This is the abstract base class for all POM classes and it 
 * uses the PageFactory for initializing the elements in the page
 * All POM in this project will extend this class.
 * 
 * @author Pius Kurian
 * @version 1.0
 *
 */

public abstract class AbstractBasePage {
	
	protected WebDriver driver;
	
	public AbstractBasePage (WebDriver webDriver) {
		this.driver = webDriver;
		// After 100 second if the element is not visible to perform an operation
		// timeout exception will appear. This is a lazy loading operation and 
		// will start only if we perform an operation on the control.
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory (driver, 100);
		// This initElements method will create all WebElements
		PageFactory.initElements(factory, this);
	}

}
