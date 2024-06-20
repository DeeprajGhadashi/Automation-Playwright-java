package PlaywrightJavaSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocators {

	static Page page;
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		page = browserContext.newPage();  // Initialize the static page variable
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
		//page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();
		
		selectUser("Joe.Root");
		selectUser("Garry.white");
		selectUser("Jordan.Mathews");
		
		System.out.println(getUserRole("Joe.Root"));
		
		//String userRole = page.locator("td:right-of(:text('Joe.Root'))").first().textContent();
		//System.out.println(userRole);
	}
	
	public static void selectUser(String userName) {
		page.locator("input[type='checkbox']:left-of(:text('" + userName + "'))").first().click();
	}
	
	public static String getUserRole(String userName) {
		return page.locator("td:right-of(:text('" + userName + "'))").first().textContent();
	}
}
