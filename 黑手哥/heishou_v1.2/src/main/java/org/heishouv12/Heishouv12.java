package org.heishouv12;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Heishouv12 extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // 注册事件监听器
        Bukkit.getPluginManager().registerEvents(this, this);
        // 输出启动成功消息
        getLogger().info(ChatColor.GREEN + "黑手插件启动成功！");
    }

    @Override
    public void onDisable() {
        // 插件关闭时的处理（如果需要）
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        getLogger().info("Received message: " + message);  // 输出接收到的消息

        if (message.equals("我想飞起来")) {
            // 在主线程中执行传送操作
            Bukkit.getScheduler().runTask(this, () -> {
                player.teleport(player.getLocation().add(0, 114, 0));
                Bukkit.broadcastMessage(ChatColor.RED + "因为" + player.getName() + "装逼所以神鹰哥让他尝到了什么是黑手");
            });
        }
    }
}
