package ru.kalispeller.HackedClient.module.misc;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovementInputFromOptions;
import org.lwjgl.input.Keyboard;
import ru.kalispeller.HackedClient.HackInit;
import ru.kalispeller.HackedClient.event.EventTarget;
import ru.kalispeller.HackedClient.event.events.EventUpdate;
import ru.kalispeller.HackedClient.module.Category;
import ru.kalispeller.HackedClient.module.GlobFunc;
import ru.kalispeller.HackedClient.module.Module;

import java.math.BigDecimal;

public class FastBuild extends Module {

    public FastBuild() {
        super("FastBuild", Keyboard.KEY_LMENU, Category.MISC);
    }

    public boolean isSneak;

    @EventTarget
    public void onPre(EventUpdate event) {

        ItemStack itemStack = mc.thePlayer.inventory.getCurrentItem();

        double p2PosX = mc.thePlayer.posX;
        double p2PosY = mc.thePlayer.posY;
        double p2PosZ = mc.thePlayer.posZ;

        int pPosX = GlobFunc.getInt(p2PosX);
        int pPosY = GlobFunc.getInt(p2PosY);
        int pPosZ = GlobFunc.getInt(p2PosZ);


        double splitX = GlobFunc.getFrac(mc.thePlayer.posX);
        double splitZ = GlobFunc.getFrac(mc.thePlayer.posZ);

        double alertX = GlobFunc.round(splitX, 1);
        double alertY = GlobFunc.round(splitZ, 1);

        if (alertX == 0.3D || alertY == 0.3D || alertX == 0.7D || alertY == 0.7D ) {
            HackInit.instance.fastBuild.isSneak = true;
        } else {
            HackInit.instance.fastBuild.isSneak = false;
        }
        mc.thePlayer.addChatMessage(new ChatComponentText("x: " + pPosX + " y: " + pPosY + " z: " + pPosZ));
    }

    @Override
    public void onDisable() {
        super.onDisable();
        HackInit.instance.fastBuild.isSneak = false;
    }
}



    //setblock => shiftup => go backward => pos => shiftdown => setblock