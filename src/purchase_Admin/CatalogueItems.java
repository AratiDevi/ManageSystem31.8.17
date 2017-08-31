package purchase_Admin;

import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import common_Function.RW;

public class CatalogueItems extends RW{
	private static ExtentReports report;

	public synchronized static ExtentReports getReporter(String filePath) { //allow only one thread to access the shared resource,To prevent thread interference.
	    if (report == null) {
	    	report = new ExtentReports(path.concat("Report.html"));
	        
	        report
	            .addSystemInfo("Host Name", "Arati") //Environment Setup For Report
	            .addSystemInfo("Environment", "QA");
	    }
	    
	    return report;
		}
	
					
		public void ManageSystems(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;

			ArrayList<Row> row= OR_Purchase_m.searchSheet("ManageSystem",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		    ArrayList<Row> row1=input_purc_m.searchSheet("ManageSystem", 3,0);//Functn key, sheet no, test data excel
		    
		    
		    
		    String input_purch_URL=url.concat(input_purc_m.getData(3, 4, 4));
				 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Url_Ctrl") == 0) {
						driver.get(input_purch_URL);
						Thread.sleep(k);
						
						String actualTitle=driver.getTitle().trim();
						String expectedTitle=" 	Manage System ".trim();
						Assert.assertEquals(actualTitle, expectedTitle);
						
						if(expectedTitle.equals(actualTitle)){
							
							System.out.println("Title Match");
							Thread.sleep(1000);
						}
						else{
							System.out.println("Title doesnt Match");
							Thread.sleep(1000);
						}
						
						

					}
									
				}
			}
		}
		
		
	

		public void SearchFunction(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
			 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchFunction",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			 ArrayList<Row> row1=input_purc_m.searchSheet("SearchFunction", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			
			
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();
			
				
				{
		
					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
						

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
	              
					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            

					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
						
					
					}
				}
			}
		}
	}//}
		

			
								
		
		public void ValidationForAddCatalogue(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
			 ArrayList<Row> row= OR_Purchase_m.searchSheet("ValidationForAddCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			 ArrayList<Row> row1=input_purc_m.searchSheet("ValidationForAddCatalogue", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();
			
				
				{
				
	

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
						

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
	              
					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					

				}
			}
		}
	}}
		
		
		
		public void DuplicateAddCatalogue(WebDriver driver1) throws Exception {  

			WebDriver driver = driver1;
			
			 ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			 ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddCatalogue", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
						

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
	              
					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

				}
			}
		}
	}

				 
		 public void SearchAddCatalogue(WebDriver driver1) throws Exception {  

				WebDriver driver = driver1;
				
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddCatalogue", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}
				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
							

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						              					

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
							
						
						}

					}
				}
			}
		}
		 
		
		 
		 
		 public void EditCatalogue(WebDriver driver1) throws Exception {  

				WebDriver driver = driver1;
				
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("EditCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				  ArrayList<Row> row1=input_purc_m.searchSheet("EditCatalogue", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
							

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
	                 
						

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						

						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

					}
				}
			}
		}
		 
		 
		 
		 public void SearchEditedAddCatalogue(WebDriver driver1) throws Exception {  

				WebDriver driver = driver1;
				
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedAddCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedAddCatalogue", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}
				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
							

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
									
						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
							
						
						}

					}
				}
			}
		}
		 
		 
		 public void ValidationForAddSubCatalogue(WebDriver driver1) throws Exception {  

				WebDriver driver = driver1;
				
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("ValidationForAddSubCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("ValidationForAddSubCatalogue", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}
				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
							

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
									
						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

					}
				}
			}
		}
		 
		 
		 
		 public void DuplicateAddSubCatalogue(WebDriver driver1) throws Exception {  

				WebDriver driver = driver1;
				
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddSubCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddSubCatalogue", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}
				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
							

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
									
						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

					}
				}
			}
		}
		 	 
		 
		 public void SearchAddSubCatalogue(WebDriver driver1) throws Exception {  

				WebDriver driver = driver1;
				
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddSubCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddSubCatalogue", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
							

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						       
						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
					}
				}
			}
		}
		 
		
		public void EditSubCatalogue(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("EditSubCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("EditSubCatalogue", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

							click_element(driver, "class", strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

					}
				}
			}
		}
		
		public void SearchEditedAddSubCatalogue(WebDriver driver1) throws Exception { // (priority=26)

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedAddSubCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				  ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedAddSubCatalogue", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

						
						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
					}
				}
			}
		}
		
			
		
		public void ValidationForAddStoresItem(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("ValidationForAddStoresItem",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("ValidationForAddStoresItem", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}					

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
											
					}
				}
			}
		}
		
		
		public void DuplicateAddStoresItem(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddStoresItem",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddStoresItem", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				
				String strControl = row.get(i).getCell(2).getStringCellValue();
				
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}					

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
											
					}
				}
			}
		}
		
		
		
		public void SearchAddStoresItem(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddStoresItem",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				  ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddStoresItem", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				
				String strControl = row.get(i).getCell(2).getStringCellValue();
				
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}					

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
											
					}
				}
			}
		}
		
		
		public void EditStoresItem(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("EditStoresItem",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("EditStoresItem", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

							click_element(driver, "class", strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

					}
				}
			}
		}
		
		
		
		public void SearchEditedStoresItem(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedStoresItem",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedStoresItem", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

							click_element(driver, "class", strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

					}
				}
			}
		}
		
		
		public void AppendCopyItems(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("AppendCopyItems",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("AppendCopyItems", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(11000);
						}

						
						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						
						if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

							frameSwitchto(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
							Thread.sleep(k);
							frameSwitchBack(driver);
							Thread.sleep(k);
							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							
					}
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}	
					}
				}
			}
		}
		
		
		
		public void SearchAppendCopyItems(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAppendCopyItems",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("SearchAppendCopyItems", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(11000);
						}

						
						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						
						if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

							frameSwitchto(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
												
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}	
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
					}
				}
			}
		}
		
		
		
		
		public void OverwriteCopyItems(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
			
			ArrayList<Row> row= OR_Purchase_m.searchSheet("OverwriteCopyItems",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			ArrayList<Row> row1=input_purc_m.searchSheet("OverwriteCopyItems", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(11000);
						}

						if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

							click_element(driver, "class", strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						
						if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

							frameSwitchto(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
							Thread.sleep(k);
							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							frameSwitchBack(driver);
							
							
							Thread.sleep(k);
					}
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}	
						
						
					
					}
				}
			}
		}
		
		
		
		public void SearchOverwriteCopyItems(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
				
				ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchOverwriteCopyItems",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				ArrayList<Row> row1=input_purc_m.searchSheet("SearchOverwriteCopyItems", 3,0);//Functn key, sheet no, test data excel
					 	 
				for (int i = 0; i < row.size(); i++) {
					String strValue = "";
					String LocatorType=row.get(i).getCell(1).getStringCellValue();
					String strControl = row.get(i).getCell(2).getStringCellValue();
					for (int j = 0; j < row1.size(); j++) {
						if (row.get(i).getCell(0) != null) {

							if (row1.get(j).getCell(1) != null) {
								if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
									strValue = row1.get(j).getCell(4).toString();

									switch (row1.get(j).getCell(4).getCellTypeEnum()) {

									case NUMERIC:
										strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
										break;
									case STRING:
										strValue = row1.get(j).getCell(4).getStringCellValue();
										break;
									case BOOLEAN:
										strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
										break;
									default:
										strValue = row1.get(j).getCell(4).getStringCellValue();
										break;
									}

								}
							}
						}

					}

					if (row.get(i).getCell(10) != null) {

						String strControlTypeKey = row.get(i).getCell(10).toString();

						if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

							if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

								click_element(driver, LocatorType, strControl);
								Thread.sleep(11000);
							}
							

							if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

								dropdown(driver, LocatorType, strControl, strValue);
								Thread.sleep(k);

							}

							if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

								sendkeys(driver, LocatorType, strControl, strValue);
								Thread.sleep(k);
							}

							if (strControlTypeKey.compareTo("Alert_accept") == 0) {

								click_element(driver, LocatorType, strControl);
								Thread.sleep(k);
								Alert(driver);
								
							}

							if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

								clear_element(driver, LocatorType, strControl);
								Thread.sleep(k);
							}
							
						
							if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

								refresh(driver, LocatorType, strControl);
								Thread.sleep(k);
							}	
							
							if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

								gettext(driver, LocatorType, strControl);
								Thread.sleep(k);
							}
						
						}
					}
				}
			}
		
		
		
		public void MoveItems(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("MoveItems",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("MoveItems", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}
				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(8000);
						}

						if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

							click_element(driver, "class", strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						
						if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

							frameSwitchto(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
							Thread.sleep(k);
							frameSwitchBack(driver);
							Thread.sleep(k);
							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
					}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
					
					}
				}
			}
		}
		
		
		
		
		public void SearchMoveItems(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchMoveItems",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("SearchMoveItems", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}
				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(8000);
						}

						if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

							click_element(driver, "class", strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						
						if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

							frameSwitchto(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
							Thread.sleep(k);
							frameSwitchBack(driver);
							Thread.sleep(k);
							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
					}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
					
					}
				}
			}
		}
		
		
		
		public void DeleteStoresItem(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteStoresItem",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("DeleteStoresItem", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();
					
					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

						

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
							
						
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
							
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						

					}
				}
			}
		}
		
		
		
		public void SearchDeletedStoresItem(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchDeletedStoresItem",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("SearchDeletedStoresItem", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();
					
					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

						

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}
						
					
						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
							
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						

					}
				}
			}
		}
		
		
		public void RestoreStoresItem(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("RestoreStoresItem",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("RestoreStoresItem", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

						

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
							
						
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
							
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

					}
				}
			}
		}
		
		
		public void SearchRestoredStoresItem(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchRestoredStoresItem",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("SearchRestoredStoresItem", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

						

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
													
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
							
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

					}
				}
			}
		}
		
		
		public void DeleteSubCatalogue(WebDriver driver1) throws Exception {

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteSubCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				    ArrayList<Row> row1=input_purc_m.searchSheet("DeleteSubCatalogue", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

							click_element(driver, "class", strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
							Alert(driver);
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

					}
				}
			}
		}
		
		public void DeleteCatalogue(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				  ArrayList<Row> row1=input_purc_m.searchSheet("DeleteCatalogue", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

							click_element(driver, "class", strControl);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
							Alert(driver);
							
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
							
						
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
											
					}
				}
			}
		}
		
		
		
		public void SearchDeletedCatalogue(WebDriver driver1) throws Exception { 

			WebDriver driver = driver1;
			
				  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchDeletedCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
				  ArrayList<Row> row1=input_purc_m.searchSheet("SearchDeletedCatalogue", 3,0);//Functn key, sheet no, test data excel
				 	 
			for (int i = 0; i < row.size(); i++) {
				String strValue = "";
				String LocatorType=row.get(i).getCell(1).getStringCellValue();
				String strControl = row.get(i).getCell(2).getStringCellValue();
				for (int j = 0; j < row1.size(); j++) {
					if (row.get(i).getCell(0) != null) {

						if (row1.get(j).getCell(1) != null) {
							if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
								strValue = row1.get(j).getCell(4).toString();

								switch (row1.get(j).getCell(4).getCellTypeEnum()) {

								case NUMERIC:
									strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
									break;
								case STRING:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								case BOOLEAN:
									strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
									break;
								default:
									strValue = row1.get(j).getCell(4).getStringCellValue();
									break;
								}

							}
						}
					}

				}

				if (row.get(i).getCell(10) != null) {

					String strControlTypeKey = row.get(i).getCell(10).toString();

					if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

						if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}

						

						if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

							dropdown(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);

						}

						if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

							sendkeys(driver, LocatorType, strControl, strValue);
							Thread.sleep(k);
						}

						if (strControlTypeKey.compareTo("Alert_accept") == 0) {

							click_element(driver, LocatorType, strControl);
							Thread.sleep(k);
							Alert(driver);
							Thread.sleep(k);
							Alert(driver);
							
						}

						if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

							clear_element(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
						
						if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

							gettext(driver, LocatorType, strControl);
							Thread.sleep(k);
							
						
						}
						
						if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

							refresh(driver, LocatorType, strControl);
							Thread.sleep(k);
						}
											
					}
				}
			}
		}
			
		


	public void RestoreCatalogue(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("RestoreCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			  ArrayList<Row> row1=input_purc_m.searchSheet("RestoreCatalogue", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
						Alert(driver);
						
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
										
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
										
				}
			}
		}
	}


	public void SearchRestoredCatalogue(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchRestoredCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			  ArrayList<Row> row1=input_purc_m.searchSheet("SearchRestoredCatalogue", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
						Alert(driver);
						
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
										
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
										
				}
			}
		}
	}





	//-----------------------------------------------Office------------------------------------------------------------------------------------------//
	

	public void RequisitionType_Office(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;		

		 ArrayList<Row> row= OR_Purchase_m.searchSheet("RequisitionType_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		  ArrayList<Row> row1=input_purc_m.searchSheet("RequisitionType_Office", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

			}}}}

	public void SearchFunction_Office(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		
		  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchFunction_Office",2,9);//Functn key,sheetNo.,Column no.// Xpath locator
		  ArrayList<Row> row1=input_purc_m.searchSheet("SearchFunction_Office", 2,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
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
					Thread.sleep(k);
				}
				            
			if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

				refresh(driver, LocatorType, strControl);
				Thread.sleep(k);
			}

			if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

				sendkeys(driver, LocatorType, strControl, strValue);
				Thread.sleep(k);
			}
			
			if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

				gettext(driver, LocatorType, strControl);
				Thread.sleep(k);
								
			}
			
			}
		}
	}
	

	public void ValidationForAddCatalogue_Office(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("ValidationForAddCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("ValidationForAddCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();
		
			
			{
			


			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
              
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				

			}
		}
	}
}}
	
	
	

	


	public void DuplicateAddCatalogue_Office(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}

			 
	 public void SearchAddCatalogue_Office(WebDriver driver1) throws Exception {  //(priority=26)

			WebDriver driver = driver1;
			
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
						

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					              					

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
										
					}

				}
			}
		}
	}
	 

	 
	 
	 public void EditCatalogue_Office(WebDriver driver1) throws Exception {  //(priority=26)

			WebDriver driver = driver1;
			
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("EditCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("EditCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
						

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
	             
					

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					

					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

				}
			}
		}
	}
	 
	 
	 
	 public void SearchEditedAddCatalogue_Office(WebDriver driver1) throws Exception {  //(priority=26)

			WebDriver driver = driver1;
			
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedAddCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedAddCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
						

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
								
					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
										
					}

				}
			}
		}
	}
	 
	 
	 public void ValidationForAddSubCatalogue_Office(WebDriver driver1) throws Exception {  //(priority=26)

			WebDriver driver = driver1;
			
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("ValidationForAddSubCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("ValidationForAddSubCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
			    
			    for (int i = 0; i < row.size(); i++) {
					String strValue = "";
					String LocatorType=row.get(i).getCell(1).getStringCellValue();
					String strControl = row.get(i).getCell(2).getStringCellValue();
					for (int j = 0; j < row1.size(); j++) {
						if (row.get(i).getCell(0) != null) {

							if (row1.get(j).getCell(1) != null) {
								if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
									strValue = row1.get(j).getCell(4).toString();

									switch (row1.get(j).getCell(4).getCellTypeEnum()) {

									case NUMERIC:
										strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
										break;
									case STRING:
										strValue = row1.get(j).getCell(4).getStringCellValue();
										break;
									case BOOLEAN:
										strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
										break;
									default:
										strValue = row1.get(j).getCell(4).getStringCellValue();
										break;
									}

								}
							}
						}

					}
					if (row.get(i).getCell(10) != null) {

						String strControlTypeKey = row.get(i).getCell(10).toString();

						if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

							if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
								

								click_element(driver, LocatorType, strControl);
								Thread.sleep(k);
							}
										
							if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

								dropdown(driver, LocatorType, strControl, strValue);
								Thread.sleep(k);

							}

							if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

								sendkeys(driver, LocatorType, strControl, strValue);
								Thread.sleep(k);
							}

							if (strControlTypeKey.compareTo("Alert_accept") == 0) {

								click_element(driver, LocatorType, strControl);
								Thread.sleep(k);
								Alert(driver);
								Thread.sleep(k);
							}

							if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

								clear_element(driver, LocatorType, strControl);
								Thread.sleep(k);
							}
							
							if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

								refresh(driver, LocatorType, strControl);
								Thread.sleep(k);
							}

						}
					}
				}
		
	}
	 
	 
	 
	 public void DuplicateAddSubCatalogue_Office(WebDriver driver1) throws Exception {  //(priority=26)

			WebDriver driver = driver1;
			
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddSubCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddSubCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
						

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
								
					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {
						Thread.sleep(k);
						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

				}
			}
		}
	}
	 	 
	 
	 public void SearchAddSubCatalogue_Office(WebDriver driver1) throws Exception {  //(priority=26)

			WebDriver driver = driver1;
			
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddSubCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddSubCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
						

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					       
					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
										
					}
				}
			}
		}
	}
	 

	public void EditSubCatalogue_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("EditSubCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("EditSubCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {
						Thread.sleep(k);
						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

				}
			}
		}
	}

	public void SearchEditedAddSubCatalogue_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedAddSubCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			  ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedAddSubCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					
					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
										
					}

				}
			}
		}
	}

		

	public void ValidationForAddStoresItem_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("ValidationForAddStoresItem_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("ValidationForAddStoresItem_Office", 3,0);//Functn key, sheet no, test data excel
			    
			    
			    
			    for (int i = 0; i < row.size(); i++) {
					String strValue = "";
					String LocatorType=row.get(i).getCell(1).getStringCellValue();
					String strControl = row.get(i).getCell(2).getStringCellValue();
					for (int j = 0; j < row1.size(); j++) {
						if (row.get(i).getCell(0) != null) {

							if (row1.get(j).getCell(1) != null) {
								if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
									strValue = row1.get(j).getCell(4).toString();

									switch (row1.get(j).getCell(4).getCellTypeEnum()) {

									case NUMERIC:
										strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
										break;
									case STRING:
										strValue = row1.get(j).getCell(4).getStringCellValue();
										break;
									case BOOLEAN:
										strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
										break;
									default:
										strValue = row1.get(j).getCell(4).getStringCellValue();
										break;
									}

								}
							}
						}

					}
					if (row.get(i).getCell(10) != null) {

						String strControlTypeKey = row.get(i).getCell(10).toString();

						if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

							if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
								

								click_element(driver, LocatorType, strControl);
								Thread.sleep(k);
							}
										
							if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

								dropdown(driver, LocatorType, strControl, strValue);
								Thread.sleep(k);

							}

							if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

								sendkeys(driver, LocatorType, strControl, strValue);
								Thread.sleep(k);
							}

							if (strControlTypeKey.compareTo("Alert_accept") == 0) {

								click_element(driver, LocatorType, strControl);
								Thread.sleep(k);
								Alert(driver);
								Thread.sleep(k);
							}

							if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

								clear_element(driver, LocatorType, strControl);
								Thread.sleep(k);
							}
							
							if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

								refresh(driver, LocatorType, strControl);
								Thread.sleep(k);
							}

						}
					}
				}
			 	 
		/*for (int i = 0; i < row.size(); i++) {
			
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			
			String strControl = row.get(i).getCell(2).getStringCellValue();
			
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}					

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {
						
						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
										
				}
			}
		}*/
	}


	public void DuplicateAddStoresItem_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddStoresItem_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddStoresItem_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			
			String strControl = row.get(i).getCell(2).getStringCellValue();
			
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}					

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {
						Thread.sleep(k);
						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
										
				}
			}
		}
	}



	public void SearchAddStoresItem_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddStoresItem_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddStoresItem_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			
			String strControl = row.get(i).getCell(2).getStringCellValue();
			
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}					

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {
						Thread.sleep(k);
						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
										
					}
										
				}
			}
		}
	}


	public void EditOfficeItem_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("EditOfficeItem_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("EditOfficeItem_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

						click_element(driver, "class", strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {
						Thread.sleep(k);
						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

				}
			}
		}
	}



	public void SearchEditedOfficeItem_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedOfficeItem_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedOfficeItem_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
										
					}

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

				}
			}
		}
	}

			

	public void DeleteOfficeItem_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteOfficeItem_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("DeleteOfficeItem_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();
				
				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
						
					
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {
						Thread.sleep(k);
						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
						
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					

				}
			}
		}
	}




	public void SearchDeletedOfficeItem_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchDeletedOfficeItem_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("SearchDeletedOfficeItem_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();
				
				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
						
					
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
						
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					

				}
			}
		}
	}


	public void RestoreOfficeItem_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("RestoreOfficeItem_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("RestoreOfficeItem_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}					

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
						
					
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {
						Thread.sleep(k);
						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
						
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

				}
			}
		}
	}


	public void SearchRestoredOfficeItem_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchRestoredOfficeItem_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("SearchRestoredOfficeItem_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
						
					
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
						
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

				}
			}
		}
	}


	public void DeleteSubCatalogue_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteSubCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("DeleteSubCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

						click_element(driver, "class", strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {
						Thread.sleep(k);
						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
						Alert(driver);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
						
					
					}

				}
			}
		}
	}



	public void DeleteCatalogue_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("DeleteCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

						click_element(driver, "class", strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
						Alert(driver);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

				}
			}
		}
	}

	public void SearchDeletedCatalogue_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchDeletedCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("SearchDeletedCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

						click_element(driver, "class", strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
						Alert(driver);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
						
					
					}

				}
			}
		}
	}


	public void RestoreCatalogue_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("RestoreCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("RestoreCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

						click_element(driver, "class", strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
						Alert(driver);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

				}
			}
		}
	}

	public void SearchRestoredCatalogue_Office(WebDriver driver1) throws Exception { // (priority=26)

		WebDriver driver = driver1;
		
			  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchRestoredCatalogue_Office",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
			    ArrayList<Row> row1=input_purc_m.searchSheet("SearchRestoredCatalogue_Office", 3,0);//Functn key, sheet no, test data excel
			 	 
		for (int i = 0; i < row.size(); i++) {
			String strValue = "";
			String LocatorType=row.get(i).getCell(1).getStringCellValue();
			String strControl = row.get(i).getCell(2).getStringCellValue();
			for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();

				if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Click_Ctrl1") == 0) {

						click_element(driver, "class", strControl);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

						dropdown(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);

					}

					if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

						sendkeys(driver, LocatorType, strControl, strValue);
						Thread.sleep(k);
					}

					if (strControlTypeKey.compareTo("Alert_accept") == 0) {

						click_element(driver, LocatorType, strControl);
						Thread.sleep(k);
						Alert(driver);
						Thread.sleep(k);
						Alert(driver);
					}

					if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

						clear_element(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					
					if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

						refresh(driver, LocatorType, strControl);
						Thread.sleep(k);
					}
					if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

						gettext(driver, LocatorType, strControl);
						Thread.sleep(k);
						
					
					}


				}
			}
		}
	}


	//=======================================================SPARE-Is SERVICE=====================================================================





	public void SearchFunction_Spare(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;

		  ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchFunction_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		  ArrayList<Row> row1=input_purc_m.searchSheet("SearchFunction_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
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
					Thread.sleep(k);
				}
				            
				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	




	public void ValidationForAddCatalogue_Spare_IsService(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("ValidationForAddCatalogue_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("ValidationForAddCatalogue_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					Thread.sleep(k);
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}

	public void DuplicateAddCatalogue_Spare_IsService(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddCatalogue_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddCatalogue_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					
					Alert(driver);
					Thread.sleep(k);
					Thread.sleep(k);
					Thread.sleep(k);
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}



	public void SearchAddCatalogue_Spare_IsService(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddCatalogue_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddCatalogue_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}


	public void EditAddCatalogue_Spare_IsService(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("EditAddCatalogue_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("EditAddCatalogue_Spare_IsService",3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}


	public void SearchEditedAddCatalogue_Spare_IsService(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedAddCatalogue_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedAddCatalogue_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}


	public void ValidationForAddSubCatalogue_Spare_IsService(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("ValidationForAddSubCatalogue_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("ValidationForAddSubCatalogue_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(7000);
					Alert(driver);
					Thread.sleep(7000);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}

	public void DuplicateAddSubCatalogue_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddSubCatalogue_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddSubCatalogue_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {
					Thread.sleep(3000);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}


	public void SearchAddSubCatalogue_Spare_IsService(WebDriver driver1) throws Exception {  
		Thread.sleep(k);
		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddSubCatalogue_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddSubCatalogue_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		
		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}

	public void EditAddedSubCatalogue_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("EditAddedSubCatalogue_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("EditAddedSubCatalogue_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}


	public void SearchEditedAddSubCatalogue_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedAddSubCatalogue_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedAddSubCatalogue_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {

					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	  }
	}



	public void AddJobs_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("AddJobs_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("AddJobs_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}


	public void DuplicateJobs_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateJobs_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateJobs_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}


	public void SearchAddJobs_Spare_IsService(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddJobs_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddJobs_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}


	public void EditAddedJobs_Spare_IsService(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("EditAddedJobs_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("EditAddedJobs_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}



	public void SearchEditedAddJobs_Spare_IsService(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedAddJobs_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedAddJobs_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}


	public void AppendCopyJobs__Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("AppendCopyJobs__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("AppendCopyJobs__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				
				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					
					
					Thread.sleep(k);
			}
				

			}
		}
	}
	}


	public void SearchAppendCopyJobs_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAppendCopyJobs_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAppendCopyJobs_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void OverwriteCopyJobs_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("OverwriteCopyJobs_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("OverwriteCopyJobs_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				
				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					Thread.sleep(4000);
					
						
					}

				}
			}
		}
	}

	public void SearchOverwriteCopyJobs_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchOverwriteCopyJobs_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchOverwriteCopyJobs_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void MoveJobs_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("MoveJobs_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("MoveJobs_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					
					Thread.sleep(k);
			}
			}
		}
	}
	}


	public void AddSpareItem_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("AddSpareItem_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("AddSpareItem_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void DuplicateAddSpareItem_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddSpareItem_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddSpareItem_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void SearchAddedSpareItem_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddedSpareItem_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddedSpareItem_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}




	public void EditSpareItem_Spare_IsService(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("EditSpareItem_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("EditSpareItem_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}



	public void SearchEditSpareItem_Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditSpareItem_Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditSpareItem_Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void AppendCopyItems__Spare_IsService(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("AppendCopyItems__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("AppendCopyItems__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					
					Thread.sleep(k);
			}
			}
		}
	}
	}



	public void SearchAppendCopyItems__Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAppendCopyItems__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAppendCopyItems__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}

	public void OverwriteCopyItems__Spare_IsService(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("OverwriteCopyItems__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("OverwriteCopyItems__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					
					Thread.sleep(k);
			}
			}
		}
	}
	}

	public void SearchOverwriteCopyItems__Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchOverwriteCopyItems__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchOverwriteCopyItems__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}


	public void MoveItems__Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("MoveItems__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("MoveItems__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					
					Thread.sleep(k);
			}
			}
		}
	}
	}


	public void SearchMoveItems__Spare_IsService(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchMoveItems__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchMoveItems__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}


	public void DeleteStoresItem__Spare_IsService(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteStoresItem__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DeleteStoresItem__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}
	
	
	
	public void SearchDeletedStoresItem__Spare_IsService(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchDeletedStoresItem__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchDeletedStoresItem__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}


	public void RestoreStoresItem__Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("RestoreStoresItem__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("RestoreStoresItem__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}
	
	
	public void SearchRestoreStoresItem__Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchRestoreStoresItem__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchRestoreStoresItem__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
								
				
			}
		}
	}
	}



	public void DeleteSubCatalogue__Spare_IsService(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteSubCatalogue__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DeleteSubCatalogue__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}


	public void DeleteCatalogue__Spare_IsService(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteCatalogue__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DeleteCatalogue__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}



	public void SearchDeleteCatalogue__Spare_IsService(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchDeleteCatalogue__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchDeleteCatalogue__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}



	public void RestoreCatalogue__Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("RestoreCatalogue__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("RestoreCatalogue__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}



	public void SearchRestoredCatalogue__Spare_IsService(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchRestoredCatalogue__Spare_IsService",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchRestoredCatalogue__Spare_IsService", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}

	
	//=========================================== SPARE  =====================================================================================

	public void SearchFunction_Spare1(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchFunction_Spare1",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchFunction_Spare1", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}



	public void ValidationForAddCatalogue_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("ValidationForAddCatalogue_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("ValidationForAddCatalogue_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}

	public void DuplicateAddCatalogue_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddCatalogue_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddCatalogue_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}

	public void SearchAddCatalogue_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddCatalogue_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddCatalogue_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void EditAddCatalogue_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("EditAddCatalogue_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("EditAddCatalogue_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}



	public void SearchEditedAddCatalogue_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedAddCatalogue_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedAddCatalogue_Spare",3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				
			}
		}
	}
	}



	public void ValidationForAddSubCatalogue_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("ValidationForAddSubCatalogue_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("ValidationForAddSubCatalogue_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);

					}

				}
			}
		}
	}



	public void DuplicateForAddSubCatalogue_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateForAddSubCatalogue_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateForAddSubCatalogue_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
			

				
			}
		}
	}
	}


	public void SearchAddSubCatalogue_Spare(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddSubCatalogue_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddSubCatalogue_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				
			}
		}
	}
	}


	public void EditAddedSubCatalogue_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("EditAddedSubCatalogue_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("EditAddedSubCatalogue_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}


	public void SearchEditedAddSubCatalogue_Spare(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedAddSubCatalogue_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedAddSubCatalogue_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	     for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					
					
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				
			}
		}
	}
	}


	public void AddJobs_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("AddJobs_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("AddJobs_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}


	public void DuplicateJobs_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateJobs_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateJobs_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}


	public void SearchAddJobs_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddJobs_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddJobs_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}



	public void EditAddedJobs_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("EditAddedJobs_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("EditAddedJobs_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}



	public void SearchEditedAddJobs_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditedAddJobs_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditedAddJobs_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}



	public void AppendCopyJobs__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("AppendCopyJobs__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("AppendCopyJobs__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					Thread.sleep(k);
					
					
			}
			}
		}
	}
	}



	/*public void SearchAppendCopyJobs_Spare(WebDriver driver1) throws Exception {  //(priority=26)

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAppendCopyJobs_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAppendCopyJobs_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}

			}
		}
	}
	}
	*/

	public void OverwriteCopyJobs_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("OverwriteCopyJobs_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("OverwriteCopyJobs_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					Thread.sleep(k);
					
					
			}

			}
		}
	}
	}


	public void SearchOverwriteCopyJobs_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchOverwriteCopyJobs_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchOverwriteCopyJobs_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}

	public void MoveJobs_Spare(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("MoveJobs_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("MoveJobs_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					Thread.sleep(k);
					
					
			}

			}
		}
	}
	}
	
	
	public void SearchMoveJobs_Spare(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchMoveJobs_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchMoveJobs_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
					}

				}
			}
		}
	}


	public void AddSpareItem_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("AddSpareItem_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("AddSpareItem_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void DuplicateAddSpareItem_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DuplicateAddSpareItem_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DuplicateAddSpareItem_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void SearchAddedSpareItem_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAddedSpareItem_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAddedSpareItem_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void EditSpareItem_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("EditSpareItem_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("EditSpareItem_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void SearchEditSpareItem_Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchEditSpareItem_Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchEditSpareItem_Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}



	public void AppendCopyItems__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("AppendCopyItems__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("AppendCopyItems__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					Thread.sleep(k);
					
					
			}
			}
		}
	}
	}


	public void SearchAppendCopyItems__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchAppendCopyItems__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchAppendCopyItems__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}



	public void OverwriteCopyItems__Spare(WebDriver driver1) throws Exception { 

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("OverwriteCopyItems__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("OverwriteCopyItems__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					Thread.sleep(k);
					
					
			}

			}
		}
	}
	}



	public void SearchOverwriteCopyItems__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchOverwriteCopyItems__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchOverwriteCopyItems__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}



	public void MoveItems__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("MoveItems__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("MoveItems__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					Thread.sleep(k);
					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					frameSwitchBack(driver);
					Thread.sleep(k);
					
					
			}

			}
		}
	}
	}



	public void SearchMoveItems__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchMoveItems__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchMoveItems__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void DeleteStoresItem__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteStoresItem__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DeleteStoresItem__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}



	public void SearchDeletedStoresItem__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchDeletedStoresItem__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchDeletedStoresItem__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void RestoreStoresItem__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("RestoreStoresItem__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("RestoreStoresItem__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}

	public void SearchRestoredStoresItem__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchRestoredStoresItem__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchRestoredStoresItem__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}



	public void DeleteSubCatalogue__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteSubCatalogue__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DeleteSubCatalogue__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}



	public void DeleteCatalogue__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("DeleteCatalogue__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("DeleteCatalogue__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void SearchDeleteCatalogue(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchDeleteCatalogue",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchDeleteCatalogue", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}
		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}



	public void RestoreCatalogue__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("RestoreCatalogue__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("RestoreCatalogue__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	public void SearchRestoredCatalogue__Spare(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		 ArrayList<Row> row= OR_Purchase_m.searchSheet("SearchRestoredCatalogue__Spare",3,9);//Functn key,sheetNo.,Column no.// Xpath locator
		 ArrayList<Row> row1=input_purc_m.searchSheet("SearchRestoredCatalogue__Spare", 3,0);//Functn key, sheet no, test data excel
		 	 
	for (int i = 0; i < row.size(); i++) {
		String strValue = "";
		String LocatorType=row.get(i).getCell(1).getStringCellValue();
		String strControl = row.get(i).getCell(2).getStringCellValue();
		for (int j = 0; j < row1.size(); j++) {
			if (row.get(i).getCell(0) != null) {

				if (row1.get(j).getCell(1) != null) {
					if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
						strValue = row1.get(j).getCell(4).toString();

						switch (row1.get(j).getCell(4).getCellTypeEnum()) {

						case NUMERIC:
							strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
							break;
						case STRING:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						case BOOLEAN:
							strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
							break;
						default:
							strValue = row1.get(j).getCell(4).getStringCellValue();
							break;
						}

					}
				}
			}

		}

		if (row.get(i).getCell(10) != null) {

			String strControlTypeKey = row.get(i).getCell(10).toString();

			if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
	          
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {

					dropdown(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					
					Thread.sleep(k);
					sendkeys(driver, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {

					click_element(driver, LocatorType, strControl);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
					Alert(driver);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {

					clear_element(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {

					refresh(driver, LocatorType, strControl);
					Thread.sleep(k);
				}
				
				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					gettext(driver, LocatorType, strControl);
					Thread.sleep(k);
									
				}
				
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver, LocatorType, strControl);
					Thread.sleep(k);
				}

			}
		}
	}
	}


	}
