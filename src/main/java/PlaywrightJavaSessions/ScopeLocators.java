package PlaywrightJavaSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScopeLocators {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		

		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		 // Navigate to the page
        page.navigate("https://datatables.net/extensions/select/examples/checkbox/order.html");

        // Locate the row containing "Ashton Cox" and click the checkbox
        Locator row = page.locator("table#example tr").filter(new Locator.FilterOptions().setHasText("Ashton Cox"));
        row.locator(".dt-select-checkbox").click();
        
      

	}

}
