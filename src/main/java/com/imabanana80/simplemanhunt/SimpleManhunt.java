package com.imabanana80.simplemanhunt;

import com.imabanana80.simplemanhunt.Commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleManhunt extends JavaPlugin {

    private static SimpleManhunt plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        
        getCommand("runner").setExecutor(new RunnerCommand());
        getCommand("setrunner").setExecutor(new SetRunnerCommand());
        getCommand("hunters").setExecutor(new HuntersCommand());
        getCommand("addhunter").setExecutor(new AddHunterCommand());
        getCommand("removehunter").setExecutor(new RemoveHunterCommand());

    }

    public static SimpleManhunt getPlugin() { return plugin; }
    
}
