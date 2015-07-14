package me.xorgon.holomap;

import de.slikey.effectlib.EffectManager;
import me.xorgon.holomap.util.DrawMap;
import me.xorgon.holomap.util.GenerateMap;
import me.xorgon.holomap.util.Selection;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Created by Elijah on 13/07/2015.
 */
public class HMCommands implements CommandExecutor {

    private HoloMapPlugin plugin = HoloMapPlugin.getInstance();
    private HMManager manager = plugin.getManager();
    private EffectManager effectManager = plugin.getEffectManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args[0].equalsIgnoreCase("p1") || args[0].equalsIgnoreCase("point1")) {
            Player player = (Player) sender;
            manager.getSelection(player).setP1(player.getTargetBlock(null, 32).getLocation().toVector());
            player.sendMessage(ChatColor.GREEN + "Point1 set.");
            return true;
        } else if (args[0].equalsIgnoreCase("p2") || args[0].equalsIgnoreCase("point2")) {
            Player player = (Player) sender;
            manager.getSelection(player).setP2(player.getTargetBlock(null, 32).getLocation().toVector());
            player.sendMessage(ChatColor.GREEN + "Point2 set.");
        } else if (args[0].equalsIgnoreCase("drawmap") || args[0].equalsIgnoreCase("dm")) {
            Player player = (Player) sender;
            Selection selection = manager.getSelection(player);

            HoloMap holoMap = new HoloMap();

            Vector max = selection.getMax();
            holoMap.setMax(max);
            Vector min = selection.getMin();
            holoMap.setMin(min);

            Location location = player.getLocation();
            holoMap.setBase(location);

            holoMap.setBlockParticles(GenerateMap.genBlockParticles(min, max, location.getWorld()));

            DrawMap drawMap = new DrawMap(effectManager);

            drawMap.setBase(holoMap.getBase());
            drawMap.setBlockParticles(holoMap.getBlockParticles());
            System.out.println(holoMap.getBlockParticles());
            drawMap.start();
        } else {
            sender.sendMessage(ChatColor.RED + "point1, point2");
        }
        return true;
    }

}
