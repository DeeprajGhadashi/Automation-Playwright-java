package PlaywrightJavaSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HasElements {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		

		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		
		page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
		Locator loc = page.locator("select#Form_getForm_Country:has(option[value='India'])");
		loc.allInnerTexts().forEach(e -> System.out.println(e));
		
	
		
		
		
		
	}

}
