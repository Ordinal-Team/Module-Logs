package fr.ordinalteam.bot.logs.events;

import fr.ordinalteam.bot.api.utils.ColorHelper;
import fr.ordinalteam.bot.api.utils.References;
import fr.ordinalteam.bot.logs.utils.Util;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildUnbanEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/**
 * Create by Arinonia 28/06/2021
 */
public class MemberUnbannedEvent extends ListenerAdapter {

    @Override
    public void onGuildUnban(@NotNull GuildUnbanEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        User user = event.getUser();
        StringBuilder builder = new StringBuilder();

        eb.setTitle(":unlock: Il est unban (glou glou)");
        eb.setAuthor(user.getName(),  null, user.getAvatarUrl());
        builder.append("Id: ").append(user.getId()).append("\n");
        builder.append("Discriminator: ").append(user.getDiscriminator()).append("\n");
        eb.setDescription(builder.toString());
        eb.setColor(ColorHelper.VALIDATE);
        eb.setFooter(References.ORDINAL_FOOTER);
        Util.getLogsChannelFromGuild(event.getGuild(), "mods").sendMessage(eb.build()).queue();
    }
}
