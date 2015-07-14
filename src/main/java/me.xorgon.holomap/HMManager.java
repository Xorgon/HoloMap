package me.xorgon.holomap;

import me.xorgon.holomap.util.Selection;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The manager class for HoloMap.
 */
public class HMManager {

    private HoloMapPlugin plugin;
    private List<HoloMap> holoMaps;
    private Map<Player, Selection> selections;

    public HMManager(HoloMapPlugin plugin) {
        this.plugin = plugin;
        selections = new HashMap<>();
    }

    public Selection getSelection(Player player) {
        Selection selection = selections.get(player);
        if (selection == null) {
            selection = new Selection();
            selections.put(player, selection);
        }
        return selection;
    }

}
