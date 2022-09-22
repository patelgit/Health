import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetailPayPal extends Base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(opt);
		driver.get("https://devhyb.shaklee.co.jp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		RetailPayPal retailPayPaluser = new RetailPayPal();
		retailPayPaluser.navigateToCart();
		retailPayPaluser.addProducts();
		retailPayPaluser.loginDuringCheckout();
		retailPayPaluser.accountInfo("Retail");
		retailPayPaluser.primaryResidenceAddress();
		retailPayPaluser.shippingCheckout();
		retailPayPaluser.paymentCheckout("PayPal");
		retailPayPaluser.reviewCheckout();
	}

}
