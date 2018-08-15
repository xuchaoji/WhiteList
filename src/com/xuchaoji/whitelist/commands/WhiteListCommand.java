package com.xuchaoji.whitelist.commands;

import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.xuchaoji.whitelist.WhiteList;

public class WhiteListCommand implements CommandExecutor{
	private Plugin plugin=WhiteList.getPlugin(WhiteList.class);
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			if(sender.isOp()) {
				/*
				 * wl add chaoji
				 * wl remove chaoji
				 */
				Player player=(Player)sender;
				if(args.length==0) {
					player.sendMessage(ChatColor.GREEN+"用法：\n wl add player1 player2 ... 添加白名单\n wl remove player1 player2 ... 移除白名单");
				}else if(args.length==1 && args[0].equalsIgnoreCase("list")){
					Set<String> players = plugin.getConfig().getKeys(true);
					player.sendMessage(ChatColor.GREEN+"白名单玩家:");
					for(String p:players) {
						if(plugin.getConfig().getBoolean(p)) {
							String message=p;
							String[] msg=message.split("whitelist.");
							player.sendMessage(ChatColor.GOLD+msg[1]);
						}
					}
				}else if(args.length>=2 && args[0].equalsIgnoreCase("add")){
					for(int i=1;i<args.length;i++) {
						plugin.getConfig().set("whitelist."+args[i], true);
						plugin.saveConfig();
						player.sendMessage(ChatColor.GREEN+"[白名单]已添加："+ChatColor.GOLD+args[i]);
					}
				}else if(args.length>=2 && args[0].equalsIgnoreCase("remove")) {
					for(int i=1;i<args.length;i++) {
						plugin.getConfig().set("whitelist."+args[i], false);
						plugin.saveConfig();
						player.sendMessage(ChatColor.RED+"[白名单]已移除："+ChatColor.GOLD+args[i]);
					}
				}else {
					player.sendMessage(ChatColor.GREEN+"用法：\n wl add player1 player2 ... 添加白名单\n wl remove player1 player2 ... 移除白名单");
				}
			}else {
				sender.sendMessage(ChatColor.RED+"你没有权限执行此命令");
			}
		}else {
			if(args.length==0) {
				System.out.println(ChatColor.GREEN+"用法：\n wl add player1 player2 ... 添加白名单\n wl remove player1 player2 ... 移除白名单");
			}else if(args.length==1 && args[0].equalsIgnoreCase("list")){
				Set<String> players = plugin.getConfig().getKeys(true);
				System.out.println(ChatColor.GREEN+"白名单玩家:");
				for(String p:players) {
					if(plugin.getConfig().getBoolean(p)) {
						String message=p;
						String[] msg=message.split("whitelist.");
						System.out.println(ChatColor.GOLD+msg[1]);
					}
				}
			}else if(args.length>=2 && args[0].equalsIgnoreCase("add")){
				for(int i=1;i<args.length;i++) {
					plugin.getConfig().set("whitelist."+args[i], true);
					plugin.saveConfig();
					System.out.println(ChatColor.GREEN+"[白名单]已添加："+ChatColor.GOLD+args[i]);
				}
			}else if(args.length>=2 && args[0].equalsIgnoreCase("remove")) {
				for(int i=1;i<args.length;i++) {
					plugin.getConfig().set("whitelist."+args[i], false);
					plugin.saveConfig();
					System.out.println(ChatColor.RED+"[白名单]已移除："+ChatColor.GOLD+args[i]);
				}
			}else {
				System.out.println(ChatColor.GREEN+"用法：\n wl add player1 player2 ... 添加白名单\n wl remove player1 player2 ... 移除白名单");
			}
		}
		return true;
	}

}
