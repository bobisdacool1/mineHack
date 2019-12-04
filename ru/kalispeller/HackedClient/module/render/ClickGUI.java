package ru.kalispeller.HackedClient.module.render;


import de.Hero.settings.Setting;
import org.lwjgl.input.Keyboard;
import ru.kalispeller.HackedClient.HackInit;
import ru.kalispeller.HackedClient.module.Category;
import ru.kalispeller.HackedClient.module.Module;

import java.util.ArrayList;

public class ClickGUI extends Module {
    public ClickGUI() {
        super("ClickGUI", Keyboard.KEY_GRAVE, Category.RENDER);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<>();
        options.add("New");
        options.add("JellyLike");
        HackInit.instance.settingsManager.rSetting(new Setting("Design", this, "New", options));
        HackInit.instance.settingsManager.rSetting(new Setting("Sound", this, true));
        HackInit.instance.settingsManager.rSetting(new Setting("GuiRed", this, 255, 0, 255, true));
        HackInit.instance.settingsManager.rSetting(new Setting("GuiGreen", this, 26, 0, 255, true));
        HackInit.instance.settingsManager.rSetting(new Setting("GuiBlue", this, 42, 0, 255, true));
    }

    @Override
    public void onEnable() {
        super.onEnable();

        mc.displayGuiScreen(HackInit.instance.clickGui);
        toggle();
    }
}