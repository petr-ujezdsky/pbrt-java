package org.pujezdsky.pbrt.math;

public class Bounds3f {

    public final Point3d pMin;

    public final Point3d pMax;

    public Bounds3f(Point3d p) {
        this(p, p);
    }

    public Bounds3f(Point3d p1, Point3d p2) {
        this.pMin = p1.min(p2);
        this.pMax = p1.max(p2);
    }

//    public Bounds3f(Point3d pMin, Point3d pMax) {
//        this.pMin = pMin;
//        this.pMax = pMax;
//    }

    public Point3d get(int component) {
        return component == 0 ? pMin : pMax;
    }

    public Point3d corner(int corner) {
        return new Point3d(
                get(corner & 1).x,
                get((corner & 2) != 0 ? 1 : 0).y,
                get((corner & 4) != 0 ? 1 : 0).z
        );
    }

    public Bounds3f union(Point3d p) {
        return new Bounds3f(
                pMin.min(p),
                pMax.max(p)
        );
    }

    public Bounds3f union(Bounds3f b) {
        return new Bounds3f(
                pMin.min(b.pMin),
                pMax.max(b.pMax)
        );
    }

    public Bounds3f intersect(Bounds3f b) {
        return new Bounds3f(
                pMin.max(b.pMin),
                pMax.min(b.pMax)
        );
    }

    public boolean overlaps(Bounds3f b) {
        return overlaps(this, b);
    }

    public boolean inside(Point3d p) {
        return inside(p, this);
    }

    public boolean insideExclusive(Point3d p) {
        return insideExclusive(p, this);
    }

    public Bounds3f expand(double delta) {
        return new Bounds3f(
                pMin.subtract(new Vector3d(delta, delta, delta)),
                pMax.add(new Vector3d(delta, delta, delta))
        );
    }

    public Vector3d diagonal() {
        return pMax.subtract(pMin);
    }

    public double surfaceArea() {
        Vector3d d = diagonal();
        return 2 * (d.x * d.y + d.x * d.z + d.y * d.z);
    }

    public double volume() {
        Vector3d d = diagonal();
        return d.x * d.y * d.z;
    }

    public int maximumExtent() {
        Vector3d d = diagonal();
        if (d.x > d.y && d.x > d.z)
            return 0;
        else if (d.y > d.z)
            return 1;
        else
            return 2;
    }

    public Point3d lerp(Point3d t) {
        return pMin.lerp(t, pMax);
    }

    public Vector3d offset(Point3d p) {
        Vector3d o = p.subtract(pMin);
//        double x = o.x;
//        double y = o.y;
//        double z = o.z;
//
//        if (pMax.x > pMin.x) x /= pMax.x - pMin.x;
//        if (pMax.y > pMin.y) y /= pMax.y - pMin.y;
//        if (pMax.z > pMin.z) z /= pMax.z - pMin.z;
//
//        return new Vector3d(x, y, z);

        if (pMax.x > pMin.x) o.x /= pMax.x - pMin.x;
        if (pMax.y > pMin.y) o.y /= pMax.y - pMin.y;
        if (pMax.z > pMin.z) o.z /= pMax.z - pMin.z;
        return o;
    }

    public BoundingSphere boundingSphere() {
        Point3d center = pMin.add(pMax).multiply(0.5);

        return new BoundingSphere(
                center,
                inside(center) ? center.distance(pMax) : 0.0f
        );
    }


    public static boolean overlaps(Bounds3f b1, Bounds3f b2) {
        boolean x = (b1.pMax.x >= b2.pMin.x) && (b1.pMin.x <= b2.pMax.x);
        boolean y = (b1.pMax.y >= b2.pMin.y) && (b1.pMin.y <= b2.pMax.y);
        boolean z = (b1.pMax.z >= b2.pMin.z) && (b1.pMin.z <= b2.pMax.z);
        return (x && y && z);
    }

    public static boolean inside(Point3d p, Bounds3f b) {
        return (p.x >= b.pMin.x && p.x <= b.pMax.x &&
                p.y >= b.pMin.y && p.y <= b.pMax.y &&
                p.z >= b.pMin.z && p.z <= b.pMax.z);
    }

    public static boolean insideExclusive(Point3d p, Bounds3f b) {
        return (p.x >= b.pMin.x && p.x < b.pMax.x &&
                p.y >= b.pMin.y && p.y < b.pMax.y &&
                p.z >= b.pMin.z && p.z < b.pMax.z);
    }
}
