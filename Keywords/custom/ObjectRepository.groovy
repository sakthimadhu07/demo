package custom

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject






public class ObjectRepository {
	
	@Keyword
	static TestObject datePicker()
	{
		TestObject object=new TestObject()
		object.addProperty('xpath',ConditionType.EQUALS,'//input[@id="datepicker"]')
		return object
	}
	
	@Keyword
	static TestObject month()
	{
		TestObject monthobject=new TestObject()
		monthobject.addProperty('xpath',ConditionType.EQUALS,'//span[@class="ui-datepicker-month"]')
		return monthobject
	}
	
	@Keyword
	static TestObject year()
	{
		TestObject yearobject=new TestObject()
		yearobject.addProperty('xpath',ConditionType.EQUALS,'//span[@class="ui-datepicker-year"]')
		return yearobject
	}
	
	@Keyword
	static TestObject allDate()
	{
		TestObject dataobjects=new TestObject()
		dataobjects.addProperty('xpath',ConditionType.EQUALS,'//table[@class="ui-datepicker-calendar"]//tbody//tr//td//a')
		return dataobjects
	}
	
	@Keyword
	static TestObject next()
	{
		TestObject nextObject=new TestObject()
		nextObject.addProperty('xpath',ConditionType.EQUALS,'//span[@class="ui-icon ui-icon-circle-triangle-e"]')
		return nextObject
	}
	
	@Keyword
	static TestObject previous()
	{
		TestObject previousObject=new TestObject()
		previousObject.addProperty('xpath',ConditionType.EQUALS,'//span[@class="ui-icon ui-icon-circle-triangle-w"]')
		return previousObject
	}
}
