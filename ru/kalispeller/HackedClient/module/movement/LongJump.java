package ru.kalispeller.HackedClient.module.movement;

import net.minecraft.potion.Potion;
import org.lwjgl.input.Keyboard;
import ru.kalispeller.HackedClient.event.EventTarget;
import ru.kalispeller.HackedClient.event.events.EventPostMotionUpdate;
import ru.kalispeller.HackedClient.module.Category;
import ru.kalispeller.HackedClient.module.Module;

public class LongJump extends Module {
    public LongJump() {
        super("LongJump", Keyboard.KEY_L, Category.MOVEMENT);
    }

    @EventTarget
    public void onPost(EventPostMotionUpdate event) {
        if((mc.gameSettings.keyBindForward.isKeyDown() || mc.gameSettings.keyBindLeft.isKeyDown() || mc.gameSettings.keyBindRight.isKeyDown() || mc.gameSettings.keyBindBack.isKeyDown()) && mc.gameSettings.keyBindJump.isKeyDown()) {
            //float dir = mc.thePlayer.rotationYaw + ((mc.thePlayer.moveForward < 0) ? 180 : 0) + ((mc.thePlayer.moveStrafing > 0) ? (-90F * ((mc.thePlayer.moveForward < 0) ? -.5F : ((mc.thePlayer.moveForward > 0) ? .4F : 1F))) : 0);

            float dir = mc.thePlayer.rotationYaw + ((mc.thePlayer.moveForward < 0) ? 180 : 0) + ((mc.thePlayer.moveStrafing > 0) ? (-90F * ((mc.thePlayer.moveForward < 0) ? -.5F : ((mc.thePlayer.moveForward > 0) ? .4F : 1F))) : ((90F * (mc.thePlayer.moveStrafing < 0 ? (mc.thePlayer.moveForward < 0) ? -.5F : ((mc.thePlayer.moveForward > 0) ? .4F : 1F) : 0))));
            float xDir = (float)Math.cos((dir + 90F) * Math.PI / 180);
            float zDir = (float)Math.sin((dir + 90F) * Math.PI / 180);
            if(mc.thePlayer.isCollidedVertically && (mc.gameSettings.keyBindForward.isKeyDown() || mc.gameSettings.keyBindLeft.isKeyDown() || mc.gameSettings.keyBindRight.isKeyDown() || mc.gameSettings.keyBindBack.isKeyDown()) && mc.gameSettings.keyBindJump.isKeyDown()) {
                mc.thePlayer.motionX = xDir * .29F;
                mc.thePlayer.motionZ = zDir * .29F;
            }
            if(mc.thePlayer.motionY == .33319999363422365 && (mc.gameSettings.keyBindForward.isKeyDown() || mc.gameSettings.keyBindLeft.isKeyDown() || mc.gameSettings.keyBindRight.isKeyDown() || mc.gameSettings.keyBindBack.isKeyDown())) {
                if (mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
                    mc.thePlayer.motionX = xDir * 1.34;
                    mc.thePlayer.motionZ = zDir * 1.34;
                } else {
                    mc.thePlayer.motionX = xDir * 1.261;
                    mc.thePlayer.motionZ = zDir * 1.261;
                }
            }
        }
    }
}