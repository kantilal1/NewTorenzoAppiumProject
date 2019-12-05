package com.torenzo.qa.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.AdminSettingPage;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PayingPaymentPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.SplitReceiptPage;
import com.torenzo.qa.pages.TableStructurePage;
import com.torenzo.qa.pages.TableViewPage;
import com.torenzo.qa.pages.TransactionOrderPage;
import com.torenzo.qa.util.ScrollMethod;

import static com.torenzo.qa.util.StaticVariable.EditTotalAmt;
import static com.torenzo.qa.util.StaticVariable.comapre;
import static com.torenzo.qa.util.StaticVariable.guestCountFromParty;
import static com.torenzo.qa.util.StaticVariable.paymentValue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TableStructurePageTest extends TestBase {
	TransactionOrderPage transactionOrderPage;
	HomePage homePage;
	LoginPage loginPage;
	OrderPage orderPage;
	GuestPage guestPage;
	PaymentPage paymentPage; 
	SplitReceiptPage splitReceiptPage;
	PayingPaymentPage payingPaymentPage;
	TableStructurePage tableStructurePage;  
	ScrollMethod scrollMethod;
	AdminSettingPage adminSettingPage;
	TableViewPage  tableViewPage;
	HomePageTest homePageTest;
	
	public TableStructurePageTest() throws IOException{
		   super();
	   }
		
	@BeforeClass
	    public void setUp() throws IOException, InterruptedException
	    {
			initilization();
			loginPage = new LoginPage(driver);
			homePage = new HomePage(driver);
			orderPage = new OrderPage(driver);
			guestPage = new GuestPage(driver);
			paymentPage = new PaymentPage(driver);
			transactionOrderPage = new TransactionOrderPage(driver); 
		    splitReceiptPage = new SplitReceiptPage(driver);
		    payingPaymentPage = new PayingPaymentPage(driver);
		    tableStructurePage = new TableStructurePage(driver);
		    scrollMethod = new ScrollMethod();
		    adminSettingPage = new AdminSettingPage(driver);
		    tableViewPage = new TableViewPage(driver);	
		    homePageTest = new HomePageTest();
		    
	    }
		
		@Test(priority = 1)
		public void loginApp() throws IOException, InterruptedException
		{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		homePageTest.loginApp();
		/*loginPage.validatelaunchLink();		 
		Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found (App not launched)");		
		loginPage.clickOnOpenExistStoreButton();	  
		boolean titleOfLoginWindow = loginPage.titleOfLoginPage();
		Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Open Existing Store");
		loginPage.clickOnSubmitLoginButton();
		boolean clockInButton = loginPage.validateClockInButton();
		Assert.assertTrue(clockInButton, "Clock In Button is not dispalyed upon submitting user with valid creadentials (Check n/w or server)");
		loginPage.clickOnClockInButton();
     	Assert.assertTrue(loginPage.validateTitileClockIn(), "Clock In titile page is not dispalyed upon clickiing on Clock in button");
		loginPage.clickOnroleNameButton();
		 Assert.assertTrue(loginPage.validatePermissionPopup(), "Permission popup is not found");				
	     homePage = loginPage.clickOnPermissionPupup();				
		 homePage.titleOfhomePage();					
		System.out.println("Heelo pass==>"+homePage.titleOfhomePage());		
		Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found (login not succefully)");*/
		
		}
		
		@Test(priority = 1)
		public void validateTableStrucutre() throws IOException, InterruptedException{
		
		try{
			if (homePage.validatetableStructureButton()){
				scrollMethod.swipAdmin();
				Assert.assertTrue(adminSettingPage.verifyAdminSettingPanel(), "Admin Setting Page not found after scrolling it");
				tableViewPage = adminSettingPage.clickOnadminSettings();
			
			}
		}catch(Exception e)
		{
			scrollMethod.swipAdmin();
			Assert.assertTrue(adminSettingPage.verifyAdminSettingPanel(), "Admin Setting Page not found after scrolling it");
			tableViewPage = adminSettingPage.clickOnadminSettings();
			tableViewPage.clickOnTableviewDisplay();

	    }
		
		tableStructurePage = tableViewPage.clickOnreloadTables();
		
		Assert.assertTrue(tableStructurePage.titleOfTableStructure(), "Table Structure page is not found upon reloading table from Admin Settings");
	}
	
		@Test(priority = 2)
		public void selectEmptyTable() throws InterruptedException, IOException{
		tableStructurePage.checkForEmptyTable();
	    Assert.assertTrue(guestPage.verifytitleOfPartySizeInTable(), "Party size window not found upon clicking on empty table");
	    guestPage.clickAddGuestThree();
	    guestCountFromParty = guestPage.gteTextCountAddedFromPartyWindow();
	    orderPage = guestPage.clickOnDoneEmployeeList();
     	String count = Integer.toString(orderPage.totolGuestCount());
        Assert.assertEquals(guestCountFromParty, count, "Guest count is not matched when it to each other from order page to party size window");	   
        orderPage.selectGuestandAddItem();
        System.out.println("getTextFromOrderTotal=>" +homePage.getTextFromOrderTotal());
    	comapre = orderPage.totolGuestCount();
		System.out.println("comapre=>" +comapre);		
        paymentPage = homePage.clickOnOrderTotalUpsideButton();
        Assert.assertEquals( paymentPage.verifyPaymentPagetitle(), "PayBill", "Payment Page is not found upon clicking on TotalUpsideButton from Order");
	 }
	
	@Test(priority = 3)
	public void getPaymentDone() throws IOException, InterruptedException{
		splitReceiptPage = paymentPage.ClickOnSplitReceiptClick();
		Assert.assertTrue(splitReceiptPage.verifySplitReceiptPage(), "Receipt page is not found upon clicking on Split receipt button");
		System.out.println("Spliting receipt for single guest");
		splitReceiptPage.clickOnSingleRecipt();	
		System.out.println("receipt count is =>" +paymentPage.totolReceiptCount());
		System.out.println("paymentPage.totalReceipt is =>" +paymentPage.totalReceipt.size());
	
	for( WebElement  we : paymentPage.totalReceipt){
		
		we.click();
		payingPaymentPage  = paymentPage.clickOnPayBill();
			Assert.assertTrue(payingPaymentPage.titleOfPaymentWindow(), "Payment window is not opened upon clicking on Paybill button");
			EditTotalAmt =payingPaymentPage.getTextEditTotalAmt();
			EditTotalAmt =EditTotalAmt.substring(0, EditTotalAmt.length()-1);
			payingPaymentPage.ClickOnaddPayment();
			paymentValue = payingPaymentPage.getTextpaymentValue();
			System.out.println("EditTotalAmt is =>" +EditTotalAmt);
			System.out.println("paymentValue =>" +paymentValue);
			Assert.assertEquals(EditTotalAmt, paymentValue, "Both value is not matched with each other from Payment Window");
			payingPaymentPage.clickOnDoneFromPaymentWindow();
			payingPaymentPage.closeTableWithoutReceiptButton();
			
			try{
				payingPaymentPage.continueWithoutClosingtableButton();
			}catch(Exception e){
				 System.out.println("Order is Paid");
			}
		
		}

		Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found (after paying order");
	

	}
        

}