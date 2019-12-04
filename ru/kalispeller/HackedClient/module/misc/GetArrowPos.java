package ru.kalispeller.HackedClient.module.misc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import ru.kalispeller.HackedClient.event.EventTarget;
import ru.kalispeller.HackedClient.event.events.EventUpdate;
import ru.kalispeller.HackedClient.module.Category;
import ru.kalispeller.HackedClient.module.Module;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class GetArrowPos extends Module {
    public  GetArrowPos() {
        super("GetArrowPosition", Keyboard.KEY_F4, Category.MISC);
    }


    @Override
    public void onEnable() {
        super.onEnable();
        mc.thePlayer.addChatMessage(new ChatComponentText("Hello, world!"));
    }

    private double prevPosX = 0, prevPosY = 0, prevPosZ = 0;


    //ROUND FUNCTION
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    @EventTarget
    public void onUpdate(EventUpdate event) {


        for (Object object : mc.theWorld.loadedEntityList) {
            Entity entity = (Entity)object;
            if (entity instanceof EntityArrow) {
                double posX, posY, posZ;


                posX = entity.posX;
                posY = entity.posY;
                posZ = entity.posZ;


                if (posX != prevPosX || posY != prevPosY || posZ != prevPosZ) {
                    prevPosX = posX;
                    prevPosY = posY;
                    prevPosZ = posZ;

                    double playerPosX, playerPosY, playerPosZ;

                    double alertPosX, alertPosY, alertPosZ;

                    playerPosX = mc.thePlayer.posX;
                    playerPosY = mc.thePlayer.posY;
                    playerPosZ = mc.thePlayer.posZ;

                    alertPosX = round (posX - playerPosX, 4);
                    alertPosY = round (posY - playerPosY, 4);
                    alertPosZ = round (posZ - playerPosZ, 4);

                    String text =  "X: " + alertPosX + " Y: " + alertPosY + " Z: " + alertPosZ;
                    mc.thePlayer.addChatMessage(new ChatComponentText(text));

                }

            }
        }
    }

}



