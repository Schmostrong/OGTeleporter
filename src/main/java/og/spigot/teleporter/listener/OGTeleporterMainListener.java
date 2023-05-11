package og.spigot.teleporter.listener;

import jdk.jshell.execution.LoaderDelegate;
import og.spigot.teleporter.manager.OGTeleporterConfigurationManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class OGTeleporterMainListener implements Listener {
    @EventHandler
    public void onPlayerJump(PlayerMoveEvent playerMoveEvent){
        if(playerJumped(playerMoveEvent.getFrom(), playerMoveEvent.getTo())){
            try{
                playerMoveEvent.getPlayer().teleport(retrieveTeleporterLocationUpwards(playerMoveEvent.getFrom()));
            }catch (NullPointerException npe){

            }
        }
    }

    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent playerToggleSneakEvent){
        if(playerToggleSneakEvent.isSneaking()){
            try{
                playerToggleSneakEvent.getPlayer().teleport(retrieveTeleporterLocationUpwards(playerToggleSneakEvent.getPlayer().getLocation()));
            }catch (NullPointerException npe){

            }
        }
    }

    /**
     * Function is used to determine, wheter a player jumped when changing his position
     *
     * @param from - Location the player was at before he moved
     * @param to - Location the player is at after he moved
     * @return - Boolean telling wheter the player jumped
     */
    public boolean playerJumped(Location from, Location to){
        return to.getY() > from.getY() ? true : false;
    }

    /**
     * Function is used to retrieve the location of a teleporter point if there is one within the given range
     *
     * @param from - Location from where it should be checked
     * @return - Location where another teleporter point is located if existing, else null
     */
    public Location retrieveTeleporterLocationUpwards(Location from){
        Location teleporterPoint = null;
        for (int i = 0; i <= OGTeleporterConfigurationManager.getOgTeleporterConfigurationManager().getTeleporterRange(); i++) {
            from.setY(from.getY() + i);
            if(from.getBlock().getType() == OGTeleporterConfigurationManager.getOgTeleporterConfigurationManager().getTeleporterMaterial()){
                teleporterPoint = from;
                break;
            }
        }

        return teleporterPoint;
    }

    /**
     * Function is used to retrieve the location of a teleporter point if there is one within the given range
     *
     * @param from - Location from where it should be checked
     * @return - Location where another teleporter point is located if existing, else null
     */
    public Location retrieveTeleporterLocationDownwards(Location from){
        Location teleporterPoint = null;
        for (int i = 0; i <= OGTeleporterConfigurationManager.getOgTeleporterConfigurationManager().getTeleporterRange(); i++) {
            from.setY(from.getY() - i);
            if(from.getBlock().getType() == OGTeleporterConfigurationManager.getOgTeleporterConfigurationManager().getTeleporterMaterial()){
                teleporterPoint = from;
                break;
            }
        }

        return teleporterPoint;
    }
}
