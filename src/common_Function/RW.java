
package common_Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RW
{
	
	public static String path="C:\\Users\\Arati\\workspace\\ManageSystem3\\"; //Workspace-->Project-->excel path
	
	protected int k=1000; 
	
	public String pass="PASS";
	public String fail="FAIL";
	
	/*//---------------------------------- STAGE  ----------------------------------------------------------------------------------------//
	
    public ExcelRead jibe_config = new ExcelRead(path.concat("src\\Jibe_Config\\Jibe_Config.xlsx"));  // Read config data from Excel
    
    public ExcelRead OR_Purchase_m = new ExcelRead(path.concat("src\\object\\OR_Purchase_Stage.xlsx")); // Read Purchase element locators
    
    public ExcelRead input_purc_m = new ExcelRead(path.concat("src\\Input_Purchase\\Purchase_Input_Stage.xlsx")); //Read purchase input data
    
    public WriteExcel write_data = new WriteExcel(path.concat("src\\Input_Purchase\\Purchase_Input_Stage.xlsx"));// printing Status in excel
*/ 
    
	
//---------------------------------- LOCAL  ----------------------------------------------------------------------------------------//
	
    public ExcelRead jibe_config = new ExcelRead(path.concat("src\\Jibe_Config\\Jibe_Config.xlsx"));  // Read config data from Excel
    
    public ExcelRead OR_Purchase_m = new ExcelRead(path.concat("src\\object\\OR_Purchase_local.xlsx")); // Read Purchase element locators
    
    public ExcelRead input_purc_m = new ExcelRead(path.concat("src\\Input_Purchase\\Purchase_Input_local.xlsx")); //Read purchase input data
    
    public WriteExcel write_data = new WriteExcel(path.concat("src\\Input_Purchase\\Purchase_Input_local.xlsx"));// printing Status in excel
    
    
    
    public String url = jibe_config.getData(0, 1, 1); //Get URL From excel
    
  
     //All Keyword
     
     public static String radioButton(WebDriver driver, String locatorType, String locatorvalue) throws Exception
     
     {
     
      switch(locatorType)
       {

       case "id":
              driver.findElement(By.id(locatorvalue)).click();
              break;

       case "name":
    	     driver.findElement(By.name(locatorvalue)).click();
             break;

       case "xpath":
    	     driver.findElement(By.xpath(locatorvalue)).click();
             break;
             
       case "linkText":
    	     driver.findElement(By.linkText(locatorvalue)).click();
             break;

       }

       Thread.sleep(1000);
       
       return null;

     }

    public static String click_element(WebDriver driver, String locatorType, String locatorvalue) throws Exception
     
     {
     
      switch(locatorType)
       {

       case "id":
              driver.findElement(By.id(locatorvalue)).click();
              break;

       case "name":
    	     driver.findElement(By.name(locatorvalue)).click();
             break;

       case "xpath":
    	     driver.findElement(By.xpath(locatorvalue)).click();
             break;
             
       case "linkText":
    	     driver.findElement(By.linkText(locatorvalue)).click();
             break;

       }

       Thread.sleep(1000);
       
       return null;

     }


    public static String dropdown(WebDriver driver, String locatorType, String locatorvalue,String pamarValue) throws Exception
     
     {
     
      switch(locatorType)
       {

       case "id":
              driver.findElement(By.id(locatorvalue)).sendKeys(pamarValue);
              break;

       case "name":
    	     driver.findElement(By.name(locatorvalue)).sendKeys(pamarValue);
             break;

       case "xpath":
    	     driver.findElement(By.xpath(locatorvalue)).sendKeys(pamarValue);
             break;
             
       case "linkText":
    	     driver.findElement(By.linkText(locatorvalue)).sendKeys(pamarValue);
             break;

       }

       Thread.sleep(1000);
       
       return null;

     }


    public static String sendkeys(WebDriver driver, String locatorType, String strControl1, String pamarValue) throws Exception
     
     {
     
      switch(locatorType)
       {

       case "id":
              driver.findElement(By.id(strControl1)).sendKeys(pamarValue);
              break;

       case "name":
    	     driver.findElement(By.name(strControl1)).sendKeys(pamarValue);
             break;

       case "xpath":
    	     driver.findElement(By.xpath(strControl1)).sendKeys(pamarValue);
             break;
             
       case "linkText":
    	     driver.findElement(By.linkText(strControl1)).sendKeys(pamarValue);
             break;

       }

       Thread.sleep(1000);
       
       return null;

     }


    public static String clear_element(WebDriver driver, String locatorType, String locatorvalue) throws Exception
     
     {
     
      switch(locatorType)
       {

       case "id":
              driver.findElement(By.id(locatorvalue)).clear();
              break;

       case "name":
    	     driver.findElement(By.name(locatorvalue)).clear();
             break;

       case "xpath":
    	     driver.findElement(By.xpath(locatorvalue)).clear();
             break;
             
       case "linkText":
    	     driver.findElement(By.linkText(locatorvalue)).clear();
             break;

       }

       Thread.sleep(1000);
       
       return null;

     }


    public static String checkbox_element(WebDriver driver, String locatorType, String locatorvalue) throws Exception
     
     {
     
      switch(locatorType)
       {

       case "id":
              driver.findElement(By.id(locatorvalue)).click();
              break;

       case "name":
    	     driver.findElement(By.name(locatorvalue)).click();
             break;

       case "xpath":
    	     driver.findElement(By.xpath(locatorvalue)).click();
             break;
             
       case "linkText":
    	     driver.findElement(By.linkText(locatorvalue)).click();
             break;

       }

       Thread.sleep(1000);
       
       return null;

     }

    public static String dropdownCheckbox(WebDriver driver, String locatorType, String locatorvalue1,String locatorvalue2,String locatorvalue3) throws Exception

    {

     switch(locatorType)
      {

      case "id":
         driver.findElement(By.id(locatorvalue1)).click();   // Arrow
         Thread.sleep(1000);
         driver.findElement(By.id(locatorvalue2)).click();   // Select CheckBox
         Thread.sleep(1000);
         driver.findElement(By.id(locatorvalue3)).click();   // OK Button
             break;

      case "name":
         driver.findElement(By.name(locatorvalue1)).click();   // Arrow
         Thread.sleep(1000); 
         driver.findElement(By.name(locatorvalue2)).click();   // Select CheckBox
         Thread.sleep(1000);
         driver.findElement(By.name(locatorvalue3)).click();   // OK Button
            break;

      case "xpath":
         driver.findElement(By.xpath(locatorvalue1)).click();    // Arrow
         Thread.sleep(1000);
         driver.findElement(By.xpath(locatorvalue2)).click();    // Select CheckBox
         Thread.sleep(1000);
         driver.findElement(By.xpath(locatorvalue3)).click();    // OK Button
            break;
            
      case "linkText":
         driver.findElement(By.linkText(locatorvalue1)).click();    // Arrow
         Thread.sleep(1000);
         driver.findElement(By.linkText(locatorvalue2)).click();    // Select CheckBox
         Thread.sleep(1000);
         driver.findElement(By.linkText(locatorvalue3)).click();    // OK Button
            break;

      }

      Thread.sleep(1000);
      
      return null;

    }


    public static String uploadFile(WebDriver driver, String locatorType, String locatorvalue1, String locatorvalue2, String path, String locatorvalue3, String locatorvalue4) throws Exception
     
     {
     
      switch(locatorType)
       {

       case "id":
              driver.findElement(By.id(locatorvalue1)).click();        // Add Attachment
              
              Thread.sleep(1000);
             
              driver.findElement(By.id(locatorvalue2)).sendKeys(path); // Select File path
              
              Thread.sleep(1000);
              
              driver.findElement(By.id(locatorvalue3)).click();        // Upload
              
              Thread.sleep(1000);
              
              driver.findElement(By.id(locatorvalue4)).click();        // Close
              
              
              break;

       case "name":
    	      driver.findElement(By.name(locatorvalue1)).click();        // Add Attachment
    	      
    	      Thread.sleep(1000);
              
              driver.findElement(By.name(locatorvalue2)).sendKeys(path); // Select File path
              
              Thread.sleep(1000);
              
              driver.findElement(By.id(locatorvalue3)).click();          // Upload
              
              Thread.sleep(1000);
              
              driver.findElement(By.name(locatorvalue4)).click();        // Close
    	     
    	     
             break;

       case "xpath":
    	      driver.findElement(By.xpath(locatorvalue1)).click();        // Add Attachment
    	      
    	      Thread.sleep(1000);
             
              driver.findElement(By.xpath(locatorvalue2)).sendKeys(path); // Select File path
              
              Thread.sleep(1000);
              
              driver.findElement(By.id(locatorvalue3)).click();           // Upload
              
              Thread.sleep(1000);
              
              driver.findElement(By.xpath(locatorvalue4)).click();        // Close
              
              Thread.sleep(1000);
              
             break;
             
       case "linkText":
    	      driver.findElement(By.linkText(locatorvalue1)).click();        // Add Attachment
    	      
    	      Thread.sleep(1000);
             
              driver.findElement(By.linkText(locatorvalue2)).sendKeys(path); // Select File path
              
              Thread.sleep(1000);
              
              driver.findElement(By.id(locatorvalue3)).click();              // Upload
              
              Thread.sleep(1000);
              
              driver.findElement(By.linkText(locatorvalue4)).click();        // Close
              
             break;

       }
      Thread.sleep(1000);
      
      return null;

    }


    	public static String frameSwitchto(WebDriver driver, String locatorType, String locatorvalue) throws Exception
    	 
    	 {
    	 
    	  switch(locatorType)
    	   {

    	   case "id":
    		     WebElement iframe1=driver.findElement(By.id(locatorvalue));
    	          
    	         driver.switchTo().frame(iframe1);
    	          break;

    	   case "name":
    		     WebElement iframe2=driver.findElement(By.name(locatorvalue));
    		   
    		     driver.switchTo().frame(iframe2);
    	         break;

    	   case "xpath":
             WebElement iframe3=driver.findElement(By.xpath(locatorvalue));
    		   
    		     driver.switchTo().frame(iframe3);
    	         break;
    	         
    	   case "linkText":
    		     WebElement iframe4=driver.findElement(By.linkText(locatorvalue));
    		   
    		     driver.switchTo().frame(iframe4);
    	         break;
    	         
    	   case "cssSelector":
    		     WebElement iframe5=driver.findElement(By.cssSelector(locatorvalue));
    		   
    		     driver.switchTo().frame(iframe5);
    	         break;

    	   }

    	   Thread.sleep(1000);
    	   
    	   return null;

    	 }
    	
    	
    	/*public static String WindowPrentVariable(WebDriver driver) throws Exception                          
     	 
     	 {
     		  		
     			  String HandleBefore=driver.getWindowHandle();
     			    
     	          return null ;
     	 

     	   }*/
    	
    	
    	public static String WindowSwitchto(WebDriver driver) throws Exception
    	 
    	 {
    		
    		    // String HandleBefore=driver.getWindowHandle();
    	         for (String handle : driver.getWindowHandles()) {          //Switch to new window
    		    	 
    			 driver.switchTo().window(handle);}
    	        
    	         Thread.sleep(1000);
    	   
    	         return null ;

    	 }
    	
    	
    	
    	
    	
    	/*public static String WindowSwitchBack(WebDriver driver) throws Exception                          
     	 
     	 {
     		  		
     			  String HandleBefore=driver.getWindowHandle();
     			  
     			  driver.switchTo().window(HandleBefore);
     			    
     	          return null ;
     	 

     	   }*/
    	


    	public static String Alert(WebDriver driver) throws Exception
    	 
    	 {
    		Alert alert = driver.switchTo().alert();                                         //Alert handling for Please enter a effect name
    	     alert.accept();
    	     Thread.sleep(4000);
    	     return null ;

    	 }
    	
    	public static String gettext(WebDriver driver, String locatorType, String locatorvalue ) throws Exception
    	 
    	 {
    	 
    	  switch(locatorType)
    	   {

    	   case "id":  	        
    	         driver.findElement(By.id(locatorvalue)).getText();  	        
    	          break;

    	   case "name":
    		   
    		     driver.findElement(By.name(locatorvalue)).getText();
    	         break;

    	   case "xpath":
    		    
    		    driver.findElement(By.xpath(locatorvalue)).getText();   
    	
    	         break;
    	         
    	   case "linkText":
    		   
    		   driver.findElement(By.linkText(locatorvalue)).getText();
    	         break;

    	   }
    	 

    	   Thread.sleep(1000);
    	   
    	   return null;

    	
	 
   	  
   	 }
   	
    	public static String frameSwitchBack(WebDriver driver) throws Exception                          
   	 
   	 {
   		  		
   			  driver.switchTo().defaultContent();
   			    
   	          return null ;
   	 

   	   }
   	
   	
   	public static String refresh(WebDriver driver, String locatorType, String locatorvalue) throws Exception                               
   	 
   	 {
   		
   		switch(locatorType)
   		   {

   		   case "id":
   			     driver.navigate().refresh();
   			     driver.findElement(By.id(locatorvalue)).click(); 
   			    
   		          break;

   		   case "name":
   			   driver.navigate().refresh();
   			     driver.findElement(By.name(locatorvalue)).click(); 
   			     
   		         break;

   		   case "xpath":
   			   driver.navigate().refresh();
   			   driver.findElement(By.xpath(locatorvalue)).click();   
   	          
   		         break;
   		         
   		   case "linkText":
   			   driver.navigate().refresh();
   			   driver.findElement(By.linkText(locatorvalue)).click(); 
   			    
   		         break;
   		         
   		   case "cssSelector":
   			   driver.navigate().refresh();
   			   driver.findElement(By.cssSelector(locatorvalue)).click(); 
   			     
   		         break;

   		   }
   	   
   	   return null ;
   	 

   	   }



    public static void close_driver(WebDriver driver)

    {
    	driver.close();
    	
    }

    }