package com.imabanana80.simplemanhunt.Listeners;

import com.imabanana80.simplemanhunt.Manager.ItemManager;
import com.imabanana80.simplemanhunt.SimpleManhunt;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        if (SimpleManhunt.getPlugin().getConfig().getList("hunters").contains(e.getPlayer().getName())){
            ItemManager.giveTracker(e.getPlayer());
        }
    }
}
