package PlaywrightJavaSessions;
import java.nio.file.Paths;

//opening locally : mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"
//opening on Browser : trace.zip -> upload file trace.zip
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class TracerInspection {
	public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      
	      //Start tracing before creating / navigating a page.
	      context.tracing().start(new Tracing.StartOptions()
	        .setScreenshots(true)
	        .setSnapshots(true)
	        .setSources(true));
	      
	      Page page = context.newPage();
	      page.navigate("https://www.demoblaze.com/index.html");
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in")).click();
	      page.locator("#loginusername").click();
	      page.locator("#loginusername").fill("pavanol");
	      page.locator("#loginpassword").click();
	      page.locator("#loginpassword").fill("test@123");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Samsung galaxy s6")).click();
	      page.onceDialog(dialog -> {
	        System.out.println(String.format("Dialog message: %s", dialog.message()));
	        dialog.dismiss();
	      });
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart").setExact(true)).click();
	      
	   // Stop tracing and export it into a zip archive.
	      context.tracing().stop(new Tracing.StopOptions()
	        .setPath(Paths.get("trace.zip")));
	      
	      browser.close();
	      playwright.close();
	      
	   
	    }
	  }
}
