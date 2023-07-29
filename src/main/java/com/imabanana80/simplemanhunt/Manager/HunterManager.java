package com.imabanana80.simplemanhunt.Manager;

import com.imabanana80.simplemanhunt.SimpleManhunt;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HunterManager {
    public static void addHunter(String playername){
        List<Player> hunters = getHunters();
        hunters.add(Bukkit.getPlayer(playername));
        List<String> hunternames = new ArrayList<>();
        for (Player hunter : hunters){
            hunternames.add(hunter.getName());
        }
        SimpleManhunt.getPlugin().getConfig().set("hunters", hunternames);
        SimpleManhunt.getPlugin().saveConfig();
        
    }
    
    public static void removeHunter(String playername){
        List<Player> hunters = getHunters();
        hunters.remove(Bukkit.getPlayer(playername));
        List<String> hunternames = new ArrayList<>();
        for (Player hunter : hunters){
            hunternames.add(hunter.getName());
        }
        SimpleManhunt.getPlugin().getConfig().set("hunters", hunternames);
        SimpleManhunt.getPlugin().saveConfig();
    }
    
    public static List<Player> getHunters(){
        List<?> stringHunters = SimpleManhunt.getPlugin().getConfig().getList("hunters");
        List<Player> hunters = new ArrayList<>();
        for (Object huntername : stringHunters){
            Player hunter = Bukkit.getPlayer((String) huntername);
            if (hunter != null){
                hunters.add(hunter);
            }
        }
        return hunters;
    }
}
