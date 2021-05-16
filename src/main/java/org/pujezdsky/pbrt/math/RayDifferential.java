package org.pujezdsky.pbrt.math;

import org.pujezdsky.pbrt.Medium;

public class RayDifferential extends Ray {

    public final boolean hasDifferentials;

    private Point3d rxOrigin;

    private Point3d ryOrigin;

    private Vector3d rxDirection;

    private Vector3d ryDirection;

    public RayDifferential(Ray ray) {
        this(
                ray.o,
                ray.d,
                ray.tMax,
                ray.time,
                ray.medium,
                false,
                null,
                null,
                null,
                null
        );
    }

    public RayDifferential(Point3d o, Vector3d d, double tMax, float time, Medium medium) {
        this(
                o,
                d,
                tMax,
                time,
                medium,
                false,
                null,
                null,
                null,
                null
        );
    }

    public RayDifferential(Point3d o, Vector3d d, double tMax, float time, Medium medium, boolean hasDifferentials, Point3d rxOrigin, Point3d ryOrigin, Vector3d rxDirection, Vector3d ryDirection) {
        super(o, d, tMax, time, medium);
        this.hasDifferentials = hasDifferentials;
        this.rxOrigin = rxOrigin;
        this.ryOrigin = ryOrigin;
        this.rxDirection = rxDirection;
        this.ryDirection = ryDirection;
    }

    public void scaleDifferentials(float s) {
        rxOrigin = o.add(rxOrigin.subtract(o).multiply(s));
        ryOrigin = o.add(ryOrigin.subtract(o).multiply(s));
        rxDirection = d.add(rxDirection.subtract(d).multiply(s));
        ryDirection = d.add(ryDirection.subtract(d).multiply(s));
    }
}
