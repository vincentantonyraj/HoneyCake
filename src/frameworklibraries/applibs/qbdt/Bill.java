package frameworklibraries.applibs.qbdt;

import org.sikuli.script.*;

import frameworklibraries.actionlibs.Actions;

public class Bill {
	public static String menuImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\Menus";
	public static String billImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\Bill";
	public static String imgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images";
	public static Screen s = new Screen();

	public static void LaunchEnterBills() {
		try {
			Actions.ClickButton(menuImgsFolder + "\\Vendors\\Vendors.png");
			Actions.ClickButton(menuImgsFolder
					+ "\\Vendors\\EnterBills.png");
			if (Actions.DoesImageExist(imgsFolder
					+ "\\Common\\BtnWindowSizeOpts.png")) {
				Actions.ClickButton(imgsFolder
						+ "\\Common\\BtnWindowSizeOpts.png");
				Actions.ClickButton(imgsFolder + "\\Common\\BtnMaximize.png");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void LaunchEnterBillsDuringGuideMeFlow() {
		try {
			Actions.ClickButtonDuringGuideMeFlow(menuImgsFolder
					+ "\\Vendors\\Vendors.png", "Select Vendors Menu");
			Actions.ClickButtonDuringGuideMeFlow(menuImgsFolder
					+ "\\Vendors\\EnterBills.png",
					"Select Enter bills");
			if (Actions.DoesImageExist(imgsFolder
					+ "\\Common\\BtnWindowSizeOpts.png")) {
				Actions.ClickButtonDuringGuideMeFlow(imgsFolder
						+ "\\Common\\BtnWindowSizeOpts.png",
						"Select Down Arrow");
				Actions.ClickButtonDuringGuideMeFlow(imgsFolder
						+ "\\Common\\BtnMaximize.png",
						"Select Maximize to maximize the window");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void CreateGuideMeForEnteringBill(String vendorName,
			String itemName, String qty) {
		try {

			frameworklibraries.applibs.qbdt.GuideMe.StartRecordingGuideMeFlow();
			LaunchEnterBillsDuringGuideMeFlow();

			Actions.EnterTextDuringGuideMeFlow(billImgsFolder
					+ "\\DDVendor.png", vendorName,
					"Select/Add a Vendor name");

			if (Actions.DoesImageExist(imgsFolder
					+ "\\Common\\BtnQuickAdd.png")) {
				Actions.ClickButtonDuringGuideMeFlow(imgsFolder
						+ "\\Common\\BtnQuickAdd.png",
						" Click this button to quick add a vendor");
			}

			Actions.ClickButtonDuringGuideMeFlow(billImgsFolder + "\\TabItems.png","Select items tab");	
			Actions.EnterTextDuringGuideMeFlow(billImgsFolder
					+ "\\TxtItemName.png", itemName,
					"Select/Enter an item name");

			if (Actions
					.DoesImageExist(imgsFolder + "\\Common\\BtnYes_Blue.png")) {
				Actions.ClickButtonDuringGuideMeFlow(imgsFolder
						+ "\\Common\\BtnYes_Blue.png",
						"Click this to add an item");

				Actions.EnterTextDuringGuideMeFlow(billImgsFolder
						+ "\\TxtItemPrice.png", "10",
						"Enter the price for the item");
				Actions.EnterTextDuringGuideMeFlow(billImgsFolder
						+ "\\DDItemAccountName.png", "SikuliExpense",
						"Select an expense account");

				if (Actions.DoesImageExist(billImgsFolder
						+ "\\BtnAccountSetup.png")) {
					Actions.ClickButtonDuringGuideMeFlow(billImgsFolder
							+ "\\BtnAccountSetup.png",
							"Select this to Add a new account ");

					Actions.ClickButtonDuringGuideMeFlow(imgsFolder
							+ "\\Common\\BtnBlueSaveAndClose.png",
							"Click SaveAndclose to save the account");
				}

				Actions.ClickButtonDuringGuideMeFlow(imgsFolder
						+ "\\Common\\BtnBlueOK.png",
						"Click Ok to save the item");

			}
			Actions.EnterTextDuringGuideMeFlow(billImgsFolder + "\\TxtQty.png",
					qty, "Enter the item quantity on purchase");

			Actions.ClickButtonDuringGuideMeFlow(imgsFolder
					+ "\\Common\\BtnSaveAndClose.png",
					"Click SaveAndClose to save the bill");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void EnterBill(String vendorName, String itemName,
			String qty) {
		try {
			LaunchEnterBills();

			Actions.EnterText(billImgsFolder
					+ "\\DDVendor.png", vendorName);

			if (Actions.DoesImageExist(imgsFolder
					+ "\\Common\\BtnQuickAdd.png")) {
				Actions.ClickButton(imgsFolder
						+ "\\Common\\BtnQuickAdd.png");
			}

			Actions.ClickButton(billImgsFolder + "\\TabItems.png");
			Actions.EnterText(billImgsFolder
					+ "\\TxtItemName.png", itemName);

			if (Actions
					.DoesImageExist(imgsFolder + "\\Common\\BtnYes_Blue.png")) {
				Actions.ClickButton(imgsFolder
						+ "\\Common\\BtnYes_Blue.png");

				Actions.EnterText(billImgsFolder
						+ "\\TxtItemPrice.png", "10");
				Actions.EnterText(billImgsFolder
						+ "\\DDItemAccountName.png", "SikuliExpense");

				if (Actions.DoesImageExist(billImgsFolder
						+ "\\BtnAccountSetup.png")) {
					Actions.ClickButton(billImgsFolder
							+ "\\BtnAccountSetup.png");

					Actions.ClickButton(imgsFolder
							+ "\\Common\\BtnBlueSaveAndClose.png");
				}

				Actions.ClickButton(imgsFolder
						+ "\\Common\\BtnBlueOK.png");

			}
			Actions.EnterText(billImgsFolder + "\\TxtQty.png",
					qty);

			Actions.ClickButton(imgsFolder
					+ "\\Common\\BtnSaveAndClose.png");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
