package com.imabanana80.simplemanhunt.Listeners;

import com.imabanana80.simplemanhunt.Manager.RunnerManger;
import com.imabanana80.simplemanhunt.SimpleManhunt;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

import java.util.logging.Level;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if (e.getAction().isRightClick()){
            ItemStack held = e.getItem();
            if (held != null && held.getItemMeta().hasCustomModelData()){
                Player p = e.getPlayer();
                if (held.getItemMeta().getCustomModelData() == 69){
                    Player runner = RunnerManger.getRunner();
                    
                    CompassMeta cmeta = (CompassMeta) held.getItemMeta();
                    if (runner == null){
                        p.sendActionBar(Component.text("The runner is either offline or is undefined").color(TextColor.color(0xFF5555)));
                    } else if (p.getLocation().getWorld().getEnvironment().equals(runner.getLocation().getWorld().getEnvironment())){
                        cmeta.setLodestone(RunnerManger.getRunner().getLocation());
                        p.sendActionBar(Component.text("Tracking " + runner.getName()));
                    } else if (p.getLocation().getWorld().getEnvironment().equals(World.Environment.NORMAL)){
                        if (runner.getLocation().getWorld().getEnvironment().equals(World.Environment.NETHER)){
                            cmeta.setLodestone(RunnerManger.getRunnerPortal());
                            p.sendActionBar(Component.text("Tracking " + runner.getName() + "'s NETHER portal"));
                        } else if (runner.getLocation().getWorld().getEnvironment().equals(World.Environment.THE_END)){
                            cmeta.setLodestone(RunnerManger.getRunnerEndPortal());
                            p.sendActionBar(Component.text("Tracking " + runner.getName() + "'s END portal"));
                        }
                    } else if (p.getLocation().getWorld().getEnvironment().equals(World.Environment.NETHER)){
                        cmeta.setLodestone(RunnerManger.getRunnerNetherSidePortal());
                        p.sendActionBar(Component.text("Tracking " + runner.getName() + "'s NETHER portal"));
                    } else if (p.getLocation().getWorld().getEnvironment().equals(World.Environment.THE_END)){
                        p.sendActionBar(Component.text("The runner is not currently in the end"));
                    }
                    
                    runner.sendActionBar(Component.text(p.getName() + " is now tracking you"));
                    held.setItemMeta(cmeta);

                    SimpleManhunt.getPlugin().getLogger().log(Level.INFO, p.getName() + " refreshed their tracker");
                }
            }
        }
    }
}
