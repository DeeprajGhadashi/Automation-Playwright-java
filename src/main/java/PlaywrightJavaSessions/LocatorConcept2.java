package PlaywrightJavaSessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept2 {

	public static void main(String[] args) {
		
		
				Playwright playwright = Playwright.create();
				Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
				
				
				BrowserContext browserContext = browser.newContext();
				Page page = browserContext.newPage();
				page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
				
				//multiple elements: like drop down 
				Locator countryOptions = page.locator("select#Form_getForm_Country option");
				System.out.println(countryOptions.count());
				
				//approach1 to print list
				/*
				for(int i=0 ; i< countryOptions.count(); i++) {
					String text = countryOptions.nth(i).textContent();
					System.out.println(text);
				}
				*/
				
				//approach2 to print list
				/*List <String> optionsTextList = countryOptions.allTextContents();
				for ( String e : optionsTextList) {
					System.out.println(e);
				}
				*/
				
				//approach3 to print list
				List <String> optionsTextList = countryOptions.allTextContents();
				optionsTextList.forEach(ele -> System.out.println(ele));
	}

}
