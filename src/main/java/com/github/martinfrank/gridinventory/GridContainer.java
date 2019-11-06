package com.github.martinfrank.gridinventory;

import com.github.martinfrank.geolib.GeoPoint;

import java.util.Collection;

public interface GridContainer {

    public Collection<GeoPoint> getContainer();

    public Collection<GridShape> getContent();

    public boolean fitsInside(GridShape container, GeoPoint location);

    public void add(GridShape shape, GeoPoint location);

    public GridShape remove(GeoPoint location);

}
