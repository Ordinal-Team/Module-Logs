package fr.ordinalteam.bot.logs.utils;

/**
 * Create by Arinonia 29/06/2021
 */
public enum ChannelLogs {
    IO("858856711904821298"),
    MODS("859244684588613652"),
    ROLES("859244713331916821"),
    UNKNOWN("859245818002014268");

    private final String id;

    ChannelLogs(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
