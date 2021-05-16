package org.pujezdsky.pbrt.math;

import org.pujezdsky.pbrt.Medium;

public class Ray {

    /** Origin */
    public final Point3d o;

    /** Direction */
    public final Vector3d d;

    /** Max t */
    public double tMax;

    /** Time */
    public final float time;

    /** Medium */
    public final Medium medium;

    /**
     * Constructor
     */
    public Ray() {
        this(Point3d.EMPTY, Vector3d.EMPTY, Double.POSITIVE_INFINITY, 0.0f, null);
    }

    /**
     * Constructor
     *
     * @param o origin
     * @param d direction
     * @param tMax max t
     * @param time time
     * @param medium medium
     */
    public Ray(Point3d o, Vector3d d, double tMax, float time, Medium medium) {
        this.o = o;
        this.d = d;
        this.tMax = tMax;
        this.time = time;
        this.medium = medium;
    }
}
