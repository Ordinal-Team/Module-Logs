package fr.ordinalteam.bot.logs.events;

import fr.ordinalteam.bot.api.utils.ColorHelper;
import fr.ordinalteam.bot.api.utils.References;
import fr.ordinalteam.bot.logs.utils.Util;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


/**
 * Create by Arinonia 28/06/2021
 */
public class MemberLeaveEvent extends ListenerAdapter {

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        event.getGuild().retrieveBan(event.getUser()).queue((success) -> {
        }, (failure) -> {
            EmbedBuilder eb = new EmbedBuilder();
            User user = event.getUser();
            StringBuilder builder = new StringBuilder();

            eb.setTitle(":outbox_tray: Il a quitté :c");
            eb.setAuthor(user.getName(), null, user.getAvatarUrl());
            builder.append("Id: ").append(user.getId()).append("\n");
            builder.append("Discriminator: ").append(user.getDiscriminator()).append("\n");
            eb.setDescription(builder.toString());
            eb.setColor(ColorHelper.ERROR);
            eb.setFooter(References.ORDINAL_FOOTER);
            Util.getLogsChannelFromGuild(event.getGuild(), "io").sendMessage(eb.build()).queue();
        });
    }

}
