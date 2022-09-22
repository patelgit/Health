import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	protected static WebDriver driver;
	public static Properties envConfig;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public Map<String, String> productsMap = new HashMap<String, String>();
	public static int targetDDay = 0, targetDMonth = 0, targetDYear = 0;
	public static int currentDay = 0, currentMonth = 0, currentYear = 0;
	static int targetDay = 0, targetMonth = 0, targetYear = 0;
	static int jumpMonthBy = 0;
	static boolean increament = true;
	public static boolean reload = false;
	public static String sku = "01859";
	public static String qty = "99";
	public static String securityQuestion = "母親の旧姓は？";
	public static String password = "test1234";

	public static String emailID = "shakleejpdistributor20@yopmail.com";
	public static String documentID = "WWP1180750";

	public static String lastName = "二宮";
	public static String firstName = "光子";
	public static String lastNameKatakana = "スズ";
	public static String firstNameKatakana = "タロ";
	public static String birthday = "1990/07/04";
	public static String gender = "Female";
	public static String mobileNumber = "90909091160";
	public static String homeNumber = "90909091161";
	public static String countryOfCitizen = "日本";
	public static String career = "会社員";
	public static String postalCode = "218-5991";
	public static String state = "山形県";
	public static String addressLine1 = "札幌市中央区旭ケ丘1";
	public static String addressLine2 = "札幌市中央区旭ケ丘2";
	public static String addressLine3 = "札幌市中央区旭ケ丘3";
	public static String deliveryDate = "2022/09/29";
	public static String deliveryTimeWindow = "6-8pm";
	public static String deliveryMessage = "留守時は宅配ボックスへ";
	
	public static String paypalUsername = "japan-buyer2@shaklee.com";
	public static String paypalPassword = "shaklee2014#";
	public static boolean maketingPomotion = true;

	public static String finacialInsti = "ゆうちょ銀行";
	public static String passbookSymbol = "111";
	public static String passbookSNumber = "11111111";

	public static String distributorLastName = "鈴⽊";
	public static String distributorFirstName = "太郎";
	public static String distributorLastNameKataKana = "鈴⽊";
	public static String distributorFirstNameKataKana = "太郎";
	public static String distributorShakleeId = "220691147";
	public static String distributorState = "北海道";

	public void navigateToCart() {
		driver.findElement(By.xpath("(//a[@href=\"/cart\"])[1]")).click();
		// addToCart();
	}

	public void addProducts() {
		productsMap.put("01859", "11");
		productsMap.put("01860", "11");
		productsMap.put("01148", "11");
		productsMap.put("01149", "11");
		productsMap.put("00159", "11");
		productsMap.put("03002", "11");
		productsMap.put("01232", "11");
		productsMap.put("57022", "11");
//		productsMap.put("01598", "11");
//		productsMap.put("00173", "22");
//		productsMap.put("00108", "22");
//		productsMap.put("01132", "22");
//		productsMap.put("01140", "22");

		// products.put("07000", "20");

		Set<String> productsInfo = productsMap.keySet();
		System.out.println(productsInfo);
		for (String sku : productsInfo) {
			System.out.println("key is-> " + sku + " value is-> " + productsMap.get(sku));
			driver.findElement(By.xpath("//input[@id=\"js-quickshop-input\"]")).sendKeys(sku);
			driver.findElement(By.xpath("//div[contains(text(), " + sku + ")]")).click();
			driver.findElement(By.xpath("(//input[@name=\"qty\"])[1]")).clear();
			// driver.findElement(By.xpath("(//input[@name=\"qty\"])[1]")).sendKeys(products.get(sku));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name=\"qty\"])[1]")))
					.sendKeys(productsMap.get(sku));
			try {
				driver.findElement(By.id("quickshopAddToCartButton")).click();

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//button[contains(text(),\"Checkout\")]")))
				.click();
	}

	public void addToCart() {
//		Map<String, String> pmap = new HashMap<String, String>();
//		pmap.put("01860", "4");
//		pmap.put("01148", "5");
//		pmap.put("01149", "5");
//		pmap.put("00159", "6");
//		pmap.put("03002", "2");
//		 products.put("01232", "2");
//		 products.put("57022", "2");
//		 products.put("01859", "99");
//
//		for (Map.Entry m : pmap.entrySet()) {
//			System.out.println("Key: " + m.getKey() + " value: " + m.getValue());
//			driver.findElement(By.xpath("//input[@id=\"js-quickshop-input\"]")).sendKeys(m.getKey().toString());
//			driver.findElement(By.xpath("//div[contains(text(), " + m.getKey().toString() + ")]")).click();
//			driver.findElement(By.xpath("(//input[@name=\"qty\"])[1]")).clear();
//			// driver.findElement(By.xpath("(//input[@name=\"qty\"])[1]")).sendKeys(products.get(sku));
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name=\"qty\"])[1]")))
//					.sendKeys(m.getValue().toString());
//			driver.findElement(By.id("quickshopAddToCartButton")).click();
//		}
		driver.findElement(By.xpath("//input[@id=\"js-quickshop-input\"]")).sendKeys(sku);
		driver.findElement(By.xpath("//div[contains(text(), " + sku + ")]")).click();
		driver.findElement(By.xpath("(//input[@name=\"qty\"])[1]")).clear();
		driver.findElement(By.xpath("(//input[@name=\"qty\"])[1]")).sendKeys(qty);
		clickadd();
	}

	public void clickadd() {
		// driver.findElement(By.xpath("//div//button[@id=\"quickshopAddToCartButton\"]")).click();
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//button[@id=\"quickshopAddToCartButton\"]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//button[contains(text(),\"Checkout\")]")))
				.click();
	}

	public void loginDuringCheckout() {

		driver.findElement(By.name("email")).sendKeys(emailID);
		driver.findElement(By.xpath("//input[@id=\"guest.confirm.email\"]")).sendKeys(emailID);
		driver.findElement(By.xpath("//div//button[contains(text(),\"Checkout as a Guest\")]")).click();

	}

	public void accountInfo(String userType) {

		enterName(lastName, firstName, lastNameKatakana, firstNameKatakana);
		selectBirthDate(birthday);
		selectGender(gender);
		enterPhone(mobileNumber, homeNumber);
		enteremail(emailID);
		if (userType == "Jion As Member") {
			driver.findElement(By.id("userPassword")).sendKeys(password);
			Select secuityQue = new Select(driver.findElement(By.id("securityQuestion")));
			secuityQue.selectByVisibleText(securityQuestion);
			driver.findElement(By.id("yourAnswer")).sendKeys(password);
		} else if (userType == "Jion As Distributor") {
			driver.findElement(By.id("documentId")).sendKeys(documentID);
			driver.findElement(By.id("checkedDocumentId")).click();
			driver.findElement(By.id("userPassword")).sendKeys(password);
			Select secuityQue = new Select(driver.findElement(By.id("securityQuestion")));
			secuityQue.selectByVisibleText(securityQuestion);
			driver.findElement(By.id("yourAnswer")).sendKeys(password);
		}
		selectCountryOfCitizen(countryOfCitizen);
		selectCareer(career);
		clickNext(false);
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("personalInfoSubmit"))).click();
	}

	public void enterName(String lName, String fName, String lKatakana, String fKatakana) {
		driver.findElement(By.id("guestLastName")).sendKeys(lName);
		driver.findElement(By.id("guestFirstName")).sendKeys(fName);
		driver.findElement(By.id("lastNameKataKana")).sendKeys(lKatakana);
		driver.findElement(By.id("firstNameKataKana")).sendKeys(fKatakana);

	}

	public void selectBirthDate(String bdate) {
		driver.findElement(By.id("birthday")).click();
		int firstIndex = bdate.indexOf("/");
		int lastIndex = bdate.lastIndexOf("/");

		String year = bdate.substring(0, firstIndex);
		targetYear = Integer.parseInt(year);
		String month = bdate.substring(firstIndex + 1, 7);
		targetMonth = Integer.parseInt(month);

		String day = bdate.substring(lastIndex + 1, bdate.length());
		String strPattern = "^0+(?!$)";
		day = day.replaceAll(strPattern, "");
		// targetDay = Integer.parseInt(day);
		System.out.println("Year is:" + targetYear + " month is:" + targetMonth + "day is: " + targetDay);

		Select bmonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		bmonth.selectByIndex(targetMonth - 1);
		Select byear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		byear.selectByValue(year);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(day))).click();
		// driver.findElement(By.linkText(day)).click();

	}

	public void selectGender(String gender) {
		Select gen = new Select(driver.findElement(By.id("gender")));
		gen.selectByVisibleText(gender);

	}

	public void enterPhone(String mobile, String home) {
		if (mobile != null) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("mobilePhone"))).sendKeys(mobile);
		}
		if (home != null) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("homePhone"))).sendKeys(home);
		}

	}

	public void enteremail(String email) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("guestEmail"))).sendKeys(email);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("emailConfirm"))).sendKeys(email);

	}

	public void selectCountryOfCitizen(String cocOption) {
		Select citizenship = new Select(driver.findElement(By.id("citizenship")));
		citizenship.selectByVisibleText(cocOption);

	}

	public void selectCareer(String careerOption) {
		Select selectCareer = new Select(driver.findElement(By.id("career")));
		selectCareer.selectByVisibleText(careerOption);

	}

	public void clickNext(boolean submitOrder) {
		try {
			System.out.println("in submit order function");
			if (submitOrder) {
				System.out.println("submit order function is true");
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"agreeTerms\" and @type=\"checkbox\" and @name=\"termsCheck\"]"))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@title,\"Place Order\")])[1]"))).click();

			} else if (submitOrder == false) {
				System.out.println("Click on next button");
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),\"Next\")]")))
						.click();
			}
		} catch (Throwable t) {
			System.out.println("Exception during submit order" + t);
		}
	}

	public void primaryResidenceAddress() {
		enterPostalCode(postalCode);
		selectState(state);
		enterAddressline(addressLine1, addressLine2, addressLine3);
		clickNext(false);
	}

	public void enterPostalCode(String postal) {
		// int firstIndex = postal.indexOf("/");
		String postalStart = postal.substring(0, 3);
		String postalEnd = postal.substring(4, postal.length());
		System.out.println(postalStart + " vcc" + postalEnd);
		driver.findElement(By.name("postCodeStart")).sendKeys(postalStart);
		driver.findElement(By.name("postCodeEnd")).sendKeys(postalEnd);

		// uncomment below line when search postal code is working
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),\"Search\")]"))).click();
	}

	public void selectState(String stateData) {

		Select stateOption = new Select(driver.findElement(By.name("regionIso")));
		stateOption.selectByVisibleText(stateData);
	}

	public void enterAddressline(String addl1, String addl2, String addl3) {

		if (addl1 != null) {
			driver.findElement(By.name("addressLine1")).sendKeys(addl1);
		}
		if (addl2 != null) {
			driver.findElement(By.name("addressLine2")).sendKeys(addl2);
		}
		if (addl3 != null) {
			driver.findElement(By.name("addressLine3")).sendKeys(addl3);
		}

	}

	public void shippingCheckout() {
		selectDeliveryDate(deliveryDate);
		selectDeliveryTime(deliveryTimeWindow);
		selectDeliveryMessage(deliveryMessage);
		clickNext(false);
	}

	public void selectDeliveryDate(String ddate) {
		getCurrentDateMonthAndYear();

		int firstIndex = ddate.indexOf("/");
		int lastIndex = ddate.lastIndexOf("/");

		String year = ddate.substring(0, firstIndex);
		targetDYear = Integer.parseInt(year);
		String month = ddate.substring(firstIndex + 1, 7);
		targetDMonth = Integer.parseInt(month);

		String strPattern = "^0+(?!$)";
		String day = ddate.substring(lastIndex + 1, ddate.length());
		day = day.replaceAll(strPattern, "");
		targetDDay = Integer.parseInt(day);

		calculateMonth();
		driver.findElement(By.id("deliveryDate")).click();
		for (int i = 0; i < jumpMonthBy; i++) {
			if (increament) {
				driver.findElement(By.xpath("//a[contains(@title,\"Next\")]")).click();
			} else {
				driver.findElement(By.xpath("//a[contains(@title,\"Prev\")]")).click();

			}
		}
		// Select dmonth = new
		// Select(driver.findElement(By.className("ui-datepicker-month")));
		// dmonth.selectByIndex(targetDMonth - 1);
		// Select dyear = new
		// Select(driver.findElement(By.className("ui-datepicker-year")));
		// dyear.selectByValue(year);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(day))).click();

	}

	public void getCurrentDateMonthAndYear() {

		Calendar cal = Calendar.getInstance();
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH) + 1;
		currentYear = cal.get(Calendar.YEAR);
	}

	public void targetDeliveryDate() {

	}

	public void calculateMonth() {
		if ((targetDMonth - currentMonth) > 0) {
			jumpMonthBy = (targetDMonth - currentMonth);
		} else {
			jumpMonthBy = (currentMonth - targetDMonth);
			increament = false;
		}
	}

	public void selectDeliveryTime(String dTime) {

		Select deliverTime = new Select(driver.findElement(By.id("deliveryTime")));
		deliverTime.selectByVisibleText(dTime);
	}

	public void selectDeliveryMessage(String dMessage) {
		try {
			if (dMessage != null) {
				Select deliverMSG = new Select(driver.findElement(By.id("deliveryMessage")));
				deliverMSG.selectByVisibleText(dMessage);
			} else {
				System.out.println("order is placing without entering delivery message");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/* Payment Checkout Page */

	public void paymentCheckout(String paymentOption) throws InterruptedException {
		if (paymentOption == "COD") {
			checkoutCOD();
			clickNext(false);
		} else if (paymentOption == "PayPal") {
			checkoutPayPal(paypalUsername, paypalPassword);
		}

	}

	public void checkoutCOD() {
		System.out.println("calling checkoutCOD");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentMethodCOD"))).click();
	}

	public void checkoutPayPal(String uname, String pwd) throws InterruptedException {
		try {

			if (reload == true) {
				System.out.println("Calling checkoutPayPal() -> reload== true");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentMethodPayPal"))).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"zoid-outlet\"]"))).click();
				navigateToPaypalWindow();
			}

			if (reload == false) {
				System.out.println("Calling checkoutPayPal() -> reload== false");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentMethodPayPal"))).click();
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"zoid-outlet\"]"))).click();
				navigateToPaypalWindow();
				driver.findElement(By.id("email")).sendKeys(uname);
				driver.findElement(By.id("btnNext")).click();
				driver.findElement(By.id("password")).sendKeys(pwd);
				driver.findElement(By.id("btnLogin")).click();
				js.executeScript("arguments[0].click();",
						driver.findElement(By.xpath("//button[@id=\"consentButton\"]")));

			}
			// driver.findElement(By.xpath("//button[@data-testid=\"submit-button-initial\"]")));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void navigateToPaypalWindow() {
		String mainwindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				if (reload == true) {
					driver.close();
					System.out.println("Child window closed");
				}

			}
		}

		// Switch back to the main window which is the parent window.
		if (reload == true) {
			driver.switchTo().window(mainwindow);
			driver.navigate().refresh();
		}
		reload = false;
	}

//	public void navigateToPaypalWindow() {
//		String mainwindow = driver.getWindowHandle();
//		Set<String> win = driver.getWindowHandles();
//		Iterator<String> iterator = win.iterator();
//		List<String> winIndex = new ArrayList<String>();
//		while (iterator.hasNext()) {
//			winIndex.add(iterator.next());
//			
//		}
//		driver.switchTo().window(winIndex.get(1));
//		driver.close();
//		
//		driver.switchTo().window(winIndex.get(0));
//		driver.navigate().refresh();
//	}

	public void commissionPayment() {

		System.out.println("Calling commissionPayment() function");
		try {
			Thread.sleep(8000);
			driver.findElement(By.name("lastName")).sendKeys("eee");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.findElement(By.xpath("//div//input[@name=\"lastName\"]")).click();

		// driver.findElement(By.xpath("//div//input[@name=\"lastName\"]")).sendKeys("abc");
		driver.findElement(By.xpath("//div//input[@id=\"firstName\"]")).sendKeys(distributorLastNameKataKana);
		driver.findElement(By.xpath("//div//input[@id=\"lastNameKataKana\"]")).sendKeys(distributorFirstNameKataKana);
		driver.findElement(By.xpath("//div//input[@id=\"firstNameKataKana\"]")).sendKeys(distributorShakleeId);

		if (finacialInsti == "ゆうちょ銀行") {
			Select bank = new Select(driver.findElement(By.xpath("//Select[@id=\"bank\"]")));
			bank.selectByVisibleText(finacialInsti);
			for (int f = 1; f <= 3; f++) {
				String pbs = finacialInsti.substring(f - 1, f + 1);
				driver.findElement(By.xpath("//input[@id=\"passbookSymbol" + f + "\"]")).sendKeys(pbs);
			}
		}

	}

	public void yourDistributorCheckout() {
		try {
			System.out.println("stated calling yourDistributorCheckout()");
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(By.name("distributorLastName")))
					.sendKeys(distributorLastName);
			// driver.findElement(By.name("distributorLastName")).sendKeys(distributorLastName);
			driver.findElement(By.name("distributorFirstName")).sendKeys(distributorFirstName);
			driver.findElement(By.name("distributorLastNameKataKana")).sendKeys(distributorLastNameKataKana);
			driver.findElement(By.name("distributorFirstNameKataKana")).sendKeys(distributorFirstNameKataKana);
			driver.findElement(By.name("distributorShakleeId")).sendKeys(distributorShakleeId);
			Select distributorProvince = new Select(driver.findElement(By.id("stateOrProvince")));
			distributorProvince.selectByVisibleText(distributorState);

			wait.until(ExpectedConditions.elementToBeClickable(By.id("searchHeathAdvisorButton"))).click();
			clickNext(false);
		} catch (Exception e) {
			System.out.println("Getting error in yourDistributorCheckout()" + e);
		}

	}

	public void reviewCheckout() {
		agreeCondition();
		clickNext(true);
	}

	public void agreeCondition() {
		try {
			if (maketingPomotion) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"isReceivePromotions\"]"))).click();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception while check the chekbox of marketing promotion" + e);
		}

	}

	public void addMembershipKit() {
		driver.findElement(By.xpath("//a[@href =\"/cart/add-kit/MEMBR\"]")).click();

	}

	public void addDistributorKit() {
		driver.findElement(By.xpath("//a[@href =\"/cart/add-kit/09272\"]")).click();

	}

}
