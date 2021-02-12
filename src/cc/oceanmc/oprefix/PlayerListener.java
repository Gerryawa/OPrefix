package cc.oceanmc.oprefix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        OPrefix.prefixManager.setPrefixAndSuffix(e.getPlayer());
    }
}
