package de.jeff_media.lumberjack.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public final class FoliaCompat {

    private FoliaCompat() {
    }

    public static boolean isOwnedByCurrentRegion(Block block) {
        return Bukkit.isOwnedByCurrentRegion(block);
    }

    public static boolean isOwnedByCurrentRegion(World world, int blockX, int blockY, int blockZ) {
        return Bukkit.isOwnedByCurrentRegion(new Location(world, blockX, blockY, blockZ));
    }
}
