import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.WebTable_URL)
WebUI.maximizeWindow()

WebUI.executeJavaScript("window.scrollBy(0,300)", null)

TestObject username=new TestObject()
username.addProperty('xpath',ConditionType.EQUALS,'//input[@type="text"]')

TestObject password=new TestObject()
password.addProperty('xpath',ConditionType.EQUALS,'//input[@type="password"]')

def user=WebUI.findWebElement(username)
def pass=WebUI.findWebElement(password)

WebUI.executeJavaScript("arguments[0].value='student'; arguments[1].value='Password123'", Arrays.asList(user, pass))
//WebUI.executeJavaScript("arguments[0].setAttribute('value','student')", username)