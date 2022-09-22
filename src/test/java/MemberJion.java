import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MemberJion extends Base{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(opt);
		//driver.get("https://devhyb.shaklee.co.jp/");
		driver.get("https://devhyb.shaklee.co.jp/registration");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.switchTo().newWindow(WindowType.TAB);
		MemberJion memberuser1 = new MemberJion();
		memberuser1.addMembershipKit();
		//memberuser1.navigateToCart();
		memberuser1.addProducts();
		//memberuser1.loginDuringCheckout();
		memberuser1.accountInfo("Jion As Member");
		memberuser1.primaryResidenceAddress();
		memberuser1.shippingCheckout();
		memberuser1.paymentCheckout("COD");
		memberuser1.yourDistributorCheckout();
		memberuser1.reviewCheckout();
	}

}
