package com.imabanana80.simplemanhunt.Listeners;

import com.imabanana80.simplemanhunt.Manager.RunnerManger;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;


public class PlayerPortalListener implements Listener {
    @EventHandler
    public static void onPlayerPortal(PlayerPortalEvent e){
        Player runner = RunnerManger.getRunner();
        if (runner != null){
            if (e.getPlayer() == runner) {
                Location from = e.getFrom();
                if (from.getWorld().getEnvironment().equals(World.Environment.NORMAL)){
                    if (e.getTo().getWorld().getEnvironment().equals(World.Environment.NETHER)){
                        RunnerManger.setRunnerNetherSidePortal(e.getTo());
                        RunnerManger.setRunnerPortal(e.getFrom());
                    } else if (e.getTo().getWorld().getEnvironment().equals(World.Environment.THE_END)){
                        RunnerManger.setRunnerEndPortal(e.getFrom());
                    }
                }
            }
        }
    }
}
