package org.pujezdsky.pbrt.math;

public class BoundingSphere {

    public final Point3d center;

    public final double radius;

    public BoundingSphere(Point3d center, double radius) {
        this.center = center;
        this.radius = radius;
    }
}
