package PlaywrightJavaSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcept {

	public static void main(String[] args) {
	
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext brcx1= browser.newContext();
		Page p1 = brcx1.newPage();
		p1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
		p1.fill("#Form_getForm_Name","Deepraj ghadashi");
		System.out.println(p1.title());
		
		BrowserContext brcx2= browser.newContext();
		Page p2 = brcx1.newPage();
		p2.navigate("https://www.amazon.in/");
		p2.fill("#twotabsearchtextbox","Tshirts");
		System.out.println(p2.title());
		
		 BrowserContext brcx3= browser.newContext();
		 Page p3 = brcx1.newPage();
		 p3.navigate("https://www.google.com/");
		 System.out.println(p3.title());
		
		 p1.close();
		 brcx1.close();
		 
		 p2.close();
		 brcx2.close();
		 
		 p3.close();
		 brcx3.close();
		

	}

}
