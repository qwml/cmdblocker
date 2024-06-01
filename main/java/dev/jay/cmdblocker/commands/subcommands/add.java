package dev.jay.cmdblocker.commands.subcommands;

import dev.jay.cmdblocker.CMDBlocker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class add {

    private final CMDBlocker plugin;
    public add(CMDBlocker plugin){
        this.plugin = plugin;
    }

    public void onAddToList(Player player, String arg){

        List<String> list = plugin.getConfig().getStringList("BlockedCMDS");

        list.add(arg);

        plugin.getConfig().set("BlockedCMDS", list);
        plugin.saveConfig();

        String message = plugin.getConfig().getString("Messages.Add");
        message = message.replace("%cmd%", arg);

        player.sendMessage(Color(plugin.getConfig().getString("Plugin.Prefix") + message));

    }

    private String Color(String s){
        s = ChatColor.translateAlternateColorCodes('&',s);
        return s;
    }
}
