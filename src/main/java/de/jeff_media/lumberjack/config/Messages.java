package de.jeff_media.lumberjack.config;


import de.jeff_media.lumberjack.LumberJack;

public class Messages {

    public final String MSG_ACTIVATED;
    public final String MSG_DEACTIVATED;
    public final String MSG_COMMANDMESSAGE;
    public final String MSG_COMMANDMESSAGE2;
    public final String MSG_CAN_NOT_DISABLE;
    final LumberJack plugin;

    public Messages(LumberJack plugin) {
        this.plugin = plugin;

        MSG_ACTIVATED = plugin.getConfig()
                .getString("message-gravity-enabled", "<gray>Tree gravity has been <green>enabled<gray>.<reset>");

        MSG_DEACTIVATED = plugin.getConfig()
                .getString("message-gravity-disabled", "<gray>Tree gravity has been <red>disabled<gray>.<reset>");

        MSG_COMMANDMESSAGE = plugin.getConfig().getString(
                "message-when-breaking-log", "<gray>Hint: Type <gold>/lumberjack<gray> to enable tree gravity.");

        MSG_COMMANDMESSAGE2 = plugin.getConfig().getString(
                "message-when-breaking-log2", "<gray>Hint: Type <gold>/lumberjack<gray> to disable tree gravity.");

        MSG_CAN_NOT_DISABLE = plugin.getConfig().getString(
                "message-can-not-disable", "<red>You are not allowed to disable tree gravity.");


    }

}