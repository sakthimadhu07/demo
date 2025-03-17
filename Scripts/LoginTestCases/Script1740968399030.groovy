import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import custom.LoginPractice as LoginPractice

WebUI.openBrowser(GlobalVariable.WebTable_URL)

WebUI.maximizeWindow()

TestObject usernam = new TestObject()
usernam.addProperty('xpath', ConditionType.EQUALS, '//input[@type="text"]')

TestObject password = CustomKeywords.'custom.LoginPractice.password'()
TestObject button=CustomKeywords.'custom.LoginPractice.button'()
TestObject logout=CustomKeywords.'custom.LoginPractice.logout'()

WebUI.scrollToElement(usernam, 3)
WebUI.setText(usernam, UserNames)

WebUI.scrollToElement(password, 3)
WebUI.setText(password, PassWords)

WebUI.click(button)

WebUI.delay(5)

//WebUI.acceptAlert()

WebUI.click(logout)

