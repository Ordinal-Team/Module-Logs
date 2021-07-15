package fr.ordinalteam.bot.logs.utils;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.Locale;

/**
 * Create by Arinonia 28/06/2021
 */
public class Util {

    public static MessageChannel getLogsChannelFromGuild(Guild guild, String channel) {
        switch (channel.toLowerCase(Locale.ROOT)) {
            case "io":
                return guild.getTextChannelById(ChannelLogs.IO.getId());
            case "mods":
                return guild.getTextChannelById(ChannelLogs.MODS.getId());
            case "roles":
                return guild.getTextChannelById(ChannelLogs.ROLES.getId());
            default:
                return guild.getTextChannelById(ChannelLogs.UNKNOWN.getId());
        }
    }

}
