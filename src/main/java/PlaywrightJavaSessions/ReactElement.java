package PlaywrightJavaSessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ReactElement {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();  // Initialize the static page variable
		page.navigate("https://www.netflix.com/in/");
		
		Locator email = page.locator("_react=[name='email'] >> input").first();
		email.click();
		email.fill("Deepraj@gmail.com");
		
		//page.locator("_react= UISelect[data-uia='language-piker']").click();
		
//		Locator footer = page.locator("_react= UIMarkup[data-uid='nmhp-card-footer']");
//		//footer.allInnerTexts();
//		List <String> footerList = footer.allInnerTexts();
//		for(String e : footerList) {
//			System.out.println(e);
//		}
//	
//		footer.allInnerTexts().stream().forEach(e-> System.out.println(e));
		
	}

}
