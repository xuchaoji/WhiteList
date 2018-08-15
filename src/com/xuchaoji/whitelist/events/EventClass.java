package com.xuchaoji.whitelist.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import com.xuchaoji.whitelist.WhiteList;

public class EventClass implements Listener {
	private String prefix=(ChatColor.GOLD+"233craft");
	private Plugin plugin=WhiteList.getPlugin(WhiteList.class);
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player=event.getPlayer();
		boolean isWhite= plugin.getConfig().getBoolean("whitelist."+player.getName());
		if(isWhite) {
			player.sendMessage(prefix+ChatColor.GREEN+"欢迎回来，"+player.getName());
		}else {
			player.kickPlayer(ChatColor.RED+player.getName()+"不在白名单中");
		}
		
	}
}
