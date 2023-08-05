package com.imabanana80.simplemanhunt.Manager;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;

import static net.kyori.adventure.text.format.Style.style;
import static net.kyori.adventure.text.format.TextDecoration.ITALIC;

public class ItemManager {
    public static void giveTracker(Player p){
        Inventory inv = p.getInventory();
        ItemStack item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("Tracker", style().decoration(ITALIC, false).build()));
        meta.setCustomModelData(69);
        item.setItemMeta(meta);

        CompassMeta cmeta = (CompassMeta) meta;
        cmeta.setLodestoneTracked(false);
        cmeta.setLodestone(RunnerManger.getRunner().getLocation());
        item.setItemMeta(cmeta);


        inv.addItem(item);
    }
}
