package PlaywrightJavaSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept {

	public static void main(String[] args) {
 
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		 //locators - text
		 // single element
	    Locator contactSalesbtn =	page.locator("text = Contact Sales");
	    int totalcontactSales = contactSalesbtn.count();
	    System.out.println(totalcontactSales);
	   
	    // choose the second option and click
        if (totalcontactSales > 1) {
            contactSalesbtn.nth(1).click();
        } else {
            System.out.println("Less than 2 'Contact Sales' buttons found.");
        }
	      	

	}

}
