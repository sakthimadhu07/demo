package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class frame {

	@Keyword
	def iframeValidation(TestObject to) {
		WebDriver driver=DriverFactory.getWebDriver()
		driver.switchTo().defaultContent()
		List<WebElement> frames=driver.findElements(By.tagName("iframe"))
		for(WebElement iframe:frames) {
			def frame=iframe.getAttribute("id")
			driver.switchTo().frame(frame)
			boolean value=WebUI.findWebElements(to, 3).size()!=0
			if(value) {
				System.out.println("driver switched to iframe and found webelement")
				break
			}

			else {
				driver.switchTo().defaultContent()
				System.out.println("WebElement not found so driver swichted out of frame")
			}
		}
	}
}
