import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

	WebDriver driver = new ChromeDriver();
	String WebSiteName = "https://www.saucedemo.com/";
	String UserName = "standard_user";
	String Password = "secret_sauce";
	Random rand=new Random();
//this is the first project
	@BeforeTest
	public void setup() {

		driver.get(WebSiteName);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void LogInTest() {

		WebElement UserNameInput = driver.findElement(By.id("user-name"));
		UserNameInput.sendKeys(UserName);
		WebElement PasswordInput = driver.findElement(By.id("password"));
		PasswordInput.sendKeys(Password);
		WebElement LogInInput = driver.findElement(By.id("login-button"));
		LogInInput.click();
	}

	@Test(priority = 2, enabled = false)
	public void AddALllItemThenRemoveALll() throws InterruptedException {

		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i).click();

		}
		Thread.sleep(3000);
		List<WebElement> RemoveAllItems = driver.findElements(By.className("btn_secondary"));
		for (int i = 0; i < RemoveAllItems.size(); i++) {
			RemoveAllItems.get(i).click();
		}
	}

	@Test(priority = 2, enabled = false)
	public void AddCErtinItems() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i).click();
			if (i == 3) {
				break;
			}
		}
	}

	@Test(priority = 2,enabled=false)
	public void SkipSomeItems() {

		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			if (i == 2 || i == 3) {
				continue;
			}

			AddToCartButtons.get(i).click();
		}
	}
	
	@Test(priority=2,enabled=false)
	public void AddItemswhichstartedwithSouce() {
		List<WebElement> ItemNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> AddToCartButton=driver.findElements(By.className("btn"));
		for(int i =0;i<ItemNames.size();i++) {
			if(ItemNames.get(i).getText().startsWith("Sauce")) {
				continue;
			}
			AddToCartButton.get(i).click();
		}
		
	}
	@Test(priority=2)
	public void AddRandomItem() {
		List<WebElement> AddToCartButton=driver.findElements(By.className("btn"));
		int RAndomIndex=rand.nextInt(AddToCartButton.size());
		System.out.println(RAndomIndex);
		AddToCartButton.get(RAndomIndex).click();
	}
	
	@Test(priority=3)
	public void CheckOutTest() {
		WebElement CArtButton=driver.findElement(By.className("shopping_cart_link"));
		CArtButton.click();
		WebElement CheckOutButton=driver.findElement(By.id("checkout"));
		CheckOutButton.click();
		
		WebElement FirstNameInput=driver.findElement(By.id("first-name"));
		WebElement LastNameInput=driver.findElement(By.id("last-name"));
		WebElement PostalCodeInput=driver.findElement(By.id("postal-code"));
		String [] Firstnames= {"Ahmad","Omar","Sara"};
		String[] LastNames= {"Reda","amjad","esraa"};
		String[] PostalCode= {"962","971","251"};
		int randomFirstName=rand.nextInt(Firstnames.length);
		int randomLastname=rand.nextInt(LastNames.length);
		int randomPostalCode= rand.nextInt(PostalCode.length);
		FirstNameInput.sendKeys(Firstnames[randomFirstName]);
		LastNameInput.sendKeys(LastNames[randomLastname]);
		PostalCodeInput.sendKeys(PostalCode[randomPostalCode]);
		WebElement ContinueButton=driver.findElement(By.id("continue"));
		ContinueButton.click();
		WebElement FinishButton=driver.findElement(By.id("finish"));
		FinishButton.click();
		
		
	}
}
