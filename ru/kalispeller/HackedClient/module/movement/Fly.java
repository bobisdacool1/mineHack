package ru.kalispeller.HackedClient.module.movement;

import de.Hero.settings.Setting;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import ru.kalispeller.HackedClient.HackInit;
import ru.kalispeller.HackedClient.event.EventTarget;
import ru.kalispeller.HackedClient.event.events.EventUpdate;
import ru.kalispeller.HackedClient.module.Category;
import ru.kalispeller.HackedClient.module.Module;

import java.util.ArrayList;

    public class Fly extends Module {

        public Fly() {
            super("Fly", Keyboard.KEY_F, Category.MOVEMENT);
        }

        @Override
        public void setup() {
            ArrayList<String> options = new ArrayList<>();
            options.add("Hypixel");
            options.add("Vanilla");
            HackInit.instance.settingsManager.rSetting(new Setting("Fly Mode", this, "Vanilla", options));
        }

        @EventTarget
        public void onUpdate(EventUpdate event) {
            this.setDisplayName("Fly §7" + HackInit.instance.settingsManager.getSettingByName("Fly Mode").getValString());

            if(HackInit.instance.settingsManager.getSettingByName("Fly Mode").getValString().equalsIgnoreCase("Hypixel")) {
                double y;
                double y1;
                mc.thePlayer.motionY = 0;
                if(mc.thePlayer.ticksExisted % 3 == 0) {
                    y = mc.thePlayer.posY - 1.0E-10D;
                    mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, y, mc.thePlayer.posZ, true));
                }
                y1 = mc.thePlayer.posY + 1.0E-10D;
                mc.thePlayer.setPosition(mc.thePlayer.posX, y1, mc.thePlayer.posZ);
            }

            if(HackInit.instance.settingsManager.getSettingByName("Fly Mode").getValString().equalsIgnoreCase("Vanilla"))
                mc.thePlayer.capabilities.isFlying = true;
        }

        @Override
        public void onDisable() {
            super.onDisable();

            if(HackInit.instance.settingsManager.getSettingByName("Fly Mode").getValString().equalsIgnoreCase("Vanilla"))
                mc.thePlayer.capabilities.isFlying = false;
        }
    }