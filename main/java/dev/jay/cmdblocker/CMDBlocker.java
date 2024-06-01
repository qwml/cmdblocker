package dev.jay.cmdblocker;

import dev.jay.cmdblocker.commands.mainCommands;
import dev.jay.cmdblocker.commands.subcommands.add;
import dev.jay.cmdblocker.commands.subcommands.list;
import dev.jay.cmdblocker.commands.subcommands.reload;
import dev.jay.cmdblocker.commands.subcommands.remove;
import dev.jay.cmdblocker.listeners.blockCommands;
import org.bukkit.plugin.java.JavaPlugin;

public final class CMDBlocker extends JavaPlugin {

    public list l;
    public reload r;
    public add a;
    public remove r1;

    @Override
    public void onEnable() {
        getLogger().info("CMDBLOCKER ACTIVATED, YOU'RE PROTECTED.");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        l = new list(this);
        r = new reload(this);
        a = new add(this);
        r1 = new remove(this);
        getServer().getPluginManager().registerEvents(new blockCommands(this),this);
        getCommand("cmdblocker").setExecutor(new mainCommands(this));
    }

}
