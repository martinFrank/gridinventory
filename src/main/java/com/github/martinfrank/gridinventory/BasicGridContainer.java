package com.github.martinfrank.gridinventory;

import com.github.martinfrank.geolib.GeoPoint;

import java.util.*;

public abstract class BasicGridContainer<I> implements GridContainer<I> {

    private final List<GeoPoint> shape;
    private final Map<GeoPoint, GridItem<I>> content;

    public BasicGridContainer(List<GeoPoint> shape) {
        this.shape = Collections.unmodifiableList(shape);
        content = new HashMap<>();
    }

    @Override
    public Collection<GeoPoint> getContainer() {
        return shape;
    }

    @Override
    public Collection<GridItem<I>> getContent() {
        return content.values();
    }

    @Override
    public boolean fitsInside(GridItem<I> shape, GeoPoint location) {
        Collection<GeoPoint> relativeShape = shape.getRelativeShape(location);
        boolean hasIntersections = hasIntersection(relativeShape);
        boolean isInBounds = isInBounds(relativeShape);
        return !hasIntersections && isInBounds;
    }

    private boolean isInBounds(Collection<GeoPoint> relativeShape) {
        for (GeoPoint point : relativeShape) {
            if (!shape.contains(point)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasIntersection(Collection<GeoPoint> relativeShape) {
        for (Map.Entry<GeoPoint, GridItem<I>> entry : content.entrySet()) {
            for (GeoPoint pointOfContent : entry.getValue().getRelativeShape(entry.getKey())) {
                if (relativeShape.contains(pointOfContent)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void add(GridItem<I> shape, GeoPoint location) {
        content.put(location, shape);
    }

    @Override
    public GridItem<I> remove(GeoPoint location) {
        return content.remove(location);
    }
}
