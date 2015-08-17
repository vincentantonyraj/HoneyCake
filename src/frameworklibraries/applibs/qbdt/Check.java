package frameworklibraries.applibs.qbdt;

import org.sikuli.script.*;

import frameworklibraries.actionlibs.Actions;

public class Check {
	public static String menuImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\Menus";
	public static String chkImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\Check";
	public static String imgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images";
	public static Screen s = new Screen();

	public static void LaunchCheck() {
		try {
			Actions.ClickButton(menuImgsFolder + "\\Banking\\MenuBanking.png");
			Actions.ClickButton(menuImgsFolder+ "\\Banking\\MenuWriteChecks.png");
			if (Actions.DoesImageExist(imgsFolder+ "\\Common\\BtnYes_Blue.png")) 
			{
				Actions.ClickButton(imgsFolder+ "\\Common\\BtnYes_Blue.png");
				Actions.EnterText(chkImgsFolder+"\\TxtBankAccountName.png","BankAccount");
				Actions.ClickButton(imgsFolder+ "\\Common\\BtnBlueSaveAndClose.png");
			}
			if(Actions.DoesImageExist(imgsFolder + "\\Common\\BtnWindowSizeOpts.png"))
			{
				Actions.ClickButton(imgsFolder + "\\Common\\BtnWindowSizeOpts.png");
				Actions.ClickButton(imgsFolder + "\\Common\\BtnMaximize.png");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void WriteCheck(String vendorName,String itemName,
			String qty) {
		try {
			LaunchCheck();

			Actions.EnterText(chkImgsFolder + "\\DDPayeeName.png", vendorName);

			if (Actions.DoesImageExist(imgsFolder
					+ "\\Common\\BtnQuickAdd.png")) {
				Actions.ClickButton(imgsFolder
						+ "\\Common\\BtnQuickAdd.png");
				s.type(Key.ENTER);
				
			}
			Actions.ClickButton(chkImgsFolder + "\\TabItems.png");		
			
			s.type(itemName);
			s.type(Key.TAB);
	

			if (Actions.DoesImageExist(imgsFolder + "\\Common\\BtnYes_Blue.png")) 
			{
				Actions.ClickButton(imgsFolder + "\\Common\\BtnYes_Blue.png");
				Actions.EnterText(chkImgsFolder + "\\TxtPrice.png", "100");
				//Actions.EnterText(chkImgsFolder + "\\TxtQty.png", qty);
				
				
				Actions.EnterText(chkImgsFolder + "\\DDItemAccountName.png",
						"SikuliExpense");

				if (Actions.DoesImageExist(chkImgsFolder
						+ "\\BtnAccountSetup.png")) {
					Actions.ClickButton(chkImgsFolder + "\\BtnAccountSetup.png");
					
					Actions.ClickButton(imgsFolder
							+ "\\Common\\BtnBlueSaveAndClose.png");
				}
				
				Actions.ClickButton(imgsFolder + "\\Common\\BtnBlueOK.png");


			}
			
			s.type(Key.ENTER);
			Actions.EnterText(chkImgsFolder + "\\TxtQty.png", qty);

			Actions.ClickButton(imgsFolder + "\\Common\\BtnSaveAndClose.png");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
