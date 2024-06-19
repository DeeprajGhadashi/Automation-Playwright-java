package PlaywrightJavaSessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElements {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		

		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.amazon.com");
		
		//button:visible 
		//button >> visible=true
		
		List <String> linksText = page.locator("a:visible").allInnerTexts();
		
		for(int i=0; i<linksText.size(); i++) {
			System.out.println(linksText.get(i));
		}
		
		int imagesCount = page.locator("xpath=//img >> visible=true").count();
		System.out.println(imagesCount);
		
	}

}
