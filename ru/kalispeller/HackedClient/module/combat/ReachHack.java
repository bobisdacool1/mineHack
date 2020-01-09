package ru.kalispeller.HackedClient.module.combat;

import de.Hero.settings.Setting;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import ru.kalispeller.HackedClient.HackInit;
import ru.kalispeller.HackedClient.module.Category;
import ru.kalispeller.HackedClient.module.Module;

import java.util.ArrayList;

public class ReachHack extends Module {

    public ReachHack() {
        super("Reach", Keyboard.KEY_NUMPAD0, Category.COMBAT);
    }

    public float reach;

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<>();
        options.add("Short");
        options.add("Medium");
        options.add("Long");
        HackInit.instance.settingsManager.rSetting(new Setting("Reach Distance", this, "Medium", options));
    }

    @Override
    public void onEnable() {
        super.onEnable();
            if (HackInit.instance.settingsManager.getSettingByName("Reach Distance").getValString().equalsIgnoreCase("Short")) {
                HackInit.instance.reachHack.reach = 4.0F;
            }
            if (HackInit.instance.settingsManager.getSettingByName("Reach Distance").getValString().equalsIgnoreCase("Medium")) {
                HackInit.instance.reachHack.reach = 5.0F;
            }
            if (HackInit.instance.settingsManager.getSettingByName("Reach Distance").getValString().equalsIgnoreCase("Long")) {
                HackInit.instance.reachHack.reach = 6.5F;
            }

//            HackInit.instance.reachHack.reach = (mode.equalsIgnoreCase("Short") ? 4.0F : (mode.equalsIgnoreCase("Normal") ? 5.0F : (mode.equalsIgnoreCase("Long") ? 6.5F : 3.5F)));
    }

    @Override
    public void onDisable() {
        super.onDisable();
        HackInit.instance.reachHack.reach = 0F;
    }

    @Override
    public void onToggle() {
        super.onToggle();
        mc.thePlayer.addChatMessage(new ChatComponentText("dist is : " + HackInit.instance.reachHack.reach));
        mc.thePlayer.addChatMessage(new ChatComponentText("reach dist is : " + mc.playerController.getBlockReachDistance()));
    }
}