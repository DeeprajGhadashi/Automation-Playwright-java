package PlaywrightJavaSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept1 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		
	    // Single element locator
     	/*Locator loginBtn = page.locator("text = Login");
     	loginBtn.hover();
     	loginBtn.click();
     	*/
		
     	// multiple locator as same text then 
     	Locator loginBtn = page.locator("text = Login");
     	int totalLogins = loginBtn.count();
     	System.out.println(totalLogins);
     	loginBtn.first().click();
     	//loginBtn.last().click()
     	
	}

}
