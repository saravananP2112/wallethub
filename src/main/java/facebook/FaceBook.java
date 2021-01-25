package facebook;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook {
	public static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	static WebDriver driver;

	public void launchFacebookApp() {
		System.setProperty(CHROME_DRIVER_PROPERTY,
				"C:\\Users\\Owern\\eclipse-workspace\\WalletHub\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public void enterUserName() {
		Scanner s = new Scanner(System.in);
		System.out.println("enter the username");
		String userName = s.nextLine();
		WebElement usernameTxt = driver.findElement(By.id("email"));
		usernameTxt.sendKeys(userName);
	}

	public void enterPassword() {
		Scanner s = new Scanner(System.in);
		System.out.println("enter the password");
		String password = s.nextLine();
		WebElement usernameTxt = driver.findElement(By.id("pass"));
		usernameTxt.sendKeys(password);
	}
	
	public void clickLoginButton() {
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
	}

	public void implicitWait(int MaxWaitTime) {
		driver.manage().timeouts().implicitlyWait(MaxWaitTime, TimeUnit.SECONDS);
	}

	public void inputStatus() {
		implicitWait(5);
		WebElement status = driver
				.findElement(By.xpath("//div[contains(@class,'m9osqain a5q79mjw jm1wdb64 k4urcfbm')]"));
		status.click();
		status.sendKeys("Hello World");
	}

	public static void main(String[] args) {
		FaceBook f = new FaceBook();
		f.launchFacebookApp();
		f.enterUserName();
		f.enterPassword();
		f.clickLoginButton();
		f.inputStatus();
	}
}
