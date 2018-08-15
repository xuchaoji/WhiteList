package com.xuchaoji.whitelist;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.xuchaoji.whitelist.commands.WhiteListCommand;
import com.xuchaoji.whitelist.events.EventClass;
public class WhiteList extends JavaPlugin {
	private FileConfiguration cfg=getConfig();
	@Override
	public void onEnable() {
		//设置默认配置文件
		cfg.addDefault("whitelist.chaoji", true);
		cfg.addDefault("whitelist.linfengfeiwu", true);
		cfg.addDefault("whitelist.failury", true);
		cfg.addDefault("whitelist._chengqi", true);
		cfg.addDefault("whitelist.susu_supreme", true);
		cfg.addDefault("whitelist.Zm_Tinker", true);
		cfg.options().copyDefaults(true);
		saveConfig();
		//register Command
		this.getCommand("wl").setExecutor(new WhiteListCommand());
		//register Listener
		getServer().getPluginManager().registerEvents(new EventClass(),this);
		System.out.println("[WhiteList]加载成功。技术支持联系admin@xuchaoji.com");
	}
	@Override
	public void onDisable() {
		System.out.println("[WhiteList]已停止运行!");
	}
}
