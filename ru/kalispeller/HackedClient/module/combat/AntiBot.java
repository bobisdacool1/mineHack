package ru.kalispeller.HackedClient.module.combat;

import de.Hero.settings.Setting;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
import org.lwjgl.input.Keyboard;
import ru.kalispeller.HackedClient.HackInit;
import ru.kalispeller.HackedClient.event.EventTarget;
import ru.kalispeller.HackedClient.event.events.EventReceivePacket;
import ru.kalispeller.HackedClient.event.events.EventUpdate;
import ru.kalispeller.HackedClient.module.Category;
import ru.kalispeller.HackedClient.module.Module;

import java.util.ArrayList;

public class AntiBot extends Module {
    public AntiBot() {
        super("antiBot", Keyboard.KEY_U, Category.COMBAT);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<>();
        options.add("Advanced");
        options.add ("Watchdog");
        HackInit.instance.settingsManager.rSetting(new Setting("AntiBot Mode", this, "Advanced", options));
    }

    @EventTarget
    public void onReceivePacket(EventReceivePacket event) {

        if (HackInit.instance.settingsManager.getSettingByName("AntiBot Mode").getValString().equalsIgnoreCase("Advanced") && event.getPacket() instanceof S0CPacketSpawnPlayer) {
            S0CPacketSpawnPlayer packet = (S0CPacketSpawnPlayer)event.getPacket();
            double posX = packet.getX() /32D;
            double posY = packet.getY() /32D;
            double posZ = packet.getZ() /32D;

            double diffX = mc.thePlayer.posX - posX;
            double diffY = mc.thePlayer.posX - posY;
            double diffZ = mc.thePlayer.posX - posZ;

            double dist = Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);

            if(dist <= 17D && posX != mc.thePlayer.posX && posY != mc.thePlayer.posY && posZ != mc.thePlayer.posZ) {
                event.setCancelled(true);
            }
        }
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        String mode = HackInit.instance.settingsManager.getSettingByName("AntiBot Mode").getValString();
        this.setDisplayName("AntiBot \u00A7" + mode);
        if(mode.equalsIgnoreCase("Watchdog"))
            for(Object entity : mc.theWorld.loadedEntityList)
                if(((Entity)entity).isInvisible() && entity != mc.thePlayer)
                    mc.theWorld.removeEntity((Entity)entity);
    }
}