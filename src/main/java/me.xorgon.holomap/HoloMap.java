package me.xorgon.holomap;

import me.xorgon.holomap.util.BlockParticle;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.List;

/**
 * The HoloMap Object.
 */
public class HoloMap {

    private Vector min;
    private Vector max;
    private Location base;
    private List<BlockParticle> blockParticles;

    public Vector getMin() {
        return min;
    }

    public void setMin(Vector min) {
        this.min = min;
    }

    public Vector getMax() {
        return max;
    }

    public void setMax(Vector max) {
        this.max = max;
    }

    public Location getBase() {
        return base;
    }

    public void setBase(Location base) {
        this.base = base;
    }

    public List<BlockParticle> getBlockParticles() {
        return blockParticles;
    }

    public void setBlockParticles(List<BlockParticle> blockParticles) {
        this.blockParticles = blockParticles;
    }
}
