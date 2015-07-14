package me.xorgon.holomap.util;

import de.slikey.effectlib.util.ParticleEffect;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.util.Vector;

/**
 * Block particles.
 */
public class BlockParticle {

    private Vector loc;
    private BlockParticleType type;

    public BlockParticle(Vector loc, BlockParticleType type) {
        this.loc = loc;
        this.type = type;
    }

    public enum BlockParticleType {
        AIR, GRASS, STONE, WATER, NONE
    }

    public static Color getColor(BlockParticleType type) {

        Color color;

        if (type == BlockParticleType.AIR) {
            color = null;
        } else if (type == BlockParticleType.GRASS) {
            color = Color.GREEN;
        } else if (type == BlockParticleType.STONE) {
            color = Color.GRAY;
        } else if (type == BlockParticleType.WATER) {
            color = Color.BLUE;
        } else if (type == BlockParticleType.NONE) {
            color = Color.GRAY;
        } else {
            color = null;
        }

        return color;
    }

    public static BlockParticleType materialToBT(Material material) {
        BlockParticleType type;

        if (material == Material.AIR) {
            type = BlockParticleType.AIR;
        } else if (material == Material.GRASS) {
            type = BlockParticleType.GRASS;
        } else if (material == Material.STONE) {
            type = BlockParticleType.STONE;
        } else if (material == Material.WATER) {
            type = BlockParticleType.WATER;
        } else {
            type = BlockParticleType.NONE;
        }

        return type;
    }

    public Vector getLoc() {
        return loc;
    }

    public void setLoc(Vector loc) {
        this.loc = loc;
    }

    public BlockParticleType getType() {
        return type;
    }

    public void setType(BlockParticleType type) {
        this.type = type;
    }
}
