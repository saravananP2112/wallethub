package facebook;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WalletHub {
	public static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	static WebDriver driver;

	public void launchFacebookApp() {
		System.setProperty(CHROME_DRIVER_PROPERTY,
				"C:\\Users\\Owern\\eclipse-workspace\\WalletHub\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://wallethub.com/join/light");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public void createAccount(String firstName, String lastname, String password, String email, String mothername) {
		WebElement signUpLink = driver.findElement(By.linkText("Sign Up"));
		signUpLink.click();
		/* Element to input first name */
		driver.findElement(By.id("first-name")).sendKeys(firstName);
		/* Element to input last name */
		driver.findElement(By.id("last-name")).sendKeys(lastname);
		/* Element to click on continue button */
		driver.findElement(By.xpath("//a[contains(@class,'btn blue reg-tabs-bt')]")).click();
		/* Element to enter email address */
		driver.findElement(By.id("email")).sendKeys(email);
		/* Element to click on continue button */
		driver.findElement(By.xpath("//button[contains(@class,'btn blue touch-element')]")).click();
		/* Element to input Password */
		driver.findElement(By.id("password")).sendKeys(password);
		/* Element to input confirm Password */
		driver.findElement(By.id("password2")).sendKeys(password);
		/* Element to click on continue button */
		driver.findElement(By.xpath("//button[contains(@class,'btn blue touch-element')]")).click();
		List<WebElement> securityQn = driver.findElements(By.xpath(
				"//ul[contains(@class,'ng-animate-enabled basic-trans touch-element-cl')]//following-sibling::li"));
		for (WebElement ele : securityQn) {
			ele.click();
			break;
		}
		String selectedSecurityqn = driver
				.findElement(By.xpath("//ul[contains(@class,'ng-animate-enabled basic-trans touch-element-cl')]"))
				.getText();
		System.out.println(selectedSecurityqn);
		driver.findElement(By.id("an-ipt")).sendKeys(mothername);
		/* Element to click on continue button */
		driver.findElement(By.xpath("//button[contains(@class,'btn blue touch-element')]")).click();
		driver.findElement(By.id("address-2")).sendKeys("220 Highland Ave");
		List<WebElement> autosuggestion = driver
				.findElements(By.xpath("//ul[contains(@class,'ng-autocomplete-list ng-animate')]//li"));
		for (WebElement ele : autosuggestion) {
			ele.click();
			break;
		}
		String address1 = driver.findElement(By.id("address-2")).getText();
		System.out.println(address1);
		driver.findElement(By.id("address-3")).sendKeys("220 Highland Ave");
		driver.findElement(By.id("address-5")).sendKeys("Glen Riddle");
		driver.findElement(By.id("address-6")).sendKeys("ME");
		driver.findElement(By.id("address-6")).sendKeys("19063");
		driver.findElement(By.xpath("//button[contains(@class,'btn blue touch-element')]")).click();
		driver.findElement(By.id("cp-ipt")).sendKeys("(541) 754-3010");
		driver.findElement(By.xpath("//button[contains(@class,'btn blue touch-element')]")).click();
		driver.findElement(By.id("month-ipt")).sendKeys("12");
		driver.findElement(By.id("day-ipt")).sendKeys("12");
		driver.findElement(By.id("year-ipt")).sendKeys("1993");
		driver.findElement(By.xpath("//button[contains(@class,'btn blue touch-element')]")).click();

	}
public static void main(String[] args) {
	WalletHub w = new WalletHub();
	w.createAccount("Wallet", "Hub", "Wallet@2112", "dummy@gmail.com", "wallet");
} 
}
