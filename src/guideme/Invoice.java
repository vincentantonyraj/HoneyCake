package guideme;

import org.sikuli.script.*;
import org.testng.annotations.*;

import frameworklibraries.actionlibs.Actions;

public class Invoice {

	public static String menuImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\Menus";
	public static String invImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\Invoice";
	public static String imgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images";
	public static Screen s = new Screen();
	static frameworklibraries.utilities.Property conf = new frameworklibraries.utilities.Property()
			.GetPropertyInstance();
	public static String globalTimeOut = conf.get("SyncTimeOut");
	public static String customerName = frameworklibraries.utilities.General
			.makeUnique("Customer");
	public static String itemName = frameworklibraries.utilities.General
			.makeUnique("Item");
	public static String testDataDirectory = conf.get("TestDataLocalDirectory");
	public static String companyFilePath = testDataDirectory
			+ conf.get("DefaultCompanyFile");

	@BeforeSuite
	public static void beforeClass() throws Exception {

		Actions.LaunchQB();
		Actions.OpenCompanyFile(companyFilePath);

	}

	@AfterSuite
	public static void afterSuite() throws Exception {
		Actions.CloseQB();

	}

	@BeforeTest
	public void beforeTest() {
		try {
			 conf.set("CustomerName", customerName);
			 conf.set("ItemName", itemName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public static void CreateInvoice() {

		 //frameworklibraries.applibs.qbdt.Invoice.CreateGuideMeForInvoiceCreation(conf.get("CustomerName"),conf.get("ItemName"), "10");
		 frameworklibraries.applibs.qbdt.Invoice.CreateInvoice(conf.get("CustomerName"),conf.get("ItemName"), "10");
	}

}