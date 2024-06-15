package PlaywrightJavaSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
//Recording open Playwright Inspector-> run on CDM -> mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="https://academy.naveenautomationlabs.com/"
//Debugging open Playwright Inspector->1) right click o code ->Run As -> Run Configurations -> Environment -> Add -> Name: PWDEBUG & Value:1   -> Apply -> Run 
//                                  OR 2) page.pause()     in between code type
//Recording a test using running codegen and Debugging
public class Example {
	public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://academy.naveenautomationlabs.com/");
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
	      page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
	      page.pause();
	      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
	      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("Deepraj Santosh Ghadashi");
	      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
	    
	      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("deep@gmail.com");
	      page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").click();
	      page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("Deep@12");
	      page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").click();
	      page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").fill("+91 77743-958311");
	      page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn path").click();
	    }
	  }
}
