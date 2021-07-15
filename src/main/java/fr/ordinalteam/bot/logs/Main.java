package fr.ordinalteam.bot.logs;

import fr.ordinalteam.bot.api.plugin.Plugin;
import fr.ordinalteam.bot.logs.events.*;

/**
 * Create by Arinonia 28/06/2021
 */
public class Main extends Plugin {

    @Override
    public void onEnable() {
        System.out.println("Register du plugin de logs");
        this.getJDAListenerManager().registerJDAListener(new MemberJoinEvent());
        this.getJDAListenerManager().registerJDAListener(new MemberLeaveEvent());
        this.getJDAListenerManager().registerJDAListener(new MemberBannedEvent());
        this.getJDAListenerManager().registerJDAListener(new MemberUnbannedEvent());
        this.getJDAListenerManager().registerJDAListener(new MemberRoleChangeEvent());
    }
}
