package org.pujezdsky.pbrt.math;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Vector3dTest {

    @Test
    public void testConstructor0() {
        Vector3d v = new Vector3d();


        assertEquals(0.0, v.x);
        assertEquals(0.0, v.y);
        assertEquals(0.0, v.z);
    }

    @Test
    public void testConstructor1() {
        Vector3d v = new Vector3d(1, 2, 3);


        assertEquals(1.0, v.x);
        assertEquals(2.0, v.y);
        assertEquals(3.0, v.z);
    }

    @Test
    public void testConstructor2() {
        Vector3d v = new Vector3d(new Vector3d(1, 2, 3));


        assertEquals(1.0, v.x);
        assertEquals(2.0, v.y);
        assertEquals(3.0, v.z);
    }

    @Test
    public void testEquals() {
        Vector3d v1 = new Vector3d(1, 2, 3);
        Vector3d v2 = new Vector3d(1, 2, 3);

        assertEquals(v1, v2);
    }

    @Test
    public void testHashCode() {
        Vector3d v = new Vector3d(1, 2, 3);

        assertEquals(66614367, v.hashCode());
    }

    @Test
    public void testToString() {
        Vector3d v = new Vector3d(1, 2, 3);

        assertEquals("x=1,000000, y=2,000000, z=3,000000", v.toString());
    }

    @Test
    public void testGetLength() {
        assertEquals(3.7416573867739413, new Vector3d(1, 2, 3).getLength());
        assertEquals(1.0, new Vector3d(1, 0, 0).getLength());
        assertEquals(1.0, new Vector3d(0, 1, 0).getLength());
        assertEquals(1.0, new Vector3d(0, 0, 1).getLength());
    }

    @Test
    public void testGetLengthSq() {
        assertEquals(27.0, new Vector3d(3, 3, 3).getLengthSq());
        assertEquals(1.0, new Vector3d(1, 0, 0).getLengthSq());
        assertEquals(1.0, new Vector3d(0, 1, 0).getLengthSq());
        assertEquals(1.0, new Vector3d(0, 0, 1).getLengthSq());
    }

    @Test
    public void testAdd() {
        Vector3d v = new Vector3d(1, 2, 3);

        Vector3d v2 = v.add(new Vector3d(5, 6, 7));

        assertEquals(6.0, v2.x);
        assertEquals(8.0, v2.y);
        assertEquals(10.0, v2.z);
    }

    @Test
    public void testSubtract() {
        Vector3d v = new Vector3d(1, 2, 3);

        Vector3d v2 = v.subtract(new Vector3d(5, 6, 7));

        assertEquals(-4.0, v2.x);
        assertEquals(-4.0, v2.y);
        assertEquals(-4.0, v2.z);
    }

    @Test
    public void testMultiply() {
        Vector3d v = new Vector3d(1, 2, 3);

        Vector3d v2 = v.multiply(5.0);

        assertEquals(5.0, v2.x);
        assertEquals(10.0, v2.y);
        assertEquals(15.0, v2.z);
    }

    @Test
    public void testDivide() {
        Vector3d v = new Vector3d(2, 4, -8);

        Vector3d v2 = v.divide(2.0);

        assertEquals(1.0, v2.x);
        assertEquals(2.0, v2.y);
        assertEquals(-4.0, v2.z);
    }

    @Test
    public void testNegate() {
        Vector3d v = new Vector3d(2, 4, -8);

        Vector3d v2 = v.negate();

        assertEquals(-2.0, v2.x);
        assertEquals(-4.0, v2.y);
        assertEquals(8.0, v2.z);
    }

    @Test
    public void testAbs() {
        Vector3d v = new Vector3d(2, 4, -8);

        Vector3d v2 = v.abs();

        assertEquals(2.0, v2.x);
        assertEquals(4.0, v2.y);
        assertEquals(8.0, v2.z);
    }

    @Test
    public void testNormalize() {
        Vector3d v = new Vector3d(1, 2, 3);

        Vector3d v2 = v.normalize();

        assertEquals(0.2672612419124244, v2.x);
        assertEquals(0.5345224838248488, v2.y);
        assertEquals(0.8017837257372732, v2.z);
    }

    @Test
    public void testDot() {
        Vector3d v = new Vector3d(-1, -2, -3);
        Vector3d w = new Vector3d(4, 5, 6);

        double dot = v.dot(w);

        assertEquals(-32.0, dot);
    }

    @Test
    public void testAbsDot() {
        Vector3d v = new Vector3d(-1, -2, -3);
        Vector3d w = new Vector3d(4, 5, 6);

        double dot = v.absDot(w);

        assertEquals(32.0, dot);
    }

    @Test
    public void testCross() {
        Vector3d v = new Vector3d(1, 2, 3);
        Vector3d w = new Vector3d(4, 5, 6);

        Vector3d cross = v.cross(w);

        assertEquals(-3.0, cross.x);
        assertEquals(6.0, cross.y);
        assertEquals(-3.0, cross.z);
    }

    @Test
    public void testGet() {
        assertEquals(1.0, new Vector3d(1, 2, 3).get(0));
        assertEquals(2.0, new Vector3d(1, 2, 3).get(1));
        assertEquals(3.0, new Vector3d(1, 2, 3).get(2));
    }

    @Test
    public void testGetMinComponent() {
        assertEquals(1.0, new Vector3d(1, 2, 3).getMinComponent());
        assertEquals(2.0, new Vector3d(4, 2, 3).getMinComponent());
        assertEquals(3.0, new Vector3d(5, 5, 3).getMinComponent());
    }

    @Test
    public void testGetMaxComponent() {
        assertEquals(3.0, new Vector3d(1, 2, 3).getMaxComponent());
        assertEquals(4.0, new Vector3d(4, 2, 3).getMaxComponent());
        assertEquals(5.0, new Vector3d(5, 5, 3).getMaxComponent());
    }

    @Test
    public void testGetMaxDimension() {
        assertEquals(2, new Vector3d(1, 2, 3).getMaxDimension());
        assertEquals(0, new Vector3d(4, 2, 3).getMaxDimension());
        assertEquals(1, new Vector3d(4, 5, 3).getMaxDimension());
        assertEquals(1, new Vector3d(5, 5, 3).getMaxDimension());
    }

    @Test
    public void testMin() {
        Vector3d v = new Vector3d(1, 8, 3);
        Vector3d w = new Vector3d(4, 5, 6);

        Vector3d min = v.min(w);

        assertEquals(1.0, min.x);
        assertEquals(5.0, min.y);
        assertEquals(3.0, min.z);
    }

    @Test
    public void testMax() {
        Vector3d v = new Vector3d(1, 8, 3);
        Vector3d w = new Vector3d(4, 5, 6);

        Vector3d max = v.max(w);

        assertEquals(4.0, max.x);
        assertEquals(8.0, max.y);
        assertEquals(6.0, max.z);
    }

    @Test
    public void testPermute() {
        Vector3d v = new Vector3d(1, 8, 3);

        Vector3d permute = v.permute(2, 0, 1);

        assertEquals(3.0, permute.x);
        assertEquals(1.0, permute.y);
        assertEquals(8.0, permute.z);
    }

    @Test
    public void testFaceForward() {
        Vector3d v = new Vector3d(-1, -8, -3);
        Vector3d w = new Vector3d(1, 8, 3);

        Vector3d res = v.faceForward(w);

        assertEquals(1.0, res.x);
        assertEquals(8.0, res.y);
        assertEquals(3.0, res.z);
    }
}
