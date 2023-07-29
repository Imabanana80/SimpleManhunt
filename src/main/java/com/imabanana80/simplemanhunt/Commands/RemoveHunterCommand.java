package com.imabanana80.simplemanhunt.Commands;

import com.imabanana80.simplemanhunt.Manager.HunterManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RemoveHunterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player p){
            if (strings.length > 0){
                Player hunter = Bukkit.getPlayer(strings[0]);
                if (hunter == null){
                    p.sendMessage(Component.text("Invalid username. Please specify a valid player's username.").color(TextColor.color(0xFF5555)));
                } else {
                    if (HunterManager.getHunters().contains(hunter)){
                        HunterManager.removeHunter(hunter.getName());
                        p.sendMessage(Component.text(strings[0] + " is no longer a hunter!"));
                        hunter.sendMessage(Component.text("You have been removed as a hunter!"));
                    } else {
                        p.sendMessage(Component.text(hunter.getName() + " is already not a hunter").color(TextColor.color(0xFF5555)));
                    }
                }
            } else {
                p.sendMessage(Component.text("Incomplete command. Please specify who the hunter to remove is, and with a valid username.").color(TextColor.color(0xFF5555)));
            }
        }
        return true;
    }
}
