package frameworklibraries.applibs.qbdt;

import org.sikuli.script.*;

import frameworklibraries.actionlibs.Actions;

public class GuideMe {
	public static String menuImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\Menus";	
	public static String imgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images";
	public static String gmImgsFolder = System.getProperty("user.dir")
			+ "\\src\\Images\\GuideMe";
	public static Screen s = new Screen();

	public static void LaunchGuideMe() {
		try {
			 Actions.ClickButton(menuImgsFolder+"\\Help\\MenuHelp.png");
			 Actions.ClickButton(menuImgsFolder+"\\Help\\MenuGuideMe.png");
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void StartRecordingGuideMeFlow() {
		try {
			 LaunchGuideMe();
			 Actions.ClickButton(gmImgsFolder+"\\TabCreatedByMe.png");
			 Actions.ClickButton(gmImgsFolder+"\\BtnCapture.png");
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
