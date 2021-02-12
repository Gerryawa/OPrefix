package cc.oceanmc.oprefix;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.ArrayList;

public class PrefixManager {
    private static Scoreboard sb;
    private static ScoreboardManager sbm;

    protected PrefixManager() {
        sbm = OPrefix.p.getServer().getScoreboardManager();
        sb = sbm.getNewScoreboard();
        startUpdateRunnable();
    }

    protected void setPrefix(Player player) {
        if (sb.getTeam(player.getName().toLowerCase()) == null) {
            sb.registerNewTeam(player.getName().toLowerCase());
            sb.getTeam(player.getName().toLowerCase()).setPrefix(Utils.parseColor(Utils.parsePAPI("%luckperms_prefix%", player)));
            sb.getTeam(player.getName().toLowerCase()).addEntry(player.getName());
            player.setScoreboard(sb);
        } else {
            sb.getTeam(player.getName().toLowerCase()).setPrefix(Utils.parseColor(Utils.parsePAPI("%luckperms_prefix%", player)));
            if (!sb.getTeam(player.getName().toLowerCase()).getEntries().contains(player.getName())) {
                sb.getTeam(player.getName().toLowerCase()).addEntry(player.getName());
            }
            player.setScoreboard(sb);
        }
    }

    protected void updatePrefix(Player player) {
        if (sb.getTeam(player.getName().toLowerCase()) != null) {
            sb.getTeam(player.getName().toLowerCase()).setPrefix(Utils.parseColor(Utils.parsePAPI("%luckperms_prefix%", player)));
            player.setScoreboard(sb);
        }else {
            sb.registerNewTeam(player.getName().toLowerCase());
            sb.getTeam(player.getName().toLowerCase()).setPrefix(Utils.parseColor(Utils.parsePAPI("%luckperms_prefix%", player)));
            sb.getTeam(player.getName().toLowerCase()).addEntry(player.getName());
            player.setScoreboard(sb);
        }
    }

    private void startUpdateRunnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                ArrayList<Player> list = (ArrayList<Player>) Utils.getOnlinePlayerList();
                for (Player player : list) {
                    updatePrefix(player);
                }
            }
        }.runTaskTimerAsynchronously(OPrefix.p, 0, 5 * 20L);
    }
}
