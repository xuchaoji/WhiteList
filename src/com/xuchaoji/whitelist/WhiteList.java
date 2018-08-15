package com.xuchaoji.whitelist;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.xuchaoji.whitelist.commands.WhiteListCommand;
import com.xuchaoji.whitelist.events.EventClass;
public class WhiteList extends JavaPlugin {
	private FileConfiguration cfg=getConfig();
	@Override
	public void onEnable() {
		//����Ĭ�������ļ�
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
		System.out.println("[WhiteList]���سɹ�������֧����ϵadmin@xuchaoji.com");
	}
	@Override
	public void onDisable() {
		System.out.println("[WhiteList]��ֹͣ����!");
	}
}
