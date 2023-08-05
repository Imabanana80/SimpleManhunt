package com.imabanana80.simplemanhunt;

import com.imabanana80.simplemanhunt.Commands.*;
import com.imabanana80.simplemanhunt.Listeners.PlayerDeathListener;
import com.imabanana80.simplemanhunt.Listeners.PlayerInteractListener;
import com.imabanana80.simplemanhunt.Listeners.PlayerPortalListener;
import com.imabanana80.simplemanhunt.Listeners.PlayerRespawnListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleManhunt extends JavaPlugin {

    private static SimpleManhunt plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerPortalListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);
        
        getCommand("runner").setExecutor(new RunnerCommand());
        getCommand("setrunner").setExecutor(new SetRunnerCommand());
        getCommand("hunters").setExecutor(new HuntersCommand());
        getCommand("addhunter").setExecutor(new AddHunterCommand());
        getCommand("removehunter").setExecutor(new RemoveHunterCommand());
        getCommand("tracker").setExecutor(new GiveTrackerCommand());

    }

    public static SimpleManhunt getPlugin() { return plugin; }
    
}
