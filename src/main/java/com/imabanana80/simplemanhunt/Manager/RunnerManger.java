package com.imabanana80.simplemanhunt.Manager;

import com.imabanana80.simplemanhunt.SimpleManhunt;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RunnerManger {
    
    private static Location runnerPortal;
    private static Location runnerNetherSidePortal;
    private static Location runnerEndPortal;
    
    public static void setRunner(String runnername){
        SimpleManhunt.getPlugin().getConfig().set("runner", runnername);
        SimpleManhunt.getPlugin().saveConfig();
    }
    public static Player getRunner(){
        Player runner = Bukkit.getPlayer((String) SimpleManhunt.getPlugin().getConfig().get("runner"));
        
        return runner;
    }
    public static void resetSavedPortals(){
        runnerPortal = null;
        runnerNetherSidePortal = null;
        runnerEndPortal = null;
    }
    
    public static Location getRunnerPortal(){
        return runnerPortal;
    }
    public static void setRunnerPortal(Location loc){
        runnerPortal = loc;
    }
    public static Location getRunnerEndPortal(){
        return runnerEndPortal;
    }
    public static void setRunnerEndPortal(Location loc){
        runnerEndPortal = loc;
    }
    public static Location getRunnerNetherSidePortal(){
        return runnerNetherSidePortal;
    }
    public static void setRunnerNetherSidePortal(Location loc){
        runnerNetherSidePortal = loc;
    }
    
}
