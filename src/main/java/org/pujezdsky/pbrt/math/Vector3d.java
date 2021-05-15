package org.pujezdsky.pbrt.math;

import java.util.Objects;

public class Vector3d {

    public static final Vector3d EMPTY = new Vector3d(0, 0, 0);
    public static final Vector3d E1 = new Vector3d(1, 0, 0);
    public static final Vector3d E2 = new Vector3d(0, 1, 0);
    public static final Vector3d E3 = new Vector3d(0, 0, 1);

    public final double x;
    public final double y;
    public final double z;

    public Vector3d() {
        this(0, 0, 0);
    }

    public Vector3d(Vector3d v) {
        this(v.x, v.y, v.z);
    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        assert !hasNaNs() : "Has NaNs!";
    }

    private boolean hasNaNs() {
        return !Double.isFinite(x) || !Double.isFinite(y) || !Double.isFinite(z);
    }

    public double getLengthSq() {
        return x * x + y * y + z * z;
    }

    public double getLength() {
        return Math.sqrt(getLengthSq());
    }

    public Vector3d add(Vector3d v) {
        return new Vector3d(
                x + v.x,
                y + v.y,
                z + v.z
        );
    }

    public Vector3d subtract(Vector3d v) {
        return new Vector3d(
                x - v.x,
                y - v.y,
                z - v.z
        );
    }

    public Vector3d multiply(double d) {
        return new Vector3d(
                x * d,
                y * d,
                z * d
        );
    }

    public Vector3d divide(double d) {
        double inv = 1 / d;
        return multiply(inv);
    }

    public Vector3d negate() {
        return new Vector3d(-x, -y, -z);
    }

    public Vector3d abs() {
        return new Vector3d(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    public Vector3d normalize() {
        double lengthInv = 1 / getLength();
        return multiply(lengthInv);
    }

    public double dot(Vector3d v) {
        return dot(this, v);
    }

    public double absDot(Vector3d v) {
        return Math.abs(dot(v));
    }

    public Vector3d cross(Vector3d v) {
        return cross(this, v);
    }

    public double get(int component) {
        return component == 0 ? x : component == 1 ? y : z;
    }

    public double getMinComponent() {
        return Math.min(x, Math.min(y, z));
    }

    public double getMaxComponent() {
        return Math.max(x, Math.max(y, z));
    }

    public int getMaxDimension() {
        return x > y
                ? x > z ? 0 : 2
                : y > z ? 1 : 2;
    }

    public Vector3d min(Vector3d w) {
        return min(this, w);
    }

    public Vector3d max(Vector3d w) {
        return max(this, w);
    }

    public Vector3d permute(int x, int y, int z) {
        return new Vector3d(get(x), get(y), get(z));
    }

    public static Vector3d min(Vector3d v, Vector3d w) {
        return new Vector3d(
                Math.min(v.x, w.x),
                Math.min(v.y, w.y),
                Math.min(v.z, w.z)
        );
    }

    public static Vector3d max(Vector3d v, Vector3d w) {
        return new Vector3d(
                Math.max(v.x, w.x),
                Math.max(v.y, w.y),
                Math.max(v.z, w.z)
        );
    }

    public static double dot(Vector3d a, Vector3d b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    public static Vector3d cross(Vector3d a, Vector3d b) {
        // always use doubles here!
        return new Vector3d(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3d vector3 = (Vector3d) o;
        return Double.compare(vector3.x, x) == 0 && Double.compare(vector3.y, y) == 0 && Double.compare(vector3.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return String.format("x=%f, y=%f, z=%f", x, y, z);
    }
}
