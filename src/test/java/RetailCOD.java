import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetailCOD extends Base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(opt);
		driver.get("https://devhyb.shaklee.co.jp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Base user1 = new RetailCOD();
		user1.navigateToCart();
		user1.addProducts();
		user1.loginDuringCheckout();
		user1.accountInfo("Retail");
		user1.primaryResidenceAddress();
		user1.shippingCheckout();
		user1.paymentCheckout("COD");
		user1.reviewCheckout();

	}

}
