package fr.ordinalteam.bot.logs.events;

import fr.ordinalteam.bot.api.utils.ColorHelper;
import fr.ordinalteam.bot.api.utils.References;
import fr.ordinalteam.bot.logs.utils.Util;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Create by Arinonia 29/06/2021
 */
public class MemberRoleChangeEvent extends ListenerAdapter {

    @Override
    public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent e) {
        List<Role> roles = e.getRoles();
        EmbedBuilder eb = new EmbedBuilder();
        User user = e.getUser();
        StringBuilder builder = new StringBuilder();


        eb.setTitle(":white_check_mark: Role ajouté");
        eb.setAuthor(user.getName(),  null, user.getAvatarUrl());
        builder.append("Id: ").append(user.getId()).append("\n");
        builder.append("Discriminator: ").append(user.getDiscriminator()).append("\n");

        for (Role role : roles) {
            builder.append("Role: ").append(role.getName()).append("\n");
        }

        eb.setDescription(builder.toString());
        eb.setColor(ColorHelper.VALIDATE);
        eb.setFooter(References.ORDINAL_FOOTER);

        //if (!roles.contains(e.getGuild().getRoleById("654047191395991561")))
        Util.getLogsChannelFromGuild(e.getGuild(), "roles").sendMessage(eb.build()).queue();
    }

    @Override
    public void onGuildMemberRoleRemove(@NotNull GuildMemberRoleRemoveEvent e) {
        List<Role> roles = e.getRoles();
        EmbedBuilder eb = new EmbedBuilder();
        User user = e.getUser();
        StringBuilder builder = new StringBuilder();

        eb.setTitle(":x: Role retiré");
        eb.setAuthor(user.getName(),  null, user.getAvatarUrl());
        builder.append("Id: ").append(user.getId()).append("\n");
        builder.append("Discriminator: ").append(user.getDiscriminator()).append("\n");

        for (Role role : roles) {
            builder.append("Role: ").append(role.getName()).append("\n");
        }

        eb.setDescription(builder.toString());
        eb.setColor(ColorHelper.ERROR);
        eb.setFooter(References.ORDINAL_FOOTER);
        Util.getLogsChannelFromGuild(e.getGuild(), "roles").sendMessage(eb.build()).queue();
    }
}
