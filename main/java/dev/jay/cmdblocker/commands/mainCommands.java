package dev.jay.cmdblocker.commands;

import dev.jay.cmdblocker.CMDBlocker;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mainCommands implements CommandExecutor {

    private final CMDBlocker plugin;
    public mainCommands(CMDBlocker plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (command.getName().equalsIgnoreCase("cmdblocker")){

            if (args.length < 1){

                commandSender.sendMessage(Color(plugin.getConfig().getString("Plugin.Prefix") + plugin.getConfig().getString("Errors.NoInput")));

            }else if (args[0].equalsIgnoreCase("reload")){

                plugin.r.onReload((Player) commandSender);

            }else if (args[0].equalsIgnoreCase("add")){

                try {
                    plugin.a.onAddToList((Player) commandSender, args[1]);
                }catch (ArrayIndexOutOfBoundsException ex){
                    commandSender.sendMessage(Color(plugin.getConfig().getString("Plugin.Prefix") + plugin.getConfig().getString("Errors.NoInput")));
                }

            }else if (args[0].equalsIgnoreCase("remove")){

                try {
                    plugin.r1.onRemoveItem((Player) commandSender, args[1]);
                }catch (ArrayIndexOutOfBoundsException ex){
                    commandSender.sendMessage(Color(plugin.getConfig().getString("Plugin.Prefix") + plugin.getConfig().getString("Errors.NoInput")));
                }

            }else if (args[0].equalsIgnoreCase("list")){

                plugin.l.onListRequest((Player) commandSender);

            }else{

                commandSender.sendMessage(Color(plugin.getConfig().getString("Plugin.Prefix") + plugin.getConfig().getString("Errors.NoInput")));

            }


        }


        return true;
    }

    private String Color(String s){
        s = ChatColor.translateAlternateColorCodes('&',s);
        return s;
    }
}
