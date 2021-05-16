package org.pujezdsky.pbrt.math;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class Bounds3fTest {

    @Test
    public void testGet() {
        Bounds3f b = new Bounds3f(
                new Point3d(5, 6, 7),
                new Point3d(1, 2, 3)
        );

        assertEquals(new Point3d(1, 2, 3), b.get(0));
        assertEquals(new Point3d(5, 6, 7), b.get(1));
    }

    @Test
    public void testCorner() {
        Bounds3f b = new Bounds3f(
                new Point3d(0, 0, 0),
                new Point3d(1, 1, 1)
        );

        assertEquals(new Point3d(0, 0, 0), b.corner(0));
        assertEquals(new Point3d(1, 0, 0), b.corner(1));
        assertEquals(new Point3d(0, 1, 0), b.corner(2));
        assertEquals(new Point3d(1, 1, 0), b.corner(3));
        assertEquals(new Point3d(0, 0, 1), b.corner(4));
        assertEquals(new Point3d(1, 0, 1), b.corner(5));
        assertEquals(new Point3d(0, 1, 1), b.corner(6));
        assertEquals(new Point3d(1, 1, 1), b.corner(7));
    }

    @Test
    public void testUnionPoint() {
        Bounds3f b = new Bounds3f(
                new Point3d(0, 0, 0),
                new Point3d(1, 1, 1)
        );

        Bounds3f res = b.union(new Point3d(-1, 0, 2));

        assertEquals(new Point3d(-1, 0, 0), res.pMin);
        assertEquals(new Point3d(1, 1, 2), res.pMax);
    }

    @Test
    public void testUnionBounds() {
        Bounds3f b1 = new Bounds3f(
                new Point3d(0, 0, 0),
                new Point3d(1, 1, 1)
        );

        Bounds3f b2 = new Bounds3f(
                new Point3d(0, 0, 0),
                new Point3d(-1, -1, -1)
        );

        Bounds3f res = b1.union(b2);

        assertEquals(new Point3d(-1, -1, -1), res.pMin);
        assertEquals(new Point3d(1, 1, 1), res.pMax);
    }

    @Test
    public void testIntersect() {
        Bounds3f b1 = new Bounds3f(
                new Point3d(0, 0, 0),
                new Point3d(1, 1, 1)
        );

        Bounds3f b2 = new Bounds3f(
                new Point3d(0.5, 0.5, 0.5),
                new Point3d(2, 2, 2)
        );

        Bounds3f res = b1.intersect(b2);

        assertEquals(new Point3d(0.5, 0.5, 0.5), res.pMin);
        assertEquals(new Point3d(1, 1, 1), res.pMax);
    }

    @Test
    public void testIntersectNone() {
        Bounds3f b1 = new Bounds3f(
                new Point3d(0, 0, 0),
                new Point3d(1, 1, 1)
        );

        Bounds3f b2 = new Bounds3f(
                new Point3d(-1, -1, -1),
                new Point3d(-2, -2, -2)
        );

        Bounds3f res = b1.intersect(b2);

        assertEquals(new Point3d(-1, -1, -1), res.pMin);
        assertEquals(new Point3d(0, 0, 0), res.pMax);
    }

    @Test
    public void testOverlapsTrue() {
        Bounds3f b1 = new Bounds3f(
                new Point3d(0, 0, 0),
                new Point3d(1, 1, 1)
        );

        Bounds3f b2 = new Bounds3f(
                new Point3d(0.5, 0.5, 0.5),
                new Point3d(2, 2, 2)
        );

        assertTrue(b1.overlaps(b2));
    }

    @Test
    public void testOverlapsFalse() {
        Bounds3f b1 = new Bounds3f(
                new Point3d(0, 0, 0),
                new Point3d(1, 1, 1)
        );

        Bounds3f b2 = new Bounds3f(
                new Point3d(-1, -1, -1),
                new Point3d(-2, -2, -2)
        );

        assertFalse(b1.overlaps(b2));
    }

    @Test
    public void testInside() {
        Bounds3f b1 = new Bounds3f(
                new Point3d(0, 0, 0),
                new Point3d(1, 1, 1)
        );

        assertTrue(b1.inside(new Point3d(0, 0, 0)));
        assertTrue(b1.inside(new Point3d(1, 1, 1)));
        assertTrue(b1.inside(new Point3d(0.5, 0.5, 0.5)));
        assertTrue(b1.inside(new Point3d(0.5, 0.5, 0.5)));
        assertFalse(b1.inside(new Point3d(2, 2, 2)));
    }

    @Test
    public void testInsideExclusive() {
        Bounds3f b1 = new Bounds3f(
                new Point3d(0, 0, 0),
                new Point3d(1, 1, 1)
        );

        assertTrue(b1.insideExclusive(new Point3d(0, 0, 0)));
        assertFalse(b1.insideExclusive(new Point3d(1, 1, 1)));
    }

    @Test
    public void testExpand() {
        Bounds3f b1 = new Bounds3f(
                new Point3d(0, 0, 0),
                new Point3d(1, 1, 1)
        );

        Bounds3f res = b1.expand(2);

        assertEquals(new Point3d(-2, -2, -2), res.pMin);
        assertEquals(new Point3d(3, 3, 3), res.pMax);
    }

    @Test
    public void testDiagonal() {
        Bounds3f b1 = new Bounds3f(
                new Point3d(1, 2, 3),
                new Point3d(5, 6, 7)
        );

        Vector3d res = b1.diagonal();

        assertEquals(new Vector3d(4, 4, 4), res);
    }

    @Test
    public void testSurfaceArea() {
        Bounds3f b1 = new Bounds3f(
                new Point3d(1, 2, 3),
                new Point3d(5, 6, 7)
        );

        double res = b1.surfaceArea();

        assertEquals(96.0, res);
    }

    @Test
    public void testVolume() {
        Bounds3f b1 = new Bounds3f(
                new Point3d(1, 2, 3),
                new Point3d(5, 6, 7)
        );

        double res = b1.volume();

        assertEquals(64.0, res);
    }

    @Test
    public void testMaximumExtent() {
        assertEquals(
                0,
                new Bounds3f(
                        new Point3d(0, 0, 0),
                        new Point3d(5, 1, 1)
                ).maximumExtent());

        assertEquals(
                1,
                new Bounds3f(
                        new Point3d(0, 0, 0),
                        new Point3d(1, 5, 1)
                ).maximumExtent());

        assertEquals(
                2,
                new Bounds3f(
                        new Point3d(0, 0, 0),
                        new Point3d(1, 1, 5)
                ).maximumExtent());
    }
}
