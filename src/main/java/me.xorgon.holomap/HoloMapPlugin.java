package me.xorgon.holomap;

import de.slikey.effectlib.EffectManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.MetricsLite;

import java.io.IOException;

/**
 * Main Class for HoloMap.
 */
public class HoloMapPlugin extends JavaPlugin {

    private HMManager manager;
    private EffectManager effectManager;
    private static HoloMapPlugin instance;

    public HoloMapPlugin() {
        instance = this;

    }

    @Override
    public void onEnable() {

        effectManager = new EffectManager(this);
        effectManager.enableDebug(true);
        this.manager = new HMManager(this);
        getCommand("holomap").setExecutor(new HMCommands());

        /*
        if (manager.isCollectStats()) {
            try {
                MetricsLite metrics = new MetricsLite(this);
                metrics.start();
            } catch (IOException e) {
                // Failed to submit the stats :-(
                System.out.println("MetricsLite has failed to submit stats.");
            }
        }
        */
    }

    @Override
    public void onDisable() {
        effectManager.dispose();
    }

    public static HoloMapPlugin getInstance() {
        return instance;
    }

    public HMManager getManager() {
        return manager;
    }

    public EffectManager getEffectManager() {
        return effectManager;
    }
}


