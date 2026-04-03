package de.jeff_media.lumberjack.commands;

import de.jeff_media.lumberjack.LumberJack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandLumberjack implements CommandExecutor {

    private final LumberJack plugin;

    public CommandLumberjack(LumberJack plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            return toggle(sender);
        }

        return switch (args[0].toLowerCase()) {
            case "reload" -> reload(sender);
            case "debug" -> debug(sender);
            default -> false;
        };
    }

    private boolean toggle(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            sender.sendPlainMessage("You must be a in-game to run this command.");
            return true;
        }

        if (!player.hasPermission("lumberjack.use")) {
            sender.sendPlainMessage("You do not have permission to use this command.");
            return true;
        }

        if (player.hasPermission("lumberjack.force") && !player.hasPermission("lumberjack.force.ignore")) {
            player.sendRichMessage(plugin.messages.MSG_CAN_NOT_DISABLE);
            return true;
        }

        plugin.togglePlayerSetting(player);

        if (plugin.getPlayerSetting(player).gravityEnabled) {
            sender.sendRichMessage(plugin.messages.MSG_ACTIVATED);
        } else {
            sender.sendRichMessage(plugin.messages.MSG_DEACTIVATED);
        }

        return true;
    }

    private boolean reload(CommandSender sender) {
        if (!sender.hasPermission("lumberjack.reload")) {
            sender.sendPlainMessage("You do not have permission to use this command.");
            return true;
        }

        plugin.reload();
        sender.sendMessage(Component.text("LumberJack has been reloaded.").color(NamedTextColor.GREEN));
        return true;
    }

    private boolean debug(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            sender.sendPlainMessage("You must be a in-game to run this command.");
            return true;
        }

        if (!sender.hasPermission("lumberjack.debug")) {
            sender.sendPlainMessage("You do not have permission to use this command.");
            return true;
        }

        Block target = player.getTargetBlock(null, 20);
        player.sendPlainMessage(String.valueOf(plugin.getBlockTracker().isPlayerPlacedBlock(target)));
        return true;
    }
}
