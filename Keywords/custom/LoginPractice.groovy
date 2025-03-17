package custom

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject






public class LoginPractice {

	@Keyword
	static TestObject password() {
		TestObject word=new TestObject()
		word.addProperty('xpath',ConditionType.EQUALS,'//input[@type="password"]')
		return word
	}

	@Keyword
	static TestObject button() {
		TestObject ton=new TestObject()
		ton.addProperty('xpath',ConditionType.EQUALS,'//button[@id="submit"]')
		return ton
	}

	@Keyword
	static TestObject logout() {
		TestObject out=new TestObject()
		out.addProperty('xpath',ConditionType.EQUALS,'//a[contains(text(),"Log out")]')
		return out
	}
}
