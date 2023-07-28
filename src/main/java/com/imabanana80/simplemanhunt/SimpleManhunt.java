package com.imabanana80.simplemanhunt;

import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.N;

public final class SimpleManhunt extends JavaPlugin {

    private static SimpleManhunt plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();

    }

    public static SimpleManhunt getPlugin() { return plugin; }
    
}
