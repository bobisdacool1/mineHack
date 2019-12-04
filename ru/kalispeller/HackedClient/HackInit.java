package ru.kalispeller.HackedClient;

import de.Hero.clickgui.ClickGUI;
import de.Hero.settings.SettingsManager;
import org.lwjgl.opengl.Display;
import ru.kalispeller.HackedClient.event.EventManager;
import ru.kalispeller.HackedClient.event.EventTarget;
import ru.kalispeller.HackedClient.event.events.EventKey;
import ru.kalispeller.HackedClient.module.ModuleManager;
import ru.kalispeller.HackedClient.module.combat.ReachHack;

public class HackInit {
    public String name = "Hacked Client", version = "0.0.1", creator = "Tabooscuscas";

    public static HackInit instance = new HackInit();

    public SettingsManager settingsManager;
    public EventManager eventManager;
    public ModuleManager moduleManager;
    public ClickGUI clickGui;
    public ReachHack reachHack;


    public void startClient(){
        settingsManager = new SettingsManager();
        eventManager = new EventManager();
        moduleManager = new ModuleManager();
        clickGui = new ClickGUI();
        reachHack = new ReachHack();

        System.out.println("[" + name + "] Starting client, b" + version + ", created by " + creator);
        Display.setTitle(name + " b" + version + " created by " + creator);

        eventManager.register(this);
    }
    public void stopClient() {
        eventManager.unregister(this);
    }

    @EventTarget
    public void onKey(EventKey event) {
        moduleManager.getModules().stream().filter(module -> module.getKey() == event.getKey()).forEach(module -> module.toggle());
    }
}

/*
* CHANGED LINES IN VANILLA MINECRAFT
*
* PlayerControllerMP.java, line 343, getBlockReachDistance
*
* EntityRenderer.java
*
* */

