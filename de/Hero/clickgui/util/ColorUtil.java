package de.Hero.clickgui.util;

import java.awt.Color;

import ru.kalispeller.HackedClient.HackInit;

/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit me
 *
 *  @author HeroCode
 */
public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int) HackInit.instance.settingsManager.getSettingByName("GuiRed").getValDouble(), (int)HackInit.instance.settingsManager.getSettingByName("GuiGreen").getValDouble(), (int)HackInit.instance.settingsManager.getSettingByName("GuiBlue").getValDouble());
	}
}
