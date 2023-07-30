package com.imabanana80.simplemanhunt.Commands;

import com.imabanana80.simplemanhunt.Manager.HunterManager;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HuntersCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player p){
            List<Player> hunters = HunterManager.getHunters();
            if (hunters == null){
                p.sendMessage(Component.text("The hunters was not properly defined. Please re-define the runner using /setrunner"));
            } else {
                for (Player hunter : hunters){
                    p.sendMessage(Component.text(hunter.getName() + " is a hunter"));
                }
            }
        }
        return true;
    }
}
