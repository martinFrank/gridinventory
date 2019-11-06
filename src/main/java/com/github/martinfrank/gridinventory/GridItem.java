package com.github.martinfrank.gridinventory;

import com.github.martinfrank.geolib.GeoPoint;

import java.util.Collection;

public interface GridItem<I> extends ItemHolder<I> {

    public boolean fitsInside(GridContainer<I> container, GeoPoint pointer);

    public Collection<GeoPoint> getShape();

    public Collection<GeoPoint> getRelativeShape(GeoPoint point);

}
