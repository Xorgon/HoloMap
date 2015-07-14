package me.xorgon.holomap.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Elijah on 13/07/2015.
 */
public class GenerateMap {

    public static List<BlockParticle> genBlockParticles(Vector min, Vector max, World world) {
        int y;

        List<BlockParticle> blockParticles = new ArrayList<>();

        for (int x = min.getBlockX(); x <= max.getBlockX(); x++) {
            for (int z = min.getBlockZ(); z <= max.getBlockZ(); z++) {

                y = world.getHighestBlockYAt(x, z);

                int relX = x - min.getBlockX();
                int relZ = z - min.getBlockZ();
                int relY = y - min.getBlockY();

                if (relY < 0) {
                    continue;
                }

                Vector relVect = new Vector(relX, relY, relZ);

                Material blockType = world.getBlockAt(x, y, z).getType();

                BlockParticle blockParticle = new BlockParticle(relVect, BlockParticle.materialToBT(blockType));

                blockParticles.add(blockParticle);
            }
        }

        return blockParticles;
    }
}
