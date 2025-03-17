import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//WebUI --> WebDriver driver=new ChromeDriver()

String expectedMonth="May"
String expectedYear="2023"
String expectedDate="12"

WebUI.openBrowser(GlobalVariable.JQuery)
WebUI.maximizeWindow()
WebUI.waitForPageLoad(3)

TestObject frame=new TestObject()
frame.addProperty('xpath',ConditionType.EQUALS,'//iframe[@class="demo-frame"]')
WebUI.switchToFrame(frame, 3)

'DataPickerGridObject'
TestObject dataPickGrid=CustomKeywords.'custom.ObjectRepository.datePicker'()
WebUI.scrollToElement(dataPickGrid, 3)
WebUI.findWebElement(dataPickGrid).click()

while(true)
{
	TestObject month=CustomKeywords.'custom.ObjectRepository.month'()
	String actualMonth=WebUI.findWebElement(month).getText()
	
	TestObject year=CustomKeywords.'custom.ObjectRepository.year'()
	String actualYear=WebUI.findWebElement(year).getText()
	
	if(expectedMonth.equals(actualMonth) && expectedYear.equals(actualYear))
	{
		break;
	}
	
	//TestObject next=CustomKeywords.'custom.ObjectRepository.next'()
	TestObject previous=CustomKeywords.'custom.ObjectRepository.previous'()
	WebUI.findWebElement(previous).click()
}

TestObject allDate=CustomKeywords.'custom.ObjectRepository.allDate'()
List<WebElement> dates=WebUI.findWebElements(allDate, 3)
for(WebElement date:dates)
{
	String actualDate=date.getText()
	if(actualDate.equals(expectedDate))
	{
		date.click()
		break;
	}
}

WebUI.switchToDefaultContent()

