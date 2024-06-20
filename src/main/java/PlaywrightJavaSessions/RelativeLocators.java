package PlaywrightJavaSessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
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
		
		String aboveUser = page.locator("a:above(:text('Joe.Root'))").first().textContent();
		System.out.println(aboveUser);
		
		String belowUser = page.locator("a:below(:text('Joe.Root'))").first().textContent();
		System.out.println(belowUser);
		
		Locator nearElements = page.locator("td:near(:text('Joe.Root'),400)");
		List <String> nearEleText = nearElements.allInnerTexts();
		for(String e : nearEleText) {
			System.out.println(e);
		}
		
	}
	
	public static void selectUser(String userName) {
		page.locator("input[type='checkbox']:left-of(:text('" + userName + "'))").first().click();
	}
	
	public static String getUserRole(String userName) {
		return page.locator("td:right-of(:text('" + userName + "'))").first().textContent();
	}
}
