package com.github.martinfrank.gridinventory;

import com.github.martinfrank.geolib.GeoPoint;

import java.util.*;

public class RectangleContainer implements GridContainer {

    private final List<GeoPoint> shape;
    private final Map<GeoPoint, GridShape> content;

    public RectangleContainer(int width, int height){
        shape = Collections.unmodifiableList(RectangleUtility.createShape(width, height));
        content = new HashMap<>();
    }

    @Override
    public Collection<GeoPoint> getContainer() {
        return shape;
    }

    @Override
    public Collection<GridShape> getContent() {
        return content.values();
    }

    @Override
    public boolean fitsInside(GridShape shape, GeoPoint location) {
        Collection<GeoPoint>relativeShape = shape.getRelativeShape(location);
        boolean hasIntersections = hasIntersection(relativeShape);
        boolean isInBounds = isInBounds(relativeShape);
        return !hasIntersections && isInBounds;
    }

    private boolean isInBounds(Collection<GeoPoint>relativeShape) {
        for (GeoPoint point: relativeShape){
            if (!shape.contains(point)){
                return false;
            }
        }
        return true;
    }

    private boolean hasIntersection(Collection<GeoPoint>relativeShape) {
        for (Map.Entry<GeoPoint, GridShape> entry: content.entrySet()){
            for (GeoPoint pointOfContent: entry.getValue().getRelativeShape(entry.getKey())){
                if (relativeShape.contains(pointOfContent)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void add(GridShape shape, GeoPoint location) {
        content.put(location, shape);
    }

    @Override
    public GridShape remove(GeoPoint location) {
        return content.remove(location);
    }
}
