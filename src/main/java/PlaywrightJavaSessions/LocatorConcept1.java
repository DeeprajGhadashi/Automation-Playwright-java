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
		
	    // Single element
     	Locator loginBtn = page.locator("text = Login");
     	loginBtn.hover();
     	loginBtn.click();
     	
     	
     	
	}

}
