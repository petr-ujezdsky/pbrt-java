package org.pujezdsky.pbrt.math;

public class Point3d {

    public final double x;
    public final double y;
    public final double z;

    public Point3d() {
        this(0, 0, 0);
    }

    public Point3d(Point3d p) {
        this(p.x, p.y, p.z);
    }

    public Point3d(Vector3d v) {
        this(v.x, v.y, v.z);
    }

    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        assert !hasNaNs() : "Has NaNs!";
    }

    private boolean hasNaNs() {
        return !Double.isFinite(x) || !Double.isFinite(y) || !Double.isFinite(z);
    }

    public Point3d add(Vector3d v) {
        return new Point3d(x + v.x, y + v.y, z + v.z);
    }

    public Point3d add(Point3d p) {
        return new Point3d(x + p.x, y + p.y, z + p.z);
    }

    public Point3d subtract(Vector3d v) {
        return new Point3d(x - v.x, y - v.y, z - v.z);
    }

    public Vector3d subtract(Point3d p) {
        return new Vector3d(x - p.x, y - p.y, z - p.z);
    }

    public Point3d multiply(double d) {
        return new Point3d(
                x * d,
                y * d,
                z * d
        );
    }

    public double distance(Point3d p) {
        return subtract(p).getLength();
    }

    public double distanceSq(Point3d p) {
        return subtract(p).getLengthSq();
    }

    public Point3d lerp(double t, Point3d p) {
        return multiply(1 - t).add(p.multiply(t));
    }

    public Point3d min(Point3d p) {
        return new Point3d(
                Math.min(x, p.x),
                Math.min(y, p.y),
                Math.min(z, p.z)
        );
    }

    public Point3d max(Point3d p) {
        return new Point3d(
                Math.max(x, p.x),
                Math.max(y, p.y),
                Math.max(z, p.z)
        );
    }

    public Point3d floor() {
        return new Point3d(
                Math.floor(x),
                Math.floor(y),
                Math.floor(z)
        );
    }

    public Point3d ceil() {
        return new Point3d(
                Math.ceil(x),
                Math.ceil(y),
                Math.ceil(z)
        );
    }

    public Point3d abs() {
        return new Point3d(
                Math.abs(x),
                Math.abs(y),
                Math.abs(z)
        );
    }

    public double get(int component) {
        return component == 0 ? x : component == 1 ? y : z;
    }

    public Point3d permute(int x, int y, int z) {
        return new Point3d(get(x), get(y), get(z));
    }
}
