package fr.ordinalteam.bot.logs.events;

import fr.ordinalteam.bot.api.utils.ColorHelper;
import fr.ordinalteam.bot.api.utils.References;
import fr.ordinalteam.bot.logs.utils.Util;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/**
 * Create by Arinonia 28/06/2021
 */
public class MemberJoinEvent extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        Member member = event.getMember();
        EmbedBuilder eb = new EmbedBuilder();
        StringBuilder builder = new StringBuilder();

        eb.setTitle(":inbox_tray: Nouveau membre");
        eb.setAuthor(member.getUser().getName(), null, member.getUser().getAvatarUrl());

        builder.append("Id: ").append(member.getUser().getId()).append("\n");
        builder.append("Discriminator: ").append(member.getUser().getDiscriminator()).append("\n");

        eb.setDescription(builder.toString());
        eb.setColor(ColorHelper.VALIDATE);
        eb.setFooter(References.ORDINAL_FOOTER);
        Util.getLogsChannelFromGuild(event.getGuild(), "io").sendMessage(eb.build()).queue();
    }
}
