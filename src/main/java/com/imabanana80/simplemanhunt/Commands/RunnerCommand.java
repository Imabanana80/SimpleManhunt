package com.imabanana80.simplemanhunt.Commands;

import com.imabanana80.simplemanhunt.Manager.RunnerManger;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RunnerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player p){
            Player runner = RunnerManger.getRunner();
            if (runner == null){
                p.sendMessage(Component.text("The runner is undefined. Please define the runner using /setrunner"));
            } else {
                p.sendMessage(Component.text(runner.getName() + " is currently the runner."));
            }
        }
        return true;
    }
}
