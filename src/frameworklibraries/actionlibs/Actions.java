package frameworklibraries.actionlibs;

import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import frameworklibraries.utilities.Window;

public class Actions {
	public static String menuImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\Menus";
	public static String invImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\Invoice";
	public static String imgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images";
	public static String gmImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\GuideMe";
	public static Screen s = new Screen();
	static frameworklibraries.utilities.Property conf = new frameworklibraries.utilities.Property()
			.GetPropertyInstance();
	public static Process qbApp = null;

	public static String globalTimeOut = conf.get("SyncTimeOut");

	public static void ClickButton(String imagePath) {
		try {
			s.click(new Pattern(imagePath));
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}
	
	
	public static void ClickButtonDuringGuideMeFlow(String imagePath, String userComment) {
		try {
			s.click(new Pattern(imagePath));
			Actions.EnterText(gmImgsFolder+"\\DescriptorBox.png",userComment);
			s.click(new Pattern(gmImgsFolder+"\\BtnSaveComment.png")); //this shall be replaced with save & continue button
			} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	public static void EnterText(String imagePath, String value)

	{
		try {
			ClickButton(imagePath);
			s.type(value);
			s.type(Key.TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void EnterTextDuringGuideMeFlow(String imagePath, String value,String userComment)

	{
		try {
			ClickButton(imagePath);
			Actions.EnterText(gmImgsFolder+"\\DescriptorBox.png",userComment);
			s.click(new Pattern(gmImgsFolder+"\\BtnSaveComment.png")); //this shall be replaced with save & continue button
			s.type(value);
			s.type(Key.TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean DoesImageExist(String imagePath) {
		if (s.exists(new Pattern(imagePath)) != null)
			return true;
		else
			return false;
	}

	public static void WaitUntilImageBecomesVisible(String imagePath)
			throws Exception {
		long starttime = System.currentTimeMillis();
		long currentime = 0;
		long elapsedTime = 0;

		do {
			currentime = System.currentTimeMillis();
			elapsedTime = currentime - starttime / 1000;
			Thread.sleep(500);
		} while (s.exists(imagePath) != null
				&& elapsedTime < Long.parseLong(globalTimeOut));

	}

	public static void LaunchQB() throws Exception {
		String qbApppath = conf.get("AppInstallLocation");
		try {
			qbApp = Runtime.getRuntime().exec(qbApppath);

			Actions.WaitUntilImageBecomesVisible(imgsFolder
					+ "\\NoCompanyOpen.png");
			if (DoesImageExist(imgsFolder + "\\Common\\ImageMaximize.png"))
				ClickButton(imgsFolder + "\\Common\\ImageMaximize.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void OpenCompanyFile(String companyFilePath) throws Exception {
		Window qbAppWindow = GetWindowByName("QuickBooks");

		if (qbAppWindow != null) {
			if (s.exists(imgsFolder + "\\NoCompanyOpen.png") != null) {
				Actions.ClickButton(imgsFolder + "\\OpenOrRestoreCompany.png");
				Actions.ClickButton(imgsFolder + "\\RadioOpenCompany.png");
				Actions.ClickButton(imgsFolder + "\\Common\\BtnBlueNext.png");
				companyFilePath = companyFilePath.replace("\\\\", "\\");
				EnterText(imgsFolder + "\\TxtOpenCompanyFilePath.png",
						companyFilePath);
				Actions.ClickButton(imgsFolder
						+ "\\WindowDialog\\BtnOpenInFileDialog.png");
				s.wait(imgsFolder + "\\TabHomePage.png", 99999000);
				do {
					s.hover(menuImgsFolder + "\\Windows\\Windows.png");
				} while (s.exists(menuImgsFolder
						+ "\\Windows\\WindowsGreen.png") != null);
				ClickButton(menuImgsFolder + "\\Windows\\WindowsGreen.png");
				ClickButton(menuImgsFolder + "\\Windows\\CloseAll.png");
				InitializeQB();

			} else {
				s.wait(imgsFolder + "\\TabHomePage.png", 99999000);
				do {
					s.hover(menuImgsFolder + "\\Windows\\Windows.png");
				} while (s.exists(menuImgsFolder
						+ "\\Windows\\WindowsGreen.png") != null);
				ClickButton(menuImgsFolder + "\\Windows\\WindowsGreen.png");
				ClickButton(menuImgsFolder + "\\Windows\\CloseAll.png");

				ClickButton(menuImgsFolder + "\\File\\MenuFile.png");
				ClickButton(menuImgsFolder
						+ "\\File\\MenuOpenOrRestoreCompany.png");

				Actions.ClickButton(imgsFolder + "\\RadioOpenCompany.png");
				Actions.ClickButton(imgsFolder + "\\Common\\BtnBlueNext.png");
				companyFilePath = companyFilePath.replace("\\\\", "\\");
				EnterText(imgsFolder + "\\TxtOpenCompanyFilePath.png",
						companyFilePath);
				Actions.ClickButton(imgsFolder
						+ "\\WindowDialog\\BtnOpenInFileDialog.png");
				s.wait(imgsFolder + "\\TabHomePage.png", 99999000);
				do {
					s.hover(menuImgsFolder + "\\Windows\\Windows.png");
				} while (s.exists(menuImgsFolder
						+ "\\Windows\\WindowsGreen.png") != null);
				ClickButton(menuImgsFolder + "\\Windows\\WindowsGreen.png");
				ClickButton(menuImgsFolder + "\\Windows\\CloseAll.png");
				InitializeQB();
			}

		}

	}

	public static void CloseAllQBWindows() {
		s.keyDown(Key.ALT);
		s.type("w");
		s.type("a");
		s.keyUp();
	}

	public static void InitializeQB() {
		Actions.ClickButton(menuImgsFolder + "\\Windows\\Windows.png");
		Actions.ClickButton(menuImgsFolder + "\\Windows\\CloseAll.png");
		Actions.ClickButton(menuImgsFolder + "\\View\\View.png");
		Actions.ClickButton(menuImgsFolder + "\\View\\TopIconBar.png");
	}

	public static void CloseQB() throws Exception {
		CloseAllQBWindows();
		Actions.ClickButton(menuImgsFolder + "\\File\\MenuFile.png");
		Actions.ClickButton(menuImgsFolder + "\\File\\MenuCloseCompany.png");
		if (DoesImageExist(imgsFolder + "\\Common\\BtnNoWhite.png")) {
			ClickButton(imgsFolder + "\\Common\\BtnNoWhite.png");
		}
		Actions.WaitUntilImageBecomesVisible(imgsFolder + "\\NoCompanyOpen.png");
		Actions.ClickButton(menuImgsFolder + "\\File\\MenuFile.png");
		Actions.ClickButton(menuImgsFolder + "\\File\\MenuExit.png");
	}

	public static void WaitUntilMenuBecomesClickable(String imagePath)
			throws Exception {

		long starttime = System.currentTimeMillis();
		long currentime = 0;
		long elapsedTime = 0;

		do {
			currentime = System.currentTimeMillis();
			elapsedTime = currentime - starttime / 1000;
			Thread.sleep(500);
		} while (s.click(imagePath) == 0
				&& elapsedTime < Long.parseLong(globalTimeOut));

	}

	public static Window GetWindowByName(String windowNname) {
		Window window = null;
		try {
			Process p = Runtime.getRuntime().exec("tasklist.exe /FO LIST");
			Window[] arrWindows = Window.getTopLevelWindows();

			for (Window w : arrWindows) {
				if (w.getTitle().contains(windowNname)) {
					window = w;
					break;
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return window;
	}

}
