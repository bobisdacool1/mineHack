package ru.kalispeller.HackedClient.module.combat;

import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import ru.kalispeller.HackedClient.event.EventTarget;
import ru.kalispeller.HackedClient.event.events.EventUpdate;
import ru.kalispeller.HackedClient.module.Category;
import ru.kalispeller.HackedClient.module.Module;

public class ReachHack extends Module {

    public ReachHack () {
        super("ReachHack", Keyboard.KEY_NUMPAD0, Category.COMBAT);
    }
    public boolean reach;

    @Override
    public void onToggle() {
        super.onToggle();

        reach = !reach;
    }

    public boolean isReach() {
        return reach;
    }
}