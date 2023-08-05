package com.imabanana80.simplemanhunt.Listeners;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        ItemStack toremove = null;
        for (ItemStack drop : e.getDrops()){
            if (drop.getItemMeta().hasCustomModelData()){
                if (drop.getItemMeta().getCustomModelData() == 69){
                    toremove = drop;
                }
            }
        }
        
        if (toremove != null){
            e.getDrops().remove(toremove);
        }

    }
}
