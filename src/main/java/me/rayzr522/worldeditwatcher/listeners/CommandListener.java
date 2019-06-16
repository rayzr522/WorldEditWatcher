package me.rayzr522.worldeditwatcher.listeners;

import me.rayzr522.worldeditwatcher.WorldEditWatcher;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    private final WorldEditWatcher plugin;

    public CommandListener(WorldEditWatcher plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (plugin.checkPermission(e.getPlayer(), "bypass", false)) {
            return;
        }

        if (e.getMessage().startsWith("//")) {
            Bukkit.broadcast(plugin.tr("alert.message", e.getPlayer().getName(), e.getMessage()), "WorldEditWatcher.notify");
        }
    }
}
