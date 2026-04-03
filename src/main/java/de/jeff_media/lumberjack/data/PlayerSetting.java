package de.jeff_media.lumberjack.data;

public class PlayerSetting {
    // Sorting enabled for this player?
    public volatile boolean gravityEnabled;

    // Did we already show the message how to activate sorting?
    public volatile boolean hasSeenMessage = false;

    public PlayerSetting(boolean gravityEnabled) {
        this.gravityEnabled = gravityEnabled;
    }
}
