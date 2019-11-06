package com.github.martinfrank.gridinventory;

import com.github.martinfrank.geolib.GeoPoint;

import java.util.ArrayList;
import java.util.List;

public class RectangleUtility {

    public static List<GeoPoint> createShape(int width, int height){
        List<GeoPoint> points = new ArrayList<>();
        for (int dy = 0; dy < height; dy ++){
            for (int dx = 0; dx < width; dx ++){
                points.add(new GeoPoint(dx,dy));
            }
        }
        return points;
    }
}
