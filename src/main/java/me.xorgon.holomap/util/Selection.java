package me.xorgon.holomap.util;

import org.bukkit.util.Vector;

/**
 * Selection Object.
 */
public class Selection {

    private Vector p1;
    private Vector p2;

    public Vector getP1() {
        return p1;
    }

    public void setP1(Vector p1) {
        this.p1 = p1;
    }

    public Vector getP2() {
        return p2;
    }

    public void setP2(Vector p2) {
        this.p2 = p2;
    }

    public Vector getMax() {
        return Vector.getMaximum(p1, p2);
    }

    public Vector getMin() {
        return Vector.getMinimum(p1, p2);
    }
}
