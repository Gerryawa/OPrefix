package cc.oceanmc.oprefix;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    protected static List<Player> getOnlinePlayerList() {
        return new ArrayList<>(OPrefix.p.getServer().getOnlinePlayers());
    }

    protected static String parsePAPI(String str, Player player) {
        return PlaceholderAPI.setPlaceholders(player,str);
    }

    protected static String parseColor(String str) {
        return ChatColor.translateAlternateColorCodes('&',str);
    }
}
