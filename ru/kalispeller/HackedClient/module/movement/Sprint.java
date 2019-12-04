package ru.kalispeller.HackedClient.module.movement;

import org.lwjgl.input.Keyboard;
import ru.kalispeller.HackedClient.event.EventTarget;
import ru.kalispeller.HackedClient.event.events.EventUpdate;
import ru.kalispeller.HackedClient.module.Category;
import ru.kalispeller.HackedClient.module.Module;

public class Sprint extends Module {
    public Sprint() {
        super ("Sprint", Keyboard.KEY_M, Category.MOVEMENT);
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if(!mc.thePlayer.isCollidedHorizontally && mc.thePlayer.moveForward > 0) {
            mc.thePlayer.setSprinting(true);
        }
    }

    @Override
    public void onDisable(){
        super.onDisable();

        mc.thePlayer.setSprinting(false);
    }
}
