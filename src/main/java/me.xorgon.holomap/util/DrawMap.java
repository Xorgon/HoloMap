package me.xorgon.holomap.util;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.List;

/**
 * The Effect that draws the map.
 */
public class DrawMap extends Effect {

    private EffectManager effectManager;
    private double particleSep;
    private List<BlockParticle> blockParticles;
    private Location base;
    private ParticleEffect particle;

    public DrawMap(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        infinite();
        particle = ParticleEffect.REDSTONE;
        period = 5;
        particleSep = 0.1;
        callback = new Runnable(){
            @Override
            public void run(){
            }
        };
    }

    @Override
    public void onRun() {
        try {
            //TODO Null checks.
            for (BlockParticle bP : blockParticles) {
                if (bP.getType() != BlockParticle.BlockParticleType.AIR) {
                    this.color = BlockParticle.getColor(bP.getType());
                    Location loc = base.clone().add(bP.getLoc().clone().multiply(particleSep));
                    display(particle, loc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public double getParticleSep() {
        return particleSep;
    }

    public void setParticleSep(double particleSep) {
        this.particleSep = particleSep;
    }
}
