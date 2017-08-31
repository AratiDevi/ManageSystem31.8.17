package purchase_Admin;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import common_Function.RW;
public class ItemCategory  extends RW{

	 

	private static ExtentReports report;
	public synchronized static ExtentReports getReporter(String filePath) { //allow only one thread to access the shared resource,To prevent thread interference.
	    if (report == null) {
	    	report = new ExtentReports(path.concat("Report\\Purchase_Admin_Report.html"));
	        
	        report
	            .addSystemInfo("Host Name", "Priti") //Environment Setup For Report
	            .addSystemInfo("Environment", "QA");
	    }
	    
	    return report;
	}
	public void ItemCategorys(WebDriver driver1) throws Exception {  //(priority=33)

		WebDriver driver = driver1;
	 
	     ArrayList<Row> row= OR_Purchase_m.searchSheet("ItemCategoryURL",2,9);//Functn key,sheetNo.,Column no.// Xpath locator
	     ArrayList<Row> row1=input_purc_m.searchSheet("ItemCategoryURL", 2,0);//Functn key, sheet no,//test data excel
	 	
	     //  URL Path Concat
	  			//String input_purc_URL =url.concat(input_purc_m.getData(2, 169, 2));
		for(int i=0;i<row.size();i++)
			{
				String strValue=""; 
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl=row.get(i).getCell(2).getStringCellValue();
				 for(int j=0;j<row1.size();j++)
				 {
					 if(row.get(i).getCell(0)!=null)
						{
						
						 	if(row1.get(j).getCell(1)!=null)
							{
							  if(row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString())==0)
							  {
								  strValue=row1.get(j).getCell(2).toString();
								  
								  switch(row1.get(j).getCell(2).getCellTypeEnum()){
								     
								     case NUMERIC: 
								    	 strValue=String.valueOf(row1.get(j).getCell(2).getNumericCellValue());
								    	 break;
								     case STRING:
								    	 strValue=row1.get(j).getCell(2).getStringCellValue();
								    	 break;
								     case BOOLEAN:
								    	 strValue=String.valueOf(row1.get(j).getCell(2).getBooleanCellValue());
								    	 break;
								     default:
								    	 strValue=row1.get(j).getCell(2).getStringCellValue();
								    	 break;
								     }
								     
							  }
							}
						}
				 
				 }
				 
				
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();
				
					
					
						
						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
							 click_element(driver, LocatorType, strControl);
							Thread.sleep(2000);
						}

						if (strControlTypeKey.compareTo("Url_Ctrl") == 0) {
							 driver.get(strValue);
							Thread.sleep(2000);

						} 
						
			}
		}
	}

	public void ValidationforAddNewCategory(WebDriver driver1) throws Exception {  //(priority=34)

		WebDriver driver = driver1;
		           
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("ValidationforAddNewCategory",2,9);//Functn key,sheetNo.,Column no.// Xpath locator
	     ArrayList<Row> row1=input_purc_m.searchSheet("ValidationforAddNewCategory", 2,0);//Functn key, sheet no,//test data excel
	 	



		    
	     for(int i=0;i<row.size();i++)
			{
				String strValue=""; 
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl=row.get(i).getCell(2).getStringCellValue();
				 for(int j=0;j<row1.size();j++)
				 {
					 if(row.get(i).getCell(0)!=null)
						{
						
						 	if(row1.get(j).getCell(1)!=null)
							{
							  if(row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString())==0)
							  {
								  strValue=row1.get(j).getCell(2).toString();
								  
								  switch(row1.get(j).getCell(2).getCellTypeEnum()){
								     
								     case NUMERIC: 
								    	 strValue=String.valueOf(row1.get(j).getCell(2).getNumericCellValue());
								    	 break;
								     case STRING:
								    	 strValue=row1.get(j).getCell(2).getStringCellValue();
								    	 break;
								     case BOOLEAN:
								    	 strValue=String.valueOf(row1.get(j).getCell(2).getBooleanCellValue());
								    	 break;
								     default:
								    	 strValue=row1.get(j).getCell(2).getStringCellValue();
								    	 break;
								     }
								     
							  }
							}
						}
				 
				 }
				 
				
					
					if(row.get(i).getCell(10)!=null)
					{
							
						
						String strControlTypeKey=row.get(i).getCell(10).toString();

						if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {
							
							if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
								
								click_element(driver, LocatorType, strControl); 
								Thread.sleep(5000);
							}

							if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
								
								dropdown(driver, LocatorType, strControl, strValue);
								Thread.sleep(2000);
																
							}

							if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
								
								sendkeys(driver, LocatorType, strControl, strValue); 
								Thread.sleep(4000);
							}

							if (strControlTypeKey.compareTo("Alert_accept") == 0) {
								
								click_element(driver, LocatorType, strControl); 
								Thread.sleep(2000);
								Alert(driver);
								Thread.sleep(4000);
							}
							
							
							if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
								
								clear_element(driver, LocatorType, strControl); 																										
								Thread.sleep(2000);
							}
								
					}
			}
			}
			}
	 
	
	public void DuplicateAddNewCategory(WebDriver driver1) throws Exception {  //(priority=34)

		WebDriver driver = driver1;
		           
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddNewCategory",2,9);//Functn key,sheetNo.,Column no.// Xpath locator
	     ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddNewCategory", 2,0);//Functn key, sheet no,//test data excel
	 	

	     //  URL Path Concat
			String input_purc_URL =url.concat(input_purc_m.getData(2, 180, 2));

		    
	     for(int i=0;i<row.size();i++)
			{
				String strValue=""; 
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl=row.get(i).getCell(2).getStringCellValue();
				 for(int j=0;j<row1.size();j++)
				 {
					 if(row.get(i).getCell(0)!=null)
						{
						
						 	if(row1.get(j).getCell(1)!=null)
							{
							  if(row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString())==0)
							  {
								  strValue=row1.get(j).getCell(2).toString();
								  
								  switch(row1.get(j).getCell(2).getCellTypeEnum()){
								     
								     case NUMERIC: 
								    	 strValue=String.valueOf(row1.get(j).getCell(2).getNumericCellValue());
								    	 break;
								     case STRING:
								    	 strValue=row1.get(j).getCell(2).getStringCellValue();
								    	 break;
								     case BOOLEAN:
								    	 strValue=String.valueOf(row1.get(j).getCell(2).getBooleanCellValue());
								    	 break;
								     default:
								    	 strValue=row1.get(j).getCell(2).getStringCellValue();
								    	 break;
								     }
								     
							  }
							}
						}
				 
				 }
				 
				
					
					if(row.get(i).getCell(10)!=null)
					{
							
						
						String strControlTypeKey=row.get(i).getCell(10).toString();

						if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {
							
							if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
								
								click_element(driver, LocatorType, strControl); 
								Thread.sleep(4000);
							}

							if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
								
								dropdown(driver, LocatorType, strControl, strValue);
								Thread.sleep(2000);
																
							}

							if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
								
								sendkeys(driver, LocatorType, strControl, strValue); 
								Thread.sleep(4000);
							}

							if (strControlTypeKey.compareTo("Url_Ctrl") == 0) {
								driver.get(input_purc_URL); 
								Thread.sleep(5000);

							}

							if (strControlTypeKey.compareTo("Alert_accept") == 0) {
								
								click_element(driver, LocatorType, strControl); 
								Thread.sleep(2000);
								Alert(driver);
								Thread.sleep(4000);
							}
							
							
							if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
								
								clear_element(driver, LocatorType, strControl); 																										
								Thread.sleep(2000);
							}
								
					}
			}
			}
			}
	 
	public void SearchAddNewCategory(WebDriver driver1) throws Exception {  //(priority=34)

		WebDriver driver = driver1;
		           
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddNewCategory",2,9);//Functn key,sheetNo.,Column no.// Xpath locator
	     ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddNewCategory", 2,0);//Functn key, sheet no,//test data excel
	 	



		    
	     for(int i=0;i<row.size();i++)
			{
				String strValue=""; 
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl=row.get(i).getCell(2).getStringCellValue();
				 for(int j=0;j<row1.size();j++)
				 {
					 if(row.get(i).getCell(0)!=null)
						{
						
						 	if(row1.get(j).getCell(1)!=null)
							{
							  if(row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString())==0)
							  {
								  strValue=row1.get(j).getCell(2).toString();
								  
								  switch(row1.get(j).getCell(2).getCellTypeEnum()){
								     
								     case NUMERIC: 
								    	 strValue=String.valueOf(row1.get(j).getCell(2).getNumericCellValue());
								    	 break;
								     case STRING:
								    	 strValue=row1.get(j).getCell(2).getStringCellValue();
								    	 break;
								     case BOOLEAN:
								    	 strValue=String.valueOf(row1.get(j).getCell(2).getBooleanCellValue());
								    	 break;
								     default:
								    	 strValue=row1.get(j).getCell(2).getStringCellValue();
								    	 break;
								     }
								     
							  }
							}
						}
				 
				 }
				 
				
					
					if(row.get(i).getCell(10)!=null)
					{
							
						
						String strControlTypeKey=row.get(i).getCell(10).toString();

						if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {
							
							if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
								
								click_element(driver, LocatorType, strControl); 
								Thread.sleep(5000);
							}

							if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
								
								dropdown(driver, LocatorType, strControl, strValue);
								Thread.sleep(2000);
																
							}

							if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
								
								sendkeys(driver, LocatorType, strControl, strValue); 
								Thread.sleep(4000);
							}

							if (strControlTypeKey.compareTo("Url_Ctrl") == 0) {
								driver.get(strValue); 
								Thread.sleep(2000);

							}

							if (strControlTypeKey.compareTo("Alert_accept") == 0) {
								
								click_element(driver, LocatorType, strControl); 
								Thread.sleep(2000);
								Alert(driver);
								Thread.sleep(4000);
							}
							
							
							if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
								
								clear_element(driver, LocatorType, strControl); 																										
								Thread.sleep(2000);
							}
								
					}
			}
			}
			}
	 
	
		
		public void EditAddNewCategory(WebDriver driver1) throws Exception {  //(priority=34)

			WebDriver driver = driver1;	
			
			
			 ArrayList<Row> row= OR_Purchase_m.searchSheet("EditAddNewCategory",2,9);//Functn key,sheetNo.,Column no.// Xpath locator
		     ArrayList<Row> row1=input_purc_m.searchSheet("EditAddNewCategory", 2,0);//Functn key, sheet no,//test data excel
		 	


			    
				for(int i=0;i<row.size();i++)
				{
					String strValue=""; 
					String LocatorType=row.get(i).getCell(1).getStringCellValue();
					String strControl=row.get(i).getCell(2).getStringCellValue();
					 for(int j=0;j<row1.size();j++)
					 {
						 if(row.get(i).getCell(0)!=null)
							{
							
							 	if(row1.get(j).getCell(1)!=null)
								{
								  if(row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString())==0)
								  {
									  strValue=row1.get(j).getCell(2).toString();
									  
									  switch(row1.get(j).getCell(2).getCellTypeEnum()){
									     
									     case NUMERIC: 
									    	 strValue=String.valueOf(row1.get(j).getCell(2).getNumericCellValue());
									    	 break;
									     case STRING:
									    	 strValue=row1.get(j).getCell(2).getStringCellValue();
									    	 break;
									     case BOOLEAN:
									    	 strValue=String.valueOf(row1.get(j).getCell(2).getBooleanCellValue());
									    	 break;
									     default:
									    	 strValue=row1.get(j).getCell(2).getStringCellValue();
									    	 break;
									     }
									     
								  }
								}
							}
					 
					 }
					 
					
						
						if(row.get(i).getCell(10)!=null)
						{
								
							
							String strControlTypeKey=row.get(i).getCell(10).toString();

							if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {
								if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
									click_element(driver, LocatorType, strControl); 
									Thread.sleep(4000);
								}

								if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
								
									dropdown(driver, LocatorType, strControl, strValue);
									Thread.sleep(2000);
									
									
								}

								if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
									sendkeys(driver, LocatorType, strControl, strValue); 
									Thread.sleep(4000);
								}

								if (strControlTypeKey.compareTo("Alert_accept") == 0) {
									click_element(driver, LocatorType, strControl); 
									Thread.sleep(2000);
									Alert(driver);
									Thread.sleep(4000);
								}
								

								
								
								
								if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
									clear_element(driver, LocatorType, strControl); 																										
									Thread.sleep(2000);
								}

								
								
						}
				}
				}
				}
		public void SearchEditAddNewCategory(WebDriver driver1) throws Exception {  //(priority=34)

			WebDriver driver = driver1;	
			
			
			 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditAddNewCategory",2,9);//Functn key,sheetNo.,Column no.// Xpath locator
		     ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditAddNewCategory", 2,0);//Functn key, sheet no,//test data excel
		 	


			    
				for(int i=0;i<row.size();i++)
				{
					String strValue=""; 
					String LocatorType=row.get(i).getCell(1).getStringCellValue();
					String strControl=row.get(i).getCell(2).getStringCellValue();
					 for(int j=0;j<row1.size();j++)
					 {
						 if(row.get(i).getCell(0)!=null)
							{
							
							 	if(row1.get(j).getCell(1)!=null)
								{
								  if(row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString())==0)
								  {
									  strValue=row1.get(j).getCell(2).toString();
									  
									  switch(row1.get(j).getCell(2).getCellTypeEnum()){
									     
									     case NUMERIC: 
									    	 strValue=String.valueOf(row1.get(j).getCell(2).getNumericCellValue());
									    	 break;
									     case STRING:
									    	 strValue=row1.get(j).getCell(2).getStringCellValue();
									    	 break;
									     case BOOLEAN:
									    	 strValue=String.valueOf(row1.get(j).getCell(2).getBooleanCellValue());
									    	 break;
									     default:
									    	 strValue=row1.get(j).getCell(2).getStringCellValue();
									    	 break;
									     }
									     
								  }
								}
							}
					 
					 }
					 
					
						
						if(row.get(i).getCell(10)!=null)
						{
								
							
							String strControlTypeKey=row.get(i).getCell(10).toString();

							if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {
								if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
									click_element(driver, LocatorType, strControl); 
									Thread.sleep(4000);
								}

								if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
								
									dropdown(driver, LocatorType, strControl, strValue);
									Thread.sleep(2000);
									
									
								}

								if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
									sendkeys(driver, LocatorType, strControl, strValue); 
									Thread.sleep(4000);
								}

								if (strControlTypeKey.compareTo("Alert_accept") == 0) {
									click_element(driver, LocatorType, strControl); 
									Thread.sleep(2000);
									Alert(driver);
									Thread.sleep(4000);
								}
								

								
								
								
								if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
									clear_element(driver, LocatorType, strControl); 																										
									Thread.sleep(2000);
								}

								
								
						}
				}
				}
				}
		
		public void DeleteCategory(WebDriver driver1) throws Exception {  //(priority=34)

			WebDriver driver = driver1;	
			
			 ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteCategory",2,9);//Functn key,sheetNo.,Column no.// Xpath locator
		     ArrayList<Row> row1=input_purc_m.searchSheet("DeleteCategory", 2,0);//Functn key, sheet no,//test data excel
		 	


			    
				for(int i=0;i<row.size();i++)
				{
					String strValue=""; 
					String LocatorType=row.get(i).getCell(1).getStringCellValue();
					String strControl=row.get(i).getCell(2).getStringCellValue();
					 for(int j=0;j<row1.size();j++)
					 {
						 if(row.get(i).getCell(0)!=null)
							{
							
							 	if(row1.get(j).getCell(1)!=null)
								{
								  if(row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString())==0)
								  {
									  strValue=row1.get(j).getCell(2).toString();
									  
									  switch(row1.get(j).getCell(2).getCellTypeEnum()){
									     
									     case NUMERIC: 
									    	 strValue=String.valueOf(row1.get(j).getCell(2).getNumericCellValue());
									    	 break;
									     case STRING:
									    	 strValue=row1.get(j).getCell(2).getStringCellValue();
									    	 break;
									     case BOOLEAN:
									    	 strValue=String.valueOf(row1.get(j).getCell(2).getBooleanCellValue());
									    	 break;
									     default:
									    	 strValue=row1.get(j).getCell(2).getStringCellValue();
									    	 break;
									     }
									     
								  }
								}
							}
					 
					 }
					 
					
						
						if(row.get(i).getCell(10)!=null)
						{
								
							
							String strControlTypeKey=row.get(i).getCell(10).toString();

							if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {
								if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
									click_element(driver, LocatorType, strControl); 
									Thread.sleep(2000);
								}

								if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
								
									dropdown(driver, LocatorType, strControl, strValue);
									Thread.sleep(2000);
									
									
								}

								if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
									sendkeys(driver, LocatorType, strControl, strValue); 
									Thread.sleep(2000);
								}

								if (strControlTypeKey.compareTo("Alert_accept") == 0) {
									click_element(driver, LocatorType, strControl); 
									Thread.sleep(2000);
									Alert(driver);
									Thread.sleep(2000);
									Alert(driver);
									Thread.sleep(2000);
									
									
								}
								

														
								if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
									clear_element(driver, LocatorType, strControl); 																										
									Thread.sleep(2000);
								}
								
								if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {
									gettext(driver,LocatorType, strControl);
				                      Thread.sleep(2000);
									
									
									}
								
							
						}
				}
				}
				}
		public void SearchDeleteCategory(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;	
			
			 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchDeleteCategory",2,9);//Functn key,sheetNo.,Column no.// Xpath locator
		     ArrayList<Row> row1=input_purc_m.searchSheet("SearchDeleteCategory", 2,0);//Functn key, sheet no,//test data excel
		 	


			    
				for(int i=0;i<row.size();i++)
				{
					String strValue=""; 
					String LocatorType=row.get(i).getCell(1).getStringCellValue();
					String strControl=row.get(i).getCell(2).getStringCellValue();
					 for(int j=0;j<row1.size();j++)
					 {
						 if(row.get(i).getCell(0)!=null)
							{
							
							 	if(row1.get(j).getCell(1)!=null)
								{
								  if(row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString())==0)
								  {
									  strValue=row1.get(j).getCell(2).toString();
									  
									  switch(row1.get(j).getCell(2).getCellTypeEnum()){
									     
									     case NUMERIC: 
									    	 strValue=String.valueOf(row1.get(j).getCell(2).getNumericCellValue());
									    	 break;
									     case STRING:
									    	 strValue=row1.get(j).getCell(2).getStringCellValue();
									    	 break;
									     case BOOLEAN:
									    	 strValue=String.valueOf(row1.get(j).getCell(2).getBooleanCellValue());
									    	 break;
									     default:
									    	 strValue=row1.get(j).getCell(2).getStringCellValue();
									    	 break;
									     }
									     
								  }
								}
							}
					 
					 }
					 
					
						
						if(row.get(i).getCell(10)!=null)
						{
								
							
							String strControlTypeKey=row.get(i).getCell(10).toString();

							if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {
								if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
									click_element(driver, LocatorType, strControl); 
									Thread.sleep(2000);
								}

								if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
								
									dropdown(driver, LocatorType, strControl, strValue);
									Thread.sleep(2000);
									
									
								}

								if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
									sendkeys(driver, LocatorType, strControl, strValue); 
									Thread.sleep(2000);
								}

								if (strControlTypeKey.compareTo("Alert_accept") == 0) {
									click_element(driver, LocatorType, strControl); 
									Thread.sleep(2000);
									Alert(driver);
									Thread.sleep(2000);
									Alert(driver);
									Thread.sleep(2000);
									Alert(driver);
									Thread.sleep(2000);
									
								}
								

														
								if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
									clear_element(driver, LocatorType, strControl); 																										
									Thread.sleep(2000);
								}
								
								if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {
									gettext(driver,LocatorType, strControl);
				                      Thread.sleep(2000);
									
									
									}
								
							
						}
				}
				}
				}
		
		}

		