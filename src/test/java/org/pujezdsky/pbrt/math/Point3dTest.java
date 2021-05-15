package org.pujezdsky.pbrt.math;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Point3dTest {

    @Test
    public void testAddVector() {
        Point3d p = new Point3d(1, 2, 3);

        Point3d res = p.add(new Vector3d(5, 6, 7));

        assertEquals(6.0, res.x);
        assertEquals(8.0, res.y);
        assertEquals(10.0, res.z);
    }

    @Test
    public void testAddPoint() {
        Point3d p = new Point3d(1, 2, 3);

        Point3d res = p.add(new Point3d(5, 6, 7));

        assertEquals(6.0, res.x);
        assertEquals(8.0, res.y);
        assertEquals(10.0, res.z);
    }

    @Test
    public void testSubtractVector() {
        Point3d p = new Point3d(1, 2, 3);

        Point3d res = p.subtract(new Vector3d(5, 6, 7));

        assertEquals(-4.0, res.x);
        assertEquals(-4.0, res.y);
        assertEquals(-4.0, res.z);
    }

    @Test
    public void testSubtractPoint() {
        Point3d p = new Point3d(1, 2, 3);

        Vector3d res = p.subtract(new Point3d(5, 6, 7));

        assertEquals(-4.0, res.x);
        assertEquals(-4.0, res.y);
        assertEquals(-4.0, res.z);
    }

    @Test
    public void testMultiply() {
        Point3d p = new Point3d(1, 2, 3);

        Point3d res = p.multiply(5.0);

        assertEquals(5.0, res.x);
        assertEquals(10.0, res.y);
        assertEquals(15.0, res.z);
    }

    @Test
    public void testDistance() {
        Point3d p = new Point3d(1, 2, 3);

        double res = p.distance(new Point3d(5, 6, 7));

        assertEquals(6.928203230275509, res);
    }

    @Test
    public void testDistanceSq() {
        Point3d p = new Point3d(1, 2, 3);

        double res = p.distanceSq(new Point3d(5, 6, 7));

        assertEquals(48.0, res);
    }

    @Test
    public void testLerp() {
        Point3d p = new Point3d(1, 2, 3);

        Point3d res = p.lerp(0.5, new Point3d(5, 6, 7));

        assertEquals(3.0, res.x);
        assertEquals(4.0, res.y);
        assertEquals(5.0, res.z);
    }

    @Test
    public void testMin() {
        Point3d p1 = new Point3d(1, 8, 3);
        Point3d p2 = new Point3d(4, 5, 6);

        Point3d res = p1.min(p2);

        assertEquals(1.0, res.x);
        assertEquals(5.0, res.y);
        assertEquals(3.0, res.z);
    }

    @Test
    public void testMax() {
        Point3d p1 = new Point3d(1, 8, 3);
        Point3d p2 = new Point3d(4, 5, 6);

        Point3d res = p1.max(p2);

        assertEquals(4.0, res.x);
        assertEquals(8.0, res.y);
        assertEquals(6.0, res.z);
    }

    @Test
    public void testFloor() {
        Point3d p = new Point3d(1.8, 8.9, 3.1);

        Point3d res = p.floor();

        assertEquals(1.0, res.x);
        assertEquals(8.0, res.y);
        assertEquals(3.0, res.z);
    }

    @Test
    public void testCeil() {
        Point3d p = new Point3d(1.8, 8.9, 3.1);

        Point3d res = p.ceil();

        assertEquals(2.0, res.x);
        assertEquals(9.0, res.y);
        assertEquals(4.0, res.z);
    }

    @Test
    public void testAbs() {
        Point3d p = new Point3d(-1, -2, -3);

        Point3d res = p.abs();

        assertEquals(1.0, res.x);
        assertEquals(2.0, res.y);
        assertEquals(3.0, res.z);
    }

    @Test
    public void testGet() {
        Point3d p = new Point3d(1, 2, 3);

        assertEquals(1.0, p.get(0));
        assertEquals(2.0, p.get(1));
        assertEquals(3.0, p.get(2));
    }

    @Test
    public void testPermute() {
        Point3d p = new Point3d(1, 8, 3);

        Point3d res = p.permute(2, 0, 1);

        assertEquals(3.0, res.x);
        assertEquals(1.0, res.y);
        assertEquals(8.0, res.z);
    }
}
