package com.imabanana80.simplemanhunt.Commands;

import com.imabanana80.simplemanhunt.Manager.RunnerManger;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SetRunnerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player p){
            if (strings.length > 0){
                Player runner = Bukkit.getPlayer(strings[0]);
                if (runner == null){
                    p.sendMessage(Component.text("Invalid username. Please specify a valid player's username.").color(TextColor.color(0xFF5555)));
                } else {
                    RunnerManger.setRunner(strings[0]);
                    p.sendMessage(Component.text(strings[0] + " is now the runner!"));
                    runner.sendMessage(Component.text("You are now the runner!"));
                }
            } else {
                p.sendMessage(Component.text("Incomplete command. Please specify who the runner to set is, and with a valid username.").color(TextColor.color(0xFF5555)));
            }
            
        }
        return true;
    }
}
