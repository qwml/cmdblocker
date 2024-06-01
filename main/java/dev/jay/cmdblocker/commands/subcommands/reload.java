package dev.jay.cmdblocker.commands.subcommands;

import dev.jay.cmdblocker.CMDBlocker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;



public class reload {


    private final CMDBlocker plugin;
    public reload(CMDBlocker plugin){
        this.plugin = plugin;
    }

    public void onReload(Player player){

        if (player.hasPermission("cmdblocker.reload")){

            plugin.reloadConfig();
            player.sendMessage(Color(plugin.getConfig().getString("Plugin.Prefix") + "&aPlugin reloaded."));

        }


    }

    private String Color(String s){
        s = ChatColor.translateAlternateColorCodes('&',s);
        return s;
    }
}
