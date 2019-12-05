package com.torenzo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;





import java.io.IOException;
import java.util.List;
public class GuestPage extends TestBase{

	
	public GuestPage(AndroidDriver<AndroidElement> driver) throws IOException {
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	 @AndroidFindBy(xpath ="//android.widget.TextView[@text='Edit Guest']")
		public WebElement titleOfGuestPage;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_two")
		public WebElement addTwoGuestClick;
	
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_three")
		public WebElement addThreeGuestClick;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_four")
		public WebElement addFourGuestClick;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_nine")
		public WebElement addNineGuestClick;
	
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_one")
		public WebElement addOneGuestClick;
	
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_zero")
		public WebElement addZeroGuestClick;
	  
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/cancel_add_guest")
		public WebElement cancelAddGuestClick;	 

	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_done")
		public WebElement addGuestDoneClick;
	  
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Party Size']")
		public WebElement titleOfPartySizeInTable;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/party_size_number_display")
		public WebElement partySizeNumberDisplay;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_number_display")
		public WebElement addGuestNumberDisplay;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/done_employee_list")
		public WebElement doneEmployeeList;

	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_delete")
		public WebElement deleteAddedGuest;
	 
	 @AndroidFindBy(id ="android:id/alertTitle")
		public WebElement guestAlert; // enter zero this alert display
	 
	 @AndroidFindBy(id ="android:id/button1")
		public WebElement alertOk; 
	 
	 @AndroidFindBy(id ="android:id/message")
		public WebElement alertGuest;   //enter more than 19 guest then this alert displayed
	 
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Guest Properties']")
		public WebElement guestProperties;
	 	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/add_guest_identification")
		public WebElement addGuestIdentfi;

	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/move_all_items_to_guest")
		public WebElement moveItemToGuest;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/swap_all_items_with_guest")
		public WebElement swapItemToGuest;
	 
	 @AndroidFindBy(id="com.torenzo.torenzocafe:id/delete_guest")
		public WebElement deleteGuest;

	 @AndroidFindBy(id="android:id/alertTitle")
		public WebElement confirmationDeletGuest ;
	 
	 @AndroidFindBy(id="android:id/button2")
		public WebElement oKConfirmation ;
	 
	 @AndroidFindBy(id="android:id/button1")
		public WebElement cancelConfirmation ;
	 
	 

	 public boolean verifytitleOfGuestWindow(){
		
		return titleOfGuestPage.isDisplayed();
		
	}		
	 public boolean verifytitleOfPartySizeInTable(){			
			return titleOfPartySizeInTable.isDisplayed();			
		}
	
	 public void clickAddGuestOne(){			
		 addOneGuestClick.click();			
		}
	 
	 public void clickAddGuestZero(){			
		 addZeroGuestClick.click();			
		}
	 
	 public OrderPage clickOnDoneEmployeeList() throws InterruptedException, IOException{			
		 doneEmployeeList.click();
		 return new OrderPage(driver);	
		}
	 
	 public void clickAddGuestTwo(){		
		 addTwoGuestClick.click();
			
		}
	 public void clickAddGuestThree(){		
		 addThreeGuestClick.click();		
		}
	 public void clickAddGuestFour(){		
		 addFourGuestClick.click();		
		}
	 
	 public void clickAddGuestNine(){
			 addNineGuestClick.click();
			
		} 
	 
	 public OrderPage clickAddGuestDoneClick() throws InterruptedException, IOException{			
		 addGuestDoneClick.click();
		 return new OrderPage(driver);			
		}
	 
	 public void ClickOnCancelGuestWindow() throws InterruptedException, IOException{
			 cancelAddGuestClick.click();
			
		}	 
	 public String getTextGuestCountAddedFromGuestWindow(){		
		 return addGuestNumberDisplay.getText();
			
		}
	 public void removeGuest(){		
		  addGuestNumberDisplay.clear();		
		}
	 
	 public String gteTextCountAddedFromPartyWindow(){			
		 return partySizeNumberDisplay.getText();			
		}
	
	 public String guestAlert(){			
		 return guestAlert.getText(); // enter zero this alert display			
		}
	 public String alertGuest(){		
			 return alertGuest.getText();   //enter more than 19 guest then this alert displayed		
		}
	 
	 public String  confirmationDeletGuest(){		
		 return  confirmationDeletGuest.getText();   //enter more than 19 guest then this alert displayed		
	}
	 
	
	 public void deleteGuestFromGuestWindow(){		
		 deleteAddedGuest.click();		
		}

	 public void oKOnAleret(){		
		 alertOk.click();		
		}
	 public String getTextProperties(){		
		 return guestProperties.getText();		
		}
	 
	 public void clickAddGuestIdentfi(){		
		 addGuestIdentfi.click();		
		}
	 
	 public void clickMoveItemToGuest(){		
		 moveItemToGuest.click();		
		}
	 
	 public void clickSwapItemToGuest(){		
		 swapItemToGuest.click();		
		}
	 public void clickDeleteGuest(){		
		 deleteGuest.click();		
		}
	 
	 public boolean enableOption() throws InterruptedException{
	      Boolean value[]=  {moveItemToGuest.isEnabled() , swapItemToGuest.isEnabled(), deleteGuest.isEnabled() };	 
	      for( boolean value1:value){
                 System.out.println("Hello");
	    	  	return value1;
	      }		   
		boolean value1 = false;
		return value1;	

	 }
	 
	 
	 
	 
	 
	 
		
}















/*public void PassGuest(){
	
	driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).click();
	String guest = driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).getText();
	System.out.println("guestCountFromWindow  = " +guestCountFromWindow );
	int str = Integer.parseInt(guest);
	guestCountFromWindow  = 1 + str;
  	System.out.println("guestCountFromWindow = " +guestCountFromWindow);
  	
 	driver.findElement(By.id(obj.getProperty("AddGuestDone"))).click();
}
public void verifyGuestAdded(){
	
	List<WebElement> guestCountFromOrder = driver.findElements(By.id("guest_name"));
	System.out.println("guestCountFromOrder = " +guestCountFromOrder.size());
	if(guestCountFromWindow  == guestCountFromOrder.size() )
	{
		System.out.println("Guest is added succfully");
	}
	else{
		System.out.println("Guest is not added ");
	}
	
}
public AddItemToOrderPage Navigation()
{

	 return new AddItemToOrderPage();
}*/

