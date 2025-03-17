import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


WebUI.openBrowser(GlobalVariable.InsideWebTable_URL)
WebUI.maximizeWindow()

WebDriver driver=DriverFactory.getWebDriver()

int x=1
int y=1
int z=1

ArrayList<String> header=new ArrayList<>()
ArrayList<String> rowDatas=new ArrayList<>()
LinkedHashMap<String, String> map=new LinkedHashMap<>()

List<String> listOfHeader=WebUI.findWebElements(findTestObject('Object Repository/DynamicWebTable/WebTable',[('Module'):'//table[@class="table table-striped"]//child::thead//child::tr//th']), 3)
List<String> listOfColumnName=WebUI.findWebElements(findTestObject('Object Repository/DynamicWebTable/WebTable',[('Module'):'//table[@class="table table-striped"]//child::tbody//child::tr//td[1]']), 3)

for(int i=0;i<listOfHeader.size();i++) 
	{
		def headerValue=WebUI.getText(findTestObject('Object Repository/DynamicWebTable/WebTable',[('Module'):'//table[@class="table table-striped"]//child::thead//child::tr//th['+x+']']))
		++x
		header.add(headerValue)
}

System.out.println(header)

for(int j=0;j<listOfColumnName.size();j++)
{
	def columnText=WebUI.getText(findTestObject('Object Repository/DynamicWebTable/WebTable',[('Module'):'//table[@class="table table-striped"]//child::tbody//child::tr['+y+']//child::td[1]']))
	//System.out.println(columnText)
	if(columnText.equalsIgnoreCase("Firefox"))
	{
		for(int k=0;k<listOfHeader.size();k++)
		{
			def columnEachDatas=WebUI.getText(findTestObject('Object Repository/DynamicWebTable/WebTable',[('Module'):'//table[@class="table table-striped"]//child::tbody//child::tr['+y+']//td['+z+']']))
			++z
			rowDatas.add(columnEachDatas)
		}
	}
	++y
}

System.out.println(rowDatas)

for(int m=0;m<listOfHeader.size();m++)
{
	map.put(header.get(m), rowDatas.get(m))
}

map.each { key, value -> System.out.println(key+" - "+value) }

 static String getCaseInsensitiveValue(LinkedHashMap<String, String> map, String headerInput)
 {
	 for(String eachHeaderValue: map.keySet())
	 {
		 if(eachHeaderValue.equalsIgnoreCase(headerInput))
		 {
			 return map.get(eachHeaderValue)
		 }
	 }
	 return null
 }
 
 def keyPair=getCaseInsensitiveValue(map, "name")
 System.out.println(keyPair)
 
 //map to excelsheet
 
 Workbook workbook=new XSSFWorkbook()
 Sheet sheet=workbook.createSheet("DataStore")
 
 //create row and cell set cell value
 Row headerRow=sheet.createRow(0)
 for(int n=0;n<header.size();n++)
 {
	 Cell cellIndex=headerRow.createCell(n)
	 cellIndex.setCellValue(header.get(n))
 }
 
 Row firstRow=sheet.createRow(1)
 for(int p=0;p<rowDatas.size();p++)
 {
	 Cell rowCellIndex=firstRow.createCell(p)
	 rowCellIndex.setCellValue(rowDatas.get(p))
 }
 
 FileOutputStream fileOuput=null
 try
 {
	 fileOuput=new FileOutputStream("C:\\Users\\ersak\\Katalon Studio\\Demo\\excel\\output.xlsx")
	 workbook.write(fileOuput)
 }
 
 catch(IOException e)
 {
	 e.printStackTrace()
 }
 
 finally
 {
	 if(fileOuput!=null)
	 {
		 try
		 {
			 fileOuput.close()
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace()
		 }
	 }
	 
	 try
	 {
		 workbook.close()
	 }
	 catch(IOException e)
	 {
		 e.printStackTrace()
	 }
 }