package com.github.martinfrank.gridinventory;

import com.github.martinfrank.geolib.GeoPoint;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RectangleItem<I> implements GridShape, ItemHolder<I> {

    private final List<GeoPoint> shape;
    private I item;

    public RectangleItem(int width, int height){
        shape = Collections.unmodifiableList(RectangleUtility.createShape(width, height));
    }

    @Override
    public boolean fitsInside(GridContainer container, GeoPoint pointer) {
        return container.fitsInside(this, pointer);
    }

    @Override
    public Collection<GeoPoint> getShape() {
        return shape;
    }

    @Override
    public GeoPoint getPointer() {
        return shape.get(0);
    }

    @Override
    public Collection<GeoPoint> getRelativeShape(GeoPoint point) {
        return shape.stream().map(p -> new GeoPoint(p.getX()+point.getX(), p.getY() + point.getY())).collect(Collectors.toList());
    }

    @Override
    public I getItem() {
        return item;
    }

    @Override
    public void setItem(I item) {
        this.item = item;
    }
}
