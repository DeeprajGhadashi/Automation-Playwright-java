package PlaywrightJavaSessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathLocator {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();  // Initialize the static page variable
		page.navigate("https://www.amazon.in");
		
		//page.locator("//input[@id='twotabsearchtextbox']").fill("Macbook pro");
		
		Locator totalAmazonLinks = page.locator("//a[contains(text(),'Amazon')]");
		System.out.println(totalAmazonLinks.count());
		
		List <String> textList = totalAmazonLinks.allInnerTexts();
		for(String e : textList) {
			System.out.println(e);
		}
		

	}

}
