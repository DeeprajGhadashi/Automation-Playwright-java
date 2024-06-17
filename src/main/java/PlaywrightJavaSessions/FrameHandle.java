package PlaywrightJavaSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://londonfreelance.org/courses/frames/index.html");
		
		//approach1
		String header = page.frameLocator("frame[name='main']").locator("h2").textContent();
		System.out.println(header);
		
		//approach2
		String h2 = page.frame("main").locator("h2").textContent();
		System.out.println(h2);
		
	}

}
