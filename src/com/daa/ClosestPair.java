package com.daa;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) +
                (p1.y - p2.y) * (p1.y - p2.y));
    }

    public static double closestPair(Point[] points) {
        Point[] sorted = points.clone();
        Arrays.sort(sorted, Comparator.comparingDouble(p -> p.x));
        return closestUtil(sorted, 0, sorted.length - 1);
    }

    private static double closestUtil(Point[] points, int left, int right) {
        if (right - left <= 3) {
            double minDist = Double.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    minDist = Math.min(minDist, dist(points[i], points[j]));
                }
            }
            return minDist;
        }

        int mid = (left + right) / 2;
        double d1 = closestUtil(points, left, mid);
        double d2 = closestUtil(points, mid + 1, right);

        double d = Math.min(d1, d2);

        Point[] strip = new Point[right - left + 1];
        int j = 0;
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - points[mid].x) < d) {
                strip[j++] = points[i];
            }
        }

        Arrays.sort(strip, 0, j, Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < j; i++) {
            for (int k = i + 1; k < j && (strip[k].y - strip[i].y) < d; k++) {
                d = Math.min(d, dist(strip[i], strip[k]));
            }
        }

        return d;
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };

        System.out.println("Closest distance = " + closestPair(points));
    }
}