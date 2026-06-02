package de.jeff_media.lumberjack.placeholders;

import de.jeff_media.lumberjack.LumberJack;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class LumberJackPlaceholderExpansion extends PlaceholderExpansion {

    private final LumberJack plugin;

    public LumberJackPlaceholderExpansion(LumberJack plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "lumberjack";
    }

    @Override
    public @NotNull String getAuthor() {
        return String.join(", ", plugin.getDescription().getAuthors());
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        if (!params.equalsIgnoreCase("enabled")) {
            return null;
        }

        if (player == null) {
            return "false";
        }

        return String.valueOf(plugin.isGravityEnabled(player));
    }
}
