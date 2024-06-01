package dev.jay.cmdblocker.commands.subcommands;

import dev.jay.cmdblocker.CMDBlocker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class list {

    private final CMDBlocker plugin;
    public list(CMDBlocker plugin){
        this.plugin = plugin;
    }


    public void onListRequest(Player player){
        List<String> listofcommands = plugin.getConfig().getStringList("BlockedCMDS");
        String title = plugin.getConfig().getString("ListFormat.Title");
        List<String> format = plugin.getConfig().getStringList("ListFormat.Format");


        if (player.hasPermission("cmdblocker.list")){

            player.sendMessage(Color(title));
            for (String list : listofcommands){

                for(String form : format) {

                    form = form.replace("%cmd%", list);
                    player.sendMessage(Color(form));

                }

            }

        }

    }

    private String Color(String s){
        s = ChatColor.translateAlternateColorCodes('&',s);
        return s;
    }
}
