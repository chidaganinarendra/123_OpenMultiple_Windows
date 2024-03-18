package StepDefinictions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.google.common.io.Files;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenMultipleWindows {

	WebDriver driver;
	WebElement openTabs;

	@Given("User is on Navigation to home page")
	public void user_is_on_navigation_to_home_page() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.amazon.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);

	}

	@When("User Gives to Scrolldown")
	public void user_goto_the_multiple_link() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,1000)");

	}

	@And("User Goto the MultipleLink")
	public void user_gives_to_scrolldown() throws InterruptedException {


		WebElement openTabs = driver.findElement(By.xpath("//*[@id='navFooter']/div[1]/div/div[3]"));
		openTabs.findElements(By.tagName("a")).size();
		System.out.println("Total numbers of links are "+ openTabs.findElements(By.tagName("a")).size());
		
		
		for(int i=0;i<openTabs.findElements(By.tagName("a")).size(); i++ ) {
			
			
			
			String openTabsAgain = Keys.chord(Keys.CONTROL,Keys.ENTER);
			openTabs.findElements(By.tagName("a")).get(i).sendKeys(openTabsAgain);


			Thread.sleep(3000);
		}

	}

	@Then("User Click to the ABOUT")
	public void user_click_to_the_about() throws InterruptedException, IOException {
		
       File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Files.copy(src, new File("C:\\Users\\Admin\\OneDrive\\Desktop\\Screen Shot\\GoogleScreenShot.jpg"));

		Thread.sleep(3000);

	}

	@And("Close The Browser")
	public void close_the_browser() {

		// driver.close();
	}
}
