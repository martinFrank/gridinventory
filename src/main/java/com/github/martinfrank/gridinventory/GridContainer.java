package com.github.martinfrank.gridinventory;

import com.github.martinfrank.geolib.GeoPoint;

import java.util.Collection;

public interface GridContainer<I> {

    public Collection<GeoPoint> getContainer();

    public Collection<GridItem<I>> getContent();

    public boolean fitsInside(GridItem<I> shape, GeoPoint location);

    public void add(GridItem<I> shape, GeoPoint location);

    public GridItem<I> remove(GeoPoint location);

}
