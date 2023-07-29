package com.imabanana80.simplemanhunt;

import com.imabanana80.simplemanhunt.Commands.AddHunterCommand;
import com.imabanana80.simplemanhunt.Commands.RemoveHunterCommand;
import com.imabanana80.simplemanhunt.Commands.RunnerCommand;
import com.imabanana80.simplemanhunt.Commands.SetRunnerCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleManhunt extends JavaPlugin {

    private static SimpleManhunt plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        
        getCommand("runner").setExecutor(new RunnerCommand());
        getCommand("setrunner").setExecutor(new SetRunnerCommand());
        getCommand("addhunter").setExecutor(new AddHunterCommand());
        getCommand("removehunter").setExecutor(new RemoveHunterCommand());

    }

    public static SimpleManhunt getPlugin() { return plugin; }
    
}
