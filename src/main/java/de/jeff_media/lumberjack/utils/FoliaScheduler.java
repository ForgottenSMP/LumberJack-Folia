package de.jeff_media.lumberjack.utils;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;

public final class FoliaScheduler {

    private FoliaScheduler() {
    }

    public static void runAtBlock(Plugin plugin, Block block, Runnable runnable) {
        Location location = block.getLocation();
        plugin.getServer().getRegionScheduler().execute(plugin, location, runnable);
    }

    public static void runAtBlockLater(Plugin plugin, Block block, long delayTicks, Runnable runnable) {
        Location location = block.getLocation();
        if (delayTicks <= 0) {
            plugin.getServer().getRegionScheduler().execute(plugin, location, runnable);
            return;
        }
        plugin.getServer().getRegionScheduler().runDelayed(plugin, location, task -> runnable.run(), delayTicks);
    }
}
