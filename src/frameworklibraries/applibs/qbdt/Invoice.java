package frameworklibraries.applibs.qbdt;

import org.sikuli.script.*;

import frameworklibraries.actionlibs.Actions;

public class Invoice {
	public static String menuImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\Menus";
	public static String invImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\Invoice";
	public static String imgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images";
	public static Screen s = new Screen();

	public static void LaunchInvoice() {
		try {
			Actions.ClickButton(menuImgsFolder + "\\Customers\\Customers.png");
			Actions.ClickButton(menuImgsFolder
					+ "\\Customers\\CreateInvoices.png");
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

	public static void LaunchInvoiceDuringGuideMeFlow() {
		try {
			Actions.ClickButtonDuringGuideMeFlow(menuImgsFolder
					+ "\\Customers\\Customers.png", "Select Customers");
			Actions.ClickButtonDuringGuideMeFlow(menuImgsFolder
					+ "\\Customers\\CreateInvoices.png",
					"Select Create Invoice");
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

	public static void CreateGuideMeForInvoiceCreation(String customerName,
			String itemName, String qty) {
		try {

			frameworklibraries.applibs.qbdt.GuideMe.StartRecordingGuideMeFlow();
			LaunchInvoiceDuringGuideMeFlow();

			Actions.EnterTextDuringGuideMeFlow(invImgsFolder
					+ "\\DDCustomer.png", customerName,
					"Select/Add a customer name");

			if (Actions.DoesImageExist(invImgsFolder
					+ "\\BtnCustomerQuickAdd.png")) {
				Actions.ClickButtonDuringGuideMeFlow(invImgsFolder
						+ "\\BtnCustomerQuickAdd.png",
						" Click this button to quick add a customer");
			}

			Actions.EnterTextDuringGuideMeFlow(invImgsFolder
					+ "\\TxtItemCode.png", itemName,
					"Select/Enter an item name");

			if (Actions
					.DoesImageExist(imgsFolder + "\\Common\\BtnYes_Blue.png")) {
				Actions.ClickButtonDuringGuideMeFlow(imgsFolder
						+ "\\Common\\BtnYes_Blue.png",
						"Click this to add an item");

				Actions.EnterTextDuringGuideMeFlow(invImgsFolder
						+ "\\TxtItemPrice.png", "10",
						"Enter the price for the item");
				Actions.EnterTextDuringGuideMeFlow(invImgsFolder
						+ "\\DDItemAccountName.png", "SikuliSales",
						"Select an income account");

				if (Actions.DoesImageExist(invImgsFolder
						+ "\\BtnAccountSetup.png")) {
					Actions.ClickButtonDuringGuideMeFlow(invImgsFolder
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
			Actions.EnterTextDuringGuideMeFlow(invImgsFolder + "\\TxtQty.png",
					qty, "Enter the item quantity on sale");

			Actions.ClickButtonDuringGuideMeFlow(imgsFolder
					+ "\\Common\\BtnSaveAndClose.png",
					"Click SaveAndClose to save the invoice");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void CreateInvoice(String customerName, String itemName,
			String qty) {
		try {
			LaunchInvoice();

			Actions.EnterText(invImgsFolder + "\\DDCustomer.png", customerName);

			if (Actions.DoesImageExist(invImgsFolder
					+ "\\BtnCustomerQuickAdd.png")) {
				Actions.ClickButton(invImgsFolder + "\\BtnCustomerQuickAdd.png");
			}

			Actions.EnterText(invImgsFolder + "\\TxtItemCode.png", itemName);

			if (Actions
					.DoesImageExist(imgsFolder + "\\Common\\BtnYes_Blue.png")) {
				Actions.ClickButton(imgsFolder + "\\Common\\BtnYes_Blue.png");

				Actions.EnterText(invImgsFolder + "\\TxtItemPrice.png", "10");
				Actions.EnterText(invImgsFolder + "\\DDItemAccountName.png",
						"SikuliSales");

				if (Actions.DoesImageExist(invImgsFolder
						+ "\\BtnAccountSetup.png")) {
					Actions.ClickButton(invImgsFolder + "\\BtnAccountSetup.png");

					Actions.ClickButton(imgsFolder
							+ "\\Common\\BtnBlueSaveAndClose.png");
				}

				Actions.ClickButton(imgsFolder + "\\Common\\BtnBlueOK.png");

			}
			Actions.EnterText(invImgsFolder + "\\TxtQty.png", qty);

			Actions.ClickButton(imgsFolder + "\\Common\\BtnSaveAndClose.png");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
