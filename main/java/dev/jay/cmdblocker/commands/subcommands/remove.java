package dev.jay.cmdblocker.commands.subcommands;

import dev.jay.cmdblocker.CMDBlocker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class remove {

    private final CMDBlocker plugin;
    public remove(CMDBlocker plugin){
        this.plugin = plugin;
    }

    public void onRemoveItem(Player player, String args){

        List<String> list = plugin.getConfig().getStringList("BlockedCMDS");

        list.remove(args);

        plugin.getConfig().set("BlockedCMDS", list);
        plugin.saveConfig();

        String message = plugin.getConfig().getString("Messages.Remove");
        message = message.replace("%cmd%", args);

        player.sendMessage(Color(plugin.getConfig().getString("Plugin.Prefix") + message));

    }

    private String Color(String s){
        s = ChatColor.translateAlternateColorCodes('&',s);
        return s;
    }

}
