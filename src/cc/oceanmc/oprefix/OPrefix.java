package cc.oceanmc.oprefix;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class OPrefix extends JavaPlugin {
    protected static Plugin p;
    protected static PrefixManager prefixManager;

    @Override
    public void onEnable() {
        p = this;
        prefixManager = new PrefixManager();
        getServer().getPluginManager().registerEvents(new PlayerListener(),this);
        getLogger().info("OPrefix 已启动!");
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks(this);
        getLogger().info("OPrefix 已关闭!");
    }

}
