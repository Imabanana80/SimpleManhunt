package com.imabanana80.simplemanhunt.Manager;

import com.imabanana80.simplemanhunt.SimpleManhunt;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class RunnerManger {
    public static void setRunner(String runnername){
        SimpleManhunt.getPlugin().getConfig().set("runner", runnername);
        SimpleManhunt.getPlugin().saveConfig();
    }
    public static Player getRunner(){
        Player runner = Bukkit.getPlayer((String) SimpleManhunt.getPlugin().getConfig().get("runner"));
        
        return runner;
    }
}
