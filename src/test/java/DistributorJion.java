import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DistributorJion extends Base {

	//public static String finacialInstitution = "ゆうちょ銀行";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(opt);
		// driver.get("https://devhyb.shaklee.co.jp/");
		driver.get("https://devhyb.shaklee.co.jp/registration");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DistributorJion distributoruser1 = new DistributorJion();
		distributoruser1.addDistributorKit();
		// memberuser1.navigateToCart();
		distributoruser1.addProducts();
		//distributoruser1.loginDuringCheckout();
		distributoruser1.accountInfo("Jion As Distributor");
		distributoruser1.primaryResidenceAddress();
		distributoruser1.shippingCheckout();
		distributoruser1.paymentCheckout("PayPal");
		distributoruser1.commissionPayment();
		//distributoruser1.yourDistributorCheckout();
		//distributoruser1.reviewCheckout();
	}

}
