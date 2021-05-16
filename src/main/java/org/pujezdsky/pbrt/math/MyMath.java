package org.pujezdsky.pbrt.math;

public class MyMath {
    public static double lerp(double t, double v1, double v2) {
        return (1 - t) * v1 + t * v2;
    }
}
