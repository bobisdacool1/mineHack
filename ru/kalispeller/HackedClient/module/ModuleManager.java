package ru.kalispeller.HackedClient.module;

import ru.kalispeller.HackedClient.module.movement.*;
import ru.kalispeller.HackedClient.module.player.*;
import ru.kalispeller.HackedClient.module.render.*;
import ru.kalispeller.HackedClient.module.combat.*;

import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Module> modules = new ArrayList<Module>();

    public ModuleManager() {
        //COMBAT
        modules.add(new KillAura());
        modules.add(new AntiBot());
        modules.add(new ReachHack());

        //MOVEMENT
        modules.add(new Sprint());
        modules.add(new Fly());
        modules.add(new Step());
        modules.add(new LongJump());

        //RENDER
        modules.add(new FullBright());
        modules.add(new ClickGUI());

        //PLAYER
        modules.add(new noFall());

        //MISC
//        modules.add(new GetArrowPos());

        //NONE

    }

    public ArrayList<Module> getModules() {
        return modules;
    }
    public Module getModuleByName(String name) {
        return modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }


}
