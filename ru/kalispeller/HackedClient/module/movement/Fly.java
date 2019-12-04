package ru.kalispeller.HackedClient.module.movement;

import de.Hero.settings.Setting;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.lwjgl.input.Keyboard;
import ru.kalispeller.HackedClient.HackInit;
import ru.kalispeller.HackedClient.event.EventTarget;
import ru.kalispeller.HackedClient.event.events.EventUpdate;
import ru.kalispeller.HackedClient.module.Category;
import ru.kalispeller.HackedClient.module.Module;

import java.util.ArrayList;

public class Fly extends Module {
    String mode = HackInit.instance.settingsManager.getSettingByName("Fly Mode").getValString();

    public Fly() {
        super("Fly", Keyboard.KEY_F, Category.MOVEMENT);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<>();
        options.add("Hypixel");
        options.add("Normal");
        HackInit.instance.settingsManager.rSetting(new Setting("Fly Mode", this, "Hypixel", options));
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        this.setDisplayName("Fly §" + mode);

        if(mode.equalsIgnoreCase("Hypixel")) {
            double y;
            double yl;
            mc.thePlayer.motionY = 0;
            if(mc.thePlayer.ticksExisted % 3 == 0) {
                y = mc.thePlayer.posY - 1.0E-10D;
                mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, y, mc.thePlayer.posZ, true));
            }
            yl = mc.thePlayer.posY + 1.0E-10D;
            mc.thePlayer.setPosition(mc.thePlayer.posX, yl, mc.thePlayer.posZ);
        }

        if(mode.equalsIgnoreCase("Vanilla"))
            mc.thePlayer.capabilities.isFlying = true;
    }

    @Override
    public void onDisable() {
         super.onDisable();

         if(mode.equalsIgnoreCase(("Vanilla")))
            mc.thePlayer.capabilities.isFlying = false;
    }
}
