package PlaywrightJavaSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FillFormUsingRelativeLocators {

	static Page  page;
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		page = browserContext.newPage();  // Initialize the static page variable
		page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		page.locator("input:below(lable:text('FullName'))").first().fill("Deepraj Ghadashi");
		page.locator("input:below(lable:text('Email'))").first().fill("Deepraj@gmail.com");
		page.locator("input:below(lable:text('Phone Number'))").first().fill("9876543210");
		
		

	}

}
