package PlaywrightJavaSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSelectors {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		

		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://academy.naveenautomationlabs.com");
		
		//comma seprated css Selector List
//		page.locator("a:has-text('SignIn'),"
//				   + "a:has-text('LogIn'),"
//				   + "a:has-text('Signin'),"
//				   + "a:has-text('Login')").click();
//		
		
		Locator imp_ele = page.locator("a:has-text('Courses'),"
				                     + "a:has-text('Demo Site'),"
				                     + "a:has-text('WebDriver APIs'),"
				                     + "a:has-text('Webinars'),"
				                     + "a:has-text('Login'),");
				
		System.out.println(imp_ele.count());
		
		if(imp_ele.count() == 5) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}

	}

}
