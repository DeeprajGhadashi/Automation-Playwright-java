package PlaywrightJavaSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDomElement {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//1)Page -- DOM --> Shadow DOM --> elements
		//2)Pge -- DOM --> iframe --> Shadow DOM --> elements

		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		
		// Page -- DOM --> Shadow DOM --> elements
		page.navigate("https://books-pwakit.appspot.com/");
		page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
		String text = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
		System.out.println(text);
		
		//2)Pge -- DOM --> iframe --> Shadow DOM --> elements
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		page.frameLocator("#pact1").locator("div.elementor-widget-container #glaf").fill("India");
		
		
	}

}
