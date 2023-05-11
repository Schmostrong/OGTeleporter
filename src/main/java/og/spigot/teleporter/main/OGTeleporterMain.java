package og.spigot.teleporter.main;

import og.spigot.teleporter.listener.OGTeleporterMainListener;
import og.spigot.teleporter.manager.OGTeleporterConfigurationManager;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class OGTeleporterMain extends JavaPlugin {

    @Override
    public void onDisable() {
        getLogger().info("§7[§3OGTeleporter§7] disabling...");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getLogger().info("§7[§3OGTeleporter§7] enabling...");
        readConfiguration();

        if(!getDataFolder().exists()){
            getDataFolder().mkdirs();
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }

        getServer().getPluginManager().registerEvents(new OGTeleporterMainListener(), this);
        super.onEnable();
    }

    /**
     * Function is used to read the configuration file and load the settings
     */
    public void readConfiguration(){
        OGTeleporterConfigurationManager.getOgTeleporterConfigurationManager().setTeleporterMaterial(Material.getMaterial(getConfig().getString("teleporter.material")));
        OGTeleporterConfigurationManager.getOgTeleporterConfigurationManager().setTeleporterRange(getConfig().getInt("teleporter.range"));
    }
}
