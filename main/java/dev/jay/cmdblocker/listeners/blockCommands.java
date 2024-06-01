package dev.jay.cmdblocker.listeners;

import dev.jay.cmdblocker.CMDBlocker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class blockCommands implements Listener {

    private CMDBlocker plugin;
    public blockCommands(CMDBlocker plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent pcpe){
        List<String> listofcommands = plugin.getConfig().getStringList("BlockedCMDS");

        if (plugin.getConfig().getBoolean("OpBypass")) {
            if (!pcpe.getPlayer().hasPermission(plugin.getConfig().getString("BypassPerm")) || !pcpe.getPlayer().isOp()){
                String playerCommand = pcpe.getMessage();
                for (String bcmds : listofcommands){

                    if (playerCommand.equalsIgnoreCase(bcmds)){

                        pcpe.setCancelled(true);
                        pcpe.getPlayer().sendMessage(Color(plugin.getConfig().getString("Plugin.Prefix") + plugin.getConfig().getString("Messages.Blocked")));
                        for (Player p : Bukkit.getOnlinePlayers()){

                            if (p.hasPermission(plugin.getConfig().getString("LogPerm"))){

                                p.sendMessage(Color(plugin.getConfig().getString("Plugin.Prefix") + plugin.getConfig().getString("Messages.Log")));

                            }

                        }


                    }

                }



            }

        }else{

            if (!pcpe.getPlayer().hasPermission(plugin.getConfig().getString("BypassPerm")) || pcpe.getPlayer().isOp()){


                String playerCommand = pcpe.getMessage();
                for (String bcmds : listofcommands){

                    if (playerCommand.equalsIgnoreCase(bcmds)){

                        pcpe.setCancelled(true);
                        pcpe.getPlayer().sendMessage(Color(plugin.getConfig().getString("Plugin.Prefix") + plugin.getConfig().getString("Messages.Blocked")));
                        for (Player p : Bukkit.getOnlinePlayers()){

                            if (p.hasPermission(plugin.getConfig().getString("LogPerm"))){

                                p.sendMessage(Color(plugin.getConfig().getString("Plugin.Prefix") + plugin.getConfig().getString("Messages.Log")));

                            }

                        }

                    }

                }


            }

        }

    }

    private String Color(String s){
        s = ChatColor.translateAlternateColorCodes('&',s);
        return s;
    }
}
