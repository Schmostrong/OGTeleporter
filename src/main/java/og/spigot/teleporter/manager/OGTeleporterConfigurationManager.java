package og.spigot.teleporter.manager;

import og.spigot.teleporter.main.OGTeleporterMain;
import org.bukkit.Material;

public class OGTeleporterConfigurationManager {
    //Singleton instance of the OGTeleporterConfigurationManger
    private static OGTeleporterConfigurationManager ogTeleporterConfigurationManager;

    //Material object representing the material the teleporter shall be used for
    private Material teleporterMaterial;

    //Integer holding the range a teleporter is supposed to work
    private int teleporterRange;

    //Private constructor to avoid creating a new instance outside this class
    private OGTeleporterConfigurationManager(){};


    /**
     * Returns the singleton instance of the OGTeleporterConfigurationManager
     *
     * @return - OGTeleporterConfigurationManager object holding the singleton instance of the ConfigurationManager, which holds all settings available in the config.yml
     */
    public static OGTeleporterConfigurationManager getOgTeleporterConfigurationManager() {
        if(ogTeleporterConfigurationManager == null){
            ogTeleporterConfigurationManager = new OGTeleporterConfigurationManager();
        }
        return ogTeleporterConfigurationManager;
    }

    /**
     * Function is used to retrieve the material than can be used to build a teleporter
     *
     * @return - Material object that can be used to build a teleporter
     */
    public Material getTeleporterMaterial(){
        return this.teleporterMaterial;
    }

    /**
     * Function is used to set the teleporter material
     *
     * @param teleporterMaterial - Material object representing the material of the teleporter to be set
     */
    public void setTeleporterMaterial(Material teleporterMaterial){
        this.teleporterMaterial = teleporterMaterial;
    }

    /**
     * Function is used to retrieve the range a teleporter is supposed to work at
     *
     * @return - Integer holding the max range a teleporter is supposed to work
     */
    public int getTeleporterRange(){
        return this.teleporterRange;
    }

    /**
     * Function is used to set the range of blocks a teleporter is supposed to work at
     *
     * @param teleporterRange - Integer holding the amount of blocks that are possible in order to use the teleporter
     */
    public void setTeleporterRange(int teleporterRange){
        this.teleporterRange = teleporterRange;
    }
}
